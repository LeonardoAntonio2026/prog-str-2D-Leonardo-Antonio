import java.util.Scanner;

public class Main {
    public static double RANGO_BAJO = 10.5;
    public static double RANGO_MEDIO = 25;
    public static double RANGO_ALTO = 30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular area triangulo");
            System.out.println("3. CentigradoCF");
            System.out.println("4. Calcular area circulo");
            System.out.println("5. Salir");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    calcularIMC(sc);
                    break;

                case 2:
                    areaTriangulo(sc);
                    break;

                case 3:
                    CentigradosAFarenheit(sc);
                    break;

                case 4:
                    AreaCirculo(sc);
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Ingresa una opcion valida bro");
            }

            System.out.println();

        } while (choice != 5);
    }

    public static void calcularIMC(Scanner sc){
        double peso = obtenerDouble(sc, "Dame peso ");
        double altura = obtenerDouble(sc, "Dame altura ");
        double imc = peso / (altura * altura);
        obtenerClasificacionImc(imc);
        System.out.println("IMC: " + imc);
    }

    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static void obtenerClasificacionImc(double imc){
        if (imc < RANGO_BAJO){
            System.out.println("Bajo peso");
        }
        else if (imc < RANGO_MEDIO){
            System.out.println("Peso medio");
        }
        else if (imc < RANGO_ALTO){
            System.out.println("Sobre peso");
        }
        else{
            System.out.println("Obesidad");
        }
    }

    public static void areaTriangulo(Scanner sc){
        double altura = obtenerDouble(sc, "Ingresa la altura del triangulo: ");
        double base = obtenerDouble(sc, "Ingresa la base del triangulo: ");
        double resultadoArea = (base * altura)/2;
        System.out.println("El area del triangulo es: "+ resultadoArea);
    }

    public static void CentigradosAFarenheit(Scanner sc){
        double centigrados = obtenerDouble(sc, "Ingresa la temperatura en Centigrados: ");
        double Farenheit = (centigrados * 1.8) + 32;
        System.out.println("La temperatura de "+ centigrados + " grados centigrados es "+ Farenheit + " grados Farenheit");
    }

    public static void AreaCirculo(Scanner sc){
        double radio = obtenerDouble(sc, "Ingresa el radio del circulo: ");
        double area = Math.PI * (radio * radio);
        System.out.println("El area del circulo es: " + area);
    }
}
