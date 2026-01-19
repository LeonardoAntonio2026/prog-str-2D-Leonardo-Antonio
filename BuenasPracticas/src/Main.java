import java.util.Scanner;
public class Main{
    public static void main(String[]a){

        System.out.print("Ingresa cuantas veces quieres que se sumen los numeros:");
        int cantidad = ingresarCantidad();
        int suma = resultadoSuma(cantidad);

        System.out.println("resultado: "+suma);
    }

    public static int ingresarCantidad(){
        Scanner scanner = new Scanner(System.in);
        int resultado = scanner.nextInt();
        return resultado;
    }

    public static int resultadoSuma(int cantidad){
        int suma=0;
        for(int i=1;i<=cantidad;i++)
        {
            suma+=i;
        }
        return suma;
    }
}