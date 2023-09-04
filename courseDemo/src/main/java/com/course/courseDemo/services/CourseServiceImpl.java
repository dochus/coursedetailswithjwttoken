package com.course.courseDemo.services;

import com.course.courseDemo.dao.CourseDetailsDao;
import com.course.courseDemo.domain.CourseDetails;
import com.course.courseDemo.domain.StudentDetailsFile;
import com.course.courseDemo.dto.CourseDto;
import com.course.courseDemo.dto.StudentDetailsDto;
import com.course.courseDemo.exception.RestExceptionHandler;
import com.course.courseDemo.repository.CourseDetailsRepository;
import com.course.courseDemo.repository.StudentDetailsRepository;

import javassist.tools.rmi.ObjectNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseServiceImpl implements CourseService{

    private CourseDetailsRepository courseDetailsRepository;
    private StudentDetailsRepository studentDetailsRepository;

    private CourseDetailsDao courseDetailsDao;


    @Override
    public StudentDetailsFile create(StudentDetailsDto studentDetailsDto, HttpHeaders httpHeaders) {
if(studentDetailsDto.getId()==null){
    CourseDetails courseDetails =courseDetailsRepository.findByDetails(studentDetailsDto.getCourseId());
    if(courseDetails==null){
        throw new IllegalArgumentException("Invaild Course Id ");
    }
    StudentDetailsFile studentDetails =new StudentDetailsFile();
    studentDetails.setAddress(studentDetailsDto.getAddress());
    studentDetails.setEmailAddress(studentDetailsDto.getEmailAddress());
    studentDetails.setTelephone(studentDetailsDto.getTelephone());
    studentDetails.setFullName(studentDetailsDto.getFullName());
    studentDetails.followsCourseDetails(courseDetails);
    return studentDetailsRepository.save(studentDetails);
}else {
    CourseDetails courseDetails =courseDetailsRepository.findByDetails(studentDetailsDto.getCourseId());
    StudentDetailsFile studentDetails =new StudentDetailsFile();
    studentDetails.setAddress(studentDetailsDto.getAddress());
    studentDetails.setEmailAddress(studentDetailsDto.getEmailAddress());
    studentDetails.setTelephone(studentDetailsDto.getTelephone());
    studentDetails.setFullName(studentDetailsDto.getFullName());
    studentDetails.followsCourseDetails(courseDetails);
    studentDetails.setId(studentDetailsDto.getId());
    return studentDetailsRepository.saveAndFlush(studentDetails);
}

    }

    @Override
    public CourseDetails createCourse(CourseDto courseDto, HttpHeaders httpHeaders) {
        System.out.println(courseDto);
        CourseDetails courseDetails=new CourseDetails();
        courseDetails.setCourseName(courseDto.getCourseName());

        return courseDetailsRepository.save(courseDetails);
    }

    @Override
    public List<CourseDto> getCourse(HttpHeaders httpHeaders) {
        return courseDetailsDao.findAll().stream()
                .map(this::buildCourseResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDetailsFile> getStudentCourse(HttpHeaders httpHeaders) {
        return studentDetailsRepository.findAll();
    }

    @Override
    public void delete(UUID id, HttpHeaders httpHeaders) {
         studentDetailsRepository.deleteById(id);
    }


    private CourseDto buildCourseResponse(CourseDetails courseDetails) {
        return CourseDto.builder()
                .courseName(courseDetails.getCourseName())
                .build();
    }
}
