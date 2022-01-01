package it.ericmedvet.fammulfin.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author "Eric Medvet" on 2022/01/01 for new-fammulfin
 */
@Entity
public class Group {
  @Id
  @GeneratedValue()
  private String id;
  private String name;
  @ManyToOne
  private List<User> owner;
  @ManyToMany
  private List<User> members;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<User> getOwner() {
    return owner;
  }

  public void setOwner(List<User> owner) {
    this.owner = owner;
  }

  public List<User> getMembers() {
    return members;
  }

  public void setMembers(List<User> members) {
    this.members = members;
  }

  @Override
  public String toString() {
    return "Group{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", owner=" + owner +
        ", members=" + members +
        '}';
  }
}
