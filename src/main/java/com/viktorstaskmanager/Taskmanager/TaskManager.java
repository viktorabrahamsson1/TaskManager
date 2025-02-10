package com.viktorstaskmanager.Taskmanager;

import java.util.ArrayList;

public class TaskManager {
  private ArrayList<User> users;

  public TaskManager(){
    this.users = new ArrayList<>();
  }

  public void addUser(User user){
    users.add(user);
  }

}
