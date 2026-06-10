package com.example.jewel.jewelservices;

import com.example.jewel.jewelmodel.User;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.*;
import javax.sql.DataSource;
@Service
public class UserService {   // <-- class declaration here
    @Autowired
    private DataSource dataSource;
    

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    public boolean signup(User user) {
        // driver manager- register ,jdbc drivers
        //connection object - provide new session to database, information about table,provide structure
    try (Connection conn = dataSource.getConnection())  {
        System.out.println("✅ Database connected successfully!");
        System.out.println("📩 Received signup request: username = " + user.getUsername() + ", password = " + user.getPassword());

        // Check if username already exists
        String query = "SELECT * FROM users WHERE username = ?";
        //precompiled sql styatement 
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user.getUsername());
        // pointer 
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            System.out.println("⚠ Username already exists in DB: " + user.getUsername());
            return false;
        }

        // Hash the password
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println("🔑 Hashed password: " + hashedPassword);

        // Insert new user
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO users(username, password) VALUES (?, ?)"
        );
        stmt.setString(1, user.getUsername());
        stmt.setString(2, hashedPassword);

        int rows = stmt.executeUpdate();
        System.out.println("✅ Rows inserted: " + rows);

        return rows > 0;

    } catch (SQLException e) {
        System.out.println("❌ Database connection failed!");
        e.printStackTrace();
        return false;
    }
}

    public boolean signin(String username, String password) {
        try (Connection conn = dataSource.getConnection()) {
            String query = "SELECT password FROM users WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String storedHashedPassword = rs.getString("password");
            return passwordEncoder.matches(password, storedHashedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
         return false;
    }
}
