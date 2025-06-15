package Routes;

import DB.DatabaseConnection;
import Tables.Cliente;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
public class ClienteDAO {
    public Map<Integer, Cliente> getAllClientes() throws SQLException{
        Map<Integer, Cliente> clienteMap = new HashMap<>();
        String query = "SELECT * FROM Cliente";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)){

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("ID_CLiente"),
                        rs.getString("Nome"),
                        rs.getString("Rua"),
                        rs.getString("Estado"),
                        rs.getInt("CEP"),
                        rs.getString("CPF")

                );
                clienteMap.put(rs.getInt("ID_Cliente"), cliente);
            }
        }
        return clienteMap;
    }
    public void addCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO Cliente (Nome, Rua, Estado, CEP, CPf) VALUES (?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getRua());
            stmt.setString(3, cliente.getEstado());
            stmt.setInt(4, cliente.getCEP());
            stmt.setString(5, cliente.getCPF());

            stmt.executeUpdate();
        }
    }

    public Cliente getClienteById(Integer id) throws SQLException {
        String query = "SELECT * FROM Cliente WHERE ID_Cliente = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getInt("ID_CLiente"),
                            rs.getString("Nome"),
                            rs.getString("Rua"),
                            rs.getString("Estado"),
                            rs.getInt("CEP"),
                            rs.getString("CPF")
                    );
                }
            }
        }
        return null;

    }

    public void deleteCliente(Integer id) throws SQLException{
        String query = "DELETE FROM Cliente WHERE ID_Cliente = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
