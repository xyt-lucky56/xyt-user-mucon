package com.xyt.usermucon.server.power;

import com.xyt.usermucon.dto.power.SysSystemname;
import com.xyt.usermucon.dto.power.SysSystemnameExample;

import java.util.List;

/**
 * @author :刘梦丽
 * @create 2019-09-04 14:36
 * @function
 * @editLog
 */
public interface SysSystemnameService {

    int deleteByPrimaryKey(String id);

    int insertSelective(SysSystemname record);

    List<SysSystemname> selectByExample(SysSystemnameExample example);

    SysSystemname selectByPrimaryKey(String id);

    int updateByPrimaryKey(SysSystemname record);
}

