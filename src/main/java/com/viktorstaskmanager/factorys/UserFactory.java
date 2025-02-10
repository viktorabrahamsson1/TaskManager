package com.viktorstaskmanager.factorys;

import com.viktorstaskmanager.Taskmanager.User;

import java.util.Scanner;

public class UserFactory {
  private UserFactory(){
    //Prevents instantiation
  }

  public static User createUser(Scanner scanner){
    String name;
    String password;
    String confirmPassword;

    do{
      System.out.print("Enter your name: ");
      name = scanner.nextLine();

      if(!name.isEmpty()){
        System.out.println("Your name cant be empty.");
      }

    }while(!name.isEmpty());

    do{
      System.out.print("Enter your password: ");
      password = scanner.nextLine();
      System.out.print("Confirm your password: s");
      confirmPassword = scanner.nextLine() ;
      

    }while(!password.equals(confirmPassword));



    return new User(name,password);
  }

  public static void deleteUser(){
    System.out.println("delete user..");
  }

  public static void logIn(){

  }

  public static void logOut(){

  }
}
