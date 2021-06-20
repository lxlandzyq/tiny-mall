package com.lxl.tiny.mall.modules.ums.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxl.tiny.mall.domain.AdminUserDetails;
import com.lxl.tiny.mall.modules.ums.mapper.UmsAdminMapper;
import com.lxl.tiny.mall.modules.ums.mapper.UmsResourceMapper;
import com.lxl.tiny.mall.modules.ums.model.UmsAdmin;
import com.lxl.tiny.mall.modules.ums.model.UmsResource;
import com.lxl.tiny.mall.modules.ums.service.UmsAdminCacheService;
import com.lxl.tiny.mall.modules.ums.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 后台管理员管理Service实现类
 */
@Service
public class UmsAdminServiceImpl  extends ServiceImpl<UmsAdminMapper,UmsAdmin> implements UmsAdminService {

    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Autowired
    private UmsResourceMapper resourceMapper;

    @Autowired
    private UmsAdminMapper adminMapper;

    @Override
    public UmsAdmin getAdminByUsername(String username){
        UmsAdmin admin = adminCacheService.getAdmin(username);
        if(admin != null) return admin;
        QueryWrapper<UmsAdmin> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(UmsAdmin::getUsername,username);
        List<UmsAdmin> adminList = list(wrapper);
        if(adminList != null && adminList.size() > 0){
            admin = adminList.get(0);
            adminCacheService.setAdmin(admin);
            return admin;
        }
        return null;
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId){
        List<UmsResource> resourceList = adminCacheService.getResourceList(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            return resourceList;
        }
        resourceList = resourceMapper.getResourceList(adminId);
        if(CollUtil.isNotEmpty(resourceList)){
            adminCacheService.setResourceList(adminId,resourceList);
        }
        return resourceList;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        // 获取用户信息
        UmsAdmin admin = getAdminByUsername(username);
        if(admin != null){
            List<UmsResource> resourceList = getResourceList(admin.getId());
            return new AdminUserDetails(admin,resourceList);
        }
        throw new UsernameNotFoundException("用户名或者密码错误");
    }
}
