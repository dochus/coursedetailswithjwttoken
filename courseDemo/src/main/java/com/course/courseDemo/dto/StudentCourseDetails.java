package com.course.courseDemo.dto;

import com.course.courseDemo.domain.CourseDetails;
import com.course.courseDemo.domain.StudentDetailsFile;
import com.course.courseDemo.validator.StringNotBlank;
import com.course.courseDemo.validator.ValidEmail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentCourseDetails {

    private UUID courseId;
    private UUID studentId;

}
