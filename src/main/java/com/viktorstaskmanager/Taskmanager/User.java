package com.viktorstaskmanager.Taskmanager;

import java.util.HashMap;

public class User {
  private String name;
  private String password;
  private HashMap<String,String> tasks;

  public User(String name, String password){
    this.name = name;
    this.password = password;
    this.tasks = new HashMap<>();
  }
}
