package com.course.courseDemo.api;

import com.course.courseDemo.domain.CourseDetails;
import com.course.courseDemo.domain.StudentDetailsFile;
import com.course.courseDemo.dto.CourseDto;
import com.course.courseDemo.dto.StudentDetailsDto;
import com.course.courseDemo.services.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseGroupApiImpl implements CourseGroupApi{

    private CourseService courseService;

    @Override
    public StudentDetailsFile create(@Valid @RequestBody StudentDetailsDto studentDetailsDto, @RequestHeader HttpHeaders httpHeaders) throws IOException {
       return courseService.create(studentDetailsDto,httpHeaders);
    }

    @Override
    public CourseDetails createCourse(@Valid @RequestBody CourseDto courseDto, @RequestHeader HttpHeaders httpHeaders) throws IOException {
        return courseService.createCourse(courseDto,httpHeaders);
    }

    @Override
    public List<CourseDto> getCourse(@RequestHeader HttpHeaders httpHeaders) throws IOException {
        return courseService.getCourse(httpHeaders);
    }

    @Override
    public List<StudentDetailsFile> getStudentCourse(@RequestHeader HttpHeaders httpHeaders) throws IOException {
        return courseService.getStudentCourse(httpHeaders);
    }

    @Override
    public void delete(@PathVariable("id") UUID id, @RequestHeader HttpHeaders httpHeaders) throws UnsupportedEncodingException {
        courseService.delete(id,httpHeaders);
    }


}
