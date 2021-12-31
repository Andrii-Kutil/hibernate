package com.gmail.kutilandrej.entity;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="employees")
public class Employee {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  @Id
  private int id;
  @Column(name="name")
  private String name;
  @Column(name="surname")
  private String surname;
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "department_id")
  private Department department;
  @Column(name="salary")
  private int salary;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="details_id")
  private Detail detail;

  public Employee() {
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public int getSalary() {
    return salary;
  }

  public Employee(String name, String surname, int salary) {
    this.name = name;
    this.surname = surname;
    this.salary = salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Detail getDetail() {
    return detail;
  }

  public void setDetail(Detail detail) {
    this.detail = detail;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", department='" + department + '\'' +
        '}';
  }
}
