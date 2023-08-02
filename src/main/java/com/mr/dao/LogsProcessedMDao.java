package com.mr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mr.model.LogsProcessedM;
import com.mr.model.LogsRawM;

@Component
public class LogsProcessedMDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public int insertLogsProcessedM(LogsProcessedM logsProcessedM) {
		// insert
		Integer i = (Integer) this.hibernateTemplate.save(logsProcessedM);
		return i;
		}
	public List<LogsProcessedM> getAllLogsProcessed() {
		List<LogsProcessedM> logsProcessedM = this.hibernateTemplate.loadAll(LogsProcessedM.class);
		return logsProcessedM;
		}
}
