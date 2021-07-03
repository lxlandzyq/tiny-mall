package com.lxl.tiny.mall.modules.ums.controller;

import com.lxl.tiny.mall.common.api.CommonResult;
import com.lxl.tiny.mall.modules.ums.model.UmsResource;
import com.lxl.tiny.mall.modules.ums.model.UmsResourceCategory;
import com.lxl.tiny.mall.modules.ums.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "UmsResourceCategoryController",description = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService resourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResourceCategory>> listAll(){
        List<UmsResourceCategory> resourceCategories = resourceCategoryService.listAll();
        return CommonResult.success(resourceCategories);
    }

    @ApiOperation("添加后台资源分类")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsResourceCategory umsResourceCategory){
        boolean success = resourceCategoryService.create(umsResourceCategory);
        if (success){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改后台资源分类")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody UmsResourceCategory umsResourceCategory){
        umsResourceCategory.setId(id);
        boolean success = resourceCategoryService.updateById(umsResourceCategory);
        if (success){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        boolean sucees = resourceCategoryService.removeById(id);
        if (sucees){
            return CommonResult.success(null);
        }
        return CommonResult.failed();
    }

}
