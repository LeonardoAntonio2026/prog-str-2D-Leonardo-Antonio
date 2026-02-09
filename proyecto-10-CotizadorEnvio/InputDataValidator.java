import java.util.Scanner;

public class InputDataValidator {
    
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
                System.out.println("Error: Ingrese un número decimal válido.");
                System.out.print(msg + " [" + min + " - " + max + "]: ");
                sc.next();
            }
            valor = sc.nextDouble();
            if (valor < min || valor > max) {
                System.out.println("Error: El valor debe estar entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);
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
                System.out.println("Error: Ingrese un número entero válido.");
                System.out.print(msg + " [" + min + " - " + max + "]: ");
                sc.next();
            }
            valor = sc.nextInt();
            if (valor < min || valor > max) {
                System.out.println("Error: El valor debe estar entre " + min + " y " + max);
            }
        } while (valor < min || valor > max);
        return valor;
    }
    
    /**
     * Lee un boolean (solo acepta true/false)
     * @param sc Scanner para input
     * @param msg Mensaje a mostrar al usuario
     * @return Valor boolean validado
     */
    public static boolean leerBoolean(Scanner sc, String msg) {
        boolean valor;
        System.out.print(msg + " ");
        while (!sc.hasNextBoolean()) {
            System.out.println("Error: Ingrese 'true' o 'false'.");
            System.out.print(msg + " ");
            sc.next();
        }
        valor = sc.nextBoolean();
        return valor;
    }
}