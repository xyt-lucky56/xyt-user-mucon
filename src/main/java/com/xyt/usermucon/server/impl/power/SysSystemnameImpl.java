package com.xyt.usermucon.server.impl.power;

import com.xyt.usermucon.common.BizException;
import com.xyt.usermucon.common.ToolUtils;
import com.xyt.usermucon.dao.power.SysGroupinfoMapper;
import com.xyt.usermucon.dao.power.SysPowerinfoMapper;
import com.xyt.usermucon.dao.power.SysRoleinfoMapper;
import com.xyt.usermucon.dao.power.SysSystemnameMapper;
import com.xyt.usermucon.dto.power.SysSystemname;
import com.xyt.usermucon.dto.power.SysSystemnameExample;
import com.xyt.usermucon.server.power.SysSystemnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author :刘梦丽
 * @create 2019-09-04 14:36
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class SysSystemnameImpl implements SysSystemnameService {

    @Autowired
    private SysSystemnameMapper sysSystemnameMapper;
    @Autowired
    private SysGroupinfoMapper sysGroupinfoMapper;
    @Autowired
    private SysRoleinfoMapper sysRoleinfoMapper;


    @Value("${exception.port}")
    private Short port;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return this.sysSystemnameMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insertSelective(SysSystemname record) {
        Integer counts=this.sysSystemnameMapper.querySystemCountByName(record.getSystemname());
        if(null!=counts && counts>0){
            throw new BizException("20001","系统名称重复！");
        }else{
            try {
                record.setId(ToolUtils.getPowerKey(port));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.sysSystemnameMapper.insertSelective(record);
        }
    }

    @Override
    public List<SysSystemname> selectByExample(SysSystemnameExample example) {
        return this.sysSystemnameMapper.selectByExample(example);
    }

    @Override
    public SysSystemname selectByPrimaryKey(String id) {
        return this.sysSystemnameMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(SysSystemname record) {
        SysSystemname sysSystemname=this.sysSystemnameMapper.selectByPrimaryKey(record.getId());
        Integer counts=this.sysSystemnameMapper.querySystemCountByName(record.getSystemname());
        if(null!=counts && counts>0 && !sysSystemname.getSystemname().equals(record.getSystemname())){
            throw new BizException("20001","系统名称重复！");
        }
        //同步角色、一级菜单中系统名称，保持一致性
        if(!sysSystemname.getSystemname().equals(record.getSystemname())){
            this.sysGroupinfoMapper.updateSystemNameFromGroupinfo(record.getSystemname(),sysSystemname.getSystemname());
            this.sysRoleinfoMapper.updateSystemNameFromRoleinfo(record.getSystemname(),sysSystemname.getSystemname());
        }
        return this.sysSystemnameMapper.updateByPrimaryKey(record);
    }
}

