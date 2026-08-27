package semanatres.corporatetalenthub;

import semanatres.corporatetalenthub.modelo.Empleado;

import java.util.*;

public class App {
    // Variables constantes
    private static final byte TOTAL_TRIMESTRES = 3;
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;
    private static final double PROMEDIO_PARA_APROBAR = 8.0;

    public static void main(String[] args) {

        var opcion = 0;

        try (Scanner scanner = new Scanner(System.in)) {
        // TASK 1: Uso de ArrayList() y HashMap(), para crear estructuras de datos dinámicos
        List<Empleado> empleadosList = new ArrayList<>();
        Map<Integer, Empleado> empleadosMap = new HashMap<>();
            do {
                try {
                    System.out.print("\nIngrese una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcion) {
                        case 1:
                            registrarEmpleado(empleadosList, empleadosMap, scanner);
                            break;
                        case 2:
                            listarEmpleados(empleadosList, empleadosMap);
                            break;
                        case 3:
                            eliminarEmpleado(empleadosList, empleadosMap, scanner);
                            break;
                        default:
                            System.out.print("Ingrese un valor entre 1 y 4");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.print("\n¡Error! Ingrese el valor adecuado\n");
                    scanner.nextLine();
                }


            } while (opcion != 4);
        }
    }

    public static void verCategoriaSalarial(){
        System.out.print("""
                    * * * * CATEGORÍAS SALARIALES * * * *
                    JUNIOR: <= 3.000.000 COP
                    SENIOR: 3.000.000 - 5.000.00 COP
                    EXPERT: > 5.000.000 COP
                    """);
    }

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

    // TASK 1
    // Método static: registrar empleados y almacenarlos en colecciones list y map
    public static boolean registrarEmpleado(List<Empleado> empleadosList, Map<Integer, Empleado> empleadosMap, Scanner scanner){
        System.out.println("\n* * * * REGISTRO DE EMPLEADOS * * * *");
        var calificacion = 0.0;
        var sumaCalificaciones = 0.0;
        var promedioCalificaciones = 0.0;

        // Validación para los atributos que tendrá el objeto creado
        System.out.print("Nombre: ");
        var nombre = scanner.nextLine().trim();
        if (nombre.isBlank()){
            System.out.println("- - - - - Registro invalido - - - - - ");
            return false;
        }

        System.out.print("Edad [18-65]: ");
        var edad = scanner.nextInt();
        if (edad < 18 || edad > 65){
            System.out.println("- - - - - Registro invalido - - - - - ");
            return false;
        }

        System.out.print("Salario : ");
        var salario = scanner.nextInt();
        if (salario < 0){
            System.out.println("- - - - - Registro invalido - - - - - ");
            return false;
        }

        // Bucle for para registrar las calificaciones de cada trimestre
        for (var trimestre = 0; trimestre < TOTAL_TRIMESTRES; trimestre++) {
            System.out.print("Calificación " + (trimestre + 1) + ": ");
            calificacion = scanner.nextDouble();

            if (calificacion < NOTA_MINIMA || calificacion > NOTA_MAXIMA){
                System.out.print("Registro invalido");
                return false;
            }
            sumaCalificaciones += calificacion;
        }

        // Operación para calcular el promedio de cada empleado
        promedioCalificaciones = sumaCalificaciones / TOTAL_TRIMESTRES;

        // Crear el objeto después de realizar las validaciones y almacenarlo en una variable
        var empleado = new Empleado(nombre, (byte) edad, salario, promedioCalificaciones);

        // Almacenar la variable 'empleado' en una list
        empleadosList.add(empleado);

        // Almacenar la variable 'empleado' en un map
        empleadosMap.put(empleado.getId(), empleado);

        System.out.println("- - - - - Registro exitoso - - - - -");

        return true;
    }

    // TASK 1
    // Método static: listar empleados
    public static void listarEmpleados(List<Empleado> empleadosList, Map<Integer, Empleado> empleadosMap){

        // Validar si hay empleados registrados
        if (empleadosList.isEmpty()){
            System.out.print("Aun no hay empleados registrados");
            return;
        }

        // Uso de forEach para recorrer el Map y listar cada empleado
        empleadosMap.forEach((clave, valor) -> {
            System.out.println(clave + ":" + valor);
        });
    }

    // TASK 1
    // Método static: buscar empleados
    public static boolean buscarEmpleado(Map<Integer, Empleado> empleadosMap, Integer idEmpleado){
        return empleadosMap.containsKey(idEmpleado);
    }

    // TASK 1
    // Método static: eliminar empleados
    public static void eliminarEmpleado(List<Empleado> empleadosList, Map<Integer, Empleado> empleadosMap, Scanner scanner){
        System.out.println("\n* * * * ELIMINAR EMPLEADOS * * * *");

        System.out.print("ID empleado: ");
        Integer idEmpleado = scanner.nextInt();
        var resultado = buscarEmpleado(empleadosMap, idEmpleado);

        if (empleadosList.isEmpty()){
            System.out.println("Resultado: no hay empleados para eliminar");
        } else if (!resultado){
            System.out.println("Resultado: empleado no encontrado");
        } else {
            empleadosMap.remove(idEmpleado);
            empleadosList.removeIf(objeto -> objeto.getId() == idEmpleado);
            System.out.println("Resultado: empleado eliminado");
        }

    }
}


