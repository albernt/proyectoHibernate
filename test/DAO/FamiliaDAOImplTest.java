package DAO;

import entities.Animal;
import entities.Familia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Util.HibernateUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamiliaDAOImplTest {

    private final FamiliaDAOImpl familiaDAO = new FamiliaDAOImpl();
    private final AnimalDAOImpl animalDAO = new AnimalDAOImpl();

    @BeforeEach
    void setUp() {

        var session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Animal").executeUpdate();
        session.createQuery("DELETE FROM Familia").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void testSaveFamilia() {

        Familia familia = new Familia();
        familia.setNombre("Familia García");
        familia.setEdad(50);
        familia.setCiudad("Madrid");

        familiaDAO.save(familia);


        Familia savedFamilia = familiaDAO.getById(familia.getId());
        assertNotNull(savedFamilia);
        assertEquals("Familia García", savedFamilia.getNombre());
        assertEquals(50, savedFamilia.getEdad());
        assertEquals("Madrid", savedFamilia.getCiudad());
    }


    @Test
    void testUpdateFamilia() {

        Familia familia = new Familia();
        familia.setNombre("Familia López");
        familia.setEdad(40);
        familia.setCiudad("Valencia");

        familiaDAO.save(familia);


        familia.setNombre("Familia López Actualizada");
        familia.setCiudad("Granada");
        familiaDAO.update(familia);


        Familia updatedFamilia = familiaDAO.getById(familia.getId());
        assertNotNull(updatedFamilia);
        assertEquals("Familia López Actualizada", updatedFamilia.getNombre());
        assertEquals("Granada", updatedFamilia.getCiudad());
    }

    @Test
    void testDeleteFamilia() {

        Familia familia = new Familia();
        familia.setNombre("Familia Sánchez");
        familia.setEdad(35);
        familia.setCiudad("Bilbao");

        familiaDAO.save(familia);


        familiaDAO.delete(familia);


        Familia deletedFamilia = familiaDAO.getById(familia.getId());
        assertNull(deletedFamilia);
    }


}
