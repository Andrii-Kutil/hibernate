package com.gmail.kutilandrej.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "section")
public class Section {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name")
  private String name;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "child_section"
      , joinColumns = @JoinColumn(name = "section_id")
      , inverseJoinColumns =@JoinColumn(name = "child_id"))
  private List<Child> childList;

  public Section() {
  }

  public Section(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addChild(Child child) {
    if (childList == null) {
      childList = new ArrayList<>();
    }
    this.childList.add(child);
  }

  @Override
  public String toString() {
    return "Section{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
