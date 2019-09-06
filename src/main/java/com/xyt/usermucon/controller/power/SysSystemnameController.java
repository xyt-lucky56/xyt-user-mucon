package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysSystemname;
import com.xyt.usermucon.dto.power.SysSystemnameExample;
import com.xyt.usermucon.server.power.SysSystemnameService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :刘梦丽
 * @create 2019-09-04 14:36
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/system")
@Api(value = "Swagger说明", description = "Swagger描述")
public class SysSystemnameController {
    @Autowired
    SysSystemnameService sysSystemnameService;//系统

    /**
     * 系统-查询系统列表
     * @param pageNum
     * @param pageSize
     * @param example
     * @return
     */
    @GetMapping("/querySystemInfo")
    public PageInfo querySystemInfo(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            SysSystemnameExample example) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysSystemname> list=this.sysSystemnameService.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(list,pageSize);
        return pageInfo;
    }

    /**
     * 新增系统信息
     * @param record
     * @return
     */
    @PostMapping("/addingSubsystems")
    public int addingSubsystems(@RequestBody SysSystemname record){

        return this.sysSystemnameService.insertSelective(record);
    }

    /**
     *查询系统详情
     * @param id
     * @return
     */
    @GetMapping("/querySystemInfoById")
    public SysSystemname querySystemInfoById(String id){
        return this.sysSystemnameService.selectByPrimaryKey(id);
    }

    /**
     * 编辑系统信息
     * @param record
     * @return
     */
    @PostMapping("/editSubsystems")
    public int editSubsystems(@RequestBody SysSystemname record){
        return this.sysSystemnameService.updateByPrimaryKey(record);
    }

    /**
     *   删除系统信息
     * @param id
     * @return
     */
    @PostMapping("/deleteSubsystems")
    public int deleteSubsystems(String id){
        return this.sysSystemnameService.deleteByPrimaryKey(id);
    }
}

