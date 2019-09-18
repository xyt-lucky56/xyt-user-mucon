package com.xyt.usermucon.server.power;

import com.xyt.usermucon.dto.power.SysUserinfo;

import java.util.List;
import java.util.Map;

/**
 * @Author luolei
 * @Date 2019/9/18 13:51
 * @Description
 */
public interface SysUserInfoService {

    public int addUser(SysUserinfo sysUserinfo);

    public int updateUser(SysUserinfo sysUserinfo);

    public List<Map<String,Object>> selectUserInfo();

    public List<Map<String,Object>> selectUserInfoByDept(String deptId);

    public int deleteUser(String id);

    public Map<String,Object> selectUserInfoById(String userId);

    public List<Map<String,Object>> selectDeptInfo();

    public List<SysUserinfo> selectUserInfoByExample(String username,String mobile);
}
