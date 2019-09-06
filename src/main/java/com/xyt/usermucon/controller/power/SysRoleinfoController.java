package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysRoleinfo;
import com.xyt.usermucon.dto.power.SysRoleinfoExample;
import com.xyt.usermucon.server.power.SysRoleinfoService;
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
     * @param pageNum
     * @param pageSize
     * @param example
     * @return
     */
    @GetMapping("/queryRoleInfo")
    public PageInfo queryRoleInfo(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            SysRoleinfoExample example) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysRoleinfo> list=this.SysRoleinfoService.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(list,pageSize);
        return pageInfo;
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
    @GetMapping("/queryRoleInfoById")
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
    @GetMapping("/permissionsToQueryRoles")
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

