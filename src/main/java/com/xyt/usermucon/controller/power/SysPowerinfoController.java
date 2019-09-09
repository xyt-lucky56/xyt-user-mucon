package com.xyt.usermucon.controller.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.power.SysPowerinfo;
import com.xyt.usermucon.server.power.SysPowerService;
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
     * @param page
     * @param limit
     * @param groupId
     * @param groupname
     * @param searchName
     * @return
     */
    @PostMapping("/queryPowerinfo")
    public ResultVOPage queryPowerinfo(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @RequestParam(value = "groupId",required = false)String groupId,
            @RequestParam(value = "groupname",required = false)String groupname,
            @RequestParam(value = "searchName",required = false)String searchName) {
        PageHelper.startPage(page, limit);
        List<SysPowerinfo> sysPowerinfos = this.sysPowerService.selectSysPowerinfo(groupId, groupname, searchName);
        List<SysPowerinfo> list= sysPowerinfos;
        PageInfo pageInfo = new PageInfo<>(list,limit);
        return ResultStruct.successPage(list, pageInfo.getPageNum()
                , pageInfo.getPageSize(), pageInfo.getTotal());
    }

    /**
     * 新增子菜单信息
     * @param map
     * @return
     */
    @PostMapping("/addPowerinfo")
    public ResultVO addPowerinfo(@RequestBody Map<String,Object> map){
      return ResultStruct.success(this.sysPowerService.insertSelective(this.getSysPowerinfo(map)));
    }

    public SysPowerinfo getSysPowerinfo(Map<String,Object> map){
        SysPowerinfo sysSystemname=new SysPowerinfo();
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
     *  查询子菜单详情
     * @param id
     * @return
     */
    @PostMapping("/queryPowerinfoById")
    public ResultVO queryPowerinfoById(@RequestParam(value = "id")String id){
        return ResultStruct.success(this.sysPowerService.selectByPrimaryKey(id));
    }

    /**
     * 编辑子菜单信息
     * @param map
     * @return
     */
    @PostMapping("/editPowerinfos")
    public ResultVO editPowerinfos(@RequestBody Map<String,Object> map){
        return ResultStruct.success(this.sysPowerService.updateByPrimaryKey(this.getSysPowerinfo(map)));
    }

    /**
     *   删除子菜单信息
     * @param id
     * @return
     */
    @PostMapping("/deletePowerinfos")
    public ResultVO deletePowerinfos(@RequestParam(value = "id")String id){
        return ResultStruct.success(this.sysPowerService.deleteByPrimaryKey(id));
    }
}

