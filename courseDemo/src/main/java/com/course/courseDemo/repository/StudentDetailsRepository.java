package com.course.courseDemo.repository;

import com.course.courseDemo.domain.StudentDetailsFile;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.UUID;
@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetailsFile, UUID> {




}
