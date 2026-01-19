Main
Main.java
public class Main {
    public static double RANGO_BAJO = 10.5;
    public static double RANGO_MEDIO = 25;
    public static double RANGO_ALTO = 30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame peso");
        double p = sc.nextDouble();
        System.out.println("Dame Altuca");
        double a = sc.nextDouble();
        double i = p / (a * a);
        System.out.println("IMC: " + i);

    }

    /**
     *Metodo para capturar un double desde la consola
     * @param sc Previamente instanciado desde el main
     * @param mensaje
     * @return
     */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static double calcularImc(double pesoKG, double alturaM){
        return pesoKG / (alturaM*alturaM);
    }

    public static String obtenerClasificacion(double imc){
        if (imc < 18.5){
            return System.out.println("Bag peso")
        }
        else if (imc < 25){
            return System.out.println("Peso medio");
        }
        else 1f (imc < 30){
            return System.out.println("Sobre peso");
        }
        else{
            return System.out.println("Obesidad");
        }
    }

}