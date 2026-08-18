package semanauno.corporatetalenthub.documentacion;

// 1. JAVA 8 vs JAVA 17-21

/*
    Java 8 (Legacy) está orientado a mantener la compatibilidad con sistemas
    tradicionales y se basa en un enfoque clásico de programación orientada a objetos,
    donde el desarrollador debe escribir gran parte del código de forma manual,
    como constructores, métodos de acceso (getters y setters) y otras estructuras
    repetitivas. En cambio, Java 17/21 (LTS Actual) busca aumentar la productividad
    y la calidad del software mediante una sintaxis más moderna y herramientas que
    reducen el código repetitivo, como los **Records**, además de incorporar mejoras
    en rendimiento, seguridad y concurrencia. En resumen, mientras Java 8 prioriza la
    estabilidad y el soporte para aplicaciones heredadas, Java 17/21 se enfoca en facilitar
    el desarrollo de aplicaciones modernas con un código más limpio, legible y fácil
    de mantener.
*/

// 2. JVM - GARBAGE COLLECTOR

/*
    La Java Virtual Machine (JVM) es el entorno de ejecución encargado de administrar
    los recursos utilizados por una aplicación Java, entre ellos la memoria donde se
    almacenan los objetos creados durante la ejecución del programa. Cada vez que se
    instancia un objeto mediante la palabra clave new, este se almacena en una región
    de memoria denominada Heap. La JVM supervisa continuamente el uso de esta memoria
    para garantizar un funcionamiento eficiente de la aplicación.

    Como parte de este proceso, la JVM utiliza el Garbage Collector (GC), un mecanismo
    automático de gestión de memoria cuya función es identificar y eliminar los objetos
    que ya no son utilizados por el programa. Cuando un objeto deja de tener referencias
    activas, el Garbage Collector lo considera elegible para su eliminación y libera el
    espacio que ocupaba en el Heap, permitiendo que dicha memoria sea reutilizada por nuevos
    objetos. Este proceso se realiza de manera automática, sin intervención del desarrollador,
    lo que reduce el riesgo de fugas de memoria y mejora la estabilidad de las aplicaciones.
    En conjunto, la JVM y el Garbage Collector optimizan el uso de la memoria al administrar la
    creación, el almacenamiento y la liberación de los objetos, contribuyendo a un mejor
    rendimiento y una ejecución más eficiente del sistema.
*/

public final class NotasArquitectura {

    private NotasArquitectura() {

    }

}