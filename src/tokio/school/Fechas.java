package tokio.school;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Fechas {
    public static void main(String[] args) {
        
        //  fecha y hora actual
        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha y hora actual: " + fechaActual);

        // pedimos la fecha de nacimiento al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tu fecha de nacimiento (AAAA-MM-DD): ");
        String fechaNacimientoStr = scanner.nextLine();

        // parseamos la fecha de nacimiento a objeto LocalDate
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ISO_DATE);

        // calculamos los días que quedan para el próximo cumpleaños
        LocalDate proximoCumple = fechaNacimiento.withYear(fechaActual.getYear());
        if (proximoCumple.isBefore(fechaActual) || proximoCumple.isEqual(fechaActual)) {
            proximoCumple = proximoCumple.plusYears(1);
            
            System.out.println("este año ya has cumplido , felicidades !!");
        }

        long diasRestantes = ChronoUnit.DAYS.between(fechaActual, proximoCumple);

        System.out.println("faltan " + diasRestantes + " dias para tu cumpleaños !!");
    }
}
