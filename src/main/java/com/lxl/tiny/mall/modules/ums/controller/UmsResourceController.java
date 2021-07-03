package com.lxl.tiny.mall.modules.ums.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lxl.tiny.mall.common.api.CommonPage;
import com.lxl.tiny.mall.common.api.CommonResult;
import com.lxl.tiny.mall.modules.ums.model.UmsResource;
import com.lxl.tiny.mall.modules.ums.service.UmsResourceService;
import com.lxl.tiny.mall.security.component.DynamicSecurityMetadataSource;
import com.lxl.tiny.mall.security.component.DynamicSecurityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "UmsResourceController",description = "后台资源管理")
@RequestMapping("/resource")
public class UmsResourceController {
    @Autowired
    private UmsResourceService resourceService;

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityService;

    @ApiOperation("添加后台资源")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsResource umsResource){
        boolean success = resourceService.create(umsResource);
        dynamicSecurityService.clearDataSource();
        if (success){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改后台资源")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody UmsResource umsResource){
        boolean success = resourceService.update(id,umsResource);
        dynamicSecurityService.clearDataSource();
        if (success){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据ID获取资源")
    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsResource> getItem(@PathVariable Long id){
        UmsResource umsResource = resourceService.getById(id);
        return CommonResult.success(umsResource);
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        boolean success = resourceService.delete(id);
        dynamicSecurityService.clearDataSource();
        if (success){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsResource>> list(@RequestParam(required = false) Long categoryId,
                                                      @RequestParam(required = false) String nameKeyword,
                                                      @RequestParam(required = false) String urlKeyword,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsResource> resourceList = resourceService.list(categoryId,nameKeyword, urlKeyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(resourceList));
    }

    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResource>> listAll(){
        List<UmsResource> resourceList = resourceService.list();
        return CommonResult.success(resourceList);
    }

}
