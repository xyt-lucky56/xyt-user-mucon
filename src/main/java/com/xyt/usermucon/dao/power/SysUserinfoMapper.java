package com.xyt.usermucon.dao.power;


import java.util.List;
import java.util.Map;

import com.xyt.usermucon.dto.power.SysUserinfo;
import com.xyt.usermucon.dto.power.SysUserinfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    long countByExample(SysUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    int deleteByExample(SysUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    int insert(SysUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    int insertSelective(SysUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    List<SysUserinfo> selectByExample(SysUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    SysUserinfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysUserinfo record, @Param("example") SysUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    int updateByExample(@Param("record") SysUserinfo record, @Param("example") SysUserinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    int updateByPrimaryKeySelective(SysUserinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_userinfo
     *
     * @mbg.generated Thu Sep 19 10:37:13 CST 2019
     */
    int updateByPrimaryKey(SysUserinfo record);
    
    List<Map<String,Object>> selectDeptInfo();

    int allocateRoleToUser(Map<String, Object> map);

    int deleteUserLinkRole(@Param("userId") String userId);
}