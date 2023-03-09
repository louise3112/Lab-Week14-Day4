package com.codeclan.bookingservice.repositories;

import com.codeclan.bookingservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //QUERIES

    //GET ALL CUSTOMERS FOR A GIVEN COURSE:
    List<Customer> findByBookingsCourseId(Long id);

    //GET ALL CUSTOMERS IN A TOWN BOOKED ON A GIVEN COURSE:
    List<Customer> findByTownAndBookingsCourseId(String town, Long id);

    //GET ALL CUSTOMERS IN A TOWN BOOKED ON A GIVEN COURSE OVER A GIVEN AGE:
    List<Customer> findByTownAndBookingsCourseIdAndAgeGreaterThan (String town, Long id, int Age);
}
