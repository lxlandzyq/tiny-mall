package com.lxl.tiny.mall.modules.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxl.tiny.mall.modules.ums.model.UmsResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台资源Mapper接口
 */
public interface UmsResourceMapper extends BaseMapper<UmsResource> {

    /**
     * 获取用户所有可访问资源
     * @param adminId
     * @return
     */
    List<UmsResource> getResourceList(@Param("adminId") Long adminId);

    /**
     * 根据角色ID获取资源
     * @param roleId
     * @return
     */
    List<UmsResource> getResourceListByRoleId(@Param("roleId") Long roleId);

}
