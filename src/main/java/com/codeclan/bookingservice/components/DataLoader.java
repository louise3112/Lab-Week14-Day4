package com.codeclan.bookingservice.components;

import com.codeclan.bookingservice.models.Booking;
import com.codeclan.bookingservice.models.Course;
import com.codeclan.bookingservice.models.Customer;
import com.codeclan.bookingservice.repositories.BookingRepository;
import com.codeclan.bookingservice.repositories.CourseRepository;
import com.codeclan.bookingservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {}

    public void run(ApplicationArguments args) {
        Course course1 = new Course("Java", "Edinburgh", 3);
        Course course2 = new Course("Python", "Glasgow", 4);
        courseRepository.save(course1);
        courseRepository.save(course2);

        Customer customer1 = new Customer("Eilidh", "Charleston", 35);
        Customer customer2 = new Customer("Louise", "Dunbar", 33);
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        Booking booking1 = new Booking("09-03-23", course1, customer1);
        Booking booking2 = new Booking("25-06-22", course2, customer1);
        Booking booking3 = new Booking("12-08-23", course1, customer2);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
    }
}
