package semanatres.corporatetalenthub;

import semanatres.corporatetalenthub.modelo.Empleado;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    // Variables constantes
    private static final byte TOTAL_TRIMESTRES = 3;
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;
    private static final double PROMEDIO_PARA_APROBAR = 8.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TASK 1: Uso de ArrayList() y HashMap(), para crear estructuras de datos dinámicos
        List<Empleado> empleadosList = new ArrayList<>();
        Map<Integer, Empleado> empleadosMap = new HashMap<>();
        registrarEmpleado(empleadosList, empleadosMap, scanner);
        System.out.print(empleadosList);
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

    public static boolean registrarEmpleado(List<Empleado> empleadosList, Map<Integer, Empleado> empleadosMap, Scanner scanner){
        var calificacion = 0.0;
        var sumaCalificaciones = 0.0;
        var promedioCalificaciones = 0.0;

        System.out.print("Nombre: ");
        var nombre = scanner.nextLine().trim();
        if (nombre.isBlank()){
            System.out.print("¡Error! Escriba un nombre válido");
            return false;
        }

        System.out.print("Edad: ");
        var edad = scanner.nextInt();
        if (edad < 18 || edad > 65){
            System.out.print("¡Error! Edad inválida para trabajar");
            return false;
        }

        System.out.print("Salario: ");
        var salario = scanner.nextInt();
        if (salario < 0){
            System.out.print("¡Error! El salario no puede ser negativo");
            return false;
        }

        for (var trimestre = 0; trimestre < TOTAL_TRIMESTRES; trimestre++) {
            System.out.print("Calificación " + (trimestre + 1) + ": ");
            calificacion = scanner.nextDouble();

            if (calificacion < NOTA_MINIMA || calificacion > NOTA_MAXIMA){
                System.out.print("¡Error! Debe ingresar una nota en este rango [0 - 10]");
                return false;
            }
            sumaCalificaciones += calificacion;
        }

        promedioCalificaciones = sumaCalificaciones / TOTAL_TRIMESTRES;
        empleadosList.add(new Empleado(nombre, (byte) edad, salario, promedioCalificaciones));
        empleadosMap.put(empleadosList.get(0).getId(), new Empleado(nombre, (byte) edad, salario, promedioCalificaciones));

        return true;
    }
}


