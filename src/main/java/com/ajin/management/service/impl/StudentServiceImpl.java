package com.ajin.management.service.impl;

import com.ajin.management.entity.Student;
import com.ajin.management.mapper.StudentMapper;
import com.ajin.management.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AJin
 * @since 2023-06-03
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
