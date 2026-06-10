package com.example.jewel.jewelservices;

import com.example.jewel.jewelmodel.Product;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final DataSource dataSource;

    public ProductService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getProductsByCategory(int category_id) {
        List<Product> products = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String query = "SELECT * FROM product WHERE category_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, category_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getInt("category_id"),
                        rs.getString("name"),
                        rs.getString("model_number"),
                        rs.getString("image_url")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int id){
        try(Connection conn = dataSource.getConnection()){
            String query = "select * from product where id =?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return new Product(
                    rs.getInt( "id"),
                    rs.getInt("category_id"),
                    rs.getString("name"),
                    rs.getString("model_number"),
                    rs.getString("image_url")
                );
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
