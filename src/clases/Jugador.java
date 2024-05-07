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
            System.out.println("El jugador " + nombre + " no puede recibir más objetos.");
        }
    }
    
    public void turno(boolean puedeUsarObjeto){
        if(puedeUsarObjeto){
            if(devolverNumEspaciosOcupados(inventario) != 0){
                int opcion;
                System.out.println("Elige el objeto a usar:");
                for (int i = 0; i < inventario.length; i++) {
                    System.out.println("Objeto nº" + (i+1) + ": " + inventario[i]);
                }
                do{
                    opcion = pedirInt(false);
                    opcion--;
                }while(opcion < 0 || opcion > inventario.length);
                Objeto elegido = inventario[opcion];
                //Elimino el objeto del inventario
                inventario[opcion] = null;
                //Reordeno el array para evitar posiciones nulas desperdigadas
                defragmentarArray(inventario);
                main.Main.objetoAUsar = elegido;
            }
        }else{
            System.out.println("El jugador " + nombre + " no tiene objetos para usar.");
        }
    }
    
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
