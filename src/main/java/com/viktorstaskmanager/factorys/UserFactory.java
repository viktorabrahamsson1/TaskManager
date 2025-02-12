package com.viktorstaskmanager.factorys;

import com.viktorstaskmanager.Taskmanager.User;

import java.util.ArrayList;

public class UserFactory {
  private UserFactory() {
    //Prevents instantiation
  }

  public static boolean addUserToList(String name, String password, ArrayList<User> users) {
    if (name == null || password == null || name.isEmpty() || password.isEmpty()) {
      return false;
    }

    try {
      users.add(new User(name, password));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean removeUserFromList(String name, String password, User loggedInUser, ArrayList<User> users) {
    return users.removeIf(user -> user.getName().equals(name) && user.getPassword().equals(password));
  }

  public static User logIn(String name, String password, ArrayList<User> users) {
    for (User user : users) {
      if (name.equals(user.getName()) && password.equals(user.getPassword())) {
        return user;
      }
    }
    return null;
  }

  public static User logOut() {
    return null;
  }
}
