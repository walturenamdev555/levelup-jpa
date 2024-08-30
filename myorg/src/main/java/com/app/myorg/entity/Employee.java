package com.app.myorg.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE")
@Data
public class Employee {
  @GeneratedValue @Id private Integer empId;
  private String firstName;
  private String lastName;
  private BigDecimal salary;

  @Column(nullable = false, unique = true)
  private String email;

  @CreationTimestamp private LocalDate dateOfJoining;

  // Below configuration will be used to configure unidirectional OneToOne mapping here addressId
  // filed will be added into Employee table as address_id column name In Unidirectional mapping we
  // need only parent side mapping
  // @OneToOne(cascade = CascadeType.ALL)
  // @JoinColumn(name = "address_id", referencedColumnName = "addressId")

  // Below configuration will be used to bi-directional OneToOne mapping
  // In order to not to create address column in employee table we have to tell that employee
  // variable is going to mapped the mapping in Address table
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id", referencedColumnName = "addressId")
  private Address address;

  // In ManyToMany Uni-directional mapping we don't have to add anything in other relational table
  // (even we don't have to add employee reference in Roles class)
  // In Bi_Directional mapping, mapping would be same in this class but in another relational entity
  // we have to add mapping
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
      name = "EMPLOYEE_ROLE",
      joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "empId"),
      inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
  private Set<Role> roles;
}
