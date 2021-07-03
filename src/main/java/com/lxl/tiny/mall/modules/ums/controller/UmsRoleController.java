package com.lxl.tiny.mall.modules.ums.controller;

import com.lxl.tiny.mall.modules.ums.service.UmsRoleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台用户角色管理
 */
@Controller
@Api(tags = "UmsRoleController",description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;



}
