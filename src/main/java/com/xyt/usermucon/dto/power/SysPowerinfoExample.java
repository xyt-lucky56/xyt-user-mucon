package com.xyt.usermucon.dto.power;

import java.util.ArrayList;
import java.util.List;

public class SysPowerinfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public SysPowerinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPowernameIsNull() {
            addCriterion("powerName is null");
            return (Criteria) this;
        }

        public Criteria andPowernameIsNotNull() {
            addCriterion("powerName is not null");
            return (Criteria) this;
        }

        public Criteria andPowernameEqualTo(String value) {
            addCriterion("powerName =", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotEqualTo(String value) {
            addCriterion("powerName <>", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameGreaterThan(String value) {
            addCriterion("powerName >", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameGreaterThanOrEqualTo(String value) {
            addCriterion("powerName >=", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameLessThan(String value) {
            addCriterion("powerName <", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameLessThanOrEqualTo(String value) {
            addCriterion("powerName <=", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameLike(String value) {
            addCriterion("powerName like", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotLike(String value) {
            addCriterion("powerName not like", value, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameIn(List<String> values) {
            addCriterion("powerName in", values, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotIn(List<String> values) {
            addCriterion("powerName not in", values, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameBetween(String value1, String value2) {
            addCriterion("powerName between", value1, value2, "powername");
            return (Criteria) this;
        }

        public Criteria andPowernameNotBetween(String value1, String value2) {
            addCriterion("powerName not between", value1, value2, "powername");
            return (Criteria) this;
        }

        public Criteria andPowercontentIsNull() {
            addCriterion("powerContent is null");
            return (Criteria) this;
        }

        public Criteria andPowercontentIsNotNull() {
            addCriterion("powerContent is not null");
            return (Criteria) this;
        }

        public Criteria andPowercontentEqualTo(String value) {
            addCriterion("powerContent =", value, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentNotEqualTo(String value) {
            addCriterion("powerContent <>", value, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentGreaterThan(String value) {
            addCriterion("powerContent >", value, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentGreaterThanOrEqualTo(String value) {
            addCriterion("powerContent >=", value, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentLessThan(String value) {
            addCriterion("powerContent <", value, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentLessThanOrEqualTo(String value) {
            addCriterion("powerContent <=", value, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentLike(String value) {
            addCriterion("powerContent like", value, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentNotLike(String value) {
            addCriterion("powerContent not like", value, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentIn(List<String> values) {
            addCriterion("powerContent in", values, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentNotIn(List<String> values) {
            addCriterion("powerContent not in", values, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentBetween(String value1, String value2) {
            addCriterion("powerContent between", value1, value2, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowercontentNotBetween(String value1, String value2) {
            addCriterion("powerContent not between", value1, value2, "powercontent");
            return (Criteria) this;
        }

        public Criteria andPowertypeIsNull() {
            addCriterion("powerType is null");
            return (Criteria) this;
        }

        public Criteria andPowertypeIsNotNull() {
            addCriterion("powerType is not null");
            return (Criteria) this;
        }

        public Criteria andPowertypeEqualTo(String value) {
            addCriterion("powerType =", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeNotEqualTo(String value) {
            addCriterion("powerType <>", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeGreaterThan(String value) {
            addCriterion("powerType >", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeGreaterThanOrEqualTo(String value) {
            addCriterion("powerType >=", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeLessThan(String value) {
            addCriterion("powerType <", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeLessThanOrEqualTo(String value) {
            addCriterion("powerType <=", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeLike(String value) {
            addCriterion("powerType like", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeNotLike(String value) {
            addCriterion("powerType not like", value, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeIn(List<String> values) {
            addCriterion("powerType in", values, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeNotIn(List<String> values) {
            addCriterion("powerType not in", values, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeBetween(String value1, String value2) {
            addCriterion("powerType between", value1, value2, "powertype");
            return (Criteria) this;
        }

        public Criteria andPowertypeNotBetween(String value1, String value2) {
            addCriterion("powerType not between", value1, value2, "powertype");
            return (Criteria) this;
        }

        public Criteria andParamstrIsNull() {
            addCriterion("paramStr is null");
            return (Criteria) this;
        }

        public Criteria andParamstrIsNotNull() {
            addCriterion("paramStr is not null");
            return (Criteria) this;
        }

        public Criteria andParamstrEqualTo(String value) {
            addCriterion("paramStr =", value, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrNotEqualTo(String value) {
            addCriterion("paramStr <>", value, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrGreaterThan(String value) {
            addCriterion("paramStr >", value, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrGreaterThanOrEqualTo(String value) {
            addCriterion("paramStr >=", value, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrLessThan(String value) {
            addCriterion("paramStr <", value, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrLessThanOrEqualTo(String value) {
            addCriterion("paramStr <=", value, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrLike(String value) {
            addCriterion("paramStr like", value, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrNotLike(String value) {
            addCriterion("paramStr not like", value, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrIn(List<String> values) {
            addCriterion("paramStr in", values, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrNotIn(List<String> values) {
            addCriterion("paramStr not in", values, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrBetween(String value1, String value2) {
            addCriterion("paramStr between", value1, value2, "paramstr");
            return (Criteria) this;
        }

        public Criteria andParamstrNotBetween(String value1, String value2) {
            addCriterion("paramStr not between", value1, value2, "paramstr");
            return (Criteria) this;
        }

        public Criteria andRelativepathIsNull() {
            addCriterion("relativePath is null");
            return (Criteria) this;
        }

        public Criteria andRelativepathIsNotNull() {
            addCriterion("relativePath is not null");
            return (Criteria) this;
        }

        public Criteria andRelativepathEqualTo(String value) {
            addCriterion("relativePath =", value, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathNotEqualTo(String value) {
            addCriterion("relativePath <>", value, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathGreaterThan(String value) {
            addCriterion("relativePath >", value, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathGreaterThanOrEqualTo(String value) {
            addCriterion("relativePath >=", value, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathLessThan(String value) {
            addCriterion("relativePath <", value, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathLessThanOrEqualTo(String value) {
            addCriterion("relativePath <=", value, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathLike(String value) {
            addCriterion("relativePath like", value, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathNotLike(String value) {
            addCriterion("relativePath not like", value, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathIn(List<String> values) {
            addCriterion("relativePath in", values, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathNotIn(List<String> values) {
            addCriterion("relativePath not in", values, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathBetween(String value1, String value2) {
            addCriterion("relativePath between", value1, value2, "relativepath");
            return (Criteria) this;
        }

        public Criteria andRelativepathNotBetween(String value1, String value2) {
            addCriterion("relativePath not between", value1, value2, "relativepath");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("fileName is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("fileName is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("fileName =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("fileName <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("fileName >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("fileName >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("fileName <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("fileName <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("fileName like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("fileName not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("fileName in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("fileName not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("fileName between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("fileName not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathIsNull() {
            addCriterion("picRelativePath is null");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathIsNotNull() {
            addCriterion("picRelativePath is not null");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathEqualTo(String value) {
            addCriterion("picRelativePath =", value, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathNotEqualTo(String value) {
            addCriterion("picRelativePath <>", value, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathGreaterThan(String value) {
            addCriterion("picRelativePath >", value, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathGreaterThanOrEqualTo(String value) {
            addCriterion("picRelativePath >=", value, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathLessThan(String value) {
            addCriterion("picRelativePath <", value, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathLessThanOrEqualTo(String value) {
            addCriterion("picRelativePath <=", value, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathLike(String value) {
            addCriterion("picRelativePath like", value, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathNotLike(String value) {
            addCriterion("picRelativePath not like", value, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathIn(List<String> values) {
            addCriterion("picRelativePath in", values, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathNotIn(List<String> values) {
            addCriterion("picRelativePath not in", values, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathBetween(String value1, String value2) {
            addCriterion("picRelativePath between", value1, value2, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicrelativepathNotBetween(String value1, String value2) {
            addCriterion("picRelativePath not between", value1, value2, "picrelativepath");
            return (Criteria) this;
        }

        public Criteria andPicnameIsNull() {
            addCriterion("picName is null");
            return (Criteria) this;
        }

        public Criteria andPicnameIsNotNull() {
            addCriterion("picName is not null");
            return (Criteria) this;
        }

        public Criteria andPicnameEqualTo(String value) {
            addCriterion("picName =", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameNotEqualTo(String value) {
            addCriterion("picName <>", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameGreaterThan(String value) {
            addCriterion("picName >", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameGreaterThanOrEqualTo(String value) {
            addCriterion("picName >=", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameLessThan(String value) {
            addCriterion("picName <", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameLessThanOrEqualTo(String value) {
            addCriterion("picName <=", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameLike(String value) {
            addCriterion("picName like", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameNotLike(String value) {
            addCriterion("picName not like", value, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameIn(List<String> values) {
            addCriterion("picName in", values, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameNotIn(List<String> values) {
            addCriterion("picName not in", values, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameBetween(String value1, String value2) {
            addCriterion("picName between", value1, value2, "picname");
            return (Criteria) this;
        }

        public Criteria andPicnameNotBetween(String value1, String value2) {
            addCriterion("picName not between", value1, value2, "picname");
            return (Criteria) this;
        }

        public Criteria andFormtypeIsNull() {
            addCriterion("formType is null");
            return (Criteria) this;
        }

        public Criteria andFormtypeIsNotNull() {
            addCriterion("formType is not null");
            return (Criteria) this;
        }

        public Criteria andFormtypeEqualTo(String value) {
            addCriterion("formType =", value, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeNotEqualTo(String value) {
            addCriterion("formType <>", value, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeGreaterThan(String value) {
            addCriterion("formType >", value, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeGreaterThanOrEqualTo(String value) {
            addCriterion("formType >=", value, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeLessThan(String value) {
            addCriterion("formType <", value, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeLessThanOrEqualTo(String value) {
            addCriterion("formType <=", value, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeLike(String value) {
            addCriterion("formType like", value, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeNotLike(String value) {
            addCriterion("formType not like", value, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeIn(List<String> values) {
            addCriterion("formType in", values, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeNotIn(List<String> values) {
            addCriterion("formType not in", values, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeBetween(String value1, String value2) {
            addCriterion("formType between", value1, value2, "formtype");
            return (Criteria) this;
        }

        public Criteria andFormtypeNotBetween(String value1, String value2) {
            addCriterion("formType not between", value1, value2, "formtype");
            return (Criteria) this;
        }

        public Criteria andStopsignIsNull() {
            addCriterion("stopSign is null");
            return (Criteria) this;
        }

        public Criteria andStopsignIsNotNull() {
            addCriterion("stopSign is not null");
            return (Criteria) this;
        }

        public Criteria andStopsignEqualTo(Boolean value) {
            addCriterion("stopSign =", value, "stopsign");
            return (Criteria) this;
        }

        public Criteria andStopsignNotEqualTo(Boolean value) {
            addCriterion("stopSign <>", value, "stopsign");
            return (Criteria) this;
        }

        public Criteria andStopsignGreaterThan(Boolean value) {
            addCriterion("stopSign >", value, "stopsign");
            return (Criteria) this;
        }

        public Criteria andStopsignGreaterThanOrEqualTo(Boolean value) {
            addCriterion("stopSign >=", value, "stopsign");
            return (Criteria) this;
        }

        public Criteria andStopsignLessThan(Boolean value) {
            addCriterion("stopSign <", value, "stopsign");
            return (Criteria) this;
        }

        public Criteria andStopsignLessThanOrEqualTo(Boolean value) {
            addCriterion("stopSign <=", value, "stopsign");
            return (Criteria) this;
        }

        public Criteria andStopsignIn(List<Boolean> values) {
            addCriterion("stopSign in", values, "stopsign");
            return (Criteria) this;
        }

        public Criteria andStopsignNotIn(List<Boolean> values) {
            addCriterion("stopSign not in", values, "stopsign");
            return (Criteria) this;
        }

        public Criteria andStopsignBetween(Boolean value1, Boolean value2) {
            addCriterion("stopSign between", value1, value2, "stopsign");
            return (Criteria) this;
        }

        public Criteria andStopsignNotBetween(Boolean value1, Boolean value2) {
            addCriterion("stopSign not between", value1, value2, "stopsign");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_powerinfo
     *
     * @mbg.generated do_not_delete_during_merge Thu Sep 05 09:30:25 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_powerinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}