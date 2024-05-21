package ru.vtb.t1.course.product.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author mchuchalov on 01.05.2024
 */
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class HikariProperties extends HikariConfig {
}
