import java.util.Scanner;

public class ConversorMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        int celciusAF = 0;
        int farenheitAC = 0;
        int kmAMillas = 0;
        int millasAKm = 0;
        int totalConversiones = 0;

        do {
            System.out.println("\nElije una conversion");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.print("Elige una opción: ");


            while (!sc.hasNextInt()) {
                System.out.print("Opción inválida. Ingresa un número del 1 al 5: ");
                sc.next();
            }

            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("Esa Opción no existeee. Intenta de nuevo.");
                continue;
            }

            double valor, resultado;

            switch (opcion) {
                case 1:
                    valor = pedirNumero(sc, "Ingresa grados Celsius: ");
                    resultado = (valor * 9 / 5) + 32;
                    System.out.println("Resultado: " + resultado + " °F");
                    celciusAF++;
                    totalConversiones++;
                    break;

                case 2:
                    valor = pedirNumero(sc, "Ingresa grados Fahrenheit: ");
                    resultado = (valor - 32) * 5 / 9;
                    System.out.println("Resultado: " + resultado + " °C");
                    farenheitAC++;
                    totalConversiones++;
                    break;

                case 3:
                    valor = pedirNumero(sc, "Ingresa kilómetros: ");
                    resultado = valor * 0.621371;
                    System.out.println("Resultado: " + resultado + " Millas");
                    kmAMillas++;
                    totalConversiones++;
                    break;

                case 4:
                    valor = pedirNumero(sc, "Ingresa millas: ");
                    resultado = valor / 0.621371;
                    System.out.println("Resultado: " + resultado + " Km");
                    millasAKm++;
                    totalConversiones++;
                    break;

                case 5:
                    System.out.println("\nSaliendo...");
                    break;
            }

        } while (opcion != 5);

        System.out.println("Total de conversiones: " + totalConversiones);
        System.out.println("°C a °F: " + celciusAF);
        System.out.println("°F a °C: " + farenheitAC);
        System.out.println("Km a Millas: " + kmAMillas);
        System.out.println("Millas a Km: " + millasAKm);

        sc.close();
    }


    public static double pedirNumero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.print("Dato inválido. Ingresa un número: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
