package com.xyt.usermucon.dao.power;

import java.util.List;

import com.xyt.usermucon.dto.power.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleinfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    long countByExample(SysRoleinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    int deleteByExample(SysRoleinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    int insert(SysRoleinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    int insertSelective(SysRoleinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    List<SysRoleinfo> selectByExample(SysRoleinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    SysRoleinfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysRoleinfo record, @Param("example") SysRoleinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    int updateByExample(@Param("record") SysRoleinfo record, @Param("example") SysRoleinfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    int updateByPrimaryKeySelective(SysRoleinfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_roleinfo
     *
     * @mbg.generated Wed Sep 04 14:40:50 CST 2019
     */
    int updateByPrimaryKey(SysRoleinfo record);

    /**
     * 查询含有该角色名称的数量
     * @param rolename
     * @return
     */
    Integer queryRoleByName(String rolename);

    /**
     * 角色-查询角色的权限
     * @return
     */
    List<SysPowerinfo> permissionsToQueryRoles(@Param("id") String id,@Param("systemname") String systemname);

    /**
     * 角色-查询所有权限
     * @return
     */
    List<SysPowerinfo> queryPermissions(@Param("systemname") String systemname);

    /**
     *  获取该角色的所有权限
     * @param roleId
     * @return
     */
    List<SysGrouplinkpower> queryRoleGroupPower(String roleId);

    /**
     * 添加角色权限
     * @param list
     * @return
     */
    int addRolelinkpower(List<SysRolelinkpower> list);

    /**
     * 删除角色权限
     * @param roleId
     * @param powerIds
     * @return
     */
    int deleteRolelinkpower(@Param("roleId") String roleId, @Param("powerIds") List<String> powerIds);
}