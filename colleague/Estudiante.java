package colleague;

import mediator.Mediator;
import model.Libro;

public class Estudiante {

    private final String nombre;
    private final Mediator mediator;

    public Estudiante(String nombre, Mediator mediator) {
        this.nombre = nombre;
        this.mediator = mediator;
    }

    public String getNombre() {
        return nombre;
    }

    public void solicitarLibro(Libro libro) {
        mediator.solicitarPrestamo(nombre, libro);
    }

    public void devolverLibro(Libro libro) {
        mediator.devolverLibro(nombre, libro);
    }
}