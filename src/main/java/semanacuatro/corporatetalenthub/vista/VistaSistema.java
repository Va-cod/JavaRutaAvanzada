package semanacuatro.corporatetalenthub.vista;

import semanacuatro.corporatetalenthub.modelo.DesempenoReporte;
import semanacuatro.corporatetalenthub.modelo.Persona;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VistaSistema {
    private final Scanner scanner;

    public VistaSistema() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu(){
        System.out.print("""
                    \n* * * * * CORPORATE TALENT HUB * * * * *
                    1. Registrar desarrollador
                    2. Registrar gerente
                    3. Registrar consultor externo
                    4. Listar empleados
                    5. Eliminar empleados
                    6. Ver sedes y tecnologías
                    7. Eliminar empleados no promovidos
                    8. Generar reporte
                    9. Mostra bonos de ascenso
                    10. Mostrar Empleados por area
                    10. Salir
                    ----------------------------------------
                    """);
        System.out.print("Opcion: ");
        return scanner.nextInt();
    }

    public int solicitarId(){
        scanner.nextLine();
        System.out.print("Id: ");
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
        System.out.print("Calificacion " + contador + ": ");
        return scanner.nextDouble();
    }

    public double solicitarSalario() {
        System.out.print("Ingrese el salario: ");
        return scanner.nextDouble();
    }

    public String solicitarLenguajePrincipal() {
        scanner.nextLine();
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

    public void mostrarLista(List<Persona> empleadoList){
        empleadoList.forEach(System.out::println);
    }

    public void mostrarTecnologias(List<String> tecnologias){
        System.out.println("\nTECNOLOGIAS");
        tecnologias.forEach(System.out::println);
    }

    public void mostrarSedes(Map<Integer, String> sedes){
        System.out.println("\nSEDES");
        sedes.forEach((clave, valor) -> {
            System.out.println(clave + ": " + valor);
        });
    }

    public void mostrarReporte(List<DesempenoReporte> reportes){
        reportes.forEach(System.out::println);
    }

    public void mostrarBonos(List<String> bonos){
        bonos.forEach(System.out::println);
    }
}
