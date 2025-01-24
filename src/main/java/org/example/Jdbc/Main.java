package org.example.Jdbc;

import DAO.AnimalDAO;
import DAO.AnimalDAOImpl;
import Util.HibernateUtil;
import entities.Animal;
import entities.Familia;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnimalDAO animalDAO = new AnimalDAOImpl();

        Long animalId = 2L;

        Animal animal = animalDAO.findById(animalId);
        if (animal != null) {
            animal.setEdad(10);
            animalDAO.update(animal);

        }

        animalDAO.update(animal);



        HibernateUtil.shutdown();
    }
}
