package semanacuatro.corporatetalenthub.modelo;

public abstract sealed class Persona permits Empleado, ConsultorExterno {
    private static int contadorId = 1;
    private final int id;
    private final String nombreCompleto;
    private final int edad;
    private final double promedioDesempeno;

    public Persona(String nombreCompleto, int edad, double promedioDesempeno) {
        this.id = contadorId++;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.promedioDesempeno = promedioDesempeno;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public double getPromedioDesempeno() {
        return promedioDesempeno;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombreCompleto + ", Edad: " + edad + ", Promedio de desempeño: " + promedioDesempeno;
    }
}

