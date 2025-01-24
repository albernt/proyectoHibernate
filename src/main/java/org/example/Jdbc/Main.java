package org.example.Jdbc;

import DAO.AnimalDAOImpl;
import DAO.FamiliaDAO;
import DAO.FamiliaDAOImpl;
import entities.Animal;
import entities.Familia;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que permite gestionar animales y familias.
 */

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AnimalDAOImpl animalDAO = new AnimalDAOImpl();
        FamiliaDAOImpl familiaDAO = new FamiliaDAOImpl();
        int opcion;

        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Gestionar Animales");
            System.out.println("2. Gestionar Familias");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarAnimales(animalDAO, familiaDAO, scanner);
                    break;
                case 2:
                    gestionarFamilias(familiaDAO, scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Gestiona a los animales
     * @param animalDAO El objeto que gestiona las operaciones con animales.
     * @param familiaDAO El objeto que gestiona las operaciones con familias.
     * @param scanner El objeto Scanner para obtener entradas del usuario.
     */
    private static void gestionarAnimales(AnimalDAOImpl animalDAO, FamiliaDAOImpl familiaDAO, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Animales ===");
            System.out.println("1. Agregar Animal");
            System.out.println("2. Listar Animales");
            System.out.println("3. Buscar Animal por ID");
            System.out.println("4. Buscar Animales por Especie");
            System.out.println("5. Actualizar Animal");
            System.out.println("6. Eliminar Animal");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Especie: ");
                    String especie = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();


                    System.out.print("ID de la Familia: ");
                    Long familiaId = scanner.nextLong();
                    scanner.nextLine();


                    Familia familia = familiaDAO.getById(familiaId);


                    if (familia != null) {
                        Animal animal = new Animal();
                        animal.setNombre(nombre);
                        animal.setEspecie(especie);
                        animal.setEdad(edad);
                        animal.setDescripcion(descripcion);
                        animal.setEstado(estado);
                        animal.setFamilia(familia);

                        animalDAO.save(animal);
                        System.out.println("Animal agregado con éxito.");
                    } else {
                        System.out.println("Familia no encontrada. El animal no ha sido agregado.");
                    }
                    break;

                case 2:
                    List<Animal> animales = animalDAO.findAll();
                    System.out.println("\n=== Lista de Animales ===");
                    for (Animal a : animales) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    System.out.print("ID del Animal: ");
                    Long id = scanner.nextLong();
                    Animal animalEncontrado = animalDAO.findById(id);
                    System.out.println(animalEncontrado != null ? animalEncontrado : "Animal no encontrado.");
                    break;

                case 4:
                    System.out.print("Especie: ");
                    String especieBuscada = scanner.nextLine();
                    List<Animal> animalesPorEspecie = animalDAO.findByEspecie(especieBuscada);
                    for (Animal a : animalesPorEspecie) {
                        System.out.println(a);
                    }
                    break;

                case 5:
                    System.out.print("ID del Animal a actualizar: ");
                    Long idActualizar = scanner.nextLong();
                    scanner.nextLine();
                    Animal animalActualizar = animalDAO.findById(idActualizar);
                    if (animalActualizar != null) {
                        System.out.print("Nuevo Nombre: ");
                        animalActualizar.setNombre(scanner.nextLine());
                        System.out.print("Nueva Especie: ");
                        animalActualizar.setEspecie(scanner.nextLine());
                        System.out.print("Nueva Edad: ");
                        animalActualizar.setEdad(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Nueva Descripción: ");
                        animalActualizar.setDescripcion(scanner.nextLine());
                        System.out.print("Nuevo Estado: ");
                        animalActualizar.setEstado(scanner.nextLine());

                        animalDAO.update(animalActualizar);
                        System.out.println("Animal actualizado con éxito.");
                    } else {
                        System.out.println("Animal no encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("ID del Animal a eliminar: ");
                    Long idEliminar = scanner.nextLong();
                    scanner.nextLine();
                    Animal animalEliminar = animalDAO.findById(idEliminar);
                    if (animalEliminar != null) {
                        animalDAO.delete(animalEliminar);
                        System.out.println("Animal eliminado con éxito.");
                    } else {
                        System.out.println("Animal no encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Gestiona las operaciones relacionadas con las familias,
     * @param familiaDAO El objeto que gestiona las operaciones con familias.
     * @param scanner El objeto Scanner para obtener entradas del usuario.
     */
    private static void gestionarFamilias(FamiliaDAOImpl familiaDAO, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Familias ===");
            System.out.println("1. Agregar Familia");
            System.out.println("2. Listar Familias");
            System.out.println("3. Buscar Familia por ID");
            System.out.println("4. Actualizar Familia");
            System.out.println("5. Eliminar Familia");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();

                    Familia familia = new Familia();
                    familia.setNombre(nombre);
                    familia.setEdad(edad);
                    familia.setCiudad(ciudad);

                    familiaDAO.save(familia);
                    System.out.println("Familia agregada con éxito.");
                    break;

                case 2:
                    List<Familia> familias = familiaDAO.getAll();
                    System.out.println("\n=== Lista de Familias ===");
                    for (Familia f : familias) {
                        System.out.println(f);
                    }
                    break;

                case 3:
                    System.out.print("ID de la Familia: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    Familia familiaEncontrada = familiaDAO.getById(id);
                    System.out.println(familiaEncontrada != null ? familiaEncontrada : "Familia no encontrada.");
                    break;

                case 4:
                    System.out.print("ID de la Familia a actualizar: ");
                    Long idActualizar = scanner.nextLong();
                    scanner.nextLine();
                    Familia familiaActualizar = familiaDAO.getById(idActualizar);
                    if (familiaActualizar != null) {
                        System.out.print("Nuevo Nombre: ");
                        familiaActualizar.setNombre(scanner.nextLine());
                        System.out.print("Nueva Edad: ");
                        familiaActualizar.setEdad(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Nueva Ciudad: ");
                        familiaActualizar.setCiudad(scanner.nextLine());

                        familiaDAO.update(familiaActualizar);
                        System.out.println("Familia actualizada con éxito.");
                    } else {
                        System.out.println("Familia no encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("ID de la Familia a eliminar: ");
                    Long idEliminar = scanner.nextLong();
                    scanner.nextLine();
                    Familia familiaEliminar = familiaDAO.getById(idEliminar);
                    if (familiaEliminar != null) {
                        familiaDAO.delete(familiaEliminar);
                        System.out.println("Familia eliminada con éxito.");
                    } else {
                        System.out.println("Familia no encontrada.");
                    }
                    break;

                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
