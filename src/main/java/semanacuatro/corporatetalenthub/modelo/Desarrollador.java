package semanacuatro.corporatetalenthub.modelo;

public final class Desarrollador extends Empleado {

    private final String lenguajePrincipal;

    public Desarrollador(String nombreCompleto, int edad, double promedioDesempeno, double salario, String lenguajePrincipal) {
        super(nombreCompleto, edad, promedioDesempeno, salario);

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