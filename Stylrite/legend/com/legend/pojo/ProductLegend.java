package com.legend.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="d_product_legend")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ProductLegend")
@Proxy(lazy = false)
public class ProductLegend implements Serializable 
{
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="rowNo")
		private int rowNo;
		
		@Column(name="rowId")
		private String rowId;
		
		@Column(name="legendGroup")
		private String legendGroup;
		
		@Column(name="category")
		private String category;
		
		@Column(name="subCategory")
		private String subCategory;
		
		@Column(name="description")
		private String description;
		
		@Column(name="otherInfo")
		private String otherInfo;

		public int getRowNo() {
			return rowNo;
		}

		public void setRowNo(int rowNo) {
			this.rowNo = rowNo;
		}

		public String getRowId() {
			return rowId;
		}

		public void setRowId(String rowId) {
			this.rowId = rowId;
		}

		public String getLegendGroup() {
			return legendGroup;
		}

		public void setLegendGroup(String legendGroup) {
			this.legendGroup = legendGroup;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getSubCategory() {
			return subCategory;
		}

		public void setSubCategory(String subCategory) {
			this.subCategory = subCategory;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getOtherInfo() {
			return otherInfo;
		}

		public void setOtherInfo(String otherInfo) {
			this.otherInfo = otherInfo;
		}
}
