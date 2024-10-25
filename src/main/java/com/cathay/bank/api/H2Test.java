package com.cathay.bank.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Test {
    public static void main(String[] args) {
        //String url = "jdbc:h2:~/test"; // 嵌入式模式
        String url = "jdbc:h2:tcp://localhost/~/test"; // 伺服器模式
        String user = "sa"; // 用戶名
        String password = "1234"; // 密碼

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("成功連接到 H2 資料庫！");
            }
        } catch (SQLException e) {
            System.out.println("連接失敗！");
            e.printStackTrace();
        }
    }
}
