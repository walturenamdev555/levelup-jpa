package com.app.myorg.controller;

import com.app.myorg.entity.Employee;
import com.app.myorg.entity.User;
import com.app.myorg.service.EmployeeService;
import com.app.myorg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myorg")
public class OrgController {

  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private UserService userService;

  @PostMapping("/employee/save")
  public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
    return ResponseEntity.ok().body(employeeService.saveEmployee(employee));
  }

  @PostMapping("/user/save")
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    return ResponseEntity.ok().body(userService.saveUser(user));
  }

  @GetMapping("/getStatus")
  public ResponseEntity<String> getStatus() {
    return ResponseEntity.ok().body("Organization is running actively");
  }
}
