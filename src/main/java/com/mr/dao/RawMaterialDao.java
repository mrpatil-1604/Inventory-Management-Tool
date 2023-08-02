package com.mr.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mr.model.RawMaterial;

@Component
public class RawMaterialDao {
		@Autowired
		private HibernateTemplate hibernateTemplate;
		public HibernateTemplate getHibernateTemplate() {
			return hibernateTemplate;
		}
		public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
			this.hibernateTemplate = hibernateTemplate;
		}
		@Transactional
		public int insertRaw(RawMaterial rawMaterial) {
			// insert
			Integer i = (Integer) this.hibernateTemplate.save(rawMaterial);
			return i;
			}
		public RawMaterial getId(int Id){
			RawMaterial rawMaterial =this.hibernateTemplate.get(RawMaterial.class, Id);
			return rawMaterial;
		}
		public List<RawMaterial> getAllRaw() {
			List<RawMaterial> rawMaterial = this.hibernateTemplate.loadAll(RawMaterial.class);
			return rawMaterial;
			}
		@Transactional
		public void deleteRaw(int Id) {
			RawMaterial rawMaterial = this.hibernateTemplate.get(RawMaterial.class, Id);
			this.hibernateTemplate.delete(rawMaterial);
			}	
		@Transactional
		public void updateQuantity(RawMaterial rawMaterial) {
			this.hibernateTemplate.update(rawMaterial);
			}
}
