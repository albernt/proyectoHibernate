package DAO;

import entities.Animal;
import java.util.List;

public interface AnimalDAO {
    void save(Animal animal);  // Create
    Animal findById(Long id); // Read
    List<Animal> findByEspecie(String especie); // Read by especie
    List<Animal> findAll();   // Read all
    void update(Animal animal); // Update
    void delete(Animal animal); // Delete
}
