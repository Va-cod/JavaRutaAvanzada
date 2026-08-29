package semanacuatro.corporatetalenthub.vista;

import java.util.Scanner;

public class VistaSistema {
    private final Scanner scanner;

    public VistaSistema() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu(){
        System.out.print("""
                    * * * * * CORPORATE TALENT HUB * * * * *
                    1. Registrar desarrollador
                    2. Registrar gerente
                    3. Registrar cosultor externo
                    5. Listar empleados
                    6. Eliminar empleados
                    7. Ver sedes y tecnologías
                    8. Eliminar empleados no promovidos
                    9. Generar reporte
                    10. Salir
                    """);
        System.out.print("Opcion:");
        return scanner.nextInt();
    }

    public String solicitarNombre() {
        scanner.nextLine();
        System.out.print("Nombre completo: ");
        return scanner.nextLine();
    }

    public int solicitarEdad() {
        System.out.print("Edad: ");
        return scanner.nextInt();
    }

    public double solicitarCalificacion(int contador) {
        System.out.print("Calificacion " + contador + ":");
        return scanner.nextDouble();
    }

    public double solicitarSalario() {
        System.out.print("Ingrese el salario: ");
        return scanner.nextDouble();
    }

    public String solicitarLenguajePrincipal() {
        System.out.print("Lenguaje principal: ");
        return scanner.nextLine();
    }

    public double solicitarPresupuestoMensual() {
        System.out.print("Presupuesto mensual: ");
        return scanner.nextDouble();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
