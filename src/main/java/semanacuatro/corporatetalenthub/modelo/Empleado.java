package semanacuatro.corporatetalenthub.modelo;

public sealed class Empleado extends Persona permits Desarrollador, Gerente {

    private final double salario;

    public Empleado(int id, String nombreCompleto, int edad, double promedioDesempeno, double salario) {
        super(id, nombreCompleto, edad, promedioDesempeno);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Salario: " + salario;
    }
}