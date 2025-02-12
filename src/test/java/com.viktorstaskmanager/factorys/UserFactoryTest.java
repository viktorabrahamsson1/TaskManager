package com.viktorstaskmanager.factorys;

import com.viktorstaskmanager.Taskmanager.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class UserFactoryTest {

  private ArrayList<User> users;

  @BeforeEach
  public void setUp() {
    users = new ArrayList<>();
  }

  @Test
  public void testAddUserToList_Success() {
    // Arrange
    String name = "Test User";
    String password = "password123";

    // Act
    boolean result = UserFactory.addUserToList(name, password, users);

    // Assert
    assertTrue(result);
    assertEquals(1, users.size());  // Verify the user is added
    assertEquals(name, users.get(0).getName());  // Verify the correct name is added
  }

  @Test
  public void testAddUserToList_Failure_EmptyName() {
    // Arrange
    String name = "";
    String password = "password123";

    // Act
    boolean result = UserFactory.addUserToList(name, password, users);

    // Assert
    assertFalse(result);  // Should return false if name is empty
    assertEquals(0, users.size());  // User should not be added
  }

  @Test
  public void testAddUserToList_Failure_EmptyPassword() {
    String name = "Test Name";
    String password = "";

    boolean result = UserFactory.addUserToList(name, password, users);

    assertFalse(result);
    assertEquals(0, users.size());
  }

  @Test
  public void testRemoveUserFromList_Success() {
    // Arrange
    String name = "Test User";
    String password = "password123";
    User loggedInUser = new User(name, password);
    UserFactory.addUserToList(name, password, users);  // Add user first

    // Act
    boolean result = UserFactory.removeUserFromList(name, password, loggedInUser, users);

    // Assert
    assertTrue(result);
    assertEquals(0, users.size());  // Verify user is removed
  }

  @Test
  public void testRemoveUserFromList_Failure_UserNotFound() {
    // Arrange
    String name = "Test User";
    String password = "wrongPassword";
    User loggedInUser = new User("Other User", "password123");

    // Act
    boolean result = UserFactory.removeUserFromList(name, password, loggedInUser, users);

    // Assert
    assertFalse(result);  // Should return false if user is not found
  }
}
