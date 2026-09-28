import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class ServicioSalarios {
    private List<Empleado> empleados;

    public ServicioSalarios(String ruta) throws IOException {
        empleados = Files.lines(Paths.get(ruta))
                .skip(1) // Salta la cabecera
                .filter(l -> !l.trim().isEmpty()) // Evita líneas en blanco
                .map(l -> l.split(";")) // ¡Punto y coma crucial!
                .filter(d -> d.length >= 10)
                .map(d -> new Empleado(
                        d[0].trim(),                     // Cargo (job_title)
                        d[4].trim(),                     // Industria (industry)
                        d[2].trim(),                     // Educación (education_level)
                        Double.parseDouble(d[1]),        // Experiencia (experience_years)
                        Integer.parseInt(d[8]),          // Certificaciones (certifications)
                        d[7].trim(),                     // Modalidad (remote_work)
                        d[5].trim(),                     // Empresa (company_size)
                        d[6].trim(),                     // País (location)
                        Double.parseDouble(d[9]),        // Salario (salary)
                        Integer.parseInt(d[3])           // Skills (skills_count)
                ))
                .collect(Collectors.toList());

        // (Opcional) Mensajito para confirmar que funcionó
        System.out.println("Base de datos cargada con éxito. Registros: " + empleados.size());
    }

    public void modulo1Predicate() {
        System.out.println("--- MODULO 1: Predicate ---");
        Predicate<Empleado> salAlto = e -> e.getSalario() > 150000;
        Predicate<Empleado> expAlta = e -> e.getExperiencia() > 10;
        Predicate<Empleado> esRemoto = e -> e.getModalidad().equalsIgnoreCase("Remote");

        System.out.println("> Empleados remotos con más de 10 años de experiencia y salario > 150k:");
        empleados.stream().filter(salAlto.and(expAlta).and(esRemoto)).limit(5).forEach(System.out::println);
    }

    public void modulo2Function() {
        System.out.println("--- MODULO 2: Function ---");
        Function<Empleado, String> aMayusculas = e -> e.getCargo().toUpperCase();
        Function<Empleado, String> descripcion = e -> e.getCargo() + " gana $" + e.getSalario();

        empleados.stream().map(aMayusculas).distinct().limit(5).forEach(System.out::println);
        empleados.stream().map(descripcion).limit(5).forEach(System.out::println);
    }

    public void modulo3Consumer() {
        System.out.println("--- MODULO 3: Consumer ---");
        Consumer<Empleado> reporteDetallado = e -> System.out.println("REPORTE: " + e.getCargo() + " - Exp: " + e.getExperiencia() + " - $" + e.getSalario());

        empleados.stream().filter(e -> e.getModalidad().equalsIgnoreCase("Remote")).limit(5).forEach(reporteDetallado);
    }

    public void modulo4BiFunction() {
        System.out.println("--- MODULO 4: BiFunction ---");
        if(empleados.size() >= 2) {
            Empleado e1 = empleados.get(0);
            Empleado e2 = empleados.get(1);

            BiFunction<Empleado, Empleado, Double> sumarSalarios = (a, b) -> a.getSalario() + b.getSalario();
            BiFunction<Empleado, Empleado, String> comparar = (a, b) -> a.getSalario() > b.getSalario() ? a.getCargo() : b.getCargo();

            System.out.println("> Suma salarios (" + e1.getCargo() + " + " + e2.getCargo() + "): $" + sumarSalarios.apply(e1, e2));
            System.out.println("> Cargo con mayor salario entre ambos: " + comparar.apply(e1, e2));
        }
    }

    public void modulo5Collect() {
        System.out.println("--- MODULO 5: Collect & Stream ---");
        Map<String, Long> porIndustria = empleados.stream().collect(Collectors.groupingBy(Empleado::getIndustria, Collectors.counting()));
        porIndustria.entrySet().stream().limit(5).forEach(System.out::println);
    }

    public void moduloEstadistico() {
        System.out.println("--- ANALISIS ESTADISTICO ---");
        double sumTotal = empleados.stream().mapToDouble(Empleado::getSalario).sum();
        double max = empleados.stream().mapToDouble(Empleado::getSalario).max().orElse(0);
        double min = empleados.stream().mapToDouble(Empleado::getSalario).min().orElse(0);
        double promExp = empleados.stream().mapToDouble(Empleado::getExperiencia).average().orElse(0);

        System.out.println("Total nómina global: $" + sumTotal);
        System.out.println("Salario Máximo: $" + max);
        System.out.println("Salario Mínimo: $" + min);
        System.out.println("Promedio Experiencia: " + String.format("%.1f", promExp) + " años");
    }
}