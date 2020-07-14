package com.company.dao;

import com.company.connection.MysqlConnection;
import com.company.entity.Subscriber;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBSubscribersDao implements SubscribersDao {
    @Override
    public List<Subscriber> get() {
        List<Subscriber> subscribers = new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, email FROM subscribers");
            while (resultSet.next()) {
                Subscriber subscriber = new Subscriber();
                subscriber.setName(resultSet.getString("name"));
                subscriber.setEmail(resultSet.getString("email"));
                subscribers.add(subscriber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribers;
    }
}

