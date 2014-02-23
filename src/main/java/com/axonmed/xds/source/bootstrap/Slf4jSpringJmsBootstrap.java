package com.axonmed.xds.source.bootstrap;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hornetq.integration.spring.SpringJmsBootstrap;
import org.springframework.stereotype.Component;

import com.axonmed.xds.source.delegate.Slf4jLogDelegateFactory;

@Component("hornetqServer")
public class Slf4jSpringJmsBootstrap extends SpringJmsBootstrap {

	@PostConstruct
	@Override
	public void start() throws Exception {
		org.hornetq.core.logging.Logger
				.setDelegateFactory(new Slf4jLogDelegateFactory());
		super.start();
	}

	@PreDestroy
	@Override
	public void stop() throws Exception {
		super.stop();
	}
}
