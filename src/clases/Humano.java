package clases;

public class Humano extends Jugador{
    
    public Humano(String nombre, int vidas){
        super(nombre,vidas);
    }

    @Override
    public void turno(boolean puedeUsarObjeto){
        if(puedeUsarObjeto){
            if(devolverNumEspaciosOcupados(inventario) != 0){
                int opcion;
                System.out.println("Elige el objeto a usar, si no quieres usar uno introduce un '-1':");
                for (int i = 0; i < inventario.length; i++) {
                    if (inventario[i] != null) {
                        System.out.println("Objeto nº" + (i+1) + ": " + inventario[i].nombre);
                    } 
                }
                do{
                    opcion = pedirInt(false);
                    if (opcion ==-1) {
                        break;
                    }
                    
                    opcion--;
                    
                }while(opcion < 0 || opcion > inventario.length);
                
                if (opcion != -1) {
                    Objeto elegido = inventario[opcion];

                    //Elimino el objeto del inventario
                    inventario[opcion] = null;
                    //Reordeno el array para evitar posiciones nulas desperdigadas
                    defragmentarArray(inventario);
                    main.Main.objetoAUsar = elegido;  
                }
            
            }
        }else{
            System.out.println("El jugador " + nombre + " no tiene objetos para usar.");
        }
    }
}
