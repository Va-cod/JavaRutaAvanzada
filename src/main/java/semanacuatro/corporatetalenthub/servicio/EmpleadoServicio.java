package semanacuatro.corporatetalenthub.servicio;

import semanacuatro.corporatetalenthub.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpleadoServicio implements Promocionable{
    private final List<Persona> empleados;
    private final List<DesempenoReporte> reportes;
    private final List<String> tecnologias;
    private final Map<Integer, String> sedes;
    private final List<String> bonos;
    private final List<String> departamentos;

    public EmpleadoServicio() {
        reportes = new ArrayList<>();
        empleados = new ArrayList<>();
        tecnologias = List.of("Java", "Spring Boot", "Python", "JavaScript");
        sedes = Map.of(1, "Barranquilla",2, "Bogotá",3, "Medellín");
        bonos = new ArrayList<>();
        departamentos = new ArrayList<>();
    }

    public boolean estadoLista(){
        return !empleados.isEmpty();
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

    public void eliminarEmpleado(int id){
        empleados.removeIf(empleado -> empleado.getId() == id);
    }

    public void eliminarReporte(int id){
        reportes.removeIf(reporte -> reporte.idEmpleado() == id);
    }

    public List<String> mostrarTecnologias(){
        return tecnologias;
    }

    public Map<Integer, String> mostrarSedes(){
        return sedes;
    }

    public void agregarReporte(DesempenoReporte reporte){
        reportes.add(reporte);
    }

    public List<DesempenoReporte> mostrarReporte(){
        return reportes;
    }

    public List<String> departamentos (List<Persona> empleados){
        for (Persona empleado : empleados){
            if (empleado instanceof Desarrollador e){
                departamentos.add("Nombre: " + e.getNombreCompleto() + AreaDesarrollo());
            }
            if (empleado instanceof Gerente e){
                departamentos.add("Nombre: " + e.getNombreCompleto() + AreaFinanzas());
            }
        }
        return departamentos;

    }


    @Override
    public List<String> bonoAscenso(List<Persona> empleados) {

        for (Persona empleado : empleados){
            if (empleado instanceof Empleado e && e.getPromedioDesempeno() >= 8 ){
                bonos.add("Nombre: " + e.getNombreCompleto() + ", Nuevo salario: " + (e.getSalario() + 200));
            }
        }
        return bonos;
    }


}

