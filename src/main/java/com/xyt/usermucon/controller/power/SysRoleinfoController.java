package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysRoleinfo;
import com.xyt.usermucon.dto.power.SysRoleinfoExample;
import com.xyt.usermucon.server.power.SysRoleinfoService;
import lh.model.ResultVOPage;
import lh.units.ResultStruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param example
     * @return
     */
    @PostMapping("/queryRoleInfo")
    public ResultVOPage queryRoleInfo(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            SysRoleinfoExample example) {
        PageHelper.startPage(page, limit);
        List<SysRoleinfo> list=this.SysRoleinfoService.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(list,limit);
        return ResultStruct.successPage(list, pageInfo.getPageNum()
                , pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * 新增角色信息
     * @param record
     * @return
     */
    @PostMapping("/addingRoleInfo")
    public int addingSubsystems(@RequestBody  SysRoleinfo record){

        return this.SysRoleinfoService.insertSelective(record);
    }

    /**
     *  查询角色详情
     * @param id
     * @return
     */
    @PostMapping("/queryRoleInfoById")
    public SysRoleinfo queryRoleInfoById(String id){
        return this.SysRoleinfoService.selectByPrimaryKey(id);
    }

    /**
     *  编辑角色信息
     * @param record
     * @return
     */
    @PostMapping("/editRoleInfo")
    public int editRoleInfo(@RequestBody SysRoleinfo record){

        return this.SysRoleinfoService.updateByPrimaryKey(record);
    }

    /**
     *   删除角色信息
     * @param id
     * @return
     */
    @PostMapping("/deleteRoleInfoById")
    public int deleteSubsystems(String id){
        return this.SysRoleinfoService.deleteByPrimaryKey(id);
    }

    /**
     *  角色-查询角色的权限
     * @return
     */
    @PostMapping("/permissionsToQueryRoles")
    public Map<String,Object> permissionsToQueryRoles(String id){
        return this.SysRoleinfoService.permissionsToQueryRoles(id);
    }

    /**
     * 权限分配
     * @param map
     * @return
     */
    @PostMapping("/allocationOfPermissions")
    public Map<String,Object> allocationOfPermissions(@RequestBody Map<String,Object> map){
        return this.SysRoleinfoService.allocationOfPermissions((String)map.get("roleId"),(List<String>)map.get("powerIds"));
    }


}

