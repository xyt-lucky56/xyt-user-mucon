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
    @Autowired
    private SysRoleinfoMapper sysRoleinfoMapper;


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
    public List<SysGroupinfo> selectByExample(SysGroupinfoExample example) {
        return this.sysGroupinfoMapper.selectByExample(example);
    }

    @Override
    public Map<String,Object> selectByPrimaryKey(String id,int pageNum,int pageSize) {
        Map<String,Object> map =new HashMap<>();
        //一级菜单详情
        map.put("sysGroupinfo",this.sysGroupinfoMapper.selectByPrimaryKey(id));
        //子菜单列表
        PageHelper.startPage(pageNum, pageSize);
        List<SysPowerinfo> sysPowerinfo = this.sysGroupinfoMapper.selectPowerinfo(id);
        PageInfo pageInfo = new PageInfo<>(sysPowerinfo,pageSize);
        map.put("sysPowerinfo",pageInfo);
        return map;
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
    public List<SysPowerinfo> queryPermissions(String name){
        return this.sysRoleinfoMapper.queryPermissions(name);
    }
}

