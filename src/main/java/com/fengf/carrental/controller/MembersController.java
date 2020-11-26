package com.fengf.carrental.controller;

import com.fengf.carrental.entity.Members;
import com.fengf.carrental.service.MembersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Members)表控制层
 *
 * @author zyf
 * @since 2020-10-12 11:40:34
 */
@Controller
@RequestMapping("/members/")
public class MembersController {
    /**
     * 服务对象
     */
    @Resource
    private MembersService membersService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Members selectOne(Integer id) {
        return this.membersService.queryById(id);
    }

    /**
     * 添加数据
     */
    @PostMapping("addMember")
    public String addMember(Members members) {

        if (membersService.insert(members)>0){
            return "redirect:/members/find_customerPage";
        }
        return "add_customer";
    }
    /**
     * 会员查询
     */
    @GetMapping("find_customerPage")
    public String find_customerPage() {

        return "find_customer";
    }
    /**
     * 注册会员页面
     */
    @GetMapping("addUMemberPage")
    public String addUMemberPage() {
        return "add_customer";
    }

}