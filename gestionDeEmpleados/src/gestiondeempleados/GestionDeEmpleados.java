package gestiondeempleados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionDeEmpleados {

     private static void AñadirInterno(List<Object> vectorObjetos) {//nuevo empleado interno
        Scanner reader = new Scanner(System.in);
        String nombre, apellido, identificacion, telefono, cargo;
        System.out.println("Nombre: ");				//lectura del nombre
        nombre = reader.nextLine();
        System.out.println("Apellido: ");			//lectura del apellido
        apellido = reader.nextLine();
        System.out.println("Identificacion: ");		//lectura de la idetificacion
        identificacion = reader.nextLine();
        System.out.println("Telefono: ");			//lectura del telefono
        telefono = reader.nextLine();
        System.out.println("Cargo: ");				//lectura del cargo
        cargo = reader.nextLine();
        vectorObjetos.add(new interno(identificacion, nombre, apellido, telefono, cargo)); //se guardan los datos
    }

    private static void AñadirColaborador(List<Object> vectorObjetos) {//nuevo empleado colborador
        Scanner reader = new Scanner(System.in);
        String nombre, apellido, empresa;
        System.out.println("Nombre: ");			//lectura del nombre
        nombre = reader.nextLine();
        System.out.println("Apellido: ");		//lectura del apellido
        apellido = reader.nextLine();
        System.out.println("Empresa: ");		//lectura de la empresa
        empresa = reader.nextLine();
        vectorObjetos.add(new colaborador(nombre, apellido, empresa)); // se guardan los datos
    }
    
    private static void Eliminar(List<Object> vectorObjetos, String criterio){//eliminar
        for (Object obj : vectorObjetos) {
            try {
                interno persona = (interno) obj; //si el objeto es de tipo interno procede a hacer
                if (criterio == null ? persona.GetIdentificacion() == null : criterio.equals(persona.GetIdentificacion())) {
                    
                    PantallaInterno(persona);		//llamado de la funcion para imprimir en pantalla
                    vectorObjetos.remove(persona);   //metodo remove para elimnar del vector el dato
                    System.out.println("ELIMINADO"); //mensaje de confirmacion
                }
            } catch (Exception e) {
                colaborador persona = (colaborador) obj;//si el dato es tipo colaborador procede a hacer
                if ((criterio == null ? persona.GetNombre() == null : criterio.equals(persona.GetNombre())) && "Colaborador".equals(persona.GetTipo())) {
                    
                    PantallaColaborador(persona);	//llamado de la funcion para imprimir en pantalla
                    vectorObjetos.remove(persona);    //metodo remove para eliminar del vector el dato
                    System.out.println("ELIMINADO"); //mensaje de confirmacion
                }
            }
        }
        System.out.println("No se encontraron coincidencias"); //mensaje en el caso de ingresar mal el dato identificador
        
    }

    private static void PantallaInterno(interno oInterno) { //impresion en pantalla de los datos de interno
        System.out.println("Nombre: " + oInterno.GetNombre());					//dato nombre
        System.out.println("Apellido: " + oInterno.GetApellido());				//dato apellido
        System.out.println("Identificaion: " + oInterno.GetIdentificacion());	//dato indentificacion
        System.out.println("Telefono: " + oInterno.GetTelefono());				//dato telefono
        System.out.println("Cargo: " + oInterno.GetCargo());					//dato cargo
    }

    private static void PantallaColaborador(colaborador oColaborador) { //impresion en pantalla de los datos colaborador
        System.out.println("Nombre: " + oColaborador.GetNombre());				//dato nombre
        System.out.println("Apellido: " + oColaborador.GetApellido());			//dato apellido
        System.out.println("Empresa: " + oColaborador.GetEmpresa());			//dato empresa
    }

    private static boolean Busqueda(List<Object> vectorObjetos, String criterio) {//funcion busqueda
        for (Object obj : vectorObjetos) {
            try {
                interno persona = (interno) obj;
                if (criterio == null ? persona.GetIdentificacion() == null : criterio.equals(persona.GetIdentificacion())) {// Si se encuentra el dato identifiacor hacer:
                    PantallaInterno(persona); //llamado a la funcion de impresion
                    return true;
                }
            } catch (Exception e) {
                colaborador persona = (colaborador) obj;
                if ((criterio == null ? persona.GetNombre() == null : criterio.equals(persona.GetNombre())) && "Colaborador".equals(persona.GetTipo())) {// Si se encuentra el dato identifiacor hacer:
                    PantallaColaborador(persona);//llamado de la funcion de impresion
                    return true;
                }
            }
        }
        System.out.println("No se encontraron coincidencias");//en el caso que no se ingrese el dato identificador correcto
        return false;
    }

    private static void menu(List<Object> vectorObjetos) {//funcion menu
        int opc = 0;
        while (opc != 4) {//hacer hasta que sea diferente de 4
            opc = 0;
            Scanner reader = new Scanner(System.in);
            while (opc < 1 || opc > 4) {
                System.out.println("SISTEMA DE CONTROL DE EMPLEADOS"); //impresion de el menu
                System.out.println("1. - Añadir empleado.");
                System.out.println("2. - Consultar empleado.");
                System.out.println("3. - Eliminar emplado.");
                System.out.println("4. - Salir");
                opc = reader.nextInt();//lectura de la opcion
            }
            switch (opc) {
                case 1:
                    while (opc != 3) {
                        opc = 0;
                        while (opc < 1 || opc > 3) {
                            System.out.println("AÑADIR EMPLADO");//impresion del submenu
                            System.out.println("1. - Añadir empleado interno.");
                            System.out.println("2. - Añadir empleado colaborador.");
                            System.out.println("3. - Salir.");
                            opc = reader.nextInt(); //lectura de la opcion
                            reader.nextLine();
                        }
                        if (opc == 1) {//hacer segun la opcion escogida
                            AñadirInterno(vectorObjetos);
                        } else if (opc == 2) {
                            AñadirColaborador(vectorObjetos);
                        } else if (opc == 3) {
                            break;
                        }
                    }
                    break;
                case 2:
                    if (vectorObjetos.size() > 0) {
                        opc = 0;
                        OUTER:
                        while (opc != 3) {
                            while (opc < 1 || opc > 3) {
                                System.out.println("BUSCAR EMPLEADO");//impresion de submenu
                                System.out.println("1. - Buscar empleado interno.");
                                System.out.println("2. - Buscar empleado colaborador.");
                                System.out.println("3. - Salir.");
                                opc = reader.nextInt();//lectura de la opcion
                                reader.nextLine();
                            }
                            String criterio = null;
                            switch (opc) {
                                case 1://hacer segun la opcion escogida
                                    System.out.println("Ingrese el numero de idetificacion del interno: ");
                                    opc = 0;
                                    break;
                                case 2://hacer segun la opcion escogida
                                    System.out.println("Ingrese el nombre del colaborador: ");
                                    opc = 0;
                                    break;
                                case 3:
                                    opc = 3;
                                    break;
                            }
                            criterio = reader.nextLine();
                            Busqueda(vectorObjetos, criterio);//llamado de la funcion buscar

                        }
                    }else {
                    	 System.out.println("Aun no se a ingresado ningun dato. ");//en el caso que no haya datos que leer
                    }
                    break;
                case 3:
                    if (vectorObjetos.size() > 0) {
                        opc = 0;
                        
                        while (opc != 3) {
                            while (opc < 1 || opc > 3) {
                                System.out.println("ELIMINAR EMPLEADO");//impresion del menu
                                System.out.println("1. - Eliminar empleado interno.");
                                System.out.println("2. - Eliminar empleado colaborador.");
                                System.out.println("3. - Salir.");
                                opc = reader.nextInt();//lectura de la opcion
                                reader.nextLine();
                            }
                            String criterio = null;
                            switch (opc) {
                                case 1://hacer segun la opcion escogida
                                    System.out.println("Ingrese el numero de idetificacion del interno: ");
                                    opc = 0;
                                    break;
                                case 2:
                                    System.out.println("Ingrese el nombre del colaborador: ");
                                    opc = 0;
                                    break;
                                case 3:
                                    opc = 3;
                                    break;
                            }
                            criterio = reader.nextLine();
                            Eliminar(vectorObjetos, criterio);//lamado a la funcion eliminar

                        }
                    }else {
                    	System.out.println("Aun no se a ingresado ningun dato. ");//mensaje en el caso que no haya datos que leer aun
                    }
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        
        List<Object> vectorObjetos = new ArrayList();//creacion del vector de objetos
        menu(vectorObjetos);//llamado a la funcion menu
        
    }
    
}
