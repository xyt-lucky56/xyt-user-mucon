package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.common.ToolUtils;
import com.xyt.usermucon.dto.power.SysUserinfo;
import com.xyt.usermucon.server.power.SysUserInfoService;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author luolei
 * @Date 2019/9/18 14:14
 * @Description
 */
@RestController
@RequestMapping("/system")
public class SysUserInfoController {
    @Value("${server.port}")
    private int port;

    @Autowired
    SysUserInfoService  sysUserInfoService;

    @PostMapping("/addUser")
    public ResultVO addUser(@RequestBody Map<String,Object> map){
        ResultVO  resultVO = new ResultVO();
        SysUserinfo sysUserinfo = new SysUserinfo();
        try {
            BeanUtils.copyProperties(sysUserinfo,map);
            sysUserinfo.setId(ToolUtils.getPowerKey((short)port));
            sysUserinfo.setCreatetime(new Date());
            sysUserinfo.setStopsign(false);
            int userNum = sysUserInfoService.addUser(sysUserinfo);
            resultVO.setCode(0);
            resultVO.setMsg("新增用户成功");
            resultVO.setCount(userNum);
            resultVO.setData(sysUserinfo.getId());
            return resultVO;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/updateUser")
    public ResultVO updateUser(@RequestBody Map<String,Object> map){
        ResultVO  resultVO = new ResultVO();
        SysUserinfo sysUserinfo = new SysUserinfo();
        try {
            BeanUtils.copyProperties(sysUserinfo,map);
            int userNum = sysUserInfoService.updateUser(sysUserinfo);
            resultVO.setCode(0);
            resultVO.setMsg("修改成功");
            resultVO.setCount(userNum);
            return resultVO;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/deleteUser")
    public ResultVO deleteUser(@RequestParam("id") String id){
        ResultVO  resultVO = new ResultVO();
        int userNum = 0;
        try {
            userNum = sysUserInfoService.deleteUser(id);
            resultVO.setCode(0);
            resultVO.setMsg("删除成功");
            resultVO.setCount(userNum);
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/findAllUser")
    public ResultVOPage getAllUser(@RequestParam("page") int page, @RequestParam("limit") int limit){
        try {
            ResultVOPage resultVOPage = new ResultVOPage();
            PageHelper.startPage(page,limit);
            List<Map<String,Object>> list = sysUserInfoService.selectUserInfo();
            PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(list);
            resultVOPage.setCode(0);
            resultVOPage.setMsg("查询成功");
            resultVOPage.setCount(pageInfo.getTotal());
            resultVOPage.setData(pageInfo.getList());
            resultVOPage.setLimit(limit);
            resultVOPage.setPage(page);
            return resultVOPage;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }

    @PostMapping("/findUserByDept")
    public ResultVOPage getAllUser(@RequestParam("page") int page,
                                   @RequestParam("limit") int limit,
                                   @RequestParam("deptId") String deptId){
        try {
            ResultVOPage resultVOPage = new ResultVOPage();
            PageHelper.startPage(page,limit);
            List<Map<String,Object>> list = sysUserInfoService.selectUserInfoByDept(deptId);
            PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(list);
            resultVOPage.setCode(0);
            resultVOPage.setMsg("查询成功");
            resultVOPage.setCount(pageInfo.getTotal());
            resultVOPage.setData(pageInfo.getList());
            resultVOPage.setLimit(limit);
            resultVOPage.setPage(page);
            return resultVOPage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/findUserById")
    public ResultVO getUserById(String userId){
        try {
            ResultVO resultVO = new ResultVO();
            Map<String, Object> map = sysUserInfoService.selectUserInfoById(userId);
            resultVO.setCode(0);
            resultVO.setMsg("查询详情成功");
            resultVO.setCount(1);
            resultVO.setData(map);
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/findDeptInfo")
    public ResultVO getDeptInfo(){
        try {
            ResultVO resultVO = new ResultVO();
            List<Map<String, Object>> list = sysUserInfoService.selectDeptInfo();
            resultVO.setCode(0);
            resultVO.setMsg("查询部门信息成功");
            resultVO.setCount(1);
            resultVO.setData(list);
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/findByUsernameAndMobile")
    public ResultVO selectUserInfoByUsernameAndMobile(@RequestParam("username") String username,
                                                      @RequestParam("mobile") String mobile){
        try {
            ResultVO resultVO = new ResultVO();
            List<SysUserinfo> userinfoList = sysUserInfoService.selectUserInfoByExample(username, mobile);
            resultVO.setCode(0);
            resultVO.setMsg("查询信息成功");
            resultVO.setCount(userinfoList.size());
            resultVO.setData(userinfoList);
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
