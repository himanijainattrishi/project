package com.niit.shoppingcart.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Entity
@Table(name="Category")  //if the class name and table name is different
@Component               //if want to cerate instance of Class Category  - category
public class Category implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//add simple properties - same as Category table
		//generate getter/setter methods
		
		@Id
		private String id;
		
		@Column(name="name")  //if the field name and property name is different
		private String name;
		
		private String description;
		
		@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
		private Set<Product> products;
		
		public Set<Product> getProducts() {
			return products;
		}

		public void setProducts(Set<Product> products) {
			this.products = products;
		}

		

		public String getId() {
			return id;
		}

		public void setId(String id) {
			System.out.println("id vaues is" +id);
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		

}
