package net.prasenjit.admin.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "net.prasenjit.config")
public class ConfigBean {
    private String property = "default";

    @Async
    public void doPrint(){
        log.info("property = " + property);
    }
}
