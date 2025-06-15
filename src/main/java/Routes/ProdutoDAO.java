package Routes;

import DB.DatabaseConnection;
import Tables.Produto;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ProdutoDAO {

    public Map<Integer, Produto> getAllProdutos() throws SQLException {
        Map<Integer, Produto> produtoMap = new HashMap<>();
        String query = "SELECT * FROM Produto";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("ID_Produto"),
                        rs.getString("nome"),
                        rs.getBigDecimal("preco"),
                        rs.getInt("quantidade")
                );
                produtoMap.put(produto.getID_Produto(), produto);
            }
        }
        return produtoMap;
    }

    public void addProduto(Produto produto) throws SQLException {
        String query = "INSERT INTO Produto (nome, preco, quantidade) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());

            stmt.executeUpdate();
        }
    }

    public Produto getProdutoById(Integer id) throws SQLException {
        String query = "SELECT * FROM Produto WHERE ID_Produto = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                            rs.getInt("ID_Produto"),
                            rs.getString("nome"),
                            rs.getBigDecimal("preco"),
                            rs.getInt("quantidade")
                    );
                }
            }
        }
        return null;
    }

    public void deleteProduto(Integer id) throws SQLException {
        String query = "DELETE FROM Produto WHERE ID_Produto = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
