package com.viktorstaskmanager.factorys;

import com.viktorstaskmanager.Taskmanager.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserFactory {
  private UserFactory() {
    //Prevents instantiation
  }

  public static User createUser(Scanner scanner) {
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


    return new User(name, password);
  }

  public static User deleteUser(Scanner scanner, User loggedInUser) {
    System.out.print("Enter the name to delete: ");
    String name = scanner.nextLine();
    System.out.print("Enter the password to confirm delete: ");
    String password = scanner.nextLine();

    if (name.equals(loggedInUser.getName()) && password.equals(loggedInUser.getPassword())) {
      System.out.println("User successfully deleted.");
      return loggedInUser;
    } else {
      System.out.println("User not found.");
      return null;
    }
  }

  public static User logIn(Scanner scanner, ArrayList<User> users) {
    String name = scanner.nextLine();
    String password = scanner.nextLine();
    for (User user : users) {
      if (name.equals(user.getName()) && password.equals(user.getPassword())) {
        return user;
      }
    }
    System.out.println("User not found.");
    return null;
  }

  public static void logOut() {

  }
}
