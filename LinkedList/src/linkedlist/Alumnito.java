
package linkedlist;

import java.util.Objects;

public class Alumnito {

    private String nombre;
    private int edad;
    private String carrera;
    private String id;
    private double calificacion;

    public Alumnito(String nombre, int edad,
            String id, double calificacion) {

        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Alumnito{"
                + "nombre='" + nombre + '\''
                + '}';
    }
}

