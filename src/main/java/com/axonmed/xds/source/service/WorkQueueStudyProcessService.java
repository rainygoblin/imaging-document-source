package com.axonmed.xds.source.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.axonmed.xds.source.model.WorkQueue;

@Service
public class WorkQueueStudyProcessService {

	private static final Logger logger = LoggerFactory
			.getLogger(WorkQueueStudyProcessService.class);

	@Transactional
	public void process(WorkQueue workQueue) {
//		checkIfStudyIsLossy();

		boolean successful = false;
		boolean idle = false;

//		loadWorkQueueUids();
	}

}