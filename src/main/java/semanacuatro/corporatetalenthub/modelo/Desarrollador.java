package semanacuatro.corporatetalenthub.modelo;

public final class Desarrollador extends Empleado {

    private final String lenguajePrincipal;

    public Desarrollador(int id, String nombreCompleto, int edad, double promedioDesempeno, double salario, String lenguajePrincipal) {
        super(id, nombreCompleto, edad, promedioDesempeno, salario);

        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    @Override
    public String toString() {
        return super.toString() + ", Lenguaje principal: " + lenguajePrincipal;
    }
}