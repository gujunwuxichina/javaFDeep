package com.gujun.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

}
