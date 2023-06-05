package com.ajin.management.controller;


import com.ajin.management.common.lang.Result;
import com.ajin.management.entity.StudentAttendance;
import com.ajin.management.service.StudentAttendanceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
@RequestMapping("/attendance")
public class StudentAttendanceController {

    @Autowired
    private StudentAttendanceService service;

    @GetMapping("/{id}")
    public Result get(@PathVariable("id") Integer id){
        StudentAttendance attendance = service.getById(id);
        if(attendance != null){
            return Result.succ(attendance);
        }
        return Result.fail("获取数据失败");
    }


    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage,5);
        IPage list = service.page(page, new QueryWrapper<StudentAttendance>().orderByDesc("create_time"));
        return Result.succ(list);
    }

    @PostMapping
    public Result add(@RequestBody StudentAttendance studentAttendance){
        boolean save = service.save(studentAttendance);
        if(save) {
            return Result.succ("添加成功");
        }
        return Result.fail("添加失败");
    }

    @PutMapping
    public Result update(@RequestBody StudentAttendance studentAttendance){
        boolean result = service.updateById(studentAttendance);
        if(result){
            return Result.succ("修改成功!");
        }
        return Result.fail("修改失败!");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id){
        boolean result = service.removeById(id);
        if(result){
            return Result.succ("删除成功!");
        }
        return Result.fail("删除失败!");
    }





}
