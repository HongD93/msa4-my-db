package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private final String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"; // MySQL JDBC Driver
    private final String DB_HOST = "localhost"; // DB 호스트
    private final String DB_PORT = "3306"; // DB 포트
    private final String DB_NAME = "dbsample"; // DB명
    private final String DB_USER = "root"; // DB 계정
    private final String DB_PW = "msa505"; // DB 비밀번호
    private final String DB_URL = String.format("jdbc:mysql://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME);

    public Connection getConn() throws SQLException, ClassNotFoundException {
        // MySQL 드라이버 클래스를 로딩
        Class.forName(DB_DRIVER_CLASS);

        // DB Connection 객체 생성
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
    }
}
