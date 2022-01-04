package it.fammulfin.newfammulfin.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
@Entity
public class Chapter {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @ManyToOne(optional = false)
  private Group group;
  @ManyToOne
  private Chapter parent;
  private String name;

  public Chapter() {
  }

  public Chapter(Group group, Chapter parent, String name) {
    this.group = group;
    this.parent = parent;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public Chapter getParent() {
    return parent;
  }

  public void setParent(Chapter parent) {
    this.parent = parent;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Chapter chapter = (Chapter) o;
    return id == chapter.id && group.equals(chapter.group) && Objects.equals(
        parent,
        chapter.parent
    ) && name.equals(chapter.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, group, parent, name);
  }

  @Override
  public String toString() {
    return "Chapter{" +
        "id=" + id +
        ", group=" + group +
        ", parent=" + parent +
        ", name='" + name + '\'' +
        '}';
  }
}
