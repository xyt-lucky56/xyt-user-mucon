package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysGroupinfo;
import com.xyt.usermucon.dto.power.SysGroupinfoExample;
import com.xyt.usermucon.dto.power.SysPowerinfo;
import com.xyt.usermucon.dto.power.SysSystemname;
import com.xyt.usermucon.server.power.SysGroupinfoService;
import io.swagger.annotations.Api;
import lh.model.ResultVOPage;
import lh.units.ResultStruct;
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
     *
     * @param page
     * @param limit
     * @param sysGroupinfo
     * @return
     */
    @PostMapping("/queryGroupinfo")
    public ResultVOPage queryGroupinfo(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            SysGroupinfo sysGroupinfo) {
        PageHelper.startPage(page, limit);
        List<SysGroupinfo> list = this.sysSysGroupinfoService.selectSysGroupinfo(sysGroupinfo);
        PageInfo pageInfo = new PageInfo<>(list, limit);
        return ResultStruct.successPage(list, pageInfo.getPageNum()
                , pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * 查询一级菜单列表
     *
     * @param page
     * @param limit
     * @return
     */
    @PostMapping("/queryGroupInfoTest")
    public ResultVOPage queryGroupInfoTest(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        PageHelper.startPage(page, limit);
        List<SysGroupinfo> list = this.sysSysGroupinfoService.selectSysGroupInfoTest();
        PageInfo pageInfo = new PageInfo<>(list, limit);
        return ResultStruct.successPage(list, pageInfo.getPageNum()
                , pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * 查询所有权限菜单
     *
     * @param name
     * @return
     */
    @PostMapping("/queryPermissionsMeun")
    public List<SysSystemname> queryPermissionsMeun(String name) {
        return this.sysSysGroupinfoService.queryPermissionsMeun(name);
    }

    /**
     * 新增一级菜单信息
     *
     * @param record
     * @return
     */
    @PostMapping("/addGroupinfos")
    public int addGroupinfos(@RequestBody SysGroupinfo record) {
        return this.sysSysGroupinfoService.insertSelective(record);
    }

    /**
     * 查询一级菜单详情
     *
     * @param id
     * @return
     */
    @PostMapping("/queryGroupinfoById")
    public Map<String, Object> queryGroupinfoById(String id, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                  @RequestParam(value = "limit", defaultValue = "10") int limit) {
        return this.sysSysGroupinfoService.selectByPrimaryKey(id, pageNum, limit);
    }

    /**
     * 编辑一级菜单信息
     *
     * @param record
     * @return
     */
    @PostMapping("/editGroupinfo")
    public int editGroupinfo(@RequestBody SysGroupinfo record) {
        return this.sysSysGroupinfoService.updateByPrimaryKey(record);
    }

    /**
     * 删除一级菜单信息
     *
     * @param id
     * @param count 点击次数
     * @return
     */
    @PostMapping("/deleteGroupinfo")
    public int deleteGroupinfo(String id, int count) {
        return this.sysSysGroupinfoService.deleteByPrimaryKey(id, count);
    }
}

