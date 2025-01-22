package org.example.Jdbc;

import DAO.personaImpl;
import entities.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        personaImpl personaImpl = new personaImpl();

        personaImpl.create(new Persona(null, "Andrea", "catalanandrea@gmail.com", 3000));
        personaImpl.create(new Persona(null, "Ivan", "ivangarcia@gmail.com", 2500));
        System.out.println(personaImpl.findAll());
        System.out.println("Dime una id de la persona para encontrarla: ");
        int id = sc.nextInt();
        System.out.println(personaImpl.findById(id));
    }

}