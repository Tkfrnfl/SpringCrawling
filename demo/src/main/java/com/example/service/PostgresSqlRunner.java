package com.example.service;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component
/*
public class PostgresSqlRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println(dataSource.getClass());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE students(name VARCHAR(255), email VARCHAR(255), PRIMARY KEY (email),graduation INTEGER, degree VARCHAR(255))";
            statement.executeUpdate(sql);
*/
/* sql += "select * from t_product";
            statement.executeUpdate(sql);

        }*//*

            //jdbcTemplate.execute("INSERT INTO t_product VALUES (1, 'Big shirt')");
        }
    }
}*/
