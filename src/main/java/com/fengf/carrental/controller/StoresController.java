package com.fengf.carrental.controller;

import com.fengf.carrental.entity.Stores;
import com.fengf.carrental.service.StoresService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Stores)表控制层
 *
 * @author zyf
 * @since 2020-10-12 11:40:35
 */
@Controller
@RequestMapping("/stores/")
public class StoresController {
    /**
     * 服务对象
     */
    @Resource
    private StoresService storesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Stores selectOne(Integer id) {
        return this.storesService.queryById(id);
    }

}