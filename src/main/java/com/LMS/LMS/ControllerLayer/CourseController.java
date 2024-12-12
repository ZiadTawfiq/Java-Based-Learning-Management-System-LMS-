package com.LMS.LMS.ControllerLayer;

import com.LMS.LMS.DTO.CourseDTO;
import com.LMS.LMS.ModelLayer.Course;
import com.LMS.LMS.ServiceLayer.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Courses")
public class CourseController {


    @Autowired
    private  CourseService courseService;



//    @PostMapping
//    public ResponseEntity<String> createCourse(@RequestBody CourseDTO courseDTO) {
//        courseService.createCourse(courseDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Course created successfully.");
//    }


    @GetMapping
    public ResponseEntity getAllCourses() {

        return ResponseEntity.ok(courseService.getAllCourses());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable int id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully.");
    }
}
