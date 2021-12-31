package com.gmail.kutilandrej.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "name")
  private String name;
  @Column(name = "max_salary")
  private int maxSalary;
  @Column(name = "min_salary")
  private int minSalary;
  @OneToMany(mappedBy = "department",
             cascade = CascadeType.ALL,
             fetch = FetchType.LAZY)
  private List<Employee> employees;

  public Department() {
  }

  public Department(String name, int maxSalary, int minSalary) {
    this.name = name;
    this.maxSalary = maxSalary;
    this.minSalary = minSalary;
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

  public int getMaxSalary() {
    return maxSalary;
  }

  public void setMaxSalary(int maxSalary) {
    this.maxSalary = maxSalary;
  }

  public int getMinSalary() {
    return minSalary;
  }

  public void setMinSalary(int minSalary) {
    this.minSalary = minSalary;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void addEmployee(Employee employee) {
    if (this.employees == null) {
      this.employees = new ArrayList<>();
    }
    this.employees.add(employee);
    employee.setDepartment(this);
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return "Department{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", maxSalary=" + maxSalary +
        ", minSalary=" + minSalary +
        ", employee=" + employees +
        '}';
  }
}
