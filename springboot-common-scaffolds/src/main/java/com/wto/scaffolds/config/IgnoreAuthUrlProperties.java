package com.wto.scaffolds.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <pre>
 * mesgType:IgnoreAuthUrlProperties
 * message desc:
 *
 * create date: 2021/6/24 15:45
 * <pre>
 **/
@Component
@ConfigurationProperties(prefix = "spring.shiro")
@Data
public class IgnoreAuthUrlProperties {
    List<String> ignoreAuthUrl;
}