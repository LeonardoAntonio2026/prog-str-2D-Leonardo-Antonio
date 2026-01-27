import java.util.Scanner;

public class Main {

    public static final int EDAD_MINIMA = 0;
    public static final int EDAD_MAXIMA = 120;

    public static final int LIMITE_NINO = 12;
    public static final int LIMITE_ADOLESCENTE = 17;

    public static final int TARIFA_NINO = 50;
    public static final int TARIFA_ADOLESCENTE_ESTUDIANTE = 60;
    public static final int TARIFA_ADOLESCENTE_NO_ESTUDIANTE = 80;
    public static final int TARIFA_ADULTO_ESTUDIANTE = 90;
    public static final int TARIFA_ADULTO_NO_ESTUDIANTE = 120;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa tu edad: ");
        int edad = scanner.nextInt();

        System.out.print("¿Eres estudiante? (true/false): ");
        boolean esEstudiante = scanner.nextBoolean();

        // Validación de edad
        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            System.out.println("Edad inválida");
            return;
        }

        int tarifa = calcularTarifa(edad, esEstudiante);

        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Tarifa final: " + tarifa);
    }

    /**
     * Calcula la tarifa según la edad y si es estudiante.
     *
     * @param edad          Edad del usuario
     * @param esEstudiante  usuario es estudiante
     * @return La tarifa correspondiente según las reglas
     */
    public static int calcularTarifa(int edad, boolean esEstudiante) {
        if (edad < LIMITE_NINO) {
            return TARIFA_NINO;
        } else if (edad <= LIMITE_ADOLESCENTE) {
            return esEstudiante ? TARIFA_ADOLESCENTE_ESTUDIANTE : TARIFA_ADOLESCENTE_NO_ESTUDIANTE;
        } else {
            return esEstudiante ? TARIFA_ADULTO_ESTUDIANTE : TARIFA_ADULTO_NO_ESTUDIANTE;
        }
    }
}
