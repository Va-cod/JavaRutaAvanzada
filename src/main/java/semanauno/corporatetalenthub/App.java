package semanauno.corporatetalenthub;
import javax.swing.JOptionPane;
import semanauno.corporatetalenthub.modelo.Empleado;
import semanauno.corporatetalenthub.modelo.EmpresaRecord;

public class App {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Carlos Sainz", (byte) 5, (short) 2026, 102, 1234L, 85.2f, 5500, 'A', false, 35, 1200, 1);
        double salarioFinal = empleado1.calcularSalarioFinal();
        String bonoExtra = (empleado1.bonoExtra()) ? "disponible" : "no disponible";
        String esElegible = (empleado1.validarElegibilidad()) ? "sí" : "no";
        double incremento = 850;
        double bonoIncrementado = empleado1.actualizarBonoMensual(incremento);

        JOptionPane.showMessageDialog(null, String.format("""
                                                        Nombre: %s
                                                        Edad: %d
                                                        Salario final: $%.2f
                                                        Bono extra: %s
                                                        Elegible: %s
                                                        Bono extra (incrementado): %.2f
                                                        """,
                                                        empleado1.getNombre(),
                                                        empleado1.getEdad(),
                                                        salarioFinal,
                                                        bonoExtra,
                                                        esElegible,
                                                        bonoIncrementado));

        EmpresaRecord miEmpresa = new EmpresaRecord("Scuderia Ferrari", "900123456-1", 2020);
        String mensaje = "Empresa: " + miEmpresa.nombre() + "\nNIT: " + miEmpresa.nit() + "\nAño de fundacion: " + miEmpresa.anioFundacion();
        JOptionPane.showMessageDialog(null, mensaje);
    }
}

