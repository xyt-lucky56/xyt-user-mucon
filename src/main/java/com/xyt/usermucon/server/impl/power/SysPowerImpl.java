package com.xyt.usermucon.server.impl.power;

import com.xyt.usermucon.common.BizException;
import com.xyt.usermucon.common.ToolUtils;
import com.xyt.usermucon.dao.power.SysGrouplinkpowerMapper;
import com.xyt.usermucon.dao.power.SysPowerinfoMapper;
import com.xyt.usermucon.dto.power.SysGrouplinkpower;
import com.xyt.usermucon.dto.power.SysPowerinfo;
import com.xyt.usermucon.dto.power.SysPowerinfoExample;
import com.xyt.usermucon.server.power.SysPowerService;
import lh.units.ResultStruct;
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
public class SysPowerImpl implements SysPowerService {

    @Autowired
    private SysPowerinfoMapper SysPowerinfoMapper;
    @Autowired
    private SysGrouplinkpowerMapper sysGrouplinkpowerMapper;

    @Value("${exception.port}")
    private Short port;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return this.SysPowerinfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insertSelective(SysPowerinfo record) {
        Integer counts = this.SysPowerinfoMapper.queryPowerCountByName(record.getPowername());
        if (null != counts && counts > 0) {
            throw new BizException("20001", "子菜单名称已经存在！");

        }
        try {
            record.setId(ToolUtils.getPowerKey(port));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //准备一级菜单与子菜单关联数据
        SysGrouplinkpower sysGrouplinkpower = new SysGrouplinkpower();
        try {
            sysGrouplinkpower.setId(ToolUtils.getPowerKey(port));
        } catch (Exception e) {
            e.printStackTrace();
        }
        sysGrouplinkpower.setGroupId(record.getGroupId());
        sysGrouplinkpower.setPowerId(record.getId());
        this.sysGrouplinkpowerMapper.addGrouplinkpower(sysGrouplinkpower);
        //添加子菜单
        return this.SysPowerinfoMapper.insertSelective(record);
    }

    @Override
    /**
     * 全查询子菜单
     * @param sysPowerinfo
     * @return
     */
    public List<SysPowerinfo> selectSysPowerinfo(String groupId,String groupname,String searchName) {
        return this.SysPowerinfoMapper.selectSysPowerinfo(groupId,groupname,searchName);
    }

    @Override
    public SysPowerinfo selectByPrimaryKey(String id) {
        return this.SysPowerinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(SysPowerinfo record) {
        SysPowerinfo sysPowerinfo = this.SysPowerinfoMapper.selectByPrimaryKey(record.getId());
        Integer counts = this.SysPowerinfoMapper.queryPowerCountByName(record.getPowername());
        if (null != counts && counts > 0 && null != sysPowerinfo.getPowername() && !sysPowerinfo.getPowername().equals(record.getPowername())) {
            throw new BizException("20001", "子菜单名称重复！");
        }
        return this.SysPowerinfoMapper.updateByPrimaryKey(record);
    }
}

