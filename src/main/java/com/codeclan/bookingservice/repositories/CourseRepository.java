package com.codeclan.bookingservice.repositories;

import com.codeclan.bookingservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //QUERIES

    //GET ALL COURSES WITH GIVEN RATING
    List<Course> findByRating(int rating);
    //GET ALL COURSES BY CUSTOMER:
    List<Course> findByBookingsCustomerId(Long id);
}
