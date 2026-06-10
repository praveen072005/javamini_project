package com.example.jewel.jewelservices;

import com.example.jewel.jewelmodel.Category;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final DataSource dataSource;

    // Inject DataSource via constructor
    public CategoryService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Category> getCategoriesByJewelType(int jewel_type_id) {
    List<Category> categories = new ArrayList<>();
    try (Connection conn = dataSource.getConnection()) {
        String query = "SELECT * FROM category WHERE jewel_type_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, jewel_type_id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            categories.add(new Category(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("jewel_type_id")
            ));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return categories;

    

}



}
