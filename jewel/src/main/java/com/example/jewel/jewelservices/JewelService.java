package com.example.jewel.jewelservices;
import java.util.List;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.example.jewel.jewelmodel.JewelType;
@Service
public class JewelService {

    private final DataSource dataSource;

    public JewelService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<JewelType> getAllTypes() {
        List<JewelType> jewelTypes = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String query = "SELECT * FROM jewel_type";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                jewelTypes.add(new JewelType(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jewelTypes;
    }

        public JewelType getJewelTypeById(int id) {
        String query = "SELECT id, name, description FROM jewel_type WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new JewelType(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // or throw an exception if not found
    
    }
}


