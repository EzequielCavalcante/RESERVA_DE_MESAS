package Mesa;

import main.ConexaoMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MesaDAO implements ServicoDaoMesa {

    public void inserirMesa(MesaVO mesa) {
        String sql = "INSERT INTO Mesa (numero, capacidade) VALUES (?, ?)";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mesa.getnumMesa());
            stmt.setInt(2, mesa.getCapazMesa());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MesaVO> listarMesas() {
        List<MesaVO> mesas = new ArrayList<>();
        String sql = "SELECT * FROM Mesa";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                mesas.add(new MesaVO(rs.getInt("numero"), rs.getInt("capacidade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesas;
    }

    public void removerMesa(int id) {
        String sql = "DELETE FROM Mesa WHERE id = ?";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MesaVO buscarMesaPorId(int id) {
        String sql = "SELECT * FROM Mesa WHERE id = ?";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new MesaVO(rs.getInt("numero"), rs.getInt("capacidade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
