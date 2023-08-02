package com.mr.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="rawmaterial")
@Component
public class RawMaterial {
		@Id
		int Id;
		String name;
		int quantity;
		String unit;
		int costPerUnit;
		@Override
		public String toString() {
			return "RawMaterial [Id=" + Id + ", name=" + name + ", quantity=" + quantity + ", unit=" + unit
					+ ", costPerUnit=" + costPerUnit + "]";
		}
		public RawMaterial() {
			super();
			// TODO Auto-generated constructor stub
		}
		public RawMaterial(int id, String name, int quantity, String unit, int costPerUnit) {
			super();
			Id = id;
			this.name = name;
			this.quantity = quantity;
			this.unit = unit;
			this.costPerUnit = costPerUnit;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		public int getCostPerUnit() {
			return costPerUnit;
		}
		public void setCostPerUnit(int costPerUnit) {
			this.costPerUnit = costPerUnit;
		}
}
