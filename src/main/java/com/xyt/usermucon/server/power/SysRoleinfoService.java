package com.xyt.usermucon.server.power;

import com.xyt.usermucon.dto.power.SysRoleinfo;
import com.xyt.usermucon.dto.power.SysRoleinfoExample;

import java.util.List;
import java.util.Map;

/**
 * @author :刘梦丽
 * @create 2019-09-04 14:36
 * @function
 * @editLog
 */
public interface SysRoleinfoService {

    int deleteByPrimaryKey(String id);

    int insertSelective(SysRoleinfo record);

    List<SysRoleinfo> selectByExample(SysRoleinfoExample example);

    SysRoleinfo selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysRoleinfo record);
    /**
     * 角色-查询角色的权限
     * @return
     */
    Map<String,Object> permissionsToQueryRoles(String id,String systemname);

    /**
     * 权限分配
     * @param roleId
     * @param powerIds
     * @return
     */
    public Map<String,Object> allocationOfPermissions(String roleId, List<String> powerIds);
}

