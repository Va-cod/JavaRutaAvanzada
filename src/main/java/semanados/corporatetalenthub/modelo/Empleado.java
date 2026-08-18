package semanados.corporatetalenthub.modelo;

// Clase empleado
public class Empleado {

    // Atributos
    private static int contadorId = 1;

    private final int id;
    private final String nombre;
    private final byte edad;
    private final int salario;
    private double promedioDesempenio;

    // Constructor
    public Empleado (String nombre, byte edad, int salario){
        this.id = contadorId++;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    // Getters
    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public byte getEdad() {
        return edad;
    }

    public int getSalario(){
        return salario;
    }

    public double getPromedio(){
        return promedioDesempenio;
    }

    public void setPromedioDesempenio(double promedioDesempenio) {
        this.promedioDesempenio = promedioDesempenio;
    }

    @Override
    public String toString() {
        return "\nEmpleado: " + id + "\n" +
                "Nombre: " + nombre +
                ", Edad: " + edad +
                ", Salario: " + salario +
                ", Promedio desempeño: " + promedioDesempenio;
    }
}
