package semanauno.corporatetalenthub.modelo;

// Clase tradicional -> Empleado
public class Empleado {

    // DATOS -> EMPLEADO

    // Tipo referenciado
    private String nombre;

    // Tipos primitivos
    private byte nivelAcceso;
    private short anioIngreso;
    private int idEmpleado;
    private long numeroDocumento;
    private float puntajeTest;
    private double salarioBase;
    private char tipoContrato;
    private boolean esActivo;
    private int edad;

    // DATOS -> ADICIONALES
    private double bonoMensual;
    private int idSede;

    // Constructor -> Empleado
    public Empleado (String nombre,
                     byte nivelAcceso,
                     short anioIngreso,
                     int idEmpleado,
                     long numeroDocumento,
                     float puntajeTest,
                     double salarioBase,
                     char tipoContrato,
                     boolean esActivo,
                     int edad,
                     double bonoMensual,
                     int idSede) {

        this.nombre = nombre;
        this.nivelAcceso = nivelAcceso;
        this.anioIngreso = anioIngreso;
        this.idEmpleado = idEmpleado;
        this.numeroDocumento = numeroDocumento;
        this.puntajeTest = puntajeTest;
        this.salarioBase = salarioBase;
        this.tipoContrato = tipoContrato;
        this.esActivo = esActivo;
        this.edad = edad;
        this.bonoMensual = bonoMensual;
        this.idSede = idSede;
    }

    /*
        La clase tradicional es más verbosa porque requiere constructores, getters y otros métodos.
        El record ofrece una sintaxis más breve y sus componentes son inmutables, es decir,
        sus valores no pueden modificarse después de crear el objeto.
    */

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }


    public double calcularSalarioFinal(){

        /*
            Orden de ejecución:
            1. Paréntesis internos y multiplicaciones -> (bonoMensual * 1.10), (salarioBase * 0.05)
            2. Suma -> (primer resultado + salarioBase)
            3. Resta -> resultado del paso 2 menos el segundo resultado del paso 1
        */

        double salarioFinal = (salarioBase + (bonoMensual * 1.10)) - (salarioBase * 0.05);
        return salarioFinal;
    }

    public boolean bonoExtra(){
        boolean idValido = (idEmpleado % 2 == 0) ? true : false;
        return idValido;
    }

    public boolean validarElegibilidad(){
        /*
            Orden de ejecución:
            1. ! -> !esActivo
            2. && -> (puntajeTest > 85 && edad < 30)
            3. || -> resultado 1 || resultado 2ó
        */

        if ((puntajeTest > 85 && edad < 30) || (idSede == 1 && !esActivo)){
            return true;
        } else {
            return false;
        }
    }

    public double actualizarBonoMensual(double incremento) {
        // bonoMensual(nuevo valor) = bonoMensual + incremento;
        bonoMensual += incremento;
        return bonoMensual;
    }

}