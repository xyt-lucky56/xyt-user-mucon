package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.common.BizException;
import com.xyt.usermucon.dto.power.SysRoleinfo;
import com.xyt.usermucon.dto.power.SysRoleinfoExample;
import com.xyt.usermucon.server.power.SysRoleinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import lh.units.ResultStruct;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@Api(value = "角色粒子层", description = "所有角色相关请求")
public class SysRoleinfoController {
    @Autowired
    SysRoleinfoService SysRoleinfoService;//角色


    /**
     * 角色-查询角色列表
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "角色-查询角色列表", notes = "方法说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数，默认1条", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页条数，默认10条", dataType = "int")
    })
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
    @ApiOperation(value = "角色-查询角色列表", notes = "方法说明")
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
    @ApiOperation(value = "角色-查询角色详情", notes = "方法说明")
    @ApiImplicitParam(name = "id", value = "角色编号", dataType = "int")
    @PostMapping("/queryRoleInfoById")
    public ResultVO queryRoleInfoById(@RequestParam(value = "id")String id){
        return ResultStruct.success(this.SysRoleinfoService.selectByPrimaryKey(id));
    }

    /**
     * 编辑角色信息
     * @param map
     * @return
     */
    @ApiOperation(value = "角色-编辑角色信息", notes = "方法说明")
    @PostMapping("/editRoleInfo")
    public ResultVO editRoleInfo(@RequestBody Map<String,Object> map){
        if(StringUtils.isEmpty(map.get("id"))){
            throw new BizException("20001","传入的用户的角色ID为空");
        }
        return ResultStruct.success(this.SysRoleinfoService.updateByPrimaryKey(this.getSysRoleinfo(map)));
    }

    /**
     *   删除角色信息
     * @param id
     * @return
     */
    @ApiOperation(value = "角色-删除角色信息", notes = "方法说明")
    @ApiImplicitParam(name = "id", value = "角色编号", dataType = "int")
    @PostMapping("/deleteRoleInfoById")
    public ResultVO deleteSubsystems(@RequestParam(value = "id")String id){
        return ResultStruct.success(this.SysRoleinfoService.deleteByPrimaryKey(id));
    }

    /**
     *  角色-查询角色的权限
     * @return
     */
    @ApiOperation(value = "角色-查询角色的权限", notes = "方法说明")
    @ApiImplicitParam(name = "id", value = "角色编号", dataType = "int")
    @PostMapping("/permissionsToQueryRoles")
    public ResultVO permissionsToQueryRoles(@RequestParam(value = "id")String id){
        return ResultStruct.success(this.SysRoleinfoService.permissionsToQueryRoles(id));
    }

    /**
     * 权限分配
     * @param map
     * @return
     */
    @ApiOperation(value = "角色-权限分配", notes = "方法说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色编号", dataType = "int"),
            @ApiImplicitParam(name = "powerIds", value = "权限编号", dataType = "int")
    })
    @PostMapping("/allocationOfPermissions")
    public ResultVO allocationOfPermissions(@RequestBody Map<String,Object> map){
        return ResultStruct.success(this.SysRoleinfoService.allocationOfPermissions((String)map.get("roleId"),(List<String>)map.get("powerIds")));
    }


}

