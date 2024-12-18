package com.LMS.LMS;

import com.LMS.LMS.DTO.UserRegistration;
import com.LMS.LMS.ModelLayer.User;
import com.LMS.LMS.RepositoryLayer.UserRepository;
import com.LMS.LMS.ServiceLayer.UserService;

import static com.LMS.LMS.ModelLayer.Role.Student;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class UserServiceTest {
    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void Initialization(){
        MockitoAnnotations.openMocks(this) ;
    }

    @Test
    public void Register_whenEmail_Doesnot_Exist() {

        UserRegistration req = new UserRegistration("Ziad", "ZiadTawfik@gmail.com", "22222", Student);

        when(repository.findByEmail("ZiadTawfik@gmail.com")).thenReturn(Optional.empty());
        when(repository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User result = userService.Register(req);

        assertNotNull(result, "The result should not be null.");
        assertEquals("Ziad", result.getUserName(), "User name should match the input.");
        assertEquals("ZiadTawfik@gmail.com", result.getEmail(), "Email should match the input.");

        verify(repository, times(1)).save(any(User.class));
    }


    @Test
    public void Test_WhenEmail_isExist_ThrowExeption(){

        UserRegistration req = new UserRegistration("Ziad", "admin@example.com", "22222", Student);
        when(repository.findByEmail(req.getEmail())).thenReturn(Optional.of(new User()));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.Register(req));
        assertEquals("Email is already Exist!", exception.getMessage());
        verify(repository, never()).save(any(User.class)); // save is never called

    }


}