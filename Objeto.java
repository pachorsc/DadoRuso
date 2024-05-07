package clases;

public class Objeto {
    protected TipoObjeto nombre;

    public Objeto(TipoObjeto nombre) {
        this.nombre = nombre;
    }

    public TipoObjeto getNombre() {
        return nombre;
    }

    public void setNombre(TipoObjeto nombre) {
        this.nombre = nombre;
    }
    
    
}
