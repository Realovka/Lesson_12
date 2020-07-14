package com.company.dao;

import com.company.connection.MysqlConnection;
import com.company.entity.Car;
import com.company.exception.DuplicateCarException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBCarDao implements CarDao {
    public void add(Car car) throws DuplicateCarException {
        try(Connection connection=MysqlConnection.getConnection()){
            String sql="INSERT INTO cars (name, price) VALUES(?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getPrice());
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public List<Car> get() {
        List<Car> cars=new ArrayList<>();
        try(Connection connection= MysqlConnection.getConnection()){
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM cars");
            while (resultSet.next()){
                Car car=new Car();
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("name"));
                car.setPrice(resultSet.getInt("price"));
                cars.add(car);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return cars;
    }

    public void remove(Car car) {
        try(Connection connection=MysqlConnection.getConnection()){
            String sql="DELETE FROM cars WHERE id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, car.getId());
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void update(Car car) {
        try(Connection connection=MysqlConnection.getConnection()){
            String sql="UPDATE cars SET name =?, price=? WHERE id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setInt(2, car.getPrice());
            preparedStatement.setInt(3,car.getId());
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
