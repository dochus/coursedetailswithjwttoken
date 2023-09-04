package com.course.courseDemo.dto;

import com.course.courseDemo.validator.StringNotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseDto {
    @StringNotBlank(message = "Course Name not be empty or null.")
    private String courseName;



}