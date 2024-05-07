
package clases;


public class PC extends Jugador{
    
    public PC (String nombre, int vidas){
        super(nombre,vidas);
    }
    
    public void turno(boolean puedeUsarObjeto){
        if(puedeUsarObjeto){
            if(devolverNumEspaciosOcupados(inventario) != 0){               
                int ale=(int)Math.random()*3;
                
                for (int i = 0; i < inventario.length; i++) {
                    System.out.println("Objeto nº" + (i+1) + ": " + inventario[i]);
                }
                do{
                    ale = pedirInt(false);
                    ale--;
                }while(ale < 0 || ale > inventario.length);
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
