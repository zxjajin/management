package com.ajin.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author ajin
 * @create 2023-06-04 22:31
 */
@Data
public class Attendance {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @NotBlank(message = "学生姓名不能为空")
    private String name;
    /**
     * 缺课最低警戒线，1代表缺1节课
     */
    private Integer absent; //5到达警戒线
}
