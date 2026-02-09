import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService gradeService = new GradeService();
        
        // I
        String nombre = InputDataValidator.leerTextoNoVacio(sc, "Introduce el nombre del alumno: ");
        
        double promedio1 = InputDataValidator.leerDoubleEnRango(sc, "Ingrese la primera calificación", 0, 100);
        double promedio2 = InputDataValidator.leerDoubleEnRango(sc, "Ingrese la segunda calificación", 0, 100);
        double promedio3 = InputDataValidator.leerDoubleEnRango(sc, "Ingrese la tercera calificación", 0, 100);
        
        int asistencia = InputDataValidator.leerIntEnRango(sc, "Ingrese el total de asistencias", 0, 100);
        
        boolean entregoProyecto = InputDataValidator.leerBoolean(sc, "Entregó el proyecto? (true/false): ");
        
        // P
        double promedio = gradeService.calcularPromedio(promedio1, promedio2, promedio3);
        double calificacionFinal = gradeService.calcularFinal(promedio, asistencia);
        String estado = gradeService.determinarEstado(calificacionFinal, asistencia, entregoProyecto);
        
        // O
        imprimirReporte(nombre, promedio1, promedio2, promedio3, promedio, asistencia, entregoProyecto, calificacionFinal, estado);
        
        sc.close();
    }
    
    public static void imprimirReporte(String nombre, double promedio1, double promedio2, double promedio3, 
                                     double promedio, int asistencia, boolean entregoProyecto, 
                                     double calificacionFinal, String estado) {
        System.out.println("\n=== REPORTE DE CALIFICACIONES ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Parciales: " + String.format("%.2f, %.2f, %.2f", promedio1, promedio2, promedio3));
        System.out.println("Promedio de parciales: " + String.format("%.2f", promedio));
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + (entregoProyecto ? "Sí" : "No"));
        System.out.println("Calificación final: " + String.format("%.2f", calificacionFinal));
        System.out.println("Estado: " + estado);
      
    }
}