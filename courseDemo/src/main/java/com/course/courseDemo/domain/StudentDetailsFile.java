package com.course.courseDemo.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "StudentDetailsFile")
@Table(name = "StudentDetailsFile")
public class StudentDetailsFile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "telephonedetails")
    private String telephone;
    @Column(name = "email_address")
    private String emailAddress;

    @ManyToMany
    @JoinTable(name ="follwed_studentDetails",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name= "student_id")
    )
    private List<CourseDetails> follwedCourseDetails=new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void followsCourseDetails (CourseDetails courseDetails){
        follwedCourseDetails.add(courseDetails);
    }

    public void removeCourseDetails (CourseDetails courseDetails){
        follwedCourseDetails.remove(courseDetails);
    }

    public List<CourseDetails> getFollwedCourseDetails() {
        return follwedCourseDetails;
    }

    public void setFollwedCourseDetails(List<CourseDetails> follwedCourseDetails) {
        this.follwedCourseDetails = follwedCourseDetails;
    }

    @Override
    public String toString() {
        return "StudentDetailsFile{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", follwedCourseDetails=" + follwedCourseDetails +
                '}';
    }
}
