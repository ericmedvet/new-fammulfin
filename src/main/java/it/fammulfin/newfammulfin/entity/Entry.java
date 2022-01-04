package it.fammulfin.newfammulfin.entity;

import it.fammulfin.newfammulfin.StringSetConverter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
@Entity
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @ManyToOne(optional = false)
  private Group group;
  @ManyToOne(optional = false)
  private Chapter chapter;
  private LocalDate date;
  @Column(precision = 10, scale = 2)
  private BigDecimal value;
  @ElementCollection
  private Map<User, BigDecimal> payingUser; // TODO: in rest, should be the user key or href
  @ElementCollection
  private Map<User, BigDecimal> accountingUser; // TODO: in rest, should be the user key or href
  private String payee;
  private String description;
  private String note;
  @Convert(converter = StringSetConverter.class)
  private Set<String> tags;

  public Entry() {
  }

  public Entry(
      Group group,
      Chapter chapter,
      LocalDate date,
      BigDecimal value,
      Map<User, BigDecimal> payingUser,
      Map<User, BigDecimal> accountingUser,
      String payee,
      String description,
      String note,
      Set<String> tags
  ) {
    this.group = group;
    this.chapter = chapter;
    this.date = date;
    this.value = value;
    this.payingUser = payingUser;
    this.accountingUser = accountingUser;
    this.payee = payee;
    this.description = description;
    this.note = note;
    this.tags = tags;
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

  public Chapter getChapter() {
    return chapter;
  }

  public void setChapter(Chapter chapter) {
    this.chapter = chapter;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public Map<User, BigDecimal> getPayingUser() {
    return payingUser;
  }

  public void setPayingUser(Map<User, BigDecimal> payingUser) {
    this.payingUser = payingUser;
  }

  public Map<User, BigDecimal> getAccountingUser() {
    return accountingUser;
  }

  public void setAccountingUser(Map<User, BigDecimal> accountingUser) {
    this.accountingUser = accountingUser;
  }

  public String getPayee() {
    return payee;
  }

  public void setPayee(String payee) {
    this.payee = payee;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Set<String> getTags() {
    return tags;
  }

  public void setTags(Set<String> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Entry entry = (Entry) o;
    return id == entry.id && group.equals(entry.group) && chapter.equals(entry.chapter) && date.equals(entry.date) && value.equals(
        entry.value) && payingUser.equals(entry.payingUser) && accountingUser.equals(entry.accountingUser) && payee.equals(
        entry.payee) && description.equals(entry.description) && note.equals(entry.note) && tags.equals(entry.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, group, chapter, date, value, payingUser, accountingUser, payee, description, note, tags);
  }

  @Override
  public String toString() {
    return "Entry{" +
        "id=" + id +
        ", group=" + group +
        ", chapter=" + chapter +
        ", date=" + date +
        ", value=" + value +
        '}';
  }
}
