package com.mr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mr.model.LogsRawM;
import com.mr.model.RawMaterial;

@Component
public class LogsRawMDao {
		@Autowired
		private HibernateTemplate hibernateTemplate;

		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}

		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		@Transactional
		public int insertLogsRawM(LogsRawM logsRawM) {
			// insert
			Integer i = (Integer) this.hibernateTemplate.save(logsRawM);
			return i;
			}
		public List<LogsRawM> getAllLogsRaw() {
			List<LogsRawM> logsRawM = this.hibernateTemplate.loadAll(LogsRawM.class);
			return logsRawM;
			}
}
