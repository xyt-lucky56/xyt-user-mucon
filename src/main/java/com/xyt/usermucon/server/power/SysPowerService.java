package com.xyt.usermucon.server.power;

import com.xyt.usermucon.dto.power.SysPowerinfo;
import com.xyt.usermucon.dto.power.SysPowerinfoExample;

import java.util.List;

/**
 * @author :刘梦丽
 * @create 2019-09-04 14:36
 * @function
 * @editLog
 */
public interface SysPowerService {

    int deleteByPrimaryKey(String id);

    int insertSelective(SysPowerinfo record);

    /**
     * 全查询子菜单
     * @param sysPowerinfo
     * @return
     */
    List<SysPowerinfo> selectSysPowerinfo(SysPowerinfo sysPowerinfo);

    SysPowerinfo selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysPowerinfo record);
}

