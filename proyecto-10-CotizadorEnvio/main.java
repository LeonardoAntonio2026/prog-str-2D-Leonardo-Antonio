import java.util.Scanner;


public class main {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calculator = new ShippingCalculator();
        
        System.out.println("=== COTIZADOR DE ENVÍOS ===");
        System.out.println();
        
     
        // INPUT
        double pesoKg = InputDataValidator.leerDoubleEnRango(sc, "Ingrese el peso del paquete (kg)", 0.1, 50.0);
        int distanciaKm = InputDataValidator.leerIntEnRango(sc, "Ingrese la distancia de envío (km)", 1, 2000);
        int tipoServicio = InputDataValidator.leerIntEnRango(sc, "Seleccione tipo de servicio (1=Estándar, 2=Express)", 1, 2);
        boolean esZonaRemota = InputDataValidator.leerBoolean(sc, "¿Es zona remota? (true/false)");
        
        // P
        double subtotal = calculator.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = calculator.calcularIVA(subtotal);
        double total = calculator.calcularTotal(subtotal, iva);
        
        // OUTPUT
        
        imprimirTicket(pesoKg, distanciaKm, tipoServicio, esZonaRemota, subtotal, iva, total);
        
        sc.close();
    }
    

    

    
    /**
     * Imprime el ticket de envío con todos los detalles
     * @param pesoKg Peso del paquete
     * @param distanciaKm Distancia de envío
     * @param tipoServicio Tipo de servicio 
     * @param esZonaRemota Si es zona remota
     * @param subtotal Subtotal antes de IVA
     * @param iva Monto del IVA
     * @param total Total final
     */
    public static void imprimirTicket(double pesoKg, int distanciaKm, int tipoServicio, 
                                     boolean esZonaRemota, double subtotal, double iva, double total) {
        System.out.println();
        System.out.println("        TICKET DE ENVÍO");
        System.out.println();
        
 
        String nombreServicio;
        if (tipoServicio == 1) {
            nombreServicio = "Estándar";
        } else {
            nombreServicio = "Express";
        }
        
        System.out.printf("Servicio:    %s%n", nombreServicio);
        System.out.printf("Peso:        %.2f kg%n", pesoKg);
        System.out.printf("Distancia:   %d km%n", distanciaKm);
        
       
        String textoZonaRemota;
        if (esZonaRemota) {
            textoZonaRemota = "Sí";
        } else {
            textoZonaRemota = "No";
        }
        System.out.printf("Zona remota:     %s%n", textoZonaRemota);
        
        System.out.println();
        System.out.printf("Subtotal:        $%.2f%n", subtotal);
        System.out.printf("IVA (16%%):       $%.2f%n", iva);
        System.out.println();
        System.out.printf("TOTAL:           $%.2f%n", total);
        System.out.println();
    }
}




