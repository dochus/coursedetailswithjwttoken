package com.course.courseDemo.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "courseDetails")
@Table(name = "courseDetails")
public class CourseDetails implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "courseName")
    private String courseName;
    @ManyToMany( mappedBy = "follwedCourseDetails",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<StudentDetailsFile> follwedStudentDetails=new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void followsStudent(StudentDetailsFile studentDetailsFile){
        follwedStudentDetails.add(studentDetailsFile);
    }

    @Override
    public String toString() {
        return "CourseDetails{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
