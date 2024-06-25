package com.ivoronline.springboot_database_namedparameterjdbctemplate_mix_oracle.controllers;

import com.ivoronline.springboot_database_namedparameterjdbctemplate_mix_oracle.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired private MyService myService;

  //=========================================================================================================
  // PREPARED STATEMENT
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/preparedStatement")
  public int preparedStatement() {
    int    success = myService.preparedStatement("Jill", 40);
    return success;
  }

  //=========================================================================================================
  // CONCATENATE
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/concatenate")
  public int concatenate() {
    int    success = myService.concatenate("Jill", 40);
    return success;
  }

}

