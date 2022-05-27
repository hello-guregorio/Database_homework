package com.demodatabase.utils;

import java.sql.*;

public class DbUtil {
    private static final String URL="jdbc:mysql://43.155.118.242:3306/GameDatabase";
    private static final String USER="root";
    private static final String PASSWORD="";

    private static final Connection connection;
    private static final Statement statement;

    static {
        try {
            connection=DriverManager.getConnection(URL,USER,PASSWORD);
            statement=connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Statement getStatement() {
        return statement;
    }
    public static Connection getConnection(){
        return connection;
    }

    public static void close() throws SQLException {
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }
    }
    public static void main(String[] args) {
    }
}
