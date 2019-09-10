package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysSystemname;
import com.xyt.usermucon.dto.power.SysSystemnameExample;
import com.xyt.usermucon.server.power.SysSystemnameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "系统粒子层", description = "所有系统内容相关请求")
public class SysSystemnameController {
    @Autowired
    SysSystemnameService sysSystemnameService;//系统

    /**
     * 系统-查询系统列表
     * @param page
     * @param limit
     * @param example
     * @return
     */
    @ApiOperation(value = "系统-查询系统列表", notes = "方法说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数，默认1条", dataType = "int"),
            @ApiImplicitParam(name = "limit", value = "每页条数，默认10条", dataType = "int")
    })
    @PostMapping("/querySystemInfo")
    public ResultVOPage querySystemInfo(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            SysSystemnameExample example) {
        PageHelper.startPage(page, limit);
        List<SysSystemname> list=this.sysSystemnameService.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(list,limit);
        return ResultStruct.successPage(list, pageInfo.getPageNum()
                , pageInfo.getPageSize(), pageInfo.getTotal());
    }

    @ApiOperation(value = "系统-查询系统列表（不分页）", notes = "方法说明")
   @PostMapping("/querySystemInfoNoPage")
    public ResultVO querySystemInfoNoPage() {
        List<SysSystemname> list=this.sysSystemnameService.selectByExample(null);
        return ResultStruct.success(list);
    }

    /**
     * 新增系统信息
     * @param map
     * @return
     */
    @ApiOperation(value = "系统-新增系统信息", notes = "方法说明")
    @PostMapping("/addingSubsystems")
    public ResultVO addingSubsystems(@RequestBody  Map<String,Object> map){
        return ResultStruct.success(this.sysSystemnameService.insertSelective(this.getSystemname(map)));
    }

    /**
     * map 转实体类
     * @param map
     * @return
     */
    public SysSystemname getSystemname(Map<String,Object> map){
        SysSystemname sysSystemname=new SysSystemname();
        try {
            BeanUtils.copyProperties(sysSystemname,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return sysSystemname;
    }

    /**
     * 查询系统详情
     * @param id
     * @return
     */
    @ApiOperation(value = "系统-查询系统详情", notes = "方法说明")
    @ApiImplicitParam(name = "id", value = "系统编号", dataType = "String")
    @PostMapping("/querySystemInfoById")
    public ResultVO querySystemInfoById(@RequestParam(value="id",required = true) String id){
        return ResultStruct.success(this.sysSystemnameService.selectByPrimaryKey(id));
    }

    /**
     * 编辑系统信息
     * @param map
     * @return
     */
    @ApiOperation(value = "系统-编辑系统信息", notes = "方法说明")
    @PostMapping("/editSubsystems")
    public ResultVO editSubsystems(@RequestBody Map<String,Object> map){
        return ResultStruct.success(this.sysSystemnameService.updateByPrimaryKey(this.getSystemname(map)));
    }

    /**
     *   删除系统信息
     * @param id
     * @return
     */
    @ApiOperation(value = "角色-查询角色列表", notes = "方法说明")
    @ApiImplicitParam(name = "id", value = "系统编号", dataType = "String")
    @PostMapping("/deleteSubsystems")
    public ResultVO deleteSubsystems(@RequestParam(value="id")String id){
        return ResultStruct.success(this.sysSystemnameService.deleteByPrimaryKey(id));
    }
}

