package com.viktorstaskmanager.Taskmanager;

import java.util.Date;

public class Task {
  private final String title;
  private final String contents;
  private final Date dueDate;

  public Task(String title, String contents, Date dueDate) {
    this.contents = contents;
    this.dueDate = dueDate;
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public String getContents() {
    return this.contents;
  }

  public Date getDueDate() {
    return this.dueDate;
  }

  @Override
  public String toString() {
    return this.title + ": " + this.contents + ", due date: " + this.dueDate;
  }
}
