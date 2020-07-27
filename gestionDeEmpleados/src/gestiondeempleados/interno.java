package gestiondeempleados;

public class interno extends persona{

    private String telefono;
    private String cargo;
    private String identificacion;
    
    public interno(String identificacion, String nombre, String apellido, String telefono, String cargo) {
        SetNombre(nombre);						//llamado al set nombre
        SetApellido(apellido);					//llamdo al set apellido
        SetTipo("Interno");						//llamado al set interno
        this.identificacion = identificacion;	//asignacion de  identificador
        this.telefono = telefono;				//asignacion de telefono
        this.cargo = cargo; 					//asignacion de cargo
    }
    
    public String GetIdentificacion(){//get indentificador
        return identificacion;
    }
    
    public String GetTelefono(){//get telefono
        return telefono;
    }
    
    public String GetCargo(){//get cargo
        return cargo;
    }
    
}
