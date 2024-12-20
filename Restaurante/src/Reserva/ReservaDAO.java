package Reserva;

import Cliente.ClienteVO;
import Mesa.MesaVO;
import main.ConexaoMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements ServicoDaoReserva  {

    public void inserirReserva(ReservaVO reserva) {
        String sql = "INSERT INTO Reserva (cliente_id, mesa_id, data) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reserva.getCliente().getId());
            stmt.setInt(2, reserva.getMesa().getnumMesa());
            stmt.setDate(3, Date.valueOf(reserva.getData()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ReservaVO> listarReservas() {
        List<ReservaVO> reservas = new ArrayList<>();
        String sql = "SELECT * FROM Reserva";
        try (Connection conn = ConexaoMysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Aqui você precisará buscar os objetos Cliente e Mesa via DAO.
                reservas.add(new ReservaVO(
                        rs.getInt("id"),
                        null, // Buscar cliente
                        null, // Buscar mesa
                        rs.getDate("data").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }
}
