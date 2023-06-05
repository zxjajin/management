package com.ajin.management.controller;


import com.ajin.management.common.lang.Result;
import com.ajin.management.entity.Teacher;
import com.ajin.management.service.StudentAttendanceService;
import com.ajin.management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author AJin
 * @since 2023-06-03
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private StudentAttendanceService attendanceService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/{id}")
    public Result get(@PathVariable("id") Integer id){
        Teacher teacher = teacherService.getById(id);
        if(teacher!=null){
            return Result.succ(teacher);
        }
        return Result.fail("获取数据失败");
    }

    @GetMapping
    public Result list(){
        List<Teacher> teachers = teacherService.list();
        return Result.succ(teachers);
    }

    @PostMapping
    public Result add(@RequestBody Teacher teacher){
        boolean save = teacherService.save(teacher);
        if(save) {
            return Result.succ("添加成功");
        }
        return Result.fail("添加失败");
    }
    @PutMapping
    public Result update(@RequestBody Teacher teacher){
        boolean result = teacherService.updateById(teacher);
        if(result){
            return Result.succ("修改成功!");
        }
        return Result.fail("修改失败!");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id){
        boolean result = teacherService.removeById(id);
        if(result){
            return Result.succ("删除成功!");
        }
        return Result.fail("删除失败!");
    }


}
