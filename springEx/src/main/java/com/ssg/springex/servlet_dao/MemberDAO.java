package com.ssg.springex.servlet_dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
    private Statement stmt;
    private Connection conn;

    private void ConnDB() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로딩 성공");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb?serverTimezone=Asia/Seoul&charEncoding=UTF-8", "root", "mysql1234");
            System.out.println("Connection 생성 성공");
            stmt = conn.createStatement();
            System.out.println("Statement 생성 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버가 존재하지 않습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<MemberVO> listMembers() {
        List<MemberVO> memberList = new ArrayList<MemberVO>();

        try {
            ConnDB();
            String sql = "select * from member";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("userid");
                String pwd = rs.getString("userpwd");
                String name = rs.getString("username");
                String email = rs.getString("useremail");
                Date joinDate = rs.getDate("joindate");

                MemberVO member = new MemberVO();
                member.setId(id);
                member.setPassword(pwd);
                member.setName(name);
                member.setEmail(email);
                member.setJoinDate(joinDate);
                memberList.add(member);

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return memberList;

    }
}
