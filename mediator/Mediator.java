package mediator;

import model.Libro;


public interface Mediator {

    void solicitarPrestamo(String nombreEstudiante, Libro libro);

    void devolverLibro(String nombreEstudiante, Libro libro);
}