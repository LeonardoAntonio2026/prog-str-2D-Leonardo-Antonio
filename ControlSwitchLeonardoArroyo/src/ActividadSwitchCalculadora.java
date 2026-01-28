import java.util.Scanner;

public class CalculadoraSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora!!");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println();

        System.out.print("Selecciona una opción (1-4): ");
        int opcion = scanner.nextInt();

        System.out.print("Ingresa el primer número: ");
        double numeroA = scanner.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        double numeroB = scanner.nextDouble();

        System.out.println();

        double resultado = 0;
        boolean esValido = true;
        switch (opcion) {
            case 1:
                resultado = numeroA + numeroB;
                System.out.println("1. Sumar");
                break;

            case 2:
                resultado = numeroA - numeroB;
                System.out.println("2. Restar");
                break;

            case 3:
                resultado = numeroA * numeroB;
                System.out.println("3. Multiplicar");
                break;

            case 4:
                System.out.println("4. Dividir");
                if (numeroB == 0) {
                    System.out.println("Noooo se puede dividir entre cero");
                    esValido = false;
                }
                else {
                    resultado = numeroA / numeroB;
                }
                break;

            default:
                esValido = false;
                System.out.println("Opción inválida");
                break;
        }

        if (esValido) {

            System.out.println("numero A = " + numeroA);
            System.out.println("numero B = " + numeroB);
            System.out.println("Resultado: " + resultado);

        }
        else{
            System.out.println("RESULTADO NO EXISTENTE");
        }

        scanner.close();
    }
}