package gestiondeempleados;

public class colaborador extends persona {//derivado de la clase persona

    private String empresa;

    public colaborador(String nombre, String apellido, String empresa) {//funcion colaborador
        SetNombre(nombre);		//llamdo al set nombre
        SetApellido(apellido);	//llamdo al set apellido
        SetTipo("Colaborador"); //llamdo al set tipo
        this.empresa = empresa;
    }

    public String GetEmpresa() {
        return empresa; //retorno de valor
    }
    
}
