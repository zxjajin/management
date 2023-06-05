package com.ajin.management;

import com.ajin.management.entity.Student;
import com.ajin.management.entity.StudentAttendance;
import com.ajin.management.service.StudentAttendanceService;
import com.ajin.management.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@SpringBootTest
class ManagementApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentAttendanceService service;

    @Test
    void contextLoads() {
        System.out.println(dataSource);
        System.out.println(dataSource.getClass());
    }

    @Test
    void test1(){
        for (StudentAttendance studentAttendance : service.list()) {
            System.out.println(studentAttendance);
        }

    }

    @Test
    void test2(){
        for (Student student : studentService.list()) {
            System.out.println(student);
        }

    }
}
