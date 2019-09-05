package com.xyt.usermucon.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xyt.usermucon.dto.PerDto;
import com.xyt.usermucon.server.PerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：杜志诚
 * @create 2019-08-22 14:36
 * @function
 * @editLog
 */
@RestController
@RequestMapping("/perController")
@Api(value = "Swagger说明", description = "Swagger描述")
public class PerController {
    @Autowired
    PerService perService;

    /**
     * 方法描述，方法ID：SE20190820103917758
     *
     * @param pageNo 当前页数
     * @param pageSize 每页条数
     * @return 方法说明
     */
    @ApiOperation(value = "方法描述", notes = "方法说明")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页数", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", dataType = "int")
    })
    @PostMapping("/getPerAndAchList1")
    public PageInfo getPerAndAchList1(
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {


        PageHelper.startPage(pageNo, pageSize);
        List<PerDto> perDtos = perService.getPerAndAchList1();
        PageInfo pageInfo = new PageInfo<>(perDtos,pageSize);
        return pageInfo;
    }
}

