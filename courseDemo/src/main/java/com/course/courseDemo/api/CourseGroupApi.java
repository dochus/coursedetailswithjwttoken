package com.course.courseDemo.api;


import com.course.courseDemo.domain.CourseDetails;
import com.course.courseDemo.domain.StudentDetailsFile;
import com.course.courseDemo.dto.CourseDto;

import com.course.courseDemo.dto.StudentDetailsDto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import static com.course.courseDemo.constant.RouteConstants.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name ="Course")
@RequestMapping("/course")
public interface CourseGroupApi {

    @PostMapping(
            value = Registration,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    @Parameter(name = "HIDE_GLOBAL_PARAMETER", description = CONTENT_TYPE)
    StudentDetailsFile create(
            StudentDetailsDto studentDetailsDto, HttpHeaders httpHeaders)
            throws IOException;

    @PostMapping(
            value = AddCourse,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    CourseDetails createCourse(
            CourseDto CourseDto, HttpHeaders httpHeaders)
            throws IOException;

    @GetMapping(
            value = GetCourse,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    List<CourseDto> getCourse(
            HttpHeaders httpHeaders)
            throws IOException;


    @GetMapping(
            value = GetStudentWithCourse,
            produces = APPLICATION_JSON_VALUE,
            consumes = APPLICATION_JSON_VALUE)
    List<StudentDetailsFile> getStudentCourse(
            HttpHeaders httpHeaders)
            throws IOException;

    @DeleteMapping(DeleteStudent)
    @ResponseStatus(NO_CONTENT)
    void delete(UUID id, HttpHeaders httpHeaders) throws UnsupportedEncodingException;

}
