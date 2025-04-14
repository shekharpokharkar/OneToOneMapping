package com.shekhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shekhar.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
