package com.xyt.usermucon.dao.power;

import com.xyt.usermucon.dto.power.SysGrouplinkpower;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysGrouplinkpowerMapper {
   
    /**
     * 添加子菜单权限
     * @param sysGrouplinkpower
     * @return
     */
    int addGrouplinkpower(SysGrouplinkpower sysGrouplinkpower);

    /**
     * 删除子菜单权限
     * @param groupId
     * @return
     */
    int deleteGrouplinkpower(String groupId);

    /**
     * 删除该一级菜单下所有的权限
     * @param id
     * @return
     */
    int deleteGroupPower(String id);
}