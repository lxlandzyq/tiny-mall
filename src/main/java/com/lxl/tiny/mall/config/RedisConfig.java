package com.lxl.tiny.mall.config;

import com.lxl.tiny.mall.common.config.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * redis配置类
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {
}
