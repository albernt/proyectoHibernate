package org.example.Jdbc;

import DAO.AnimalDAOImpl;
import entities.Animal;
import entities.Familia;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalDAOImpl animalDAO = new AnimalDAOImpl();


        while (true) {
            System.out.println("---- Menú del Refugio de Animales ----");
            System.out.println("1. Registrar Animal");
            System.out.println("2. Buscar Animales por Especie");
            System.out.println("3. Ver Todos los Animales");
            System.out.println("4. Actualizar Animal");
            System.out.println("5. Eliminar Animal");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:

                    Animal animal = new Animal();
                    System.out.print("Ingrese el nombre del animal: ");
                    animal.setNombre(scanner.nextLine());
                    System.out.print("Ingrese la especie del animal: ");
                    animal.setEspecie(scanner.nextLine());
                    System.out.print("Ingrese la edad del animal: ");
                    animal.setEdad(scanner.nextInt());
                    scanner.nextLine();  // Consumir la línea nueva
                    System.out.print("Descripción de cómo se perdió: ");
                    animal.setDescripcion(scanner.nextLine());

                    animalDAO.save(animal);
                    System.out.println("Animal registrado con éxito.");
                    break;

                case 2:

                    System.out.print("Ingrese la especie del animal: ");
                    String especie = scanner.nextLine();
                    List<Animal> animalsByEspecie = animalDAO.findByEspecie(especie);

                    if (animalsByEspecie.isEmpty()) {
                        System.out.println("No se encontraron animales con esa especie.");
                    } else {
                        System.out.println("Animales encontrados:");
                        for (Animal a : animalsByEspecie) {
                            System.out.println("ID: " + a.getId() + ", Nombre: " + a.getNombre());
                        }
                    }
                    break;

                case 3:

                    List<Animal> allAnimals = animalDAO.findAll();
                    if (allAnimals.isEmpty()) {
                        System.out.println("No hay animales registrados.");
                    } else {
                        System.out.println("Lista de todos los animales:");
                        for (Animal a : allAnimals) {
                            System.out.println("ID: " + a.getId() + ", Nombre: " + a.getNombre() + ", Especie: " + a.getEspecie());
                        }
                    }
                    break;

                case 4:

                    System.out.print("Ingrese el ID del animal a actualizar: ");
                    Long animalId = scanner.nextLong();
                    scanner.nextLine();

                    Animal animalToUpdate = animalDAO.findById(animalId);
                    if (animalToUpdate != null) {
                        System.out.println("Animal encontrado: " + animalToUpdate.getNombre());
                        System.out.print("Ingrese el nuevo nombre del animal (dejar vacío para no cambiar): ");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) {
                            animalToUpdate.setNombre(newName);
                        }

                        System.out.print("Ingrese la nueva especie del animal (dejar vacío para no cambiar): ");
                        String newEspecie = scanner.nextLine();
                        if (!newEspecie.isEmpty()) {
                            animalToUpdate.setEspecie(newEspecie);
                        }

                        System.out.print("Ingrese la nueva edad del animal (dejar vacío para no cambiar): ");
                        String newEdad = scanner.nextLine();
                        if (!newEdad.isEmpty()) {
                            animalToUpdate.setEdad(Integer.parseInt(newEdad));
                        }

                        System.out.print("Ingrese la nueva descripción del animal (dejar vacío para no cambiar): ");
                        String newDesc = scanner.nextLine();
                        if (!newDesc.isEmpty()) {
                            animalToUpdate.setDescripcion(newDesc);
                        }

                        animalDAO.update(animalToUpdate);
                        System.out.println("Animal actualizado con éxito.");
                    } else {
                        System.out.println("No se encontró el animal con ese ID.");
                    }
                    break;

                case 5:
                    // Eliminar un animal
                    System.out.print("Ingrese el ID del animal a eliminar: ");
                    Long animalIdToDelete = scanner.nextLong();
                    scanner.nextLine();

                    Animal animalToDelete = animalDAO.findById(animalIdToDelete);
                    if (animalToDelete != null) {
                        animalDAO.delete(animalToDelete);
                        System.out.println("Animal eliminado con éxito.");
                    } else {
                        System.out.println("No se encontró el animal con ese ID.");
                    }
                    break;

                case 6:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
