package clases;

import flojerasdependency.FlojerasUtility;

public abstract class Jugador extends FlojerasUtility{
    //Atributos
    protected String nombre;
    protected Objeto[] inventario;
    protected int vidas;
    
    //Constructores
    public Jugador(String nombre, int vidas){
        this.nombre = nombre;
        this.vidas = vidas;
        this.inventario = new Objeto[4];
    }

    //Métodos
    public int tirarDado(){
        return randomInt(1, 6);
    }
    
    public void aniadirObjeto(Objeto o){
        if(devolverNumEspaciosOcupados(inventario) != inventario.length){
            for(int i = 0; i < inventario.length; i++){
                if(inventario[i] == null){
                    inventario[i] = o;
                    break;
                }
            }
        }else{
            System.out.println(">El jugador " + nombre + " no puede recibir más objetos.");
        }
    }
    
    public void aumentarVida(){
        vidas++;
    }
    
    public void dsiminuirVida(){
        vidas--;
    }
    
    public abstract void turno(boolean puedeUsarObjeto);

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Objeto[] getInventario() {
        return inventario;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }
}
