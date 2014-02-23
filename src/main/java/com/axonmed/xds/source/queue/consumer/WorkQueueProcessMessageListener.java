package com.axonmed.xds.source.queue.consumer;


import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.axonmed.xds.source.enumeration.WorkQueueTypeEnum;
import com.axonmed.xds.source.model.WorkQueue;
import com.axonmed.xds.source.processor.WorkQueueStudyProcessor;

@Component
public class WorkQueueProcessMessageListener implements MessageListener {

	protected static final Logger logger = LoggerFactory
			.getLogger(WorkQueueProcessMessageListener.class);

	@Autowired
	private WorkQueueStudyProcessor workQueueStudyProcessor;

	@Override
	public void onMessage(Message message) {
		logger.info("Get one message:" + message);
		if (message instanceof ObjectMessage) {
			try {
				Object objectMessage = ((ObjectMessage) message).getObject();
				if (objectMessage instanceof WorkQueue) {
					WorkQueue workQueue = (WorkQueue) objectMessage;
					logger.info("Get the object message:" + workQueue.getId());
					if (workQueue.getWorkQueueTypeEnum() == WorkQueueTypeEnum.StudyProcess){
//							&& workQueue.getWorkQueueUids().size() > 0) {
						logger.info("to do study process");
						workQueueStudyProcessor.process(workQueue);
					}
				}
			} catch (Exception e) {
				logger.info("jms exception:", e);
			}
		}

	}

}