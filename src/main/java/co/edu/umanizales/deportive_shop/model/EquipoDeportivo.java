package co.edu.umanizales.deportive_shop.model;

public class EquipoDeportivo extends ProductoDeportivo {

    private String tipo;
    private double peso;

    
    public EquipoDeportivo(String nombre, double precio, String tipo, double peso) {
        super(nombre, precio);
        this.tipo = tipo;
        this.peso = peso;
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
    

