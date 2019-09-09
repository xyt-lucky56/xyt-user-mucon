package com.xyt.usermucon.server.impl.power;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.common.BizException;
import com.xyt.usermucon.common.ToolUtils;
import com.xyt.usermucon.dao.power.SysGroupinfoMapper;
import com.xyt.usermucon.dao.power.SysGrouplinkpowerMapper;
import com.xyt.usermucon.dao.power.SysPowerinfoMapper;
import com.xyt.usermucon.dao.power.SysRoleinfoMapper;
import com.xyt.usermucon.dto.PerDto;
import com.xyt.usermucon.dto.power.SysGroupinfo;
import com.xyt.usermucon.dto.power.SysGroupinfoExample;
import com.xyt.usermucon.dto.power.SysPowerinfo;
import com.xyt.usermucon.dto.power.SysSystemname;
import com.xyt.usermucon.server.power.SysGroupinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :刘梦丽
 * @create 2019-09-04 14:36
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class SysGroupinfoImpl implements SysGroupinfoService {

    @Autowired
    private SysGroupinfoMapper sysGroupinfoMapper;
    @Autowired
    private SysGrouplinkpowerMapper sysGrouplinkpowerMapper;


    @Value("${exception.port}")
    private Short port;


    @Override
    @Transactional
    public int deleteByPrimaryKey(String id,int count) {
        Integer counts=this.sysGroupinfoMapper.queryGrouplinkpowerByGroupId(id);
        if(null!=counts && counts>0 && count==1){
            throw new BizException("20001","该一级菜单下有权限，是否删除!");
        }else{
            if(null!=counts && counts>0){
                //删除子菜单
                this.sysGrouplinkpowerMapper.deleteGroupPower(id);
                //删除子菜单及其关联
                this.sysGrouplinkpowerMapper.deleteGrouplinkpower(id);
            }
            //删除一级菜单
            return this.sysGroupinfoMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    @Transactional
    public int insertSelective(SysGroupinfo record) {
        Integer counts=this.sysGroupinfoMapper.queryGroupByName(record.getGroupname());
        if(null!=counts && counts>0){
            throw new BizException("20001","该一级菜单重复！");
        }else{
            try {
                record.setId(ToolUtils.getPowerKey(port));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.sysGroupinfoMapper.insert(record);
        }
    }

    @Override
    public List<SysGroupinfo> selectSysGroupinfo(String systemname,String searchName) {
        return this.sysGroupinfoMapper.selectSysGroupinfo(systemname,searchName);
    }

    @Override
    public List<SysGroupinfo> selectSysGroupInfoTest() {
        return this.sysGroupinfoMapper.selectSysGroupInfoTest();
    }

    @Override
    public SysGroupinfo selectByPrimaryKey(String id) {
        return this.sysGroupinfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询该一级菜单下的权限
     * @param groupId
     * @return
     */
    public List<SysPowerinfo> selectPowerinfo(String groupId){
        return this.sysGroupinfoMapper.selectPowerinfo(groupId);
    }


    @Override
    @Transactional
    public int updateByPrimaryKey(SysGroupinfo record) {
        SysGroupinfo sysGroupinfo= this.sysGroupinfoMapper.selectByPrimaryKey(record.getId());
        Integer counts=this.sysGroupinfoMapper.queryGroupByName(record.getGroupname());
        if(null!=counts && counts>0 && !sysGroupinfo.getGroupname().equals(record.getGroupname())){
            throw new BizException("20001","该一级菜单重复！");
        }else{
            return this.sysGroupinfoMapper.updateByPrimaryKey(record);
        }
    }
    @Override
    public List<SysSystemname> queryPermissionsMeun(String name){
        return this.sysGroupinfoMapper.queryPermissionsMeun(name);
    }
}

