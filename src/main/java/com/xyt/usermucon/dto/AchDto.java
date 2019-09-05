package com.xyt.usermucon.dto;

import java.io.Serializable;

/**
 * @author ：杜志诚
 * @create 2019-08-22 14:36
 * @function
 * @editLog
 */
public class AchDto<serializer> implements Serializable {
    public String getPerId() {
        return perId;
    }

    public void setPerId(String perId) {
        this.perId = perId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    /**
     * 外键
     */
    private String perId;
    /**
     *  科目名称
     */
    private String subjectName;
    /**
     * 成绩
     */
    private Integer achievement;
    /**
     * 当前时间
     */
    private String workTime;
}
