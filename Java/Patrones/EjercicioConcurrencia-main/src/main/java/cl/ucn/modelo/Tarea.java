package cl.ucn.modelo;

public class Tarea {

    private String descripcionTarea;

    public Tarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public String obtenerDescripcionTarea() {
        return descripcionTarea;
    }
}
