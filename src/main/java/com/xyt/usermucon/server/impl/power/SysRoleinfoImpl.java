package com.xyt.usermucon.server.impl.power;

import com.xyt.usermucon.common.BizException;
import com.xyt.usermucon.common.ToolUtils;
import com.xyt.usermucon.dao.power.SysRoleinfoMapper;
import com.xyt.usermucon.dto.power.SysGrouplinkpower;
import com.xyt.usermucon.dto.power.SysRoleinfo;
import com.xyt.usermucon.dto.power.SysRoleinfoExample;
import com.xyt.usermucon.dto.power.SysRolelinkpower;
import com.xyt.usermucon.server.power.SysRoleinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
public class SysRoleinfoImpl implements SysRoleinfoService {

    @Autowired
    private SysRoleinfoMapper SysRoleinfoMapper;

    @Value("${exception.port}")
    private Short port;


    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return this.SysRoleinfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insertSelective(SysRoleinfo record) {
        Integer counts=this.SysRoleinfoMapper.queryRoleByName(record.getRolename());
        if(null!=counts && counts>0){
            throw new BizException("20001","角色名称重复！");
        }else{
            try {
                record.setId(ToolUtils.getPowerKey(port));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.SysRoleinfoMapper.insert(record);
        }
    }

    @Override
    public List<SysRoleinfo> selectByExample(SysRoleinfoExample example) {
        return this.SysRoleinfoMapper.selectByExample(example);
    }

    @Override
    public SysRoleinfo selectByPrimaryKey(String id) {
        return this.SysRoleinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(SysRoleinfo record) {
        SysRoleinfo sysRoleinfo=this.SysRoleinfoMapper.selectByPrimaryKey(record.getId());
        Integer counts=this.SysRoleinfoMapper.queryRoleByName(record.getRolename());
        if(null!=counts && counts>0 && !sysRoleinfo.getRolename().equals(record.getRolename())){
            throw new BizException("20001","角色名称重复！");
        }
        return this.SysRoleinfoMapper.updateByPrimaryKey(record);
    }

    /**
     * 角色-查询角色的权限
     * @return
     */
    @Override
    public Map<String,Object> permissionsToQueryRoles(String id,String systemname){
        Map<String,Object> map=new HashMap<String,Object>();
        //角色-查询角色的权限
        map.put("roleList",this.SysRoleinfoMapper.permissionsToQueryRoles(id,systemname));
        //角色-查询所有权限
        map.put("list",this.SysRoleinfoMapper.queryPermissions(systemname));
        return map;
    }

    /**
     * 权限分配
     * @return
     */
    @Override
    @Transactional
    public Map<String,Object> allocationOfPermissions(String roleId,List<String> powerIds) {
        Map<String,Object> map=new HashMap<String,Object>();
        List<SysGrouplinkpower> list=this.SysRoleinfoMapper.queryRoleGroupPower(roleId);
        if(null!=list && !list.isEmpty()){
            //该角色之前有权限,删除旧的关联权限
            this.SysRoleinfoMapper.deleteRolelinkpower(roleId,powerIds);
        }
        if(null!=powerIds && !powerIds.isEmpty()){
            //准备数据
            List<SysRolelinkpower> sysRolelinkpowerList=new ArrayList<>();
            for (String powerId:powerIds) {
                SysRolelinkpower sysRolelinkpower=new SysRolelinkpower();
                try {
                    sysRolelinkpower.setId(ToolUtils.getPowerKey(port));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                sysRolelinkpower.setPowerId(powerId);
                sysRolelinkpower.setRoleId(roleId);
                sysRolelinkpowerList.add(sysRolelinkpower);
            }
            //添加最新的关联权限
            this.SysRoleinfoMapper.addRolelinkpower(sysRolelinkpowerList);
        }
        return map;
    }
}

