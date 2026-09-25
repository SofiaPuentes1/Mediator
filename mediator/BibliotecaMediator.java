package mediator;

import model.Libro;

import java.util.HashMap;
import java.util.Map;


public class BibliotecaMediator implements Mediator {
    
    private final Map<String, String> prestamos = new HashMap<>();

    @Override
    public void solicitarPrestamo(String nombreEstudiante, Libro libro) {
        System.out.println(nombreEstudiante + " solicita el libro " + libro + ".");

        if (libro.isDisponible()) {
            libro.setDisponible(false);
            prestamos.put(libro.getTitulo(), nombreEstudiante);
            System.out.println("Biblioteca: préstamo aprobado para " + nombreEstudiante + ".");
        } else {
            String poseedor = prestamos.get(libro.getTitulo());
            System.out.println("Biblioteca: el libro no está disponible"
                    + (poseedor != null ? " (lo tiene " + poseedor + ")" : "") + ".");
        }
    }

    @Override
    public void devolverLibro(String nombreEstudiante, Libro libro) {
        System.out.println(nombreEstudiante + " devuelve el libro " + libro + ".");

        if (prestamos.containsKey(libro.getTitulo())
                && prestamos.get(libro.getTitulo()).equals(nombreEstudiante)) {
            prestamos.remove(libro.getTitulo());
            libro.setDisponible(true);
            System.out.println("Biblioteca: libro disponible nuevamente.");
        } else {
            System.out.println("Biblioteca: " + nombreEstudiante
                    + " no tiene registrado el préstamo de ese libro.");
        }
    }
}