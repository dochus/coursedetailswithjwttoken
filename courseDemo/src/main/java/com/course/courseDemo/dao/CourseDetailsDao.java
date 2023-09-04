package com.course.courseDemo.dao;

import com.course.courseDemo.domain.CourseDetails;
import com.course.courseDemo.repository.CourseDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseDetailsDao {

    private CourseDetailsRepository courseDetailsRepository;

    public List<CourseDetails> findAll() {
        List<CourseDetails> emailTemplates = (List<CourseDetails>) courseDetailsRepository.findAll();
        return emailTemplates.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }
}
