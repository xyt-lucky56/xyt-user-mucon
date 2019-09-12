package com.xyt.usermucon.dao.power;

import com.xyt.usermucon.dto.power.SysGroupinfo;
import com.xyt.usermucon.dto.power.SysGroupinfoExample;
import java.util.List;

import com.xyt.usermucon.dto.power.SysPowerinfo;
import com.xyt.usermucon.dto.power.SysSystemname;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysGroupinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    long countByExample(SysGroupinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    int deleteByExample(SysGroupinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    int insert(SysGroupinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    int insertSelective(SysGroupinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    List<SysGroupinfo> selectByExample(SysGroupinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    SysGroupinfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysGroupinfo record, @Param("example") SysGroupinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    int updateByExample(@Param("record") SysGroupinfo record, @Param("example") SysGroupinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    int updateByPrimaryKeySelective(SysGroupinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_groupinfo
     *
     * @mbg.generated Thu Sep 05 09:30:25 CST 2019
     */
    int updateByPrimaryKey(SysGroupinfo record);

    /**
     * 查询含有该一级菜单的数量
     * @param groupname
     * @return
     */
    Integer queryGroupByName(String groupname);

    /**
     * 查询当前一级菜单下的权限
     * @param groupId
     * @return
     */
    Integer queryGrouplinkpowerByGroupId(String groupId);

    /**
     * 查询该一级菜单下的权限
     * @param groupId
     * @return
     */
    List<SysPowerinfo> selectPowerinfo(String groupId);

    /**
     *
     * @param name
     * @return
     */
    List<SysSystemname> queryPermissionsMeun(@Param("name") String name);

    /**
     * 全查询一级菜单
     * @param systemname
     * @param searchName
     * @return
     */
    List<SysGroupinfo> selectSysGroupinfo(@Param("systemname")String systemname,@Param("searchName")String searchName);

    List<SysGroupinfo> selectSysGroupInfoTest();
}