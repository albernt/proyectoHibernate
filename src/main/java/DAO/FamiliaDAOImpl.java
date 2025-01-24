package DAO;

import entities.Familia;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FamiliaDAOImpl implements FamiliaDAO {

    /**
     * Guarda un nuevo objeto Familia en la base de datos.
     *
     * @param familia El objeto Familia que se desea guardar.
     */
    @Override
    public void save(Familia familia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(familia);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Obtiene un objeto Familia por su ID.
     *
     * @param id El ID de la familia a buscar.
     * @return El objeto Familia correspondiente al ID, o null si no se encuentra.
     */
    @Override
    public Familia getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Familia.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Obtiene todas las familias de la base de datos.
     *
     * @return Una lista con todos los objetos Familia.
     */
    @Override
    public List<Familia> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Familia", Familia.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Actualiza un objeto Familia en la base de datos.
     *
     * @param familia El objeto Familia con los datos actualizados.
     */
    @Override
    public void update(Familia familia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(familia);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Elimina un objeto Familia de la base de datos.
     *
     * @param familia El objeto Familia que se desea eliminar.
     */
    @Override
    public void delete(Familia familia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(familia);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
