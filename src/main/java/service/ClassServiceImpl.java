package service;

import model.Class;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassServiceImpl implements ClassService {

    protected Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1905?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Class> findAll() {
        List<Class> classes = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from class");) {
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                classes.add(new Class(id, name));
            }
        } catch (SQLException e) {
        }
        return classes;
    }

    @Override
    public void add(Class aClass) throws SQLException {

    }

    @Override
    public Class findById(int id) {
        Class clazz = new Class();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from class where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement); //in ra câu truy vấn.
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idClass = rs.getInt("id");
                String name = rs.getString("name");
                clazz = new Class(idClass, name);
            }
        } catch (SQLException e) {
        }
        return clazz;
    }

    @Override
    public boolean update(Class aClass) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

}
