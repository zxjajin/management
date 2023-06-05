package com.ajin.management.controller;


import com.ajin.management.common.lang.Result;
import com.ajin.management.entity.Attendance;
import com.ajin.management.entity.Student;
import com.ajin.management.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AJin
 * @since 2023-06-03
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Result student(@PathVariable("id") Long id){
        Student student = studentService.getById(id);
        if(student!=null){
            return Result.succ(student);
        }
        return Result.fail("获取学生数据失败!");
    }

    /**
     * 查看学生基本信息
     */
    @GetMapping("/student")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage, 5);
        IPage pageDate = studentService.page(page, new QueryWrapper<Student>().orderByAsc("id"));
        if(pageDate == null){
            return Result.fail("获取学生信息失败");
        }
        return Result.succ(pageDate);
    }
    @PostMapping("/student")
    public Result add(@Validated @RequestBody Student student){
        boolean result = studentService.save(student);
        if(result) {
            return Result.succ("添加学生信息成功");
        }
        return Result.fail("添加学生信息失败");
    }
    @PostMapping("/absent")
    public Result absent(@Validated @RequestBody Attendance attendance){
        if(attendance.getId() != null && attendance.getId() != 0){
            Student student = new Student(attendance.getId(), attendance.getName(), attendance.getAbsent());
            boolean b = studentService.updateById(student);
            if(b){
                return Result.succ("修改成功!");
            }
        }
        return Result.fail("修改失败!");
    }

    @PutMapping("/student")
    public Result update(@Validated @RequestBody Student student){
        if(student.getId() != null && student.getId() != 0){
        boolean b = studentService.updateById(student);
            if(b){
                return Result.succ("修改成功!");
            }
        }
        return Result.fail("修改失败!");

    }

    @DeleteMapping("/student/{id}")
    public Result delete(@PathVariable("id") Long id){
        boolean b = studentService.removeById(id);
        if(b){
            return Result.succ("删除成功!");
        }
        return Result.fail("删除失败!");
    }
}
