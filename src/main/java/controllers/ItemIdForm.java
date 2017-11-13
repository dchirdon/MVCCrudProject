package controllers;

import javax.validation.constraints.NotNull;


public class ItemIdForm {
	@NotNull
	private Integer id;
	
	public ItemIdForm() {
		// TODO Auto-generated constructor stub
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
