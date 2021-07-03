package com.lxl.tiny.mall.modules.ums.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxl.tiny.mall.common.api.CommonPage;
import com.lxl.tiny.mall.common.api.CommonResult;
import com.lxl.tiny.mall.modules.ums.dto.UmsMenuNode;
import com.lxl.tiny.mall.modules.ums.model.UmsMenu;
import com.lxl.tiny.mall.modules.ums.service.UmsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "UmsMenuController",description = "后台菜单管理系统")
@RequestMapping("/menu")
public class UmsMenuController {

    @Autowired
    private UmsMenuService umsMenuService;

    @ApiOperation("添加后台菜单")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsMenu umsMenu){
        boolean success = umsMenuService.create(umsMenu);
        if (success){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改后台菜单")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @PathVariable UmsMenu umsMenum){
        boolean success = umsMenuService.update(id,umsMenum);
        if (success){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据ID获取菜单详情")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsMenu> getItem(@PathVariable Long id){
        UmsMenu umsMenu = umsMenuService.getById(id);
        return CommonResult.success(umsMenu);
    }

    @ApiOperation("根据ID删除后台菜单")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        boolean success = umsMenuService.removeById(id);
        if (success){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页查询后台菜单")
    @RequestMapping(value = "/list/{parentId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsMenu>> list(@PathVariable Long parentId,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsMenu> menuList = umsMenuService.list(parentId,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(menuList));
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMenuNode>> treeList(){
        List<UmsMenuNode> list = umsMenuService.treeList();
        return CommonResult.success(list);
    }

    @ApiOperation("修改菜单显示状态")
    @RequestMapping(value = "/updateHidden/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateHidden(@PathVariable Long id,@RequestParam("hidden") Integer hidden){
        boolean success = umsMenuService.updateHidden(id,hidden);
        if (success){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

}
