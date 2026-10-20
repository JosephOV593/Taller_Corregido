package ejercicio317;

import java.util.Scanner;

public class PruebaPerfilMedico {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String primerNombre = leerTexto(entrada, "Primer nombre: ");
        String apellido = leerTexto(entrada, "Apellido: ");
        String sexo = leerTexto(entrada, "Sexo: ");

        int dia;
        int mes;
        int anio;
        boolean fechaValida;
        do {
            dia = leerEntero(entrada, "Día de nacimiento: ");
            mes = leerEntero(entrada, "Mes de nacimiento (1-12): ");
            anio = leerEntero(entrada, "Año de nacimiento: ");
            fechaValida = ejercicio317.PerfilMedico.esFechaValida(dia, mes, anio);
            if (!fechaValida) {
                System.out.println("Error: fecha no válida. Revise que el mes esté entre 1 y 12, "
                        + "que el día exista en ese mes, que el año sea 1900 o posterior y que no sea una fecha futura.");
            }
        } while (!fechaValida);

        double alturaCm;
        boolean alturaValida;
        do {
            alturaCm = leerDecimal(entrada, "Altura en centímetros (use punto decimal, ej. 175.5): ");
            alturaValida = ejercicio317.PerfilMedico.esAlturaValida(alturaCm);
            if (!alturaValida) {
                System.out.println("Error: la altura debe estar entre 50 y 250 cm.");
            }
        } while (!alturaValida);

        double pesoKg;
        boolean pesoValido;
        do {
            pesoKg = leerDecimal(entrada, "Peso en kilogramos (use punto decimal, ej. 70.5): ");
            pesoValido = ejercicio317.PerfilMedico.esPesoValido(pesoKg);
            if (!pesoValido) {
                System.out.println("Error: el peso debe estar entre 1 y 500 kg.");
            }
        } while (!pesoValido);
        ejercicio317.PerfilMedico perfil = new ejercicio317.PerfilMedico(primerNombre, apellido, sexo, dia, mes, anio, alturaCm, pesoKg);
        System.out.println("\n=== Información del perfil médico ===");
        System.out.println("Nombre: " + perfil.obtenerPrimerNombre() + " " + perfil.obtenerApellido());
        System.out.println("Sexo: " + perfil.obtenerSexo());
        System.out.println("Fecha de nacimiento: " + perfil.obtenerDiaNacimiento() + "/"
                + perfil.obtenerMesNacimiento() + "/" + perfil.obtenerAnioNacimiento());
        System.out.println("Altura: " + perfil.obtenerAlturaCm() + " cm");
        System.out.println("Peso: " + perfil.obtenerPesoKg() + " kg");
        System.out.println("\n=== Resultados calculados ===");
        System.out.println("Edad: " + perfil.calcularEdad() + " años");
        System.out.printf("BMI: %.2f%n", perfil.calcularBMI());
        System.out.println("Frecuencia cardíaca máxima: " + perfil.calcularFrecuenciaMaxima() + " pulsos/min");
        System.out.printf("Rango de frecuencia cardíaca esperada: %.1f a %.1f pulsos/min%n",
                perfil.calcularFrecuenciaEsperadaMinima(), perfil.calcularFrecuenciaEsperadaMaxima());

        System.out.println("\n=== VALORES DE BMI ===");
        System.out.println("Bajo peso: menos de 18.5");
        System.out.println("Normal:    entre 18.5 y 24.9");
        System.out.println("Sobrepeso: entre 25 y 29.9");
        System.out.println("Obeso:     30 o más");

        entrada.close();
    }
    private static String leerTexto(Scanner entrada, String mensaje) {
        String texto;
        boolean valido;
        do {
            System.out.print(mensaje);
            texto = entrada.nextLine();
            valido = ejercicio317.PerfilMedico.esTextoValido(texto);
            if (!valido) {
                System.out.println("Error: solo se permiten letras y espacios (no números, símbolos ni vacío).");
            }
        } while (!valido);
        return texto.trim();
    }
    private static int leerEntero(Scanner entrada, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(entrada.nextLine().trim());
            } catch (NumberFormatException error) {
                System.out.println("Error: debe escribir un número entero.");
            }
        }
    }
    private static double leerDecimal(Scanner entrada, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(entrada.nextLine().trim());
            } catch (NumberFormatException error) {
                System.out.println("Error: debe escribir un número (use punto decimal).");
            }
        }
    }
}

