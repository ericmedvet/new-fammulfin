package it.fammulfin.newfammulfin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author "Eric Medvet" on 2022/01/02 for new-fammulfin
 */
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String firstName;
  private String lastName;

  public User() {
  }

  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return id == user.id && firstName.equals(user.firstName) && lastName.equals(user.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
  }
}
