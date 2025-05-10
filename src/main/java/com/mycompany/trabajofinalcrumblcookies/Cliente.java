
package com.mycompany.trabajofinalcrumblcookies;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Cliente extends Persona {
    private String idCliente;
    Scanner leer = new Scanner (System.in);

    public Cliente(String nombre, String primerApellido, String segundoApellido, int cedula, String correo, int numeroTelefono) {
        super(nombre, primerApellido, segundoApellido, cedula, correo, numeroTelefono);
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    public void generarIdCliente(String nombre, int cedula) {
        String iniciales = nombre.substring(0, Math.min(3, nombre.length())).toUpperCase(); 
        this.idCliente = iniciales + cedula; 
    }
    
    public void solicitarInformacionCliente (String nombre, String primerApellido, String segundoApellido, int cedula, String correo, int numeroTelefono) {
        try {
        while (true) {
            System.out.println("Por favor ingrese los siguientes datos");
            System.out.println("Nombre: ");
            nombre = leer.next();
            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                this.setNombre(nombre);
                break;
            } else {
                System.out.println("Error: El nombre solo puede contener letras. Intente de nuevo.");
            }
        }
        while (true) {
            System.out.println("Primer Apellido: ");
            primerApellido = leer.next();
            if (primerApellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                this.setPrimerApellido(primerApellido);
                break;
            } else {
                System.out.println("Error: El apellido solo puede contener letras. Intente de nuevo.");
            }
        }
        while (true) {
            System.out.println("Segundo Apellido: ");
            segundoApellido = leer.next();
            if (segundoApellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                this.setSegundoApellido(primerApellido);
                break;
            } else {
                System.out.println("Error: El apellido solo puede contener letras. Intente de nuevo.");
            }
        }
        while (true) {
            System.out.print("Cedula: ");
            try {
                cedula=leer.nextInt();
                this.setCedula(cedula);
                leer.nextLine();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido para la cedula.");
                leer.nextLine(); 
            }
        }
        while (true) {
            System.out.println("Correo: ");
            correo = leer.nextLine();
            if (correo.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                this.setCorreo(correo);
                break;
            } else {
                System.out.println("Error: El correo debe tener un formato valido.");
            }
        }
        
        while (true) {
            System.out.println("Numero de Telefono");
            try {
                numeroTelefono: leer.nextInt();
                this.setNumeroTelefono(numeroTelefono);
                leer.nextLine();
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido para el telefono.");
                leer.nextLine(); 
            }
        }

            generarIdCliente(this.getNombre(), this.getCedula());
            System.out.println("\nDatos ingresados correctamente. Los datos son los siguientes:");
            System.out.println("Nombre: " + this.getNombre());
            System.out.println("Primer apellido: " + this.getPrimerApellido());
            System.out.println("Segundo apellido: " + this.getSegundoApellido());
            System.out.println("Cédula: " + this.getCedula());
            System.out.println("Correo: " + this.getCorreo());
            System.out.println("Número de teléfono: " + this.getNumeroTelefono());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
    }
}
}
