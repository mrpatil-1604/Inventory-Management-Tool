package com.mr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mr.model.ProcessedItem;
import com.mr.model.RawMaterial;

@Component
public class ProcessedItemDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insertProcessedItem(ProcessedItem processedItem){
		Integer i = (Integer) this.hibernateTemplate.save(processedItem);
		return i;
	}
	public ProcessedItem getId(int Id){
		ProcessedItem processedItem =this.hibernateTemplate.get(ProcessedItem.class, Id);
		return processedItem;
	}
	public List<ProcessedItem> getAllProcessedItem() {
		List<ProcessedItem> processedItem = this.hibernateTemplate.loadAll(ProcessedItem.class);
		return  processedItem;
		}
	@Transactional
	public void deleteProcessedItem(int Id) {
		ProcessedItem processedItem = this.hibernateTemplate.get(ProcessedItem.class, Id);
		this.hibernateTemplate.delete(processedItem);
		}	
	@Transactional
	public void updateQuantity(ProcessedItem processedItem) {
		this.hibernateTemplate.update(processedItem);
		}
}
