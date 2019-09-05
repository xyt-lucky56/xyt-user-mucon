package com.xyt.usermucon.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：杜志诚诚
 * @create 2019-08-22 14:36
 * @function
 * @editLog
 */
public class PerDto implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

    public List<AchDto> getAchDtos() {
        return achDtos;
    }

    public void setAchDtos(List<AchDto> achDtos) {
        this.achDtos = achDtos;
    }

    /**
     * 主键
     */
    private String id;
    /**
     *  姓名
     */
    private String name;
    /**
     *  性别（0：男、1：女）
     */
    private String sex;
    /**
     *  年龄
     */
    private Integer age;
    /**
     *  班级序号
     */
    private Integer classNo;
    /**
     * 关联外表
     */
    private List<AchDto> achDtos;
}

