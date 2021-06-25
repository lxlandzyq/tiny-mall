package com.lxl.tiny.mall.modules.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxl.tiny.mall.modules.ums.model.UmsMenu;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 后台菜单表Mapper接口
 */
public interface UmsMenuMapper extends BaseMapper<UmsMenu> {
    /**
     * 根据后台用户ID获取菜单
     */
    List<UmsMenu> getMenuList(@Param("adminId")Long adminId);
    /**
     * 根据角色ID获取菜单
     */
    List<UmsMenu> getMenuListByRoleId(@Param("roleId")Long roleId);
}
