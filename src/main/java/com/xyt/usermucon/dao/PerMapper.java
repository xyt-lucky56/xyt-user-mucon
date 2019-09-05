package com.xyt.usermucon.dao;

import com.xyt.usermucon.dto.PerDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ：杜志诚
 * @create 2019-08-22 14:36
 * @function
 * @editLog
 */
@Mapper
public interface PerMapper {
    /**
     * 方法描述
     *
     * @return 方法说明
     */
    List<PerDto> getPerAndAchList1();
}

