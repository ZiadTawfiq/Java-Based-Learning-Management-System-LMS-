package com.LMS.LMS.ServiceLayer;

import com.LMS.LMS.DTO.LoginReq;
import com.LMS.LMS.DTO.UserRegistration;
import com.LMS.LMS.ModelLayer.User;
import com.LMS.LMS.RepositoryLayer.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    private final UserRepository userRepository;


    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(@Lazy UserRepository userRepository,@Lazy BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public User Register(UserRegistration userReq) {
        User existedUser  = userRepository.findByEmail(userReq.getEmail()).orElse(null) ;


        if (existedUser != null){
            throw new RuntimeException("Email is already Exist !");
        }
        User user = new User();
        user.setUserName(userReq.getUsername());
        user.setEmail(userReq.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(userReq.getPassword()));  // You may want to encode the password here
        user.setRole(userReq.getRole());

        return userRepository.save(user);

    }

    public User Login(LoginReq req) {
        User user = userRepository.findByEmail(req.GetEmail()).orElseThrow(() -> new RuntimeException("Invalid Email"));
        if (!passwordEncoder.matches(user.getPassword(), req.getPassword())) {
            throw new RuntimeException("INVALID Password");
        }
        return user ;
    }
    public User ViewProfile(long Id){
        User user = userRepository.findById(Id).orElse(null);
        if (user != null){
            return user ;
        }
        else {
            throw new RuntimeException("Profile not found!");
        }
    }
    public User UpdateProfile(Long id,UserRegistration userRegistration){
        User user = userRepository.findById(id).orElse(null);
        if (user == null){
            throw new RuntimeException("Profile not found!");
        }
        if (userRegistration.getPassword() != null && !userRegistration.getPassword().isEmpty() && !userRegistration.getUsername().isEmpty() && userRegistration.getRole()!=null && !userRegistration.getEmail().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
            user.setUserName(userRegistration.getUsername());
            user.setEmail(userRegistration.getEmail());
            user.setRole(userRegistration.getRole());
            user.setPassword(userRegistration.getPassword());
        }
        return userRepository.save(user);
    }



}
