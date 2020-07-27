
package gestiondeempleados;

/**
 *
 * @author denny
 */
public class persona {

    private String nombre;
    private String apellido;
    private String tipo;

    public String GetNombre() { //get nombre
        return nombre;
    }

    public void SetNombre(String nombre) {//set nombre
        this.nombre = nombre;
    }

    public String GetApellido() { //get apellido
        return apellido;
    }

    public void SetApellido(String apellido) {//set apellido
        this.apellido = apellido;
    }

    public String GetTipo() { //get tipo
        return tipo;
    }

    public void SetTipo(String tipo) {//set tipo
        this.tipo = tipo;
    }
    
}
