package com.webcontext.apps.sprintboot.features.item.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.webcontext.apps.sprintboot.core.model.SuperEntity;

@Entity
public class Item extends SuperEntity {
	@Column
	private boolean checked;
	@Column
	private String description;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param checked
	 * @param description
	 */
	public Item(boolean checked, String description) {
		super();
		this.checked = checked;
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [checked=").append(checked)
				.append(", description=").append(description).append("]");
		return builder.toString();
	}

}