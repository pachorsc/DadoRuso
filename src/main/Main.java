package main;

import clases.*;
import flojerasdependency.FlojerasUtility;

public class Main extends FlojerasUtility {

    public static Objeto objetoAUsar;
    public static final int VIDAS = 9;
    
    public static void main(String[] args) {

        //Mínimo recomendado de vidas = 10
        System.out.println("Bienvenido al Juego del  DADO RUSO");
        System.out.println("Dime tu nombre");
        String nom = pedirTexto();
        Humano J1 = new Humano(nom,VIDAS);
        
        PC bot = new PC("Acolito del aguacate",VIDAS);
        
        boolean ganar = true;
        while(ganar){
            
            int turnj1 = J1.tirarDado();
            int turnbot = bot.tirarDado();
            System.out.println("Tu dado ha salido "+turnj1+" El dado del Acolito del aguacate ha slido "+turnbot);
            
            if (turnj1>turnbot) {
                
                //turno jugador
                System.out.println("Haz sacado más que el bot, tienes el turno");
                
                if (turnj1>=5 && turnj1<=6) {   
                    System.out.println("Tu dado ha sido por encima de 4 te ganas un objeto");
                    J1.aniadirObjeto(generarObjeto());
                }
                
                if (devolverNumEspaciosOcupados(J1.getInventario()) >0) {
                    J1.turno(true);
                } else J1.turno(false);
                
            } else {
                //turno bot
                if (turnj1>=5 && turnj1<=6) {    
                    bot.aniadirObjeto(generarObjeto());
                }
                
                if (devolverNumEspaciosOcupados(J1.getInventario()) >0) {
                    bot.turno(true);
                } else bot.turno(false);
                
            }
            sc.nextLine();
        }
    }
    
    public static Objeto generarObjeto(){
        Objeto o;
        int random = randomInt(1, 100);
        
        if(random >= 1 && random <= 45){
            o = new Objeto(TipoObjeto.AGUACATE);
        }else if(random >= 46 && random <= 89){
            o = new Objeto(TipoObjeto.DARDO);
        }else{
            o = new Objeto(TipoObjeto.DARDO_DORADO);
        }
        
        return o;
    }
}
