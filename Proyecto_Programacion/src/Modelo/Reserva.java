package Modelo;
public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;

    public Reserva( Cliente cliente, Habitacion habitacion) {
        this.cliente = cliente;
        this.habitacion = habitacion;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }
}