package com.mkyong.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "record")
public class Report {

	private int id;
	private BigDecimal sales;
	private int qty;
	private String staffName;
	private Date date;

	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "sales")
	public BigDecimal getSales() {
		return sales;
	}

	public void setSales(BigDecimal sales) {
		this.sales = sales;
	}

	@XmlElement(name = "qty")
	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@XmlElement(name = "staffName")
	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Report [id=");
		builder.append(id);
		builder.append(", sales=");
		builder.append(sales);
		builder.append(", qty=");
		builder.append(qty);
		builder.append(", staffName=");
		builder.append(staffName);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}


}