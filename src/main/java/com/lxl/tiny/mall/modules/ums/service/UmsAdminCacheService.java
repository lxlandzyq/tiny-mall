package com.lxl.tiny.mall.modules.ums.service;

import com.lxl.tiny.mall.modules.ums.model.UmsAdmin;
import com.lxl.tiny.mall.modules.ums.model.UmsResource;

import java.util.List;

/**
 * 后台用户缓存管理Service
 */
public interface UmsAdminCacheService {

    /**
     * 获取缓存后台用户信息
     * @param username
     * @return
     */
    UmsAdmin getAdmin(String username);

    /**
     * 设置缓存后台用户信息
     * @param admin
     */
    void setAdmin(UmsAdmin admin);

    /**
     * 获取缓存后台用户资源
     * @param adminId
     * @return
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 设置后台用户资源列表
     */
    void setResourceList(Long adminId,List<UmsResource> resourceList);
}
