package DAO;

import entities.Animal;
import java.util.List;

/**
 * Interfaz que define los métodos CRUD para la entidad Animal.
 */
public interface AnimalDAO {

    /**
     * Guarda un objeto Animal en la base de datos.
     *
     * @param animal El objeto Animal a guardar.
     */
    void save(Animal animal);

    /**
     * Obtiene un objeto Animal por su ID.
     *
     * @param id El ID del Animal a buscar.
     * @return El objeto Animal correspondiente al ID, o null si no se encuentra.
     */
    Animal findById(Long id);

    /**
     * Obtiene una lista de animales por su especie.
     *
     * @param especie La especie de los animales a buscar.
     * @return Una lista de objetos Animal que pertenecen a la especie indicada.
     */
    List<Animal> findByEspecie(String especie);

    /**
     * Obtiene todos los animales de la base de datos.
     *
     * @return Una lista con todos los objetos Animal almacenados en la base de datos.
     */
    List<Animal> findAll();

    /**
     * Actualiza un objeto Animal en la base de datos.
     *
     * @param animal El objeto Animal con los nuevos valores.
     */
    void update(Animal animal);

    /**
     * Elimina un objeto Animal de la base de datos.
     *
     * @param animal El objeto Animal a eliminar.
     */
    void delete(Animal animal);
}
