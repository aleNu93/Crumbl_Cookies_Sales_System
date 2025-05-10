
package com.mycompany.trabajofinalcrumblcookies;

import java.util.ArrayList;
import java.util.Scanner;

public class Galleta {
    private String idGalleta;
    private String nombreGalleta;
    private String saborGalleta;
    private String tamano;
    ArrayList<String> pedidoGalletas= new ArrayList<>();
    private final Scanner leer = new Scanner(System.in);
    private  Toppings top;

    public Galleta(String idGalleta, String nombreGalleta, String saborGalleta, String tamano) {
        this.idGalleta = idGalleta;
        this.nombreGalleta = nombreGalleta;
        this.saborGalleta = saborGalleta;
        this.tamano = tamano;
    }


    public String getIdGalleta() {
        return idGalleta;
    }

    public void setIdGalleta(String idGalleta) {
        this.idGalleta = idGalleta;
    }

    public String getNombreGalleta() {
        return nombreGalleta;
    }

    public void setNombreGalleta(String nombreGalleta) {
        this.nombreGalleta = nombreGalleta;
    }

    public String getSaborGalleta() {
        return saborGalleta;
    }

    public void setSaborGalleta(String saborGalleta) {
        this.saborGalleta = saborGalleta;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public ArrayList<String> getPedidoGalletas() {
        return pedidoGalletas;
    }

    public void setPedidoGalletas(ArrayList<String> pedidoGalletas) {
        this.pedidoGalletas = pedidoGalletas;
    }
    
    
    public void pedirGalleta (){
        int opcion = 0;
        while (true) {
            try {
                System.out.println("Por favor elija una de las siguientes opciones:");
                System.out.println("1. Elegir un sabor predeterminado (tamaño grande)");
                System.out.println("2. Personalizar una galleta");
                System.out.println("3. Salir");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1 -> elegirSaborPredeterminado();
                    case 2 -> personalizarGalleta();
                    case 3 -> {
                        System.out.println("Volviendo al menu principal.");
                        return;
                    }
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, intente nuevamente.");
                leer.nextLine(); 
            }
        }
    }

    private void elegirSaborPredeterminado() {
        int opcion;
        while (true) {
            try {
                System.out.println("Elija uno de nuestros sabores predeterminados:");
                System.out.println("1. ChocoMax");
                System.out.println("2. El Delirio del Rey");
                System.out.println("3. La Abeja Reina");
                System.out.println("4. La Locura Mentolada");
                System.out.println("5. Volver al menú principal");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1 -> setDatosGalleta("ChocoMax", "Chocolate con trozos de chocolate blanco rellena de dulce de leche", "G", "CMG");
                    case 2 -> setDatosGalleta("El Delirio del Rey", "Mantequilla de maní, nuez y macadamia", "G", "EDDRG");
                    case 3 -> setDatosGalleta("La Abeja Reina", "Avena y miel", "G", "LARG");
                    case 4 -> setDatosGalleta("La Locura Mentolada", "Chocolate, chocolate blanco con menta, ganache de chocolate", "G", "LLMG");
                    case 5 -> {
                        return;
                    }
                    default -> System.out.println("Opción inválida. Intente nuevamente.");
                }

            top = new Toppings(this.getIdGalleta(), this.getNombreGalleta(), 0, this.getIdGalleta(), this.getNombreGalleta(), this.getSaborGalleta(), this.getTamano());
            top.agregarToppings();              
            break;
                
            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                leer.nextLine(); 
            }
        }
    }

    private void personalizarGalleta() {
        try {
            System.out.println("Elija un sabor personalizado:");
            System.out.println("1. Triple Chocolate");
            System.out.println("2. Mantequilla");
            System.out.println("3. Frutos Rojos");
            System.out.println("4. Dulce de Leche");
            System.out.println("5. Red Velvet");
            System.out.println("6. Mantequilla de Maní");
            System.out.println("7. Cheesecake");
            System.out.println("8. Limón con Almendras");
            System.out.println("9. Macadamia");
            int opcionSabor = leer.nextInt();

            String[] sabores = {"Triple Chocolate", "Mantequilla", "Frutos Rojos", "Dulce de Leche", 
                                "Red Velvet", "Mantequilla de Maní", "Cheesecake", 
                                "Limón con Almendras", "Macadamia"};
            if (opcionSabor < 1 || opcionSabor > sabores.length) {
                System.out.println("Opción inválida. Intente nuevamente.");
                return;
            }

            String saborSeleccionado = sabores[opcionSabor - 1];
            this.setSaborGalleta(saborSeleccionado);
            this.setNombreGalleta(saborSeleccionado);

            System.out.println("Elija el tamaño de la galleta:");
            System.out.println("1. Pequeño (10 cm)");
            System.out.println("2. Mediano (15 cm)");
            System.out.println("3. Grande (20 cm)");
            int opcionTamano = leer.nextInt();

            switch (opcionTamano) {
                case 1 -> this.setTamano("Pequeño");
                case 2 -> this.setTamano("Mediano");
                case 3 -> this.setTamano("Grande");
                default -> {
                    System.out.println("Opción inválida. Intente nuevamente.");
                    return;
                }
            }

            this.idGalleta = saborSeleccionado + this.tamano;
            pedidoGalletas.add(this.nombreGalleta);

            top = new Toppings(this.getIdGalleta(), this.getNombreGalleta(), 0, this.getIdGalleta(), this.getNombreGalleta(), this.getSaborGalleta(), this.getTamano());
            top.agregarToppings();    
            
        } catch (Exception e) {
            System.out.println("Entrada inválida. Por favor, intente nuevamente.");
            leer.nextLine(); 
        }
    }

    private void setDatosGalleta(String nombre, String sabor, String tamano, String id) {
        this.setNombreGalleta(nombre);
        this.setSaborGalleta(sabor);
        this.setTamano(tamano);
        this.setIdGalleta(id);
        pedidoGalletas.add(nombre);
    }
}