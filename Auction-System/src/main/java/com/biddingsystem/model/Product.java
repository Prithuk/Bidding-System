package com.biddingsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
public class Product extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	private String name;
	private Long price;
	private String descriptions;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	@JoinTable(name = "tbl_product_uID_pid", joinColumns = {
//			@JoinColumn(name = "product_id", referencedColumnName = "id") }, inverseJoinColumns = {
//					@JoinColumn(name = "user_id", referencedColumnName = "id") })
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
