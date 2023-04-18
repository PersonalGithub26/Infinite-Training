package com.java.project;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name="que")
@SessionScoped
public class QuestionCheckBox {
	
	private List<SelectItem> questions;
	private List<SelectItem> questions2;
	

	public List<SelectItem> getQuestions2() {
		return questions2;
	}

	public void setQuestions2(List<SelectItem> questions2) {
		this.questions2 = questions2;
	}

	public List<SelectItem> getQuestions() {
		return questions;
	}

	public void setQuestions(List<SelectItem> questions) {
		this.questions = questions;
	}

	//DROP DOWN VALUE OF QUESTION NO 2
	public QuestionCheckBox() {
		questions2 = Arrays.stream(Questions.values()).map(q -> new SelectItem(q, q.name())).collect(Collectors.toList());

	}
	
	

}
