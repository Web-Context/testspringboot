package com.webcontext.apps.sprintboot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

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
}