package com.java.project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name="sDrop")
@SessionScoped
public class StateDropDown {

	private List<SelectItem> states;

	public List<SelectItem> getStates() {
		return states;
	}

	public void setStates(List<SelectItem> states) {
		this.states = states;
	}
	
	public StateDropDown()
	{
		states = Arrays.stream(States.values()).map(q -> new SelectItem(q, q.name())).collect(Collectors.toList());

	}
}
