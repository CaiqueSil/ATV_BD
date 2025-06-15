package Routes;

import DB.DatabaseConnection;
import Tables.Servico;

import java.sql.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ServicoDAO {

    public Map<Integer, Servico> getAllServicos() throws SQLException {
        Map<Integer, Servico> servicoMap = new HashMap<>();
        String query = "SELECT * FROM Servico";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Servico servico = new Servico(
                        rs.getInt("ID_servico"),
                        rs.getString("Nome"),
                        rs.getString("Descricao"),
                        rs.getBigDecimal("preco"),
                        rs.getInt("ID_Animal"),
                        rs.getInt("ID_tipo_servico"),
                        rs.getInt("ID_Forma_Pagamento")
                );
                servicoMap.put(rs.getInt("ID_servico"), servico);
            }
        }
        return servicoMap;
    }

    public void addServico(Servico servico) throws SQLException {
        String query = "INSERT INTO Servico (Nome, Descricao, preco, ID_Animal, ID_tipo_servico, ID_Forma_Pagamento) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, servico.getNome());
            stmt.setString(2, servico.getDescricao());
            stmt.setBigDecimal(3, servico.getPreco());
            stmt.setInt(4, servico.getID_Animal());
            stmt.setInt(5, servico.getID_tipo_servico());
            stmt.setInt(6, servico.getID_Forma_Pagamento());

            stmt.executeUpdate();
        }
    }

    public Servico getServicoById(Integer id) throws SQLException {
        String query = "SELECT * FROM Servico WHERE ID_servico = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Servico(
                            rs.getInt("ID_servico"),
                            rs.getString("Nome"),
                            rs.getString("Descricao"),
                            rs.getBigDecimal("preco"),
                            rs.getInt("ID_Animal"),
                            rs.getInt("ID_tipo_servico"),
                            rs.getInt("ID_Forma_Pagamento")
                    );
                }
            }
        }
        return null;
    }

    public void deleteServico(Integer id) throws SQLException {
        String query = "DELETE FROM Servico WHERE ID_servico = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
