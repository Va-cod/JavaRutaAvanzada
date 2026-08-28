package semanacuatro.corporatetalenthub.modelo;

public final class Gerente extends Empleado {

    private final double presupuestoMensual;

    public Gerente(int id, String nombreCompleto, int edad, double promedioDesempeno, double salario, double presupuestoMensual) {
        super(id, nombreCompleto, edad, promedioDesempeno, salario);
        this.presupuestoMensual = presupuestoMensual;
    }

    public double getPresupuestoMensual() {
        return presupuestoMensual;
    }

    @Override
    public String toString() {
        return super.toString() + ", Presupuesto mensual: " + presupuestoMensual;
    }
}
