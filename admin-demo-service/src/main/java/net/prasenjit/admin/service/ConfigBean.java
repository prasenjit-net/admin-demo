package net.prasenjit.admin.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.TraceContextHolder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "net.prasenjit.config")
public class ConfigBean {
	private String property = "default";

	@Async
	public void doPrint() {
		Span span = TraceContextHolder.getCurrentSpan();
		if (span != null)
			span.addTimelineAnnotation("time1");
		log.info("property = " + property);
		if (span != null)
			span.addTimelineAnnotation("time1");
	}
}
