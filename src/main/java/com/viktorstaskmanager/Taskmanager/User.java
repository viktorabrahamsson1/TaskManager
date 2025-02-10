package com.viktorstaskmanager.Taskmanager;

import java.util.HashMap;

public class User {
  private final String name;
  private final String password;
  private final HashMap<String, String> tasks = new HashMap<>();

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public String getName() {
    return this.name;
  }

  public String getPassword() {
    return this.password;
  }

}
