package net.prasenjit.admin.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.prasenjit.admin.service.ConfigBean;

@Slf4j
@RestController
public class HomeController {

	@Autowired
	private ConfigBean configBean;

	@RequestMapping("/")
	public String home() {
		log.trace("a trace message");
		log.debug("a debug message");
		log.info("a info message");
		log.warn("a warn message");
		log.error("a error message");
		configBean.doPrint();

		return "Hello Service " + configBean.getProperty();
	}

}
