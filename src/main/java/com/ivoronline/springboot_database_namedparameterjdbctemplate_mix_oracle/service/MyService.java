package com.ivoronline.springboot_database_namedparameterjdbctemplate_mix_oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  //=========================================================================================================
  // PREPARED STATEMENT
  //=========================================================================================================
  public int preparedStatement(String name, Integer age) {

    //CREATE SQL
    String sql = " BEGIN                                                           "+
                 "   INSERT INTO PERSON (NAME, AGE) VALUES (:name, :age);          "+
                 "   UPDATE      PERSON SET NAME = 'John new' WHERE name = 'John'; "+
                 " END;                                                            ";

    //EXECUTE SQL
    SqlParameterSource parameters = new MapSqlParameterSource()
      .addValue("name", name)
      .addValue("age" , age );

    return namedParameterJdbcTemplate.update(sql, parameters);

  }

  //=========================================================================================================
  // CONCATENATE
  //=========================================================================================================
  public int concatenate(String name, Integer age) {

    //CREATE SQL
    String sql = " BEGIN                                                           "+
                 "   INSERT INTO PERSON (NAME, AGE) VALUES ('"+name+"', "+age+");  "+
                 "   UPDATE      PERSON SET NAME = 'John new' WHERE name = 'John'; "+
                 " END;                                                            ";

    //EXECUTE SQL
    return namedParameterJdbcTemplate.update(sql, new HashMap<>());

  }

}
