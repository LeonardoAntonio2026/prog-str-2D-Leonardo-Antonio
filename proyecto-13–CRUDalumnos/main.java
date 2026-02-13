import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[25];

        Scanner scanner = new Scanner(System.in);
        int opcion;
        int id;
        String nombre;

        while (true){
            System.out.println("CRUD ALUMNOS!-------");
            System.out.println("Menu: ");
            System.out.println("1. Alta alumno");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Actualizar promedio por ID");
            System.out.println("4. Baja logica por ID");
            System.out.println("5. Listar activos");
            System.out.println("6. Reportes");
            System.out.println("0. Salir");
            opcion = InputDataValidator.leerIntEnRango(scanner,"Selecciona una opcion (0-6): ",0,6);
            switch (opcion){
                case 1:
                    System.out.println("OK, vamos a registrar un nuevo alumno");

                    id = InputDataValidator.leerIntDespuesDe(scanner,"Cual sera su id? (debe ser mayor que 0): ",0);

                    // Verificar si la ID ya está ocupada
                    while (id < alumnos.length && alumnos[id] != null && alumnos[id].isActive()) {
                        id = InputDataValidator.leerIntDespuesDe(scanner,"Esa id esta ocupada bro, pon otra (debe ser mayor que 0): ",0);
                    }

                    nombre = InputDataValidator.leerTextoNoVacio(scanner, "Esa id esta disponible. Cual es el nombre del alumno?: ");
                    
                    double promedio = InputDataValidator.leerDoubleEnRango(scanner, "Cual es el promedio del alumno? (0-10): ", 0.0, 10.0);

                    Alumno nuevoAlumno = new Alumno(id, nombre, promedio);
                    alumnos[id] = nuevoAlumno;
                    
                    System.out.println("Alumno registrado exitosamente!");
                    break;


                case 2:
                    System.out.println("OK, vamos a buscar un alumno por su ID");
                    
                    id = InputDataValidator.leerIntDespuesDe(scanner,"Cual es el ID del alumno que buscas?: ",0);
                    
                    if (id >= alumnos.length || alumnos[id] == null || !alumnos[id].isActive()) {
                        System.out.println("No hay ningun alumno activo con esa ID bro.");
                    } else {
                        System.out.println("¡Encontrado! Aqui esta la info:");
                        System.out.println(alumnos[id].toString());
                    }
                    break;
                    
                case 3:
                    System.out.println("OK, vamos a actualizar el promedio de un alumno");
                    
                    id = InputDataValidator.leerIntDespuesDe(scanner,"Cual es el ID del alumno?: ",0);
                    
                    if (id >= alumnos.length || alumnos[id] == null || !alumnos[id].isActive()) {
                        System.out.println("No hay ningun alumno activo con esa ID bro.");
                    } else {
                        System.out.println("Alumno actual:");
                        System.out.println(alumnos[id].toString());
                        System.out.println("Promedio actual: " + alumnos[id].getPromedio());
                        
                        double nuevoPromedio = InputDataValidator.leerDoubleEnRango(scanner, "Cual sera el nuevo promedio? (0-10): ", 0.0, 10.0);
                        
                        alumnos[id].setPromedio(nuevoPromedio);
                        System.out.println("Promedio actualizado exitosamente!");
                        System.out.println("Nueva info: " + alumnos[id].toString() + ", promedio=" + alumnos[id].getPromedio());
                    }
                    break;
                    
                case 4:
                    System.out.println("OK, vamos a dar de baja a un alumno por su ID");
                    
                    id = InputDataValidator.leerIntDespuesDe(scanner,"Cual es el ID del alumno que quieres dar de baja?: ",0);
                    
                    if (id >= alumnos.length || alumnos[id] == null || !alumnos[id].isActive()) {
                        System.out.println("No hay ningun alumno activo con esa ID bro.");
                    } else {
                        System.out.println("Este es el alumno que vas a dar de baja:");
                        System.out.println(alumnos[id].toString());
                        
                        String confirmacion = InputDataValidator.leerTextoNoVacio(scanner, "¿Estas seguro que lo quieres dar de baja? (escribe 'si' para confirmar): ");
                        
                        if (confirmacion.toLowerCase().equals("si")) {
                            alumnos[id].setActive(false);
                            System.out.println("Alumno dado de baja exitosamente!");
                        } else {
                            System.out.println("OK, no se dio de baja.");
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("Aqui tienes todos los alumnos activos:");
                    System.out.println("---------------------------------------");
                    
                    boolean hayAlumnos = false;
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].isActive()) {
                            System.out.println("ID: " + alumnos[i].getId() + 
                                             " | Nombre: " + alumnos[i].getName() + 
                                             " | Promedio: " + alumnos[i].getPromedio());
                            hayAlumnos = true;
                        }
                    }
                    
                    if (!hayAlumnos) {
                        System.out.println("No hay alumnos activos registrados bro.");
                    }
                    System.out.println("---------------------------------------");
                    break;
                    
                case 6:
                    System.out.println("===== REPORTES DE ALUMNOS ACTIVOS =====");
                    
                    int contadorActivos = 0;
                    double sumaPromedios = 0.0;
                    Alumno alumnoMayorPromedio = null;
                    Alumno alumnoMenorPromedio = null;
                    int contadorPromedioAlto = 0;
                    
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].isActive()) {
                            contadorActivos++;
                            sumaPromedios += alumnos[i].getPromedio();
                            
                        
                            if (alumnoMayorPromedio == null || alumnos[i].getPromedio() > alumnoMayorPromedio.getPromedio()) {
                                alumnoMayorPromedio = alumnos[i];
                            }
                            
                    
                            if (alumnoMenorPromedio == null || alumnos[i].getPromedio() < alumnoMenorPromedio.getPromedio()) {
                                alumnoMenorPromedio = alumnos[i];
                            }
                            
                            
                            if (alumnos[i].getPromedio() >= 8.0) {
                                contadorPromedioAlto++;
                            }
                        }
                    }
                    
                    if (contadorActivos == 0) {
                        System.out.println("No hay alumnos activos para generar reportes.");
                    } else {
                        
                        double promedioGeneral = sumaPromedios / contadorActivos;
                        System.out.println("\n1. Promedio general de alumnos activos: " + String.format("%.2f", promedioGeneral));
                        
                        System.out.println("\n2. Alumno con MAYOR promedio:");
                        System.out.println("   ID: " + alumnoMayorPromedio.getId());
                        System.out.println("   Nombre: " + alumnoMayorPromedio.getName());
                        System.out.println("   Promedio: " + alumnoMayorPromedio.getPromedio());
                        
                        System.out.println("\n3. Alumno con MENOR promedio:");
                        System.out.println("   ID: " + alumnoMenorPromedio.getId());
                        System.out.println("   Nombre: " + alumnoMenorPromedio.getName());
                        System.out.println("   Promedio: " + alumnoMenorPromedio.getPromedio());
                        
                        System.out.println("\n4. Alumnos con promedio >= 8.0: " + contadorPromedioAlto + " de " + contadorActivos);
                    }
                    System.out.println("========================================");
                    break;
                    
                case 0:
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
