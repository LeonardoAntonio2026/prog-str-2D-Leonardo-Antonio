import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Persona[] personas = new Persona[20];

        Scanner scanner = new Scanner(System.in);
        int opcion;
        int id;
        String nombre;

        while (true){
            System.out.println("CRUD PERSONAS!-------");
            System.out.println("Menu: ");
            System.out.println("1. Registrar persona");
            System.out.println("2. Buscar persona por ID");
            System.out.println("3. Eliminar persona por ID");
            System.out.println("4. Listar personas activas");
            System.out.println("5. Actualizar persona por ID");
            System.out.println("6. Salir");

            opcion = InputDataValidator.leerIntEnRango(scanner,"Selecciona una opcion (1-6): ",1,6);
            switch (opcion){
                case 1:
                    System.out.println("OK, vamos a registrar una nueva persona");

                    id = InputDataValidator.leerIntDespuesDe(scanner,"Cual sera su id? (no puede ser menor que 0): ",0);

                    // Verificar si la ID ya está ocupada
                    while (id < personas.length && personas[id] != null && personas[id].isActive()) {
                        id = InputDataValidator.leerIntDespuesDe(scanner,"Esa id esta ocupada bro, pon otra (no puede ser menor que 0): ",0);
                    }

                    nombre = InputDataValidator.leerTextoNoVacio(scanner, "Esa id esta disponible. Cual es el nombre de la persona?: ");

                    Persona nuevaPersona = new Persona();
                    nuevaPersona.setId(id);
                    nuevaPersona.setName(nombre);
                    nuevaPersona.setActive(true);
                    personas[id] = nuevaPersona;
                    
                    System.out.println("Persona registrada exitosamente!");
                    break;


                case 2:
                    System.out.println("OK, vamos a buscar una persona por su ID");
                    
                    id = InputDataValidator.leerIntDespuesDe(scanner,"Cual es el ID de la persona que buscas?: ",0);
                    
                    if (id >= personas.length || personas[id] == null || !personas[id].isActive()) {
                        System.out.println("No hay ninguna persona activa con esa ID bro.");
                    } else {
                        System.out.println("¡Encontrada! Aqui esta la info:");
                        System.out.println(personas[id].toString());
                    }
                    break;
                    
                case 3:
                    System.out.println("OK, vamos a eliminar una persona por su ID");
                    
                    id = InputDataValidator.leerIntDespuesDe(scanner,"Cual es el ID de la persona que quieres eliminar?: ",0);
                    
                    if (id >= personas.length || personas[id] == null || !personas[id].isActive()) {
                        System.out.println("No hay ninguna persona activa con esa ID bro.");
                    } else {
                        System.out.println("Esta es la persona que vas a eliminar:");
                        System.out.println(personas[id].toString());
                        
                        String confirmacion = InputDataValidator.leerTextoNoVacio(scanner, "¿Estas seguro que la quieres eliminar? (escribe 'si' para confirmar): ");
                        
                        if (confirmacion.toLowerCase().equals("si")) {
                            personas[id].setActive(false);
                            System.out.println("Persona eliminada exitosamente bro!");
                        } else {
                            System.out.println("OK, no se elimino nada.");
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("Aqui tienes todas las personas activas:");
                    
                    boolean hayPersonas = false;
                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].isActive()) {
                            System.out.println(personas[i].toString());
                            hayPersonas = true;
                        }
                    }
                    
                    if (!hayPersonas) {
                        System.out.println("No hay personas activas registradas bro.");
                    }
                    break;
                    
                case 5:
                    System.out.println("OK, vamos a actualizar una persona por su ID");
                    
                    id = InputDataValidator.leerIntDespuesDe(scanner,"Cual es el ID de la persona que quieres actualizar?: ",0);
                    
                    if (id >= personas.length || personas[id] == null || !personas[id].isActive()) {
                        System.out.println("No hay ninguna persona activa con esa ID bro.");
                    } else {
                        System.out.println("Esta es la persona actual:");
                        System.out.println(personas[id].toString());
                        
                        String nuevoNombre = InputDataValidator.leerTextoNoVacio(scanner, "Cual sera el nuevo nombre? (actual: " + personas[id].getName() + "): ");
                        
                        personas[id].setName(nuevoNombre);
                        System.out.println("Persona actualizada exitosamente bro!");
                        System.out.println("Nueva info: " + personas[id].toString());
                    }
                    break;
                    
                case 6:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}
