package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysRoleinfo;
import com.xyt.usermucon.dto.power.SysRoleinfoExample;
import com.xyt.usermucon.server.power.SysRoleinfoService;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import lh.units.ResultStruct;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @author :刘梦丽
 * @create 2019-09-04 14:36
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/system")
public class SysRoleinfoController {
    @Autowired
    SysRoleinfoService SysRoleinfoService;//角色


    /**
     * 角色-查询角色列表
     * @param page
     * @param limit
     * @return
     */
    @PostMapping("/queryRoleInfo")
    public ResultVOPage queryRoleInfo(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        PageHelper.startPage(page, limit);
        List<SysRoleinfo> list=this.SysRoleinfoService.selectByExample(null);
        PageInfo pageInfo = new PageInfo<>(list,limit);
        return ResultStruct.successPage(list, pageInfo.getPageNum()
                , pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * 新增角色信息
     * @param map
     * @return
     */
    @PostMapping("/addingRoleInfo")
    public ResultVO addingSubsystems(@RequestBody Map<String,Object> map){
        return ResultStruct.success(this.SysRoleinfoService.insertSelective(this.getSysRoleinfo(map)));
    }

    private SysRoleinfo getSysRoleinfo(Map<String,Object> map){
        SysRoleinfo sysRoleinfo=new SysRoleinfo();
        try {
            BeanUtils.copyProperties(sysRoleinfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return sysRoleinfo;
    }

    /**
     * 查询角色详情
     * @param id
     * @return
     */
    @PostMapping("/queryRoleInfoById")
    public ResultVO queryRoleInfoById(@RequestParam(value = "id")String id){
        return ResultStruct.success(this.SysRoleinfoService.selectByPrimaryKey(id));
    }

    /**
     * 编辑角色信息
     * @param map
     * @return
     */
    @PostMapping("/editRoleInfo")
    public ResultVO editRoleInfo(@RequestBody Map<String,Object> map){

        return ResultStruct.success(this.SysRoleinfoService.updateByPrimaryKey(this.getSysRoleinfo(map)));
    }

    /**
     *   删除角色信息
     * @param id
     * @return
     */
    @PostMapping("/deleteRoleInfoById")
    public ResultVO deleteSubsystems(@RequestParam(value = "id")String id){
        return ResultStruct.success(this.SysRoleinfoService.deleteByPrimaryKey(id));
    }

    /**
     *  角色-查询角色的权限
     * @return
     */
    @PostMapping("/permissionsToQueryRoles")
    public ResultVO permissionsToQueryRoles(@RequestParam(value = "id")String id){
        return ResultStruct.success(this.SysRoleinfoService.permissionsToQueryRoles(id));
    }

    /**
     * 权限分配
     * @param map
     * @return
     */
    @PostMapping("/allocationOfPermissions")
    public ResultVO allocationOfPermissions(@RequestBody Map<String,Object> map){
        return ResultStruct.success(this.SysRoleinfoService.allocationOfPermissions((String)map.get("roleId"),(List<String>)map.get("powerIds")));
    }


}

