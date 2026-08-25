package semanados.corporatetalenthub;

import semanados.corporatetalenthub.modelo.Empleado;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    // Variables constantes
    private static final int TOTAL_EMPLEADOS = 10;
    private static final byte TOTAL_TRIMESTRES = 3;
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;
    private static final double PROMEDIO_PARA_APROBAR = 8.0;

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)) {
            // TASK 3: Uso de matrices y arrays
            Empleado[] empleados = new Empleado[TOTAL_EMPLEADOS];                                          // Array para almacenar cada empleado
            var empleadosRegistrados = 0;                                                                  // Contador de empleados registrados para hacer validaciones
            var calificaciones = new double[TOTAL_EMPLEADOS][TOTAL_TRIMESTRES];                            // Matriz para almacenar las notas de cada empleado
            var opcion = 0;                                                                                // Variable para dar inicio al bloque do-while

            // TASK 2: uso de scanner dentro un bloque do-while
            do {
                try {
                    // TASK 4: Envolver la captura de datos del Scanner en un bloque try-catch
                    mostrarMenu();
                    System.out.print("Ingrese una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpia el Enter pendiente

                /*  Java 8: el switch tradicional requiere break para evitar
                    el fall-through accidental.
                    Java 17/21: la Switch Expression con -> evita este problema
                    y hace el código más breve y seguro. */

                /*  Java 17/21 proporciona mensajes de error y trazas de excepciones más detallados,
                    mostrando con mayor claridad dónde y por qué ocurre un error. Esto facilita la
                    depuración y permite encontrar la causa del problema más rápidamente que en Java 8. */

                    // TASK 1: menú con switch tradicional
                    switch (opcion) {
                        // Case 1: registrar empleado
                        case 1:
                            boolean registroExitoso = false;
                            if (empleadosRegistrados >= TOTAL_EMPLEADOS){
                                System.out.println("\n¡Error! Llego al limite de empleados");
                            } else {
                                System.out.println("\nEmpleado " + (empleadosRegistrados + 1));
                                registroExitoso = agregarEmpleado(scanner, empleados, calificaciones, empleadosRegistrados);
                                System.out.println("¡Registro Exitoso!");
                            }
                            if (registroExitoso){
                                empleadosRegistrados++;
                            }
                            break;
                        // Case 2: mostrar reporte
                        case 2:
                            mostrarReporte(empleados, empleadosRegistrados);
                            break;
                        // Case 3: mostrar categoria salarial
                        case 3:
                            verCategoriaSalarial();
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

    /*
        En Java 8, olvidar el `break` puede causar un "fall-through",
        ejecutando casos que no corresponden. En Java 17/21, las
        Switch Expressions son más seguras y breves, reduciendo este riesgo.
     */
    public static String obtenerCategoriaSalarial(int salario){
        int categoria = determinarCategoriaSalarial(salario);
        //TASK 1: menú con switch expression
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

        // TASK 2: Aplicar estructuras 'if-else' para realizar validaciones
        System.out.print("Nombre: ");
        var nombre = scanner.nextLine().trim();
        if (nombre.isBlank()){
            System.out.println("¡Error! Escriba un nombre válido");
            return false;
        }

        System.out.print("Edad: ");
        var edad = scanner.nextInt();
        if (edad < 18 || edad > 65){
            System.out.println("¡Error! Edad inválida para trabajar");
            return false;
        }

        System.out.print("Salario: ");
        var salario = scanner.nextInt();
        if (salario < 0){
            System.out.println("¡Error! El salario no puede ser negativo");
            return false;
        }

        // Limpiar el Enter pendiente antes de continuar
        scanner.nextLine();

        var suma = 0.0;
        var promedioDesempenio = 0.0;

        // TASK 3: Uso de bucle 'for' para recorrer la matriz de calificaciones
        for (int trimestre = 0; trimestre < TOTAL_TRIMESTRES; trimestre++) {
            System.out.print("Trimestre " + (trimestre + 1) + ": ");
                var calificacion = scanner.nextDouble();

            if (calificacion < NOTA_MINIMA || calificacion > NOTA_MAXIMA) {
                System.out.println("¡Error! Debe ingresar una nota en este rango [0 - 10]");
                return false;
            }

            calificaciones[empleadosRegistrados][trimestre] = calificacion;
            suma += calificacion;
        }

        promedioDesempenio = suma / TOTAL_TRIMESTRES;
        // TASK 3: Casting explícito para convertir el promedio final de double a int
        int promedioSimplificado = (int) promedioDesempenio;
        empleados[empleadosRegistrados] = new Empleado(nombre, (byte) edad, salario, promedioSimplificado);
        return true;
    }

    public static void mostrarReporte(Empleado[] empleados, int empleadosRegistrados){
        if (empleadosRegistrados == 0){
            System.out.println("Aun no hay empleados registrados");
            return;
        }

        for (int fila = 0; fila < empleadosRegistrados; fila++){
            // TASK 4: Uso del operador ternario para validar si empleado es promovido
            String estadoAprovacion = (empleados[fila].getPromedio() >= PROMEDIO_PARA_APROBAR) ? "Empleado promovido" : "Empleado no promovido";
            System.out.println(empleados[fila]);
            System.out.println("Categoria salarial: " + obtenerCategoriaSalarial(empleados[fila].getSalario()));
            System.out.println("Estado: " + estadoAprovacion);
        }

    }
}
