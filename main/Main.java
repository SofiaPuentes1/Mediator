package main;

import colleague.Estudiante;
import mediator.BibliotecaMediator;
import mediator.Mediator;
import model.Libro;

public class Main {

    public static void main(String[] args) {

        // 1) Creamos el mediador (único punto de comunicación)
        Mediator biblioteca = new BibliotecaMediator();

        // 2) Creamos los estudiantes conectados al mediador
        Estudiante ana = new Estudiante("Ana", biblioteca);
        Estudiante carlos = new Estudiante("Carlos", biblioteca);

        // 3) Creamos el libro compartido
        Libro patrones = new Libro("Patrones de Diseño");

        // 4) Ana solicita el libro -> aprobado
        ana.solicitarLibro(patrones);
        System.out.println();

        // 5) Carlos solicita el mismo libro -> rechazado
        carlos.solicitarLibro(patrones);
        System.out.println();

        // 6) Ana devuelve el libro -> disponible nuevamente
        ana.devolverLibro(patrones);
        System.out.println();

        // 7) Carlos vuelve a solicitar el libro -> aprobado
        carlos.solicitarLibro(patrones);
    }
}