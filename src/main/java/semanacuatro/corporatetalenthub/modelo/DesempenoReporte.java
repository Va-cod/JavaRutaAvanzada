package semanacuatro.corporatetalenthub.modelo;

public record DesempenoReporte(int idEmpleado, double promedio, String feedback) {

    @Override
    public String toString() {
        return  "Empleado: " + idEmpleado + ", Promedio: " + promedio + ", Feedback: " + feedback;
    }
}
