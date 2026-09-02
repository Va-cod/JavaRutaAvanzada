package semanacuatro.corporatetalenthub.controlador;

import semanacuatro.corporatetalenthub.modelo.ConsultorExterno;
import semanacuatro.corporatetalenthub.modelo.Desarrollador;
import semanacuatro.corporatetalenthub.modelo.Gerente;
import semanacuatro.corporatetalenthub.servicio.EmpleadoServicio;
import semanacuatro.corporatetalenthub.vista.VistaSistema;
import semanacuatro.corporatetalenthub.modelo.Persona;

import java.util.List;


public class EmpleadoControlador {
    private static final byte TOTAL_TRIMESTRES = 3;
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;
    private static final double PROMEDIO_PARA_APROBAR = 8.0;


    private final EmpleadoServicio servicio;
    private final VistaSistema vista;

    public EmpleadoControlador(EmpleadoServicio servicio, VistaSistema vista) {
        this.servicio = servicio;
        this.vista = vista;
    }

    public void iniciar() {

        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    registrarDesarrollador();
                    break;
                case 2:
                    registrarGerente();
                case 3:
                    registrarConsultorExterno();
                case 4:
                    listarEmpleados();
                    break;
                case 5:
                    eliminarEmpleado();
                    break;
                case 6:
                    listarSedesTecnologias();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void registrarDesarrollador() {

        String nombre = vista.solicitarNombre();
        int edad = vista.solicitarEdad();
        double salario = vista.solicitarSalario();
        String lenguajePrinciapl = vista.solicitarLenguajePrincipal();

        var sumaCalificacion = 0.0;
        for (var trimestre = 0; trimestre < TOTAL_TRIMESTRES; trimestre++) {
            double calificacion = vista.solicitarCalificacion(trimestre + 1);
            if (calificacion < NOTA_MINIMA || calificacion > NOTA_MAXIMA){
                System.out.print("Registro invalido");
                return;
            }
            sumaCalificacion += calificacion;
        }
        double promedioDesempeno = sumaCalificacion / TOTAL_TRIMESTRES;

        Persona empleado = new Desarrollador(nombre, edad, promedioDesempeno, salario, lenguajePrinciapl);
        servicio.agregarEmpleado(empleado);

        vista.mostrarMensaje("Empleado registrado correctamente.");
    }


    private void registrarGerente() {

        String nombre = vista.solicitarNombre();
        int edad = vista.solicitarEdad();
        double salario = vista.solicitarSalario();
        double presupuestoMensual = vista.solicitarPresupuestoMensual();

        var sumaCalificacion = 0.0;
        for (var trimestre = 0; trimestre < TOTAL_TRIMESTRES; trimestre++) {
            double calificacion = vista.solicitarCalificacion(trimestre + 1);
            if (calificacion < NOTA_MINIMA || calificacion > NOTA_MAXIMA){
                System.out.print("Registro invalido");
                return;
            }
            sumaCalificacion += calificacion;
        }
        double promedioDesempeno = sumaCalificacion / TOTAL_TRIMESTRES;

        Persona empleado = new Gerente(nombre, edad, promedioDesempeno, salario, presupuestoMensual);
        servicio.agregarEmpleado(empleado);

        vista.mostrarMensaje("Empleado registrado correctamente.");
    }

    private void registrarConsultorExterno() {
        String nombre = vista.solicitarNombre();
        int edad = vista.solicitarEdad();

        var sumaCalificacion = 0.0;
        for (var trimestre = 0; trimestre < TOTAL_TRIMESTRES; trimestre++) {
            double calificacion = vista.solicitarCalificacion(trimestre + 1);
            if (calificacion < NOTA_MINIMA || calificacion > NOTA_MAXIMA){
                System.out.print("Registro invalido");
                return;
            }
            sumaCalificacion += calificacion;
        }
        double promedioDesempeno = sumaCalificacion / TOTAL_TRIMESTRES;

        Persona empleado = new ConsultorExterno(nombre, edad, promedioDesempeno);
        servicio.agregarEmpleado(empleado);

        vista.mostrarMensaje("Empleado registrado correctamente.");
    }

    public void listarEmpleados(){
       var empleadosList = servicio.obtenerEmpleados();
       vista.mostrarLista(empleadosList);
    }

    public void eliminarEmpleado(){
        int id = vista.solicitarId();
        var resultado = servicio.buscarEmpleado(id);

        if (resultado) {
            servicio.eliminarEmpleado(id);
        } else {
            vista.mostrarMensaje("El empleado no existe");
        }

    }

    public void listarSedesTecnologias(){
        var tecnologias = servicio.mostrarTecnologias();
        var sedes = servicio.mostrarSedes();

        vista.mostrarTecnologias(tecnologias);
        vista.mostrarSedes(sedes);
    }







}
