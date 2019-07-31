package com.gujun.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/31 21:29
 * @Version 1.0
 **/
public class Test02 {

    //事务处理：
    //JDBC的事务支持;
    //connection.setAutoCommit(false)来关闭自动提交，开启事务；
    @Test
    public void test01() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try
        (
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01","root","gujun");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into person_tab (name,age) values(?,?)");
        ) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1,"li");
            preparedStatement.setInt(2,28);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
