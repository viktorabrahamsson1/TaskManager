package com.viktorstaskmanager.Taskmanager;

import com.viktorstaskmanager.factorys.UserFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
  private final ArrayList<User> users;
  private final Scanner scanner;
  private User loggedInUser = null;

  public TaskManager() {
    this.users = new ArrayList<>();
    scanner = new Scanner(System.in);
  }

  /*
   ***********************
   * USER RELATED LOGIC
   ***********************
   */

  public void logIn() {
    System.out.print("Enter your name: ");
    String name = scanner.nextLine();
    System.out.print("Enter your password: ");
    String password = scanner.nextLine();

    User user = UserFactory.logIn(name, password, users);

    if (user != null) {
      System.out.println("Successfully logged in.");
      this.loggedInUser = user;
    } else {
      System.out.println("User not found.");
    }
  }

  public void logOut() {
    this.loggedInUser = UserFactory.logOut();
  }

  public void createUser() {
    String name;
    String password;
    String confirmPassword;

    do {
      System.out.print("Enter your name: ");
      name = scanner.nextLine().trim();

      if (name.isEmpty()) {
        System.out.println("Your name cant be empty.");
      }

    } while (name.isEmpty());

    do {
      System.out.print("Enter your password: ");
      password = scanner.nextLine();
      System.out.print("Confirm your password: ");
      confirmPassword = scanner.nextLine();

      if (!password.equals(confirmPassword)) {
        System.out.println("Passwords do not math, try again!");
      }
    } while (!password.equals(confirmPassword));


    if (UserFactory.addUserToList(name, password, users)) {
      System.out.println("User created successfully");
    } else {
      System.out.println("Failed to create user.");
    }

  }

  public void deleteUser() {
    System.out.print("Enter the name to delete: ");
    String name = scanner.nextLine();
    System.out.print("Enter the password to confirm delete: ");
    String password = scanner.nextLine();

    if (UserFactory.removeUserFromList(name, password, this.loggedInUser, users)) {
      System.out.println("User successfully removed.");
      this.logOut();
    } else {
      System.out.println("Failed to remove user.");
    }
  }


  /*
   ***********************
   * TASK RELATED LOGIC
   ***********************
   */


  public void addTask() {
    System.out.print("Enter your task:");
    String taskContent = scanner.nextLine();
    System.out.println("Enter the due date for the task (days): ");
    int dueDateDays = scanner.nextInt();
    
  }

  public void deleteTask() {

  }

  public void modifyTask() {

  }

  public void completeTask() {

  }

}
