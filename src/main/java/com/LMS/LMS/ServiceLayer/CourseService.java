package com.LMS.LMS.ServiceLayer;

import com.LMS.LMS.DTO.CourseDTO;
import com.LMS.LMS.ModelLayer.Course;
import com.LMS.LMS.ModelLayer.User;
import com.LMS.LMS.RepositoryLayer.CourseRepository;
import com.LMS.LMS.RepositoryLayer.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

//    public Course createCourse(CourseDTO courseDTO) {
//        // Find the instructor from the database
//        User instructor = userRepository.findById((long) courseDTO.getInstructor().getID())
//                .orElseThrow(() -> new RuntimeException("Instructor not found"));
//
//        // Create a new course entity
//        Course course = new Course();
//        course.setTitle(courseDTO.getTitle());
//        course.setDescription(courseDTO.getDescription());
//        course.setDuration(courseDTO.getDuration());
//        course.setMediaFiles(courseDTO.getMediaFiles());
//        course.setInstructor(instructor);
//
//        return courseRepository.save(course);
//    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courses = courseRepository.findAll();
        return courses;
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }
}
