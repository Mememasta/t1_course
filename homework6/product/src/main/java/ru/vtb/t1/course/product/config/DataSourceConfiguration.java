package ru.vtb.t1.course.product.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;
import java.sql.Statement;

@Configuration
@EnableConfigurationProperties(value = HikariProperties.class)
public class DataSourceConfiguration {

    @Bean
    public Statement getStatement(HikariProperties hikariProperties) throws SQLException {
        return new HikariDataSource(hikariProperties).getConnection().createStatement();
    }
}
