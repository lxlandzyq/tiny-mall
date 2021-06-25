package com.lxl.tiny.mall.modules.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxl.tiny.mall.modules.ums.model.UmsRole;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 后台用户角色表Mapper接口
 */
public interface UmsRoleMapper extends BaseMapper<UmsRole> {
    /**
     * 获取用户所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId")Long adminId);
}
