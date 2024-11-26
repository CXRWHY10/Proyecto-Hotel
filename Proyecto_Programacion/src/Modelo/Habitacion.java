package Modelo;

public class Habitacion {
    private int id;
    private String tipo;
    private double precio;

    public Habitacion(int id, String tipo, double precio) {
        this.id = id;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
}