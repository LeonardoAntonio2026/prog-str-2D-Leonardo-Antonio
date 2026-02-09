public class GradeService {
    
    public double calcularPromedio(double calfA, double calfB, double calfC) {
        return (calfA + calfB + calfC) / 3.0;
    }
    

    public double calcularFinal(double promedio, int asistencia) {
        return (promedio * 0.7) + (asistencia * 0.3);
    }
    

    public String determinarEstado(double calificacionFinal, int asistencia, boolean entregoProyecto) {
       
        if (asistencia < 80) {
            return "REPROBADO por asistencia...";
        }
        
        
        if (!entregoProyecto) {
            return "REPROBADO no entregó proyecto!!";
        }
        
        if (calificacionFinal >= 70) {
            return "APROBADO muy bien";
        } else {
            return "REPROBADO por calificación";
        }
    }
}