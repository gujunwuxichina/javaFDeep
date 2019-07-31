package com.gujun.jdbc;

import org.junit.Test;

import java.sql.*;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/29 20:27
 * @Version 1.0
 **/
public class Test01 {

    //JDBC API
    //DriverManager，用于管理JDBC驱动的服务类，用来获取Connection对象；getConnection(...)
    //Connection数据库连接对象，代表一个物理连接会话：
        //createStatement()；prepareStatement(sql)返回预编译的Statement对象;
        //prepareCall(sql)返回CallableStatement对象，用于调用存储过程；
        //Savepoint setSavepoint([name])创建一个保存点；
        //setTransactionIsolation(int)，设置事务隔离级别；
        //rollback([Savepoint])，回滚事务或回滚到指定保存点；
        //setAutoCommit(boolean)，关闭自动提交即打开事务；
        //commit()提交事务；
        //等
    //ResultSet，结果集对象，包含访问查询结果的方法，通过列索引或列名获得列数据；

    @Test
    public void test01() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try
        (
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01","root","gujun");
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from person_tab");
        )
        {
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+"-"+resultSet.getString(2)+"-"+resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //使用PreparedStatement执行sql语句：
    //它是Statement的子接口，可以预编译sql语句，预编译后的sql语句存储在PreparedStatement中；
    @Test
    public void test02() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try
        (
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01","root","gujun");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into person_tab (name,age) values(?,?)");
        )
        {
            //如果知道sql中的类型，可以调用相应的setXXX()，不知道的话就调用setObject(),由PreparedStatement负责类型转换；
            preparedStatement.setString(1,"zhang");
            preparedStatement.setInt(2,25);
            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //使用CallableStatement调用存储过程：
    @Test
    public void test03() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try
        (
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test01","root","gujun");
            CallableStatement callableStatement=connection.prepareCall("call add_pro(?,?,?)");
        ) {
            callableStatement.setInt(1,20);
            callableStatement.setInt(2,2);
            callableStatement.registerOutParameter(3,Types.INTEGER);
            callableStatement.execute();
            System.out.println("存储过程结果:"+callableStatement.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
