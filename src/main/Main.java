package main;

import clases.*;
import flojerasdependency.FlojerasUtility;

public class Main extends FlojerasUtility {

    public static Objeto objetoAUsar;
    
    public static void main(String[] args) {
        //Mínimo recomendado de vidas = 10
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
