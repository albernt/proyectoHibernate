package DAO;

import Util.HibernateUtil;
import entities.Persona;
import org.hibernate.Session;

import java.util.List;

public class personaImpl implements persona {


    @Override
    public List<Persona> findAll() {

        // Debemos abrir la sesion
        Session session = HibernateUtil.getSessionFactory().openSession();
        // HQL (SQL de hibernate)
        List<Persona> personas = session.createQuery("FROM Persona", Persona.class).list();
        session.close();

        return personas;

    }

    @Override
    public Persona findById(int id) {
         Session session = HibernateUtil.getSessionFactory().openSession();
         Persona persona2 = session.find(Persona.class, id);
        session.close();
        return persona2;

    }

    @Override
    public List<Persona> findByName(String name) {
        return List.of();
    }

    @Override
    public Persona create(Persona persona) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(persona);
        session.getTransaction().commit();

        session.close();
        return persona;
    }

    @Override
    public Persona update(Persona persona) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


}
