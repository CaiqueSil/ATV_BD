package Routes;

import DB.DatabaseConnection;
import Tables.Animal;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AnimalDAO {
    public Map<Integer,Animal> getAllAnimals() throws SQLException {
        Map<Integer,Animal> animalMap = new HashMap<>();
        String query = "SELECT * FROM Animal";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Animal animal = new Animal(
                        Math.toIntExact(rs.getLong("ID_Animal")),
                        rs.getString("Nome"),
                        Math.toIntExact(rs.getLong("ID_cliente")),
                        Math.toIntExact(rs.getLong("ID_Especie")),
                        Math.toIntExact(rs.getLong("ID_Raca"))
                );
                animalMap.put(Math.toIntExact(rs.getLong("ID_Animal")),animal);
            }
        }
        return animalMap;
    }

    public void addAnimal(Animal animal) throws SQLException {
        String query = "INSERT INTO Animal (Nome, ID_cliente, ID_Especie, ID_Raca) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, animal.getNome());
            stmt.setLong(2, animal.getID_cliente());
            stmt.setLong(3, animal.getID_Especie());
            stmt.setLong(4, animal.getID_Raca());

            stmt.executeUpdate();
        }
    }

    public Animal getAnimalById(Integer id) throws SQLException {
        String query = "SELECT * FROM Animal WHERE ID_Animal = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Animal(
                            Math.toIntExact(rs.getLong("ID_Animal")),
                            rs.getString("Nome"),
                            Math.toIntExact(rs.getLong("ID_cliente")),
                            Math.toIntExact(rs.getLong("ID_Especie")),
                            Math.toIntExact(rs.getLong("ID_Raca"))
                    );
                }
            }
        }
        return null;
    }

    public void deleteAnimal(Long id) throws SQLException {
        String query = "DELETE FROM Animal WHERE ID_Animal = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
