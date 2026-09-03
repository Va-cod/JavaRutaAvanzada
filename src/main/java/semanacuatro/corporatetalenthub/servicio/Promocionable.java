package semanacuatro.corporatetalenthub.servicio;

import semanacuatro.corporatetalenthub.modelo.Persona;
import java.util.List;

public interface Promocionable {
    List<String> bonoAscenso(List<Persona> empleados);

    default String AreaDesarrollo(){
        return "Desarrollo";
    }

    default String AreaFinanzas(){
        return "Finanzas";
    }
}
