package ejercicio313;

import java.util.Scanner;

public class PruebaEmpleado {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== Datos del primer empleado ===");
        ejercicio313.Empleado empleado1 = leerEmpleado(entrada);

        System.out.println("\n=== Datos del segundo empleado ===");
        ejercicio313.Empleado empleado2 = leerEmpleado(entrada);

        System.out.println("\n--- Salario anual ---");
        mostrarSalarioAnual(empleado1);
        mostrarSalarioAnual(empleado2);

        empleado1.establecerSalarioMensual(empleado1.obtenerSalarioMensual() * 1.10);
        empleado2.establecerSalarioMensual(empleado2.obtenerSalarioMensual() * 1.10);

        System.out.println("\n--- Salario anual después del aumento del 10% ---");
        mostrarSalarioAnual(empleado1);
        mostrarSalarioAnual(empleado2);

        entrada.close();
    }

    private static ejercicio313.Empleado leerEmpleado(Scanner entrada) {
        System.out.print("Primer nombre: ");
        String primerNombre = entrada.nextLine();
        System.out.print("Apellido paterno: ");
        String apellidoPaterno = entrada.nextLine();
        System.out.print("Salario mensual (use punto decimal, ej. 1200.50): ");
        double salarioMensual = Double.parseDouble(entrada.nextLine());
        return new ejercicio313.Empleado(primerNombre, apellidoPaterno, salarioMensual);
    }

    private static void mostrarSalarioAnual(ejercicio313.Empleado empleado) {
        double salarioAnual = empleado.obtenerSalarioMensual() * 12;
        System.out.printf("%s %s: $%.2f%n",
                empleado.obtenerPrimerNombre(), empleado.obtenerApellidoPaterno(), salarioAnual);
    }
}
