package com.lxl.tiny.mall.modules.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lxl.tiny.mall.modules.ums.dto.UmsAdminParam;
import com.lxl.tiny.mall.modules.ums.model.UmsAdmin;
import com.lxl.tiny.mall.modules.ums.model.UmsResource;
import com.lxl.tiny.mall.modules.ums.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 后台管理员管理Service
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     */
    List<UmsResource> getResourceList(Long adminId);
}
