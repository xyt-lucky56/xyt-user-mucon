package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysGroupinfo;
import com.xyt.usermucon.dto.power.SysPowerinfo;
import com.xyt.usermucon.server.power.SysGroupinfoService;
import io.swagger.annotations.Api;
import lh.model.ResultVO;
import lh.model.ResultVOPage;
import lh.units.ResultStruct;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
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
     * @return
     */
    @PostMapping("/queryGroupinfo")
    public ResultVOPage queryGroupinfo(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "systemname",required = false)String systemname,
            @RequestParam(value = "searchName",required = false)String searchName) {
        PageHelper.startPage(page, limit);
        List<SysGroupinfo> list = this.sysSysGroupinfoService.selectSysGroupinfo(systemname,searchName);
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
    public ResultVO queryPermissionsMeun(@RequestParam(value = "name")String name) {
        return ResultStruct.success(this.sysSysGroupinfoService.queryPermissionsMeun(name));
    }

    /**
     * 新增一级菜单信息
     * @param map
     * @return
     */
    @PostMapping("/addGroupinfos")
    public ResultVO addGroupinfos(@RequestBody Map<String,Object> map) {
        return ResultStruct.success(this.sysSysGroupinfoService.insertSelective(this.getGroup(map)));
    }

    /**
     * map 转实体类
     * @param map
     *
     * @return
     */
    private SysGroupinfo getGroup(Map<String,Object> map){
        SysGroupinfo sysGroupinfo=new SysGroupinfo();
        try {
            BeanUtils.copyProperties(sysGroupinfo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
/*        sysGroupinfo.setGroupname((String)map.get("groupname"));
        sysGroupinfo.setIsexpand((Boolean) map.get("isexpand"));
        sysGroupinfo.setPicname((String)map.get("picname"));
        sysGroupinfo.setPicpath((String)map.get("picpath"));
        sysGroupinfo.setRemark((String)map.get("remark"));
        sysGroupinfo.setSortno((Integer) map.get("sortno"));
        sysGroupinfo.setSystemname((String)map.get("systemname"));*/
        return sysGroupinfo;
    }

    /**
     * 查询一级菜单详情
     *
     * @param id
     * @return
     */
    @PostMapping("/queryGroupinfoById")
    public ResultVOPage queryGroupinfoById(@RequestParam(value = "id")String id, @RequestParam(value = "page", defaultValue = "1") int page,
                                                  @RequestParam(value = "limit", defaultValue = "10") int limit) {
        Map<String,Object> map=new HashMap<String,Object>();
        //一级菜单详情
        map.put("sysGroupinfo",this.sysSysGroupinfoService.selectByPrimaryKey(id));
        //子菜单列表
        PageHelper.startPage(page, limit);
        List<SysPowerinfo> sysPowerinfo = this.sysSysGroupinfoService.selectPowerinfo(id);
        PageInfo pageInfo = new PageInfo<>(sysPowerinfo,limit);
        map.put("sysPowerinfo",sysPowerinfo);
        return ResultStruct.successPage(map, pageInfo.getPageNum()
                , pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * 编辑一级菜单信息
     *
     * @param map
     * @return
     */
    @PostMapping("/editGroupinfo")
    public ResultVO editGroupinfo(@RequestBody Map<String,Object> map) {
        return ResultStruct.success(this.sysSysGroupinfoService.updateByPrimaryKey(this.getGroup(map)));
    }

    /**
     * 删除一级菜单信息
     *
     * @param id
     * @param count 点击次数
     * @return
     */
    @PostMapping("/deleteGroupinfo")
    public ResultVO deleteGroupinfo(@RequestParam(value = "id")String id, @RequestParam(value = "count",required = false)int count) {
        return ResultStruct.success(this.sysSysGroupinfoService.deleteByPrimaryKey(id, count));
    }
}

