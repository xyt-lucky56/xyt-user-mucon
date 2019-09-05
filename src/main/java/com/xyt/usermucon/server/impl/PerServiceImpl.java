package com.xyt.usermucon.server.impl;

import com.xyt.usermucon.dao.PerMapper;
import com.xyt.usermucon.dto.PerDto;
import com.xyt.usermucon.server.PerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：杜志诚
 * @create 2019-08-22 14:36
 * @function
 * @editLog
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class PerServiceImpl implements PerService {
    @Autowired
    PerMapper perMapper;
    /**
     * 方法描述
     *
     * @return 方法说明
     */
    @Override
    public List<PerDto> getPerAndAchList1() {
        return perMapper.getPerAndAchList1();
    }
}

