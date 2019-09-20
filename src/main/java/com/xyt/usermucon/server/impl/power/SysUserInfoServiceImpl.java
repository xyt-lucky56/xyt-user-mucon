package com.xyt.usermucon.server.impl.power;

import com.xyt.usermucon.common.ToolUtils;
import com.xyt.usermucon.dao.power.SysUserinfoMapper;
import com.xyt.usermucon.dto.power.SysUserinfo;
import com.xyt.usermucon.dto.power.SysUserinfoExample;
import com.xyt.usermucon.server.power.SysUserInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author luolei
 * @Date 2019/9/18 13:50
 * @Description
 */
@Service
@Transactional
public class SysUserInfoServiceImpl implements SysUserInfoService {
    private Logger logger = LoggerFactory.getLogger(SysUserInfoServiceImpl.class);

    @Autowired
    SysUserinfoMapper sysUserinfoMapper;

    public int addUser(SysUserinfo sysUserinfo){
        return sysUserinfoMapper.insertSelective(sysUserinfo);
    }

    public int updateUser(SysUserinfo sysUserinfo){
        return sysUserinfoMapper.updateByPrimaryKeySelective(sysUserinfo);
    }

    /**
    *@Description 全表查询
    *@Author  luolei
    *@Date 2019/9/18 14:04
    *@Param
    *@Return
    *@Exception
    *
    **/
    public List<Map<String,Object>> selectUserInfo(){
        List<SysUserinfo> userinfoList = sysUserinfoMapper.selectByExample(null);
        List<Map<String, Object>> deptInfoList = sysUserinfoMapper.selectDeptInfo();
        return addDeptInfoToUser(userinfoList,deptInfoList);
    }



    /**
    *@Description 根据部门ID查询
    *@Author  luolei
    *@Date 2019/9/18 14:11
    *@Param
    *@Return
    *@Exception
    *
    **/
    public List<Map<String,Object>> selectUserInfoByDept(String deptId){
        SysUserinfoExample example = new SysUserinfoExample();
        SysUserinfoExample.Criteria criteria = example.createCriteria();
        criteria.andDeptidEqualTo(deptId);
        List<SysUserinfo> userinfoList = sysUserinfoMapper.selectByExample(example);
        List<Map<String, Object>> deptInfoList = sysUserinfoMapper.selectDeptInfo();
        return addDeptInfoToUser(userinfoList,deptInfoList);
    }

    /**
    *@Description 根据用户ID查询用户信息
    *@Author  luolei
    *@Date 2019/9/18 14:29
    *@Param
    *@Return
    *@Exception
    *
    **/
    public Map<String,Object> selectUserInfoById(String userId){
        SysUserinfo sysUserinfo = sysUserinfoMapper.selectByPrimaryKey(userId);
        String deptid = sysUserinfo.getDeptid();
        Map<String, Object> userMap = ToolUtils.convertBeanToMap(sysUserinfo);
        userMap.put("createtime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sysUserinfo.getCreatetime()));
        List<Map<String, Object>> deptInfoList = sysUserinfoMapper.selectDeptInfo();
        for(Map<String,Object> map:deptInfoList){
            if(map.get("id").equals(deptid)){
                userMap.put("deptName",map.get("deptName"));
            }else{
                userMap.put("deptName","");
            }
        }
        return userMap;
    }

    @Override
    public List<Map<String, Object>> selectDeptInfo() {
        return sysUserinfoMapper.selectDeptInfo();
    }

    /**
    *@Author luolei
    *@Date  2019/9/18 14:12
    *@Description 删除用户
    */
    public int deleteUser(String id){
        return sysUserinfoMapper.deleteByPrimaryKey(id);
    }

    /**
    *@Description 根据手机号和用户名查询用户是否已经存在
    *@Author  luolei
    *@Date 2019/9/18 16:50
    *@Param
    *@Return
    *@Exception
    *
    **/
    public List<SysUserinfo> selectUserInfoByExample(String username,String mobile){
        SysUserinfoExample example = new SysUserinfoExample();
        SysUserinfoExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(username)){
            criteria.andUsernameEqualTo(username);
        }
        if(!StringUtils.isEmpty(mobile)){
            criteria.andMobileEqualTo(mobile);
        }
        return sysUserinfoMapper.selectByExample(example);
    }

    /**
    *@Description 分配角色
    *@Author  luolei
    *@Date 2019/9/19 9:14
    *@Param
    *@Return
    *@Exception
    *
    **/
    public int allocateRoleToUser(Map<String,Object> map){
        return sysUserinfoMapper.allocateRoleToUser(map);
    }

    private List<Map<String,Object>> addDeptInfoToUser(List<SysUserinfo> userinfoList,
                                                       List<Map<String, Object>> deptInfoList){
        List<Map<String,Object>> list  = new ArrayList<>();

        for(SysUserinfo sysUserinfo:userinfoList){
            Map<String, Object> beanToMap = ToolUtils.convertBeanToMap(sysUserinfo);
            beanToMap.put("createtime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sysUserinfo.getCreatetime()));
            for(Map<String,Object> map:deptInfoList){
                String id = String.valueOf(map.get("id"));
                String deptName = String.valueOf(map.get("deptName"));
                if(id.equals(sysUserinfo.getDeptid())){
                    beanToMap.put("deptName",deptName);
                    list.add(beanToMap);
                }
            }
        }
        return list;
    }

    /**
    *@Description 根据用户ID删除用户关联角色记录
    *@Author  luolei
    *@Date 2019/9/20 9:21
    *@Param
    *@Return
    *@Exception
    *
    **/
    public int deleteUserLinkRole(String userId){
       return sysUserinfoMapper.deleteUserLinkRole(userId);
    }
}
