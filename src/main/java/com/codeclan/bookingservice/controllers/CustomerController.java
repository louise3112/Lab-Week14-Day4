package com.codeclan.bookingservice.controllers;

import com.codeclan.bookingservice.models.Course;
import com.codeclan.bookingservice.models.Customer;
import com.codeclan.bookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value ="/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            //http://localhost:8080/customers?courseId=1
            @RequestParam(name = "courseId", required = false) Long courseId,
            //http://localhost:8080/customers?town=Charleston&courseId=1
            @RequestParam(name = "town", required = false) String town,
            //http://localhost:8080/customers?town=Dunbar&courseId=1&age=30
            @RequestParam(name = "age", required = false) Integer age
            ) {
        if(town != null && courseId != null && age != null) {
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseIdAndAgeGreaterThan(town, courseId, age), HttpStatus.OK);
        }
        if(town != null && courseId != null) {
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseId(town, courseId), HttpStatus.OK);
        }
        if(courseId != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(courseId), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
