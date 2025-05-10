package com.mycompany.trabajofinalcrumblcookies;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TrabajoFinalCrumblCookies {

    public static void main(String[] args) {
        Cliente cli = new Cliente ("","","",0,"",0);
        Galleta gal= new Galleta ("","","","");
        Toppings top = new Toppings ("","",0,"","","","");
        Pedido ped = new Pedido ();
        Factura fac = new Factura ();
        Scanner leer = new Scanner (System.in);

        mostrarBienvenida();
        
        int opcion = 0;
        do {
            leer.nextLine();
            System.out.println("\n**************************************");
            System.out.println("             Menú de Opciones         ");
            System.out.println("**************************************");
            System.out.println("1. Datos del Cliente");
            System.out.println("2. Elegir Galletas");
            System.out.println("3. Agregar Toppings");
            System.out.println("4. Ver Pedido");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = leer.nextInt();
                leer.nextLine();
                switch (opcion) {
                    case 1 -> cli.solicitarInformacionCliente("", "", "", 0, "", 0);
                    case 2 -> gal.pedirGalleta();
                    case 3 -> top.agregarToppings();
                    case 4 -> {
                        System.out.println("\nResumen del Pedido:");
                        System.out.println(ped.toString()); 
                    }
                    case 5 -> {
                        System.out.println("Saliendo del sistema...");
                        leer.nextLine();
                        mostrarDespedida();

                    }
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        } while (opcion != 5);
    }

    public static void mostrarBienvenida() {
        System.out.println("**************************************");
        System.out.println("      Bienvenido a Crumbl Cookies     ");
        System.out.println("Para nosotros es un placer atenderle");
        System.out.println("**************************************");
        System.out.println("Presione enter para continuar");
    }

    public static void mostrarDespedida() {
        System.out.println("**************************************");
        System.out.println("Gracias por visitar Crumbl Cookies!");
        System.out.println("Esperamos que haya disfrutado nuestras galletas.");
        System.out.println("¡Vuelva pronto para endulzar su día con más delicias!");
        System.out.println("**************************************");
    }
}