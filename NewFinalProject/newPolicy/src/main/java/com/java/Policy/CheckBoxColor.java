package com.java.Policy;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;


@ManagedBean(name = "view")
@SessionScoped
public class CheckBoxColor {
	
	private String[] selectedColors;
	private String[] selectedColors2;
	private List<String> colors;
	private List<SelectItem> primaryColors;
	private String[] selectedPrimaryColors;
	
	
	public String[] getSelectedColors() {
		return selectedColors;
	}
	public void setSelectedColors(String[] selectedColors) {
		this.selectedColors = selectedColors;
	}
	public String[] getSelectedColors2() {
		return selectedColors2;
	}
	public void setSelectedColors2(String[] selectedColors2) {
		this.selectedColors2 = selectedColors2;
	}
	public List<String> getColors() {
		return colors;
	}
	public void setColors(List<String> colors) {
		this.colors = colors;
	}
	public List<SelectItem> getPrimaryColors() {
		return primaryColors;
	}
	public void setPrimaryColors(List<SelectItem> primaryColors) {
		this.primaryColors = primaryColors;
	}
	public String[] getSelectedPrimaryColors() {
		return selectedPrimaryColors;
	}
	public void setSelectedPrimaryColors(String[] selectedPrimaryColors) {
		this.selectedPrimaryColors = selectedPrimaryColors;
	} 

	
	public void init()
	{
		colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Green");
		colors.add("Yellow");
		colors.add("White");
		colors.add("Black");
		colors.add("Brown");
		colors.add("Grey");
		
		primaryColors = new ArrayList<SelectItem>();
		SelectItemGroup group = new SelectItemGroup("Primary Colors");
		group.setSelectItems(new SelectItem[]
				{
					new SelectItem("Red", "Red"),
					new SelectItem("Blue", "Blue"),
					new SelectItem("Green", "Green")
					
				}
				);
		
	}
	
	
	
	
}
