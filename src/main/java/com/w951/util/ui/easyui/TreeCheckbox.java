package com.w951.util.ui.easyui;

import java.io.Serializable;
import java.util.List;

public class TreeCheckbox implements Serializable {
	private static final long serialVersionUID = -2446285661915978933L;
	private String id;
	private String text;
	private String state;
	private List<TreeCheckboxChildren> children;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<TreeCheckboxChildren> getChildren() {
		return children;
	}

	public void setChildren(List<TreeCheckboxChildren> children) {
		this.children = children;
	}
}