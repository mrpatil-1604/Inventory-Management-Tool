package com.mr.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class LogsRawM {
		@Id
		int Id;
		String name;
		int quantity;
		String issuerName;
		int itemId;
		String date;
		@Override
		public String toString() {
			return "LogsRawM [Id=" + Id + ", name=" + name + ", quantity=" + quantity + ", issuerName=" + issuerName
					+ ", itemId=" + itemId + ", date=" + date + "]";
		}
		public LogsRawM() {
			super();
			// TODO Auto-generated constructor stub
		}
		public LogsRawM(int id, String name, int quantity, String issuerName, int itemId, String date) {
			super();
			Id = id;
			this.name = name;
			this.quantity = quantity;
			this.issuerName = issuerName;
			this.itemId = itemId;
			this.date = date;
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
		public String getIssuerName() {
			return issuerName;
		}
		public void setIssuerName(String issuerName) {
			this.issuerName = issuerName;
		}
		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
}
