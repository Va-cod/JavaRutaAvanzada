package semanacuatro.corporatetalenthub.servicio;

import semanacuatro.corporatetalenthub.modelo.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoServicio {
    private final List<Empleado> empleados;

    public EmpleadoServicio() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> obtenerEmpleados() {
        return empleados;
    }

    public boolean eliminarEmpleado(int id) {
        return empleados.removeIf(empleado ->
                empleado.getId() == id);
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
