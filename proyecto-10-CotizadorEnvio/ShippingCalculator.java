class ShippingCalculator {
    
    /**
     * Calcula el subtotal del envío
     * @param pesoKg Peso del paquete
     * @param distanciaKm Distancia del envío
     * @param tipoServicio Tipo de servicio (1=Estándar, 2=Express)
     * @param zonaRemota Si es zona remota
     * @return Subtotal antes de IVA
     */
    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
       
        double costoBase;
        if (tipoServicio == 1) {
            costoBase = 50.0; 
        } else {
            costoBase = 90.0; 
        }
        
     
        double costoPeso = pesoKg * 12.0;
        
        
        double costoDistancia;
        if (distanciaKm <= 50) {
            costoDistancia = 20.0;
        } else if (distanciaKm <= 200) {
            costoDistancia = 60.0;
        } else {
            costoDistancia = 120.0;
        }
        
       
        double subtotalBase = costoBase + costoPeso + costoDistancia;
        
        double subtotalFinal;
        if (zonaRemota) {
            subtotalFinal = subtotalBase * 1.10; // +10%
        } else {
            subtotalFinal = subtotalBase;
        }
        
        return subtotalFinal;
    }
    
    /**
     * Calcula el IVA sobre el subtotal
     * @param subtotal Subtotal sobre el cual calcular IVA
     * @return Monto del IVA
     */
    public double calcularIVA(double subtotal) {
        return subtotal * 0.16;
    }
    
    /**
     * Calcula el total final
     * @param subtotal Subtotal antes de IVA
     * @param iva Monto del IVA
     * @return Total final
     */
    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}