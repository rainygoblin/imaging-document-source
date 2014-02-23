package com.axonmed.xds.source.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axonmed.xds.source.enumeration.WorkQueueTypeEnum;
import com.axonmed.xds.source.model.WorkQueue;
import com.axonmed.xds.source.model.WorkQueueTypeProperties;
import com.axonmed.xds.source.model.WorkQueueUid;
import com.axonmed.xds.source.repository.WorkQueueMapper;
import com.axonmed.xds.source.repository.WorkQueueTypePropertiesMapper;
import com.axonmed.xds.source.repository.WorkQueueUidMapper;

@Service
@Transactional(readOnly = true)
public class WorkQueueService {

	private static final Logger logger = LoggerFactory
			.getLogger(WorkQueueService.class);

	@Autowired
	private WorkQueueUidMapper workQueueUidMapper;

	@Autowired
	private WorkQueueTypePropertiesMapper workQueueTypePropertiesMapper;

	@Autowired
	private WorkQueueMapper workQueueMapper;

	@Resource(name = "workQueueProcessJmsTemplate")
	private JmsTemplate workQueueProcessJmsTemplate;

	public boolean workQueueUidExists(long studyStorageId,
			String seriesInstanceUid, String sopInstanceUid) {
		boolean result = false;
		Map<String, Object> parms = new HashMap<String, Object>();
		parms.put("seriesInstanceUid", seriesInstanceUid);
		parms.put("sopInstanceUid", sopInstanceUid);
		WorkQueueUid workQueueUid = workQueueUidMapper
				.findBySeriesInstanceUidAndSopInstanceUid(parms);
		if (workQueueUid != null) {
			WorkQueue workQueue = workQueueMapper.findById(workQueueUid
					.getWorkQueueId());
			if (workQueue != null) {
				if (workQueue.getStudyStorageId() == studyStorageId) {
					result = true;
				}

			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public void insertWorkQueue(Map<String, Object> parms) {
		logger.info("1. insert the work queue table");
		workQueueMapper.insertWorkQueue(parms);
		List<WorkQueue> workQueues = (List<WorkQueue>) parms.get("curResult");
		if (workQueues != null & workQueues.size() > 0) {
			final WorkQueue insertedWorkQueue = workQueues.get(0);

			if (insertedWorkQueue != null) {
				logger.info("2. produce one work queue message.");
				workQueueProcessJmsTemplate.send(new MessageCreator() {
					public Message createMessage(Session session)
							throws JMSException {
						Message m = session
								.createObjectMessage(insertedWorkQueue);
						return m;
					}
				});
			}
		}

	}

	public WorkQueueTypeProperties getWorkQueueProperties(
			WorkQueueTypeEnum workQueueTypeEnum) {
		
		return workQueueTypePropertiesMapper.getWorkQueueProperties(workQueueTypeEnum);
	}

	public List<WorkQueueUid> findWorkQueueUidByWorkQueueId(long workQueueId) {

		return workQueueUidMapper.findWorkQueueUidByWorkQueueId(workQueueId);
	}

}