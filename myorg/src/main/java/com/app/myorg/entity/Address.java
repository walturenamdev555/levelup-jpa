package com.app.myorg.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "ADDRESS")
@Data
public class Address {
  @Id @GeneratedValue private Integer addressId;
  private String houseNumber;
  private String city;

  @Column(nullable = false)
  private Integer pinCode;

  // one extra column will be created by adding empId into it
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "emp_id", referencedColumnName = "empId")
  private Employee employee;

}
