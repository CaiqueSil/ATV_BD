package Routes;

import DB.DatabaseConnection;
import Tables.Compra;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

public class CompraDAO {

    public Map<Integer, Compra> getAllCompras() throws SQLException {
        Map<Integer, Compra> compraMap = new HashMap<>();
        String query = "SELECT * FROM Compra";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Compra compra = new Compra(
                        rs.getInt("ID_Compra"),
                        rs.getDate("Data_Compra").toLocalDate(),
                        rs.getBigDecimal("valor"),
                        rs.getInt("ID_Cliente")
                );
                compraMap.put(rs.getInt("ID_Compra"), compra);
            }
        }
        return compraMap;
    }

    public void addCompra(Compra compra) throws SQLException {
        String query = "INSERT INTO Compra (Data_Compra, valor, ID_Cliente) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDate(1, Date.valueOf(compra.getData_Compra()));
            stmt.setBigDecimal(2, compra.getValor());
            stmt.setInt(3, compra.getID_Cliente());

            stmt.executeUpdate();
        }
    }

    public Compra getCompraById(Integer id) throws SQLException {
        String query = "SELECT * FROM Compra WHERE ID_Compra = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Compra(
                            rs.getInt("ID_Compra"),
                            rs.getDate("Data_Compra").toLocalDate(),
                            rs.getBigDecimal("valor"),
                            rs.getInt("ID_Cliente")
                    );
                }
            }
        }
        return null;
    }

    public void deleteCompra(Integer id) throws SQLException {
        String query = "DELETE FROM Compra WHERE ID_Compra = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
