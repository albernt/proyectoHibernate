package DAO;

import entities.Animal;
import entities.Familia;
import Util.HibernateUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalDAOImplTest {

    private final AnimalDAOImpl animalDAO = new AnimalDAOImpl();
    private final FamiliaDAOImpl familiaDAO = new FamiliaDAOImpl();

    @BeforeEach
    void setUp() {
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Animal").executeUpdate();
        session.createQuery("DELETE FROM Familia").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @AfterEach
    void tearDown() {
        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Animal").executeUpdate();
        session.createQuery("DELETE FROM Familia").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void testSaveAnimal() {
        Familia familia = new Familia();
        familia.setNombre("Familia Pérez");
        familia.setEdad(45);
        familia.setCiudad("Sevilla");
        familiaDAO.save(familia);

        Animal animal = new Animal();
        animal.setNombre("Luna");
        animal.setEspecie("Perro");
        animal.setEdad(3);
        animal.setDescripcion("Un perro amistoso y juguetón.");
        animal.setEstado("Saludable");
        animal.setFamilia(familia);

        animalDAO.save(animal);

        Animal savedAnimal = animalDAO.findById(animal.getId());
        assertNotNull(savedAnimal);
        assertEquals("Luna", savedAnimal.getNombre());
        assertEquals("Perro", savedAnimal.getEspecie());
        assertEquals(3, savedAnimal.getEdad());
        assertEquals("Saludable", savedAnimal.getEstado());
        assertNotNull(savedAnimal.getFamilia());
        assertEquals("Familia Pérez", savedAnimal.getFamilia().getNombre());
    }

    @Test
    void testUpdateAnimal() {
        Familia familia = new Familia();
        familia.setNombre("Familia López");
        familia.setEdad(50);
        familia.setCiudad("Granada");
        familiaDAO.save(familia);

        Animal animal = new Animal();
        animal.setNombre("Rex");
        animal.setEspecie("Gato");
        animal.setEdad(5);
        animal.setDescripcion("Un gato tranquilo.");
        animal.setEstado("Saludable");
        animal.setFamilia(familia);

        animalDAO.save(animal);

        animal.setNombre("Rex Actualizado");
        animal.setEstado("En tratamiento");
        animalDAO.update(animal);

        Animal updatedAnimal = animalDAO.findById(animal.getId());
        assertNotNull(updatedAnimal);
        assertEquals("Rex Actualizado", updatedAnimal.getNombre());
        assertEquals("En tratamiento", updatedAnimal.getEstado());
    }

    @Test
    void testDeleteAnimal() {
        Familia familia = new Familia();
        familia.setNombre("Familia García");
        familia.setEdad(60);
        familia.setCiudad("Madrid");
        familiaDAO.save(familia);

        Animal animal = new Animal();
        animal.setNombre("Bobby");
        animal.setEspecie("Conejo");
        animal.setEdad(2);
        animal.setDescripcion("Un conejo blanco pequeño.");
        animal.setEstado("Saludable");
        animal.setFamilia(familia);

        animalDAO.save(animal);

        animalDAO.delete(animal);

        Animal deletedAnimal = animalDAO.findById(animal.getId());
        assertNull(deletedAnimal);
    }

    @Test
    void testFindByEspecie() {
        Familia familia = new Familia();
        familia.setNombre("Familia Martínez");
        familia.setEdad(35);
        familia.setCiudad("Barcelona");
        familiaDAO.save(familia);

        Animal animal1 = new Animal();
        animal1.setNombre("Max");
        animal1.setEspecie("Perro");
        animal1.setEdad(4);
        animal1.setDescripcion("Perro activo.");
        animal1.setEstado("Saludable");
        animal1.setFamilia(familia);

        Animal animal2 = new Animal();
        animal2.setNombre("Bella");
        animal2.setEspecie("Perro");
        animal2.setEdad(6);
        animal2.setDescripcion("Perra cariñosa.");
        animal2.setEstado("Saludable");
        animal2.setFamilia(familia);

        animalDAO.save(animal1);
        animalDAO.save(animal2);

        var perros = animalDAO.findByEspecie("Perro");
        assertEquals(2, perros.size());
        assertTrue(perros.stream().anyMatch(animal -> animal.getNombre().equals("Max")));
        assertTrue(perros.stream().anyMatch(animal -> animal.getNombre().equals("Bella")));
    }

    @Test
    void testFindAllAnimals() {
        Familia familia = new Familia();
        familia.setNombre("Familia Rivera");
        familia.setEdad(40);
        familia.setCiudad("Bilbao");
        familiaDAO.save(familia);

        Animal animal1 = new Animal();
        animal1.setNombre("Lucy");
        animal1.setEspecie("Gato");
        animal1.setEdad(3);
        animal1.setDescripcion("Un gato juguetón.");
        animal1.setEstado("Saludable");
        animal1.setFamilia(familia);

        Animal animal2 = new Animal();
        animal2.setNombre("Charlie");
        animal2.setEspecie("Conejo");
        animal2.setEdad(2);
        animal2.setDescripcion("Un conejo curioso.");
        animal2.setEstado("Saludable");
        animal2.setFamilia(familia);

        animalDAO.save(animal1);
        animalDAO.save(animal2);

        var allAnimals = animalDAO.findAll();
        assertEquals(2, allAnimals.size());
        assertTrue(allAnimals.stream().anyMatch(animal -> animal.getNombre().equals("Lucy")));
        assertTrue(allAnimals.stream().anyMatch(animal -> animal.getNombre().equals("Charlie")));
    }
}
