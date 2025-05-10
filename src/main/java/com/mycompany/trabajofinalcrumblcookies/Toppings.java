
package com.mycompany.trabajofinalcrumblcookies;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Toppings extends Galleta {
    private String idTopping;
    private String nombreTopping;
    private int cantidadTopping;
    ArrayList<String> pedidoToppings= new ArrayList<>();
    private Scanner leer = new Scanner(System.in);


    public Toppings(String idTopping, String nombreTopping, int cantidadTopping, String idGalleta, String nombreGalleta, String saborGalleta, String tamano) {
        super(idGalleta, nombreGalleta, saborGalleta, tamano);
        this.idTopping = idTopping;
        this.nombreTopping = nombreTopping;
        this.cantidadTopping = cantidadTopping;
    }

    public String getIdTopping() {
        return idTopping;
    }

    public void setIdTopping(String idTopping) {
        this.idTopping = idTopping;
    }

    public String getNombreTopping() {
        return nombreTopping;
    }

    public void setNombreTopping(String nombreTopping) {
        this.nombreTopping = nombreTopping;
    }

    public int getCantidadTopping() {
        return cantidadTopping;
    }

    public void setCantidadTopping(int cantidadTopping) {
        this.cantidadTopping = cantidadTopping;
    }

    public Scanner getLeer() {
        return leer;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

    public ArrayList<String> getPedidoToppings() {
        return pedidoToppings;
    }

    public void setPedidoToppings(ArrayList<String> pedidoToppings) {
        this.pedidoToppings = pedidoToppings;
    }
    
    
public void agregarToppings() {
        System.out.println("¿Desea agregar un topping? (S/N)");
        String eleccionTopping = leer.next();
        while (!eleccionTopping.equalsIgnoreCase("N")) {
            if (!eleccionTopping.equalsIgnoreCase("S")) {
            System.out.println("Por favor, ingrese una opción válida (S/N):");
            eleccionTopping = leer.next();
            continue;
        }
            try{
                System.out.println("Por favor elija uno de los siguientes toppings:");
                System.out.println("1. Almendras");
                System.out.println("2. Macadamia");
                System.out.println("3. Maní");
                System.out.println("4. Gomitas");
                System.out.println("5. Chispas de Chocolate Blanco");
                System.out.println("6. Chispas de Chocolate Negro");
                System.out.println("7. Leche Condensada");
                System.out.println("8. Dulce de Leche");
                System.out.println("9. Marshmallows");
                System.out.println("10. Mantequilla de Maní");
                
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1 -> this.setNombreTopping("Almendras");
                    case 2 -> this.setNombreTopping("Macadamia");
                    case 3 -> this.setNombreTopping("Maní");
                    case 4 -> this.setNombreTopping("Gomitas");
                    case 5 -> this.setNombreTopping("Chispas de Chocolate Blanco");
                    case 6 -> this.setNombreTopping("Chispas de Chocolate Negro");
                    case 7 -> this.setNombreTopping("Leche Condensada");
                    case 8 -> this.setNombreTopping("Dulce de Leche");
                    case 9 -> this.setNombreTopping("Marshmallows");
                    case 10 -> this.setNombreTopping("Mantequilla de Maní");
                    default -> {
                        System.out.println("Opción inválida, por favor intente nuevamente.");
                        continue; 
                    }
                }
            cantidadTopping++;
            this.setCantidadTopping(cantidadTopping);
            String idTopping = this.getNombreTopping() + cantidadTopping;
            pedidoToppings.add(idTopping);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
            leer.nextLine();
            
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }

        System.out.println("¿Desea agregar otro topping? (S/N)");
        eleccionTopping = leer.next();
    }
    System.out.println("Toppings seleccionados: " + String.join(", ", pedidoToppings));
}
}

