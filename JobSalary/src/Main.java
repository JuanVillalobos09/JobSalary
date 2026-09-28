import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Cargando base de datos salarial...");
            ServicioSalarios servicio = new ServicioSalarios("data/job_salary_prediction_dataset.csv");
            int opcion;

            do {
                System.out.println("\n===== MENU JOB SALARY =====");
                System.out.println("1. Ejecutar Módulo 1 (Filtros Predicate)");
                System.out.println("2. Ejecutar Módulo 2 (Transformaciones Function)");
                System.out.println("3. Ejecutar Módulo 3 (Impresiones Consumer)");
                System.out.println("4. Ejecutar Módulo 4 (Lógica BiFunction)");
                System.out.println("5. Ejecutar Módulo 5 (Agrupaciones Collect)");
                System.out.println("6. Ver Análisis Estadístico");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> servicio.modulo1Predicate();
                    case 2 -> servicio.modulo2Function();
                    case 3 -> servicio.modulo3Consumer();
                    case 4 -> servicio.modulo4BiFunction();
                    case 5 -> servicio.modulo5Collect();
                    case 6 -> servicio.moduloEstadistico();
                    case 0 -> System.out.println("Cerrando sistema de salarios...");
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 0);

        } catch (Exception e) {
            System.out.println("Error crítico: " + e.getMessage());
        }
    }
}