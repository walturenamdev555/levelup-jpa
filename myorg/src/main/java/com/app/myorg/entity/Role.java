package com.app.myorg.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "ROLE")
@Data
public class Role {
  @GeneratedValue @Id private Integer roleId;
  private String roleName;
  private boolean isActive;

  // This is required in Bi-Directional mapping only other-wise no need to add employees in this
  // class
  @ManyToMany(
      cascade = {CascadeType.ALL, CascadeType.PERSIST},
      fetch = FetchType.EAGER,
      mappedBy = "roles")
  private Set<Employee> employee;
}
