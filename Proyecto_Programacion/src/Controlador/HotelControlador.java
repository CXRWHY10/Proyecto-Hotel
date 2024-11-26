package Controlador;
import Modelo.*;
import Vista.HotelVista;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HotelControlador {
    private HabitacionDAO habitacionDAO;
    private ReservaDAO reservaDAO;
    private ClienteDAO clienteDAO;
    private HotelVista hotelVista;

    public HotelControlador(HabitacionDAO habitacionDAO, ReservaDAO reservaDAO, ClienteDAO clienteDAO, HotelVista hotelVista) {
        this.habitacionDAO = habitacionDAO;
        this.reservaDAO = reservaDAO;
        this.clienteDAO = clienteDAO;
        this.hotelVista = hotelVista;
    }

    public void listarHabitaciones() {
        List<Habitacion> habitaciones = habitacionDAO.obtenerHabitaciones();
        hotelVista.mostrarHabitaciones(habitaciones);
    }

    public void agregarCliente() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el correo del cliente: ");
        String email = sc.nextLine();

        Cliente cliente = new Cliente(0, nombre, email);
        clienteDAO.agregarCliente(cliente);
        System.out.println("Cliente agregado con éxito.");
    }

    public void agregarReserva() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente: ");
        int clienteId = sc.nextInt();
        System.out.print("Ingrese el ID de la habitación: ");
        int habitacionId = sc.nextInt();

        Cliente cliente = new Cliente(clienteId, "", "");
        Habitacion habitacion = new Habitacion(habitacionId, "", 6000);
        reservaDAO.agregarReserva(cliente, habitacion);
        System.out.println("Reserva agregada con éxito.");
    }

    public void eliminarReserva() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID de la reserva a eliminar: ");
        int reservaId = sc.nextInt();

        int clienteId = obtenerClienteIdPorReserva(reservaId);

        reservaDAO.eliminarReserva(reservaId);
        clienteDAO.eliminarCliente(clienteId);
        System.out.println("Reserva y cliente eliminados con éxito.");
    }

    private int obtenerClienteIdPorReserva(int reservaId) {
        return 0;
    }
}

