package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysPowerinfo;
import com.xyt.usermucon.dto.power.SysPowerinfoExample;
import com.xyt.usermucon.server.power.SysPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :刘梦丽
 * @create 2019-09-05 14:36
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/system")
public class SysPowerinfoController {
    @Autowired
    SysPowerService sysPowerService;//子菜单

    /**
     * 子菜单-查询子菜单列表
     * @param pageNum
     * @param pageSize
     * @param sysPowerinfo
     * @return
     */
    @GetMapping("/queryPowerinfo")
    public PageInfo queryPowerinfo(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            SysPowerinfo sysPowerinfo) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysPowerinfo> list=this.sysPowerService.selectSysPowerinfo(sysPowerinfo);
        PageInfo pageInfo = new PageInfo<>(list,pageSize);
        return pageInfo;
    }

    /**
     * 新增子菜单信息
     * @param record
     * @return
     */
    @PostMapping("/addPowerinfo")
    public int addPowerinfo(@RequestBody SysPowerinfo record){

        return this.sysPowerService.insertSelective(record);
    }

    /**
     *  查询子菜单详情
     * @param id
     * @return
     */
    @GetMapping("/queryPowerinfoById")
    public SysPowerinfo queryPowerinfoById(String id){
        return this.sysPowerService.selectByPrimaryKey(id);
    }

    /**
     * 编辑子菜单信息
     * @param record
     * @return
     */
    @PostMapping("/editPowerinfos")
    public int editPowerinfos(@RequestBody SysPowerinfo record){
        return this.sysPowerService.updateByPrimaryKey(record);
    }

    /**
     *   删除子菜单信息
     * @param id
     * @return
     */
    @PostMapping("/deletePowerinfos")
    public int deletePowerinfos(String id){
        return this.sysPowerService.deleteByPrimaryKey(id);
    }
}

