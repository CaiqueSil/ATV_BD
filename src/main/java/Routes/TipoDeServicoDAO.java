package Routes;

import DB.DatabaseConnection;
import Tables.TipoDeServico;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TipoDeServicoDAO {

    public Map<Integer, TipoDeServico> getAllTipos() throws SQLException {
        Map<Integer, TipoDeServico> tipoMap = new HashMap<>();
        String query = "SELECT * FROM TipoDeServico";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                TipoDeServico tipo = new TipoDeServico(
                        rs.getInt("id_tipo"),
                        rs.getString("tipo_servico")
                );
                tipoMap.put(rs.getInt("id_tipo"), tipo);
            }
        }
        return tipoMap;
    }

    public void addTipoDeServico(TipoDeServico tipo) throws SQLException {
        String query = "INSERT INTO TipoDeServico (tipo_servico) VALUES (?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, tipo.getTipo_servico());
            stmt.executeUpdate();
        }
    }

    public TipoDeServico getTipoById(Integer id) throws SQLException {
        String query = "SELECT * FROM TipoDeServico WHERE id_tipo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TipoDeServico(
                            rs.getInt("id_tipo"),
                            rs.getString("tipo_servico")
                    );
                }
            }
        }
        return null;
    }

    public void deleteTipo(Integer id) throws SQLException {
        String query = "DELETE FROM TipoDeServico WHERE id_tipo = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
