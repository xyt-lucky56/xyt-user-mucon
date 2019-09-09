package com.xyt.usermucon.server.power;

import com.xyt.usermucon.dto.power.SysGroupinfo;
import com.xyt.usermucon.dto.power.SysGroupinfoExample;
import com.xyt.usermucon.dto.power.SysPowerinfo;
import com.xyt.usermucon.dto.power.SysSystemname;

import java.util.List;
import java.util.Map;

/**
 * @author :刘梦丽
 * @create 2019-09-04 14:36
 * @function
 * @editLog
 */
public interface SysGroupinfoService {

    int deleteByPrimaryKey(String id, int count);

    int insertSelective(SysGroupinfo record);

    List<SysGroupinfo> selectSysGroupinfo(String systemname,String searchName);

    List<SysGroupinfo> selectSysGroupInfoTest();

    SysGroupinfo selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysGroupinfo record);

    List<SysSystemname> queryPermissionsMeun(String name);

    /**
     * 查询该一级菜单下的权限
     * @param groupId
     * @return
     */
    List<SysPowerinfo> selectPowerinfo(String groupId);
}

