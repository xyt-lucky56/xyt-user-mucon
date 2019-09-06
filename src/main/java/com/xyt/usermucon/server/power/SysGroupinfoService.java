package com.xyt.usermucon.server.power;

import com.xyt.usermucon.dto.power.SysGroupinfo;
import com.xyt.usermucon.dto.power.SysGroupinfoExample;

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

    List<SysGroupinfo> selectByExample(SysGroupinfoExample example);

    Map<String,Object> selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysGroupinfo record);
}

