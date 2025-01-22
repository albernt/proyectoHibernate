package com.example.entities;

import Util.HibernateUtil;
import entities.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

public class PersonaTest {

    @Test

    void createTableTest() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("Creacion de tabla Persona realizada con exito");

        Persona persona = new Persona(null, "Niko", "nikoganfornina@gmail.com", 1500);
        Persona persona2 = new Persona(null, "Alberto", "albertoylasbombas@gmail.com", 1800);

        List<Persona> personas = List.of(persona, persona2);

        //trasaccion

        session.beginTransaction();

        //guarda en mi bbdd

        session.persist(persona);
        session.persist(persona2);

        //compiteamos la transaccion

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

        System.out.println("Personas guardada con exito");

    }

}
