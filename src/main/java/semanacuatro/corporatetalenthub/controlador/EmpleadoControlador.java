package semanacuatro.corporatetalenthub.controlador;

import semanacuatro.corporatetalenthub.servicio.EmpleadoServicio;
import semanacuatro.corporatetalenthub.vista.VistaSistema;

public class EmpleadoControlador {
    private final EmpleadoServicio servicio;
    private final VistaSistema vista;

    public EmpleadoControlador(EmpleadoServicio servicio, VistaSistema vista) {
        this.servicio = servicio;
        this.vista = vista;
    }
}
