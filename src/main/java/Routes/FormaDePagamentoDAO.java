package Routes;

import DB.DatabaseConnection;
import Tables.FormaDePagamento;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class FormaDePagamentoDAO {

    public Map<Integer, FormaDePagamento> getAllFormas() throws SQLException {
        Map<Integer, FormaDePagamento> pagamentoMap = new HashMap<>();
        String query = "SELECT * FROM FormaDePagamento";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                FormaDePagamento forma = new FormaDePagamento(
                        rs.getInt("ID_Pagamento"),
                        rs.getString("forma_pagamento")
                );
                pagamentoMap.put(rs.getInt("ID_Pagamento"), forma);
            }
        }
        return pagamentoMap;
    }

    public void addFormaDePagamento(FormaDePagamento forma) throws SQLException {
        String query = "INSERT INTO FormaDePagamento (forma_pagamento) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, forma.getForma_pagamento());
            stmt.executeUpdate();
        }
    }

    public FormaDePagamento getFormaById(Integer id) throws SQLException {
        String query = "SELECT * FROM FormaDePagamento WHERE ID_Pagamento = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new FormaDePagamento(
                            rs.getInt("ID_Pagamento"),
                            rs.getString("forma_pagamento")
                    );
                }
            }
        }
        return null;
    }

    public void deleteForma(Integer id) throws SQLException {
        String query = "DELETE FROM FormaDePagamento WHERE ID_Pagamento = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
