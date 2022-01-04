package it.fammulfin.newfammulfin.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
@Entity
@Table(name="UsersGroup")
public class Group {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  @ManyToOne(optional = false)
  private User owner;
  @ManyToMany
  private Set<User> members;

  public Group() {
  }

  public Group(String name, User owner, Set<User> members) {
    this.name = name;
    this.owner = owner;
    this.members = members;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public Set<User> getMembers() {
    return members;
  }

  public void setMembers(Set<User> members) {
    this.members = members;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Group group = (Group) o;
    return id == group.id && name.equals(group.name) && owner.equals(group.owner) && members.equals(group.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, owner, members);
  }

  @Override
  public String toString() {
    return "Group{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", owner=" + owner +
        ", members=" + members +
        '}';
  }
}
