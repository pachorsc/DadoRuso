package clases;

public abstract class Jugador {
    protected String nombre;
    protected Objeto[] inventario;
    protected int vidas;
    
    public Jugador(String nombre, int vidas){
        this.nombre = nombre;
        this.vidas = vidas;
    }
}
