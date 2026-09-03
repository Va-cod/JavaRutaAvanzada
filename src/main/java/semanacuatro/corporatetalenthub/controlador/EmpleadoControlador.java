package semanacuatro.corporatetalenthub.controlador;

import semanacuatro.corporatetalenthub.modelo.*;
import semanacuatro.corporatetalenthub.servicio.EmpleadoServicio;
import semanacuatro.corporatetalenthub.vista.VistaSistema;

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
                    break;
                case 3:
                    registrarConsultorExterno();
                    break;
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
                    eliminarEmpleadosNoPromovidos();
                    break;
                case 8:
                    mostrarReporte();
                    break;
                case 9:
                    mostrarEmpleadosPromovidos();
                    break;
                case 10:
                    mostrarEmpleadoArea();
                    break;
                case 11:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
            }
        } while (opcion != 10);
    }

    private void registrarDesarrollador() {
        vista.mostrarMensaje("\n* * * * * Registrar Desarrollador * * * * *");
        String nombre = vista.solicitarNombre();
        int edad = vista.solicitarEdad();
        double salario = vista.solicitarSalario();
        String lenguajePrinciapl = vista.solicitarLenguajePrincipal();

        var sumaCalificacion = 0.0;
        for (var trimestre = 0; trimestre < TOTAL_TRIMESTRES; trimestre++) {
            double calificacion = vista.solicitarCalificacion(trimestre + 1);
            if (calificacion < NOTA_MINIMA || calificacion > NOTA_MAXIMA){
                vista.mostrarMensaje("Ingrese una nota entre 1 y 10");
                return;
            }
            sumaCalificacion += calificacion;
        }
        double promedioDesempeno = sumaCalificacion / TOTAL_TRIMESTRES;

        Persona empleado = new Desarrollador(nombre, edad, promedioDesempeno, salario, lenguajePrinciapl);
        servicio.agregarEmpleado(empleado);

        var id = empleado.getId();
        var promedio = empleado.getPromedioDesempeno();
        var feedback = (empleado.getPromedioDesempeno() > PROMEDIO_PARA_APROBAR) ? "Promovido" : "No promovido";
        DesempenoReporte reporte = new DesempenoReporte(id, promedio, feedback);
        servicio.agregarReporte(reporte);

        vista.mostrarMensaje("Empleado registrado correctamente");
    }


    private void registrarGerente() {
        vista.mostrarMensaje("\n* * * * * Registrar Gerente * * * * *");
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

        var id = empleado.getId();
        var promedio = empleado.getPromedioDesempeno();
        var feedback = (empleado.getPromedioDesempeno() > PROMEDIO_PARA_APROBAR) ? "Promovido" : "No promovido";
        DesempenoReporte reporte = new DesempenoReporte(id, promedio, feedback);
        servicio.agregarReporte(reporte);

        vista.mostrarMensaje("Empleado registrado correctamente");
    }

    private void registrarConsultorExterno() {
        vista.mostrarMensaje("\n* * * * * Registrar Consultor Externo * * * * *");
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

        var id = empleado.getId();
        var promedio = empleado.getPromedioDesempeno();
        var feedback = (empleado.getPromedioDesempeno() > PROMEDIO_PARA_APROBAR) ? "Promovido" : "No promovido";
        DesempenoReporte reporte = new DesempenoReporte(id, promedio, feedback);
        servicio.agregarReporte(reporte);

        vista.mostrarMensaje("Empleado registrado correctamente");
    }

    public void listarEmpleados(){
        vista.mostrarMensaje("\n* * * * * Listar Empleados * * * * *");
        var resultado = servicio.estadoLista();

        if (resultado){
            var empleadosList = servicio.obtenerEmpleados();
            vista.mostrarLista(empleadosList);
        } else {
            vista.mostrarMensaje("Aun no hay empleados registrados");
        }
    }

    public void eliminarEmpleado() {
        vista.mostrarMensaje("* * * * * Eliminar Empleados * * * * *");
        if (!servicio.estadoLista()) {
            vista.mostrarMensaje("No hay empleados registrados");
            return;
        }

        int id = vista.solicitarId();

        if (!servicio.buscarEmpleado(id)) {
            vista.mostrarMensaje("No existe un empleado con el ID: " + id);
            return;
        }

        servicio.eliminarEmpleado(id);
        servicio.eliminarReporte(id);
        vista.mostrarMensaje("El empleado fue eliminado");
    }

    public void listarSedesTecnologias(){
        var tecnologias = servicio.mostrarTecnologias();
        var sedes = servicio.mostrarSedes();

        vista.mostrarTecnologias(tecnologias);
        vista.mostrarSedes(sedes);
    }

    public void mostrarReporte(){
        vista.mostrarMensaje("\n* * * * * Reporte General * * * * *");
        if (!servicio.estadoLista()) {
            vista.mostrarMensaje("No hay empleados registrados");
            return;
        }
        vista.mostrarReporte(servicio.mostrarReporte());
    }

    public void eliminarEmpleadosNoPromovidos() {
        vista.mostrarMensaje("\n* * * * ELIMINAR EMPLEADOS NO PROMOVIDOS * * * *");

        var empleadosList = servicio.obtenerEmpleados();

        boolean empleadosEliminados = empleadosList.removeIf(empleado -> empleado.getPromedioDesempeno() < PROMEDIO_PARA_APROBAR);

        if (empleadosEliminados) {
            System.out.println("Empleados no promovidos eliminados correctamente");
        } else {
            System.out.println("No hay empleados para eliminar");
        }
    }

    public void mostrarEmpleadosPromovidos(){
        vista.mostrarMensaje("\n* * * * EMPLEADOS PROMOVIDOS * * * *");
        var empleadosList = servicio.obtenerEmpleados();
        var bonos = servicio.bonoAscenso(empleadosList);
        vista.mostrarBonos(bonos);
    }

    public void mostrarEmpleadoArea(){
        var empleadosList = servicio.obtenerEmpleados();
        var departamentos = servicio.departamentos(empleadosList);
        vista.mostrarBonos(departamentos);

    }







}
