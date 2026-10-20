package ejercicio317;

import java.util.Scanner;

public class PruebaPerfilMedico {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Primer nombre: ");
        String primerNombre = entrada.nextLine();
        System.out.print("Apellido: ");
        String apellido = entrada.nextLine();
        System.out.print("Sexo: ");
        String sexo = entrada.nextLine();
        System.out.print("Día de nacimiento: ");
        int dia = Integer.parseInt(entrada.nextLine());
        System.out.print("Mes de nacimiento (1-12): ");
        int mes = Integer.parseInt(entrada.nextLine());
        System.out.print("Año de nacimiento: ");
        int anio = Integer.parseInt(entrada.nextLine());
        System.out.print("Altura en centímetros (use punto decimal, ej. 175.5): ");
        double alturaCm = Double.parseDouble(entrada.nextLine());
        System.out.print("Peso en kilogramos (use punto decimal, ej. 70.5): ");
        double pesoKg = Double.parseDouble(entrada.nextLine());


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
}
