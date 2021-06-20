package com.lxl.tiny.mall.modules.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxl.tiny.mall.modules.ums.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户表 Mapper接口
 */
public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {
    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);
}
