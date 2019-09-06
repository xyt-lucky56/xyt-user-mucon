package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysGroupinfo;
import com.xyt.usermucon.dto.power.SysGroupinfoExample;
import com.xyt.usermucon.server.power.SysGroupinfoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author :刘梦丽
 * @create 2019-09-05 14:36
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/system")
@Api(value = "Swagger说明", description = "Swagger描述")
public class SysGroupinfoController {
    @Autowired
    SysGroupinfoService sysSysGroupinfoService;//一级菜单

    /**
     * 查询一级菜单列表
     * @param pageNum
     * @param pageSize
     * @param example
     * @return
     */
    @GetMapping("/queryGroupinfo")
    public PageInfo queryGroupinfo(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            SysGroupinfoExample example) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysGroupinfo> list=this.sysSysGroupinfoService.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(list,pageSize);
        return pageInfo;
    }

    /**
     * 新增一级菜单信息
     * @param record
     * @return
     */
    @PostMapping("/addGroupinfos")
    public int addGroupinfos(@RequestBody SysGroupinfo record){
        return this.sysSysGroupinfoService.insertSelective(record);
    }

    /**
     *  查询一级菜单详情
     * @param id
     * @return
     */
    @GetMapping("/queryGroupinfoById")
    public Map<String,Object> queryGroupinfoById(String id,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                 @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        return this.sysSysGroupinfoService.selectByPrimaryKey(id,pageNum,pageSize);
    }

    /**
     * 编辑一级菜单信息
     * @param record
     * @return
     */
    @PostMapping("/editGroupinfo")
    public int editGroupinfo(@RequestBody SysGroupinfo record){
        return this.sysSysGroupinfoService.updateByPrimaryKey(record);
    }

    /**
     * 删除一级菜单信息
     * @param id
     * @param count  点击次数
     * @return
     */
    @PostMapping("/deleteGroupinfo")
    public int deleteGroupinfo(String id,int count){
        return this.sysSysGroupinfoService.deleteByPrimaryKey(id,count);
    }
}

