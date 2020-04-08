package com.cloud.text;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 2u
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class JdbcBean {

    private String url;

    private String username;

    private String password;

    /**
     * 预设sql固定值
     */
    private String sql = "select COLUMN_NAME,DATA_TYPE,COLUMN_COMMENT from information_schema.COLUMNS where table_name = '%s';";
}
