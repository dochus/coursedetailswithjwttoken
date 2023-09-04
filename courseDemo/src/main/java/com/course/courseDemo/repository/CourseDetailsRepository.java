package com.course.courseDemo.repository;

import com.course.courseDemo.domain.CourseDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseDetailsRepository extends JpaRepository<CourseDetails, UUID> {
@Query("select d from courseDetails d where d.id= ?1")
CourseDetails findByDetails(UUID id);
}
