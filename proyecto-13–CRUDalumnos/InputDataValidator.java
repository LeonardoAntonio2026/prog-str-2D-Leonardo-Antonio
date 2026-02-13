import java.util.Scanner;

public class InputDataValidator {
    
    /**
     * Lee un string no vacío
     * @param sc Scanner para input
     * @param msg Mensaje a mostrar al usuario
     * @return String validado (no vacío)
     */
    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Error: El texto no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }
    
    /**
     * Lee un double dentro de un rango específico
     * @param sc Scanner para input
     * @param msg Mensaje a mostrar al usuario
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return Valor double validado
     */
    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg + " [" + min + " - " + max + "]: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Error: Pon un número decimal válido.");
                System.out.print(msg + " [" + min + " - " + max + "]: ");
                sc.next();
            }
            valor = sc.nextDouble();
            if (valor < min || valor > max) {
                System.out.println("Error: El valor debe estar entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);
        sc.nextLine(); 
        return valor;
    }
    
    /**
     * Lee un int dentro de un rango específico
     * @param sc Scanner para input
     * @param msg Mensaje a mostrar al usuario
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return Valor int validado
     */
    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg + " [" + min + " - " + max + "]: ");
            while (!sc.hasNextInt()) {
                System.out.println("Error: Pon un número entero válido.");
                System.out.print(msg + " [" + min + " - " + max + "]: ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < min || valor > max) {
                System.out.println("Error: El valor debe estar entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);
        sc.nextLine(); // Consumir el salto de línea
        return valor;
    }

    public static int leerIntDespuesDe(Scanner sc, String msg, int min) {
        int valor;
        do {
            System.out.print(msg + " [mayor o igual a " + min + "]: ");
            while (!sc.hasNextInt()) {
                System.out.println("Error: Pon un número entero válido.");
                System.out.print(msg + " [mayor o igual a " + min + "]: ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < min) {
                System.out.println("Error: El valor debe ser mayor o igual a " + min);
            }
        } while (valor < min);
        sc.nextLine(); 
        return valor;
    }
    
    /**
     * Lee un boolean (solo acepta true/false)
     * @param sc Scanner para input
     * @param msg Mensaje a mostrar al usuario
     * @return Valor boolean validado
     */
    public static boolean leerBoolean(Scanner sc, String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine().trim().toLowerCase();
            if (!input.equals("true") && !input.equals("false")) {
                System.out.println("Error: Debe ingresar 'true' o 'false'.");
            }
        } while (!input.equals("true") && !input.equals("false"));
        return Boolean.parseBoolean(input);
    }
}