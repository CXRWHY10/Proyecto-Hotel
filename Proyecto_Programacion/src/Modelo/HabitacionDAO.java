package Modelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class HabitacionDAO {
    private Connection conexion;
    public HabitacionDAO(Connection conexion) {
        this.conexion = conexion;
    }
    public List<Habitacion> obtenerHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();
        String sql = "SELECT idhabitacion, tipo, precio FROM habitaciones";
        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("idhabitacion");
                String tipo = resultSet.getString("tipo");
                double precio = resultSet.getDouble("Precio");
                Habitacion habitacion = new Habitacion(id, tipo, precio);
                habitaciones.add(habitacion);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener las habitaciones: " + e.getMessage(), e);
        }
        return habitaciones;
    }
}