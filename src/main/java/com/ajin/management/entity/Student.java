package com.ajin.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author AJin
 * @since 2023-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    public Student(Long id,String name,Integer absent){
        this.id = id;
        this.name = name;
        this.absent = absent;
    }


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 大头照
     */
    private String photo;

    @NotBlank(message = "学生姓名不能为空")
    private String name;

    @NotBlank
    @Size(min = 11,max = 11)
    private String phone;

    /**
     * 家长名字
     */
    private String parentName;

    /**
     * 家长电话
     */
    private String parentPhone;

    /**
     * 地址
     */
    private String address;

    /**
     * 缺课最低警戒线，1代表缺1节课
     */
    private Integer absent; //5到达警戒线

    /**
     * 考勤权限
     */
    private Boolean power;


}
