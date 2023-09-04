package com.course.courseDemo.services;

import com.course.courseDemo.domain.CourseDetails;
import com.course.courseDemo.domain.StudentDetailsFile;
import com.course.courseDemo.dto.CourseDto;
import com.course.courseDemo.dto.StudentCourseDetails;
import com.course.courseDemo.dto.StudentDetailsDto;
import com.course.courseDemo.dto.UuidDto;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    StudentDetailsFile create(StudentDetailsDto studentDetailsDto, HttpHeaders httpHeaders);

    CourseDetails createCourse(CourseDto courseDto, HttpHeaders httpHeaders);

    List<CourseDto> getCourse(HttpHeaders httpHeaders);

    List<StudentDetailsFile> getStudentCourse(HttpHeaders httpHeaders);


    void delete(UUID id, HttpHeaders httpHeaders);
}
