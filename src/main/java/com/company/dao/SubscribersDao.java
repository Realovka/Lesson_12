package com.company.dao;

import com.company.connection.MysqlConnection;
import com.company.entity.Subscriber;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public interface SubscribersDao {
    List<Subscriber> get();

}
