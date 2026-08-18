package semanados.corporatetalenthub;

import semanados.corporatetalenthub.modelo.Empleado;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static final int TOTAL_EMPLEADOS = 10;
    private static final byte TOTAL_TRIMESTRES = 3;
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;
    private static final double PROMEDIO_PARA_APROBAR = 8.0;

    public static void main(String[] args) {
        Empleado[] empleados = new Empleado[TOTAL_EMPLEADOS];
        int empleadosRegistrados = 0;
        double[][] calificaciones = new double[TOTAL_EMPLEADOS][TOTAL_TRIMESTRES];
        int opcion = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                mostrarMenu();
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();

                /* Java 8: el switch tradicional requiere break para evitar
                   el fall-through accidental.
                   Java 17/21: la Switch Expression con -> evita este problema
                   y hace el código más breve y seguro. */

                switch (opcion) {
                    case 1:
                        agregarEmpleado(empleados, calificaciones, empleadosRegistrados);
                        System.out.println(Arrays.toString(empleados));
                        break;
                    case 2:
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
            } catch(InputMismatchException e){
                System.out.print("\n¡Error! Ingrese un valor númerico\n");
                scanner.nextLine();
            }
        } while (opcion != 4);
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

    public static boolean agregarEmpleado(Empleado[] empleados, double[][] calificaciones, int empleadosRegistrados){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Salario: ");
        int salario = Integer.parseInt(scanner.nextLine());

        for (int trimestre = 0; trimestre < TOTAL_TRIMESTRES; trimestre++){
            System.out.print("Trimetre " + (trimestre + 1) + ": ");
            double calificacion = Double.parseDouble(scanner.nextLine());

            if (calificacion < NOTA_MINIMA || calificacion > NOTA_MAXIMA){
                System.out.println("Por favor, ingrese una nota en este rango [0 - 10]");
                return false;
            }
            calificaciones[empleadosRegistrados][trimestre] = calificacion;
        }

        empleados[empleadosRegistrados] = new Empleado(nombre, (byte) edad, salario);
        System.out.println("Se ha agregado un nuevo empleado");
        return true;
    }
}
