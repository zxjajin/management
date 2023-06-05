package com.ajin.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("student_attendance")
public class StudentAttendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id; //id

    private Long studentId; //对应学生id

    private Integer teacherId; //老师id

    private String name;//学生名字

    private String leaveReason; //请假原因

    private Boolean leaveSchool; //是否离开学校，true为离开，false不离开

    private String arriveAdress; //离开才用到的，离校到达地点

    private Date backSchool; //什么时候回学校

    private Date createTime;//请假时间

    /**
     * 班主任审批是否通过
     */
    private Boolean teacherAudit;

    /**
     * 班主任拒绝请假
     */
    private Boolean refuse;


}
