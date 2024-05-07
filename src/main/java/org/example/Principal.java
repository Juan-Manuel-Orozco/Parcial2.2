package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {
    public static void main(String[] args) throws IOException {
        MaletinCRUD maletinCRUD = new MaletinCRUD("maletines.dat");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Por favor, selecciona una opción:");
            System.out.println("1. Insertar un nuevo maletín");
            System.out.println("2. Eliminar un maletín");
            System.out.println("3. Actualizar un maletín");
            System.out.println("4. Consultar un maletín");
            System.out.println("5. Salir");

            String opcion = reader.readLine();

            switch (opcion) {
                case "1":
                    System.out.println("Introduce el ID del maletín:");
                    String id = reader.readLine();
                    System.out.println("Introduce el tipo del maletín:");
                    String tipo = reader.readLine();
                    maletinCRUD.insertar(new Maletin(id, tipo));
                    break;
                case "2":
                    System.out.println("Introduce el ID del maletín a eliminar:");
                    id = reader.readLine();
                    maletinCRUD.eliminar(id);
                    break;
                case "3":
                    System.out.println("Introduce el ID del maletín a actualizar:");
                    id = reader.readLine();
                    System.out.println("Introduce el nuevo tipo del maletín:");
                    tipo = reader.readLine();
                    maletinCRUD.actualizar(new Maletin(id, tipo));
                    break;
                case "4":
                    System.out.println("Introduce el ID del maletín a consultar:");
                    id = reader.readLine();
                    Maletin maletin = maletinCRUD.consultar(id);
                    if (maletin != null) {
                        System.out.println("Tipo del maletín: " + maletin.getTipo());
                    } else {
                        System.out.println("No se encontró el maletín con el ID proporcionado.");
                    }
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
}
