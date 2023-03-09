package com.codeclan.bookingservice.controllers;

import com.codeclan.bookingservice.models.Course;
import com.codeclan.bookingservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value ="/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name ="rating", required = false) Integer rating,
            @RequestParam(name ="customerId", required = false) Long customerId
    ) {
        if(rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        } //http://localhost:8080/courses?rating=3
        if(customerId != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerId(customerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(value ="/courses/ratings/{rating}")
//    public ResponseEntity<List<Course>> getAllCoursesByRating(@PathVariable int rating) {
//        return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
//    }


}
