package semanacuatro.corporatetalenthub;

import semanacuatro.corporatetalenthub.controlador.EmpleadoControlador;
import semanacuatro.corporatetalenthub.servicio.EmpleadoServicio;
import semanacuatro.corporatetalenthub.vista.VistaSistema;

public class Main {
    public static void main(String[] args) {

        EmpleadoServicio servicio = new EmpleadoServicio();

        VistaSistema vista = new VistaSistema();

        EmpleadoControlador controlador = new EmpleadoControlador(servicio, vista);

        controlador.iniciar();

    }
}




