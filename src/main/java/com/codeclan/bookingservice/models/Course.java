package com.codeclan.bookingservice.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    //INSTANCE VARIABLES:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "rating")
    private int rating;

    //ONE TO MANY:
    @OneToMany(mappedBy = "course")
    //mappedBy = name of the variable in booking
    private List<Booking> bookings;

    //CONSTRUCTOR:
    public Course(String name, String location, int rating) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.bookings = new ArrayList<>();
    }

    //EMPTY CONSTRUCTION:
    public Course() {}

    //SETTERS AND GETTERS:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
