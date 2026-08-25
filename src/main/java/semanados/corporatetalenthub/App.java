package semanados.corporatetalenthub;

import semanados.corporatetalenthub.modelo.Empleado;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final int TOTAL_EMPLEADOS = 2;
    private static final byte TOTAL_TRIMESTRES = 3;
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;
    private static final double PROMEDIO_PARA_APROBAR = 8.0;

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {

            Empleado[] empleados = new Empleado[TOTAL_EMPLEADOS];
            int empleadosRegistrados = 0;
            double[][] calificaciones = new double[TOTAL_EMPLEADOS][TOTAL_TRIMESTRES];
            int opcion = 0;

            do {
                try {
                    mostrarMenu();
                    System.out.print("Ingrese una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpia el Enter pendiente

                /* Java 8: el switch tradicional requiere break para evitar
                   el fall-through accidental.
                   Java 17/21: la Switch Expression con -> evita este problema
                   y hace el código más breve y seguro. */

                    switch (opcion) {
                        case 1:
                            boolean registroExitoso = false;
                            if (empleadosRegistrados >= TOTAL_EMPLEADOS){
                                System.out.println("\n¡Error! Llego al limite de empleados");
                            } else {
                                System.out.println("\nEmpleado " + (empleadosRegistrados + 1));
                                registroExitoso = agregarEmpleado(scanner, empleados, calificaciones, empleadosRegistrados);
                            }
                            if (registroExitoso){
                                empleadosRegistrados++;
                            }
                            break;
                        case 2:
                            mostrarReporte(empleados, calificaciones, empleadosRegistrados);
                            break;
                        case 3:
                            verCategoriaSalarial();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.print("Ingrese una opción válida");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.print("\n¡Error! Ingrese un valor númerico\n");
                    scanner.nextLine();
                }
            } while (opcion != 4);
        }
    }

        public static void mostrarMenu(){
        System.out.print("""
                    \n* * * * * CORPORATE TALENT HUB * * * * *
                    1. Registrar empleado
                    2. Ver reporte de desempeño
                    3. Consultar categorías salariales
                    4. Salir
                    """);
    }

    public static void verCategoriaSalarial(){
        System.out.print("""
                    \n* * * * CATEGORÍAS SALARIALES * * * *
                    JUNIOR: <= 3.000.000 COP
                    SENIOR: 3.000.000 - 5.000.00 COP
                    EXPERT: > 5.000.000 COP
                    """);
    }

    public static String obtenerCategoriaSalarial(int salario){
        int categoria = determinarCategoriaSalarial(salario);
        return switch (categoria){
            case 1 -> "JUNIOR";
            case 2 -> "SENIOR";
            case 3 -> "EXPERT";
            default -> "Categoria no encontrada";
        };
    }

    public static int determinarCategoriaSalarial(int salario){
        if (salario <= 3_000_000) {
            return 1;
        } else if (salario < 5_000_000) {
            return 2;
        } else {
            return 3;
        }
    }

    public static boolean agregarEmpleado(Scanner scanner, Empleado[] empleados, double[][] calificaciones, int empleadosRegistrados){

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isBlank()){
            System.out.println("¡Error! Escriba un nombre válido");
            return false;
        }

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        if (edad < 18 || edad > 65){
            System.out.println("¡Error! Edad inválida para trabajar");
            return false;
        }

        System.out.print("Salario: ");
        int salario = scanner.nextInt();
        if (salario < 0){
            System.out.println("¡Error! El salario no puede ser negativo");
            return false;
        }

        // Limpiar el Enter pendiente antes de continuar
        scanner.nextLine();

        double suma = 0;
        double promedioDesempenio;

        for (int trimestre = 0; trimestre < TOTAL_TRIMESTRES; trimestre++) {
            System.out.print("Trimestre " + (trimestre + 1) + ": ");
            double calificacion = scanner.nextDouble();

            if (calificacion < NOTA_MINIMA || calificacion > NOTA_MAXIMA) {
                System.out.println("Por favor, ingrese una nota en este rango [0 - 10]");
                return false;
            }

            calificaciones[empleadosRegistrados][trimestre] = calificacion;
            suma += calificacion;
        }

        promedioDesempenio = suma / TOTAL_TRIMESTRES;
        empleados[empleadosRegistrados] = new Empleado(nombre, (byte) edad, salario, promedioDesempenio);
        return true;
    }

    public static void mostrarReporte(Empleado[] empleados, double[][] calificaciones, int empleadosRegistrados){
        if (empleadosRegistrados == 0){
            System.out.println("Aun no hay empleados registrados");
            return;
        }

        for (int fila = 0; fila < empleadosRegistrados; fila++){
            String estadoAprovacion = (empleados[fila].getPromedio() >= PROMEDIO_PARA_APROBAR) ? "Empleado promovido" : "Empleado no promovido";
            System.out.println(empleados[fila]);
            System.out.println("Categoria salarial: " + obtenerCategoriaSalarial(empleados[fila].getSalario()));
            System.out.println("Estado: " + estadoAprovacion);
        }

    }
}
