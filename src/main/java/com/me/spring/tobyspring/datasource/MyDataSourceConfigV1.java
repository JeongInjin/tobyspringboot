package com.me.spring.tobyspring.datasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@Slf4j
//@EnableConfigurationProperties(MydataSourcePropertiesV1.class)
@ConfigurationPropertiesScan
public class MyDataSourceConfigV1 {

    private final MydataSourcePropertiesV1 properties;

    public MyDataSourceConfigV1(MydataSourcePropertiesV1 properties) {
        this.properties = properties;
    }

    @Bean
    public MyDataSource dataSource() {
      return new MyDataSource(properties.getUrl(), properties.getUsername(), properties.getPassword(), properties.getEtc().getMaxConnection(), properties.getEtc().getTimeout(), properties.getEtc().getOptions());
    }
}
