package semanacuatro.corporatetalenthub.servicio;

import semanacuatro.corporatetalenthub.modelo.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpleadoServicio {
    private final List<Persona> empleados;
    private final List<String> tecnologias;
    private final Map<Integer, String> sedes;

    public EmpleadoServicio() {
        empleados = new ArrayList<>();
        tecnologias = List.of("Java", "Spring Boot", "Python", "JavaScript");
        sedes = Map.of(1, "Barranquilla",2, "Bogotá",3, "Medellín");
    }

    public void agregarEmpleado(Persona empleado) {
        empleados.add(empleado);
    }

    public List<Persona> obtenerEmpleados() {
        return empleados;
    }

    public boolean buscarEmpleado(int id){
        for (Persona persona : empleados){
            if (persona.getId() == id){
                return true;
            }
        }
        return false;
    }

    public void eliminarEmpleado(int id) {
        empleados.removeIf(empleado ->
                empleado.getId() == id);
    }

    public List<String> mostrarTecnologias (){
        return tecnologias;
    }

    public Map<Integer, String> mostrarSedes (){
        return sedes;
    }

    public static String obtenerCategoriaSalarial(int salario){
        int categoria = determinarCategoriaSalarial(salario);
        return switch (categoria){
            case 1 -> "JUNIOR";
            case 2 -> "SENIOR";
            case 3 -> "EXPERT";
            default -> "Categoria no encontrada";
        };
    }

    public static int determinarCategoriaSalarial(int salario){
        if (salario <= 3_000_000) {
            return 1;
        } else if (salario < 5_000_000) {
            return 2;
        } else {
            return 3;
        }
    }
}
