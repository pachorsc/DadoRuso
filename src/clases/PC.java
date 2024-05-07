package clases;

public class PC extends Jugador{
    
    public PC (String nombre, int vidas){
        super(nombre,vidas);
    }
    
    @Override
    public void turno(boolean puedeUsarObjeto){
        if(puedeUsarObjeto){
            if(devolverNumEspaciosOcupados(inventario) != 0){               
                int ale= randomInt(0, super.getInventario().length - 1);
                
                Objeto elegido = inventario[ale];
                //Elimino el objeto del inventario
                inventario[ale] = null;
                //Reordeno el array para evitar posiciones nulas desperdigadas
                defragmentarArray(inventario);
                main.Main.objetoAUsar = elegido;               
            }
        }else{
            System.out.println("El jugador " + nombre + " no tiene objetos para usar.");
        }
    }
}
