import java.util.Scanner;

public class CalculadoraSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
        System.out.println();

        System.out.print("Selecciona una opción (1-4): ");
        int opcion = scanner.nextInt();

        System.out.print("Ingresa el primer número: ");
        double numeroA = scanner.nextDouble();

        System.out.print("Ingresa el segundo número: ");
        double numeroB = scanner.nextDouble();

        System.out.println();

        double resultado = 0;
        boolean valido = true;
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
                    System.out.println("No se puede dividir entre cero");
                    valido = false;
                } else {
                    resultado = numeroA / numeroB;
                }
                break;

            default:
                valido = false;
                System.out.println("Opción inválida");
                break;
        }

        System.out.println("Valores ingresados: ");
        System.out.println("A = " + numeroA);
        System.out.println("B = " + numeroB);

        if (valido) {
            System.out.println("Resultado: " + resultado);

        }else{
            System.out.println("RESULTADO NO EXISTENTE");
        }

        scanner.close();
    }
}