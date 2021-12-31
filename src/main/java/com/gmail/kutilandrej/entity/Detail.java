package com.gmail.kutilandrej.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="details")
public class Detail {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  @Id
  private int id;
  @Column(name="city")
  private String city;
  @Column(name="phone_number")
  private String phoneNumber;
  @Column(name="email")
  private String email;
  @OneToOne(mappedBy = "detail", cascade = CascadeType.ALL)
  private Employee employee;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Detail(String city, String phoneNumber, String email) {
    this.city = city;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public Detail() { }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Detail{" +
        "id=" + id +
        ", city='" + city + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", email='" + email + '\'' +
        ", employee=" + employee +
        '}';
  }
}
