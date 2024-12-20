package Cliente;

import main.ConexaoMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements ServicoDaoCliente {

    public void inserirCliente(ClienteVO cliente) {
        String sql = "INSERT INTO Cliente (nome, telefone, email) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ClienteVO> listarClientes() {
        List<ClienteVO> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientes.add(new ClienteVO(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void removerCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ClienteVO buscarClientePorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE id = ?";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ClienteVO(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
