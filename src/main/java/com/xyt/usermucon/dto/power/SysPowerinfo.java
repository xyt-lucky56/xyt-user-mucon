package com.xyt.usermucon.dto.power;

import java.util.List;

public class SysPowerinfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.id
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String id;
    private String powerId;
    private String groupId;
    private String groupname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.powerName
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String powername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.powerContent
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String powercontent;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.powerType
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String powertype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.paramStr
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String paramstr;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.relativePath
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String relativepath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.fileName
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String filename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.picRelativePath
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String picrelativepath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.picName
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String picname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.formType
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String formtype;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.stopSign
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private Boolean stopsign;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_powerinfo.remark
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    private String remark;

    private String searchName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.id
     *
     * @return the value of sys_powerinfo.id
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.id
     *
     * @param id the value for sys_powerinfo.id
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.powerName
     *
     * @return the value of sys_powerinfo.powerName
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getPowername() {
        return powername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.powerName
     *
     * @param powername the value for sys_powerinfo.powerName
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setPowername(String powername) {
        this.powername = powername == null ? null : powername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.powerContent
     *
     * @return the value of sys_powerinfo.powerContent
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getPowercontent() {
        return powercontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.powerContent
     *
     * @param powercontent the value for sys_powerinfo.powerContent
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setPowercontent(String powercontent) {
        this.powercontent = powercontent == null ? null : powercontent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.powerType
     *
     * @return the value of sys_powerinfo.powerType
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getPowertype() {
        return powertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.powerType
     *
     * @param powertype the value for sys_powerinfo.powerType
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setPowertype(String powertype) {
        this.powertype = powertype == null ? null : powertype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.paramStr
     *
     * @return the value of sys_powerinfo.paramStr
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getParamstr() {
        return paramstr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.paramStr
     *
     * @param paramstr the value for sys_powerinfo.paramStr
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setParamstr(String paramstr) {
        this.paramstr = paramstr == null ? null : paramstr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.relativePath
     *
     * @return the value of sys_powerinfo.relativePath
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getRelativepath() {
        return relativepath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.relativePath
     *
     * @param relativepath the value for sys_powerinfo.relativePath
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setRelativepath(String relativepath) {
        this.relativepath = relativepath == null ? null : relativepath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.fileName
     *
     * @return the value of sys_powerinfo.fileName
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getFilename() {
        return filename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.fileName
     *
     * @param filename the value for sys_powerinfo.fileName
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.picRelativePath
     *
     * @return the value of sys_powerinfo.picRelativePath
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getPicrelativepath() {
        return picrelativepath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.picRelativePath
     *
     * @param picrelativepath the value for sys_powerinfo.picRelativePath
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setPicrelativepath(String picrelativepath) {
        this.picrelativepath = picrelativepath == null ? null : picrelativepath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.picName
     *
     * @return the value of sys_powerinfo.picName
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getPicname() {
        return picname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.picName
     *
     * @param picname the value for sys_powerinfo.picName
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setPicname(String picname) {
        this.picname = picname == null ? null : picname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.formType
     *
     * @return the value of sys_powerinfo.formType
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getFormtype() {
        return formtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.formType
     *
     * @param formtype the value for sys_powerinfo.formType
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setFormtype(String formtype) {
        this.formtype = formtype == null ? null : formtype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.stopSign
     *
     * @return the value of sys_powerinfo.stopSign
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public Boolean getStopsign() {
        return stopsign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.stopSign
     *
     * @param stopsign the value for sys_powerinfo.stopSign
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setStopsign(Boolean stopsign) {
        this.stopsign = stopsign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_powerinfo.remark
     *
     * @return the value of sys_powerinfo.remark
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_powerinfo.remark
     *
     * @param remark the value for sys_powerinfo.remark
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPowerId() {
        return powerId;
    }

    public void setPowerId(String powerId) {
        this.powerId = powerId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }
}