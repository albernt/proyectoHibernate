package DAO;

import entities.Animal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Util.HibernateUtil;

import java.util.List;

/**
 * Implementación de la interfaz AnimalDAO, que gestiona las operaciones CRUD
 * para la entidad Animal utilizando Hibernate.
 */

public class AnimalDAOImpl implements AnimalDAO {

    /**
     * Guarda un nuevo animal en la base de datos.
     *
     * @param animal El objeto Animal que se desea guardar.
     */
    @Override
    public void save(Animal animal) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(animal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error al guardar el animal: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Encuentra un animal por su ID.
     *
     * @param id El ID del animal a buscar.
     * @return El objeto Animal correspondiente al ID, o null si no se encuentra.
     */
    @Override
    public Animal findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Animal.class, id);
        }
    }

    /**
     * Encuentra una lista de animales que pertenecen a una especie específica.
     *
     * @param especie La especie de los animales a buscar.
     * @return Una lista de objetos Animal que coinciden con la especie proporcionada.
     */
    @Override
    public List<Animal> findByEspecie(String especie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Animal WHERE especie = :especie", Animal.class)
                    .setParameter("especie", especie)
                    .list();
        }
    }

    /**
     * Encuentra todos los animales en la base de datos.
     *
     * @return Una lista de todos los animales.
     */
    @Override
    public List<Animal> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Animal", Animal.class).list();
        }
    }

    /**
     * Actualiza un animal en la base de datos.
     *
     * @param animal El objeto Animal con los datos actualizados.
     */
    @Override
    public void update(Animal animal) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(animal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Elimina un animal de la base de datos.
     *
     * @param animal El objeto Animal que se desea eliminar.
     */

    @Override
    public void delete(Animal animal) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(animal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
