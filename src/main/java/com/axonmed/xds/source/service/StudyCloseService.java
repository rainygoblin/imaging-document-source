package com.axonmed.xds.source.service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StudyCloseService {

	protected static final Logger logger = LoggerFactory
			.getLogger(StudyCloseService.class);

	private static int count =0;
	
	@Resource(name = "storageCommitJmsTemplate")
	private JmsTemplate storageCommitJmsTemplate;

	@Scheduled(fixedRate=5000)
	public void closeStudy(){
		logger.info("Close study begin:"+count);
		try {
			Thread.sleep(2000);
			count++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("Close study end:"+count);
		storageCommitJmsTemplate.send(new MessageCreator() {
		public Message createMessage(Session session)
				throws JMSException {
			Message m = session
					.createObjectMessage("sote");
			return m;
		}
	});
	}
}