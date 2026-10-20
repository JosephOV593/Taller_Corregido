package ejercicio317;

import java.time.LocalDate;
public class PerfilMedico {

    private String primerNombre;
    private String apellido;
    private String sexo;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;
    private double alturaCm;
    private double pesoKg;

    public PerfilMedico(String primerNombre, String apellido, String sexo,
                        int diaNacimiento, int mesNacimiento, int anioNacimiento,
                        double alturaCm, double pesoKg) {
        establecerPrimerNombre(primerNombre);
        establecerApellido(apellido);
        establecerSexo(sexo);
        if (esFechaValida(diaNacimiento, mesNacimiento, anioNacimiento)) {
            this.diaNacimiento = diaNacimiento;
            this.mesNacimiento = mesNacimiento;
            this.anioNacimiento = anioNacimiento;
        }
        establecerAlturaCm(alturaCm);
        establecerPesoKg(pesoKg);
    }
    public static boolean esTextoValido(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (!Character.isLetter(caracter) && caracter != ' ') {
                return false;
            }
        }
        return true;
    }
    public static boolean esFechaValida(int dia, int mes, int anio) {
        int anioMinimo = 1900;
        LocalDate hoy = LocalDate.now();

        if (anio < anioMinimo || anio > hoy.getYear()) {
            return false;
        }
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (dia < 1 || dia > diasDelMes(mes, anio)) {
            return false;
        }
        return !LocalDate.of(anio, mes, dia).isAfter(hoy);
    }
    private static int diasDelMes(int mes, int anio) {
        if (mes == 2) {
            boolean bisiesto = (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
            if (bisiesto) {
                return 29;
            }
            return 28;
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        }
        return 31;
    }
    public static boolean esAlturaValida(double alturaCm) {
        double alturaMinima = 50;
        double alturaMaxima = 250;
        return alturaCm >= alturaMinima && alturaCm <= alturaMaxima;
    }
    public static boolean esPesoValido(double pesoKg) {
        double pesoMinimo = 1;
        double pesoMaximo = 500;
        return pesoKg >= pesoMinimo && pesoKg <= pesoMaximo;
    }
    public void establecerPrimerNombre(String primerNombre) {
        if (esTextoValido(primerNombre)) {
            this.primerNombre = primerNombre.trim();
        }
    }
    public String obtenerPrimerNombre() {
        return primerNombre;
    }
    public void establecerApellido(String apellido) {
        if (esTextoValido(apellido)) {
            this.apellido = apellido.trim();
        }
    }
    public String obtenerApellido() {
        return apellido;
    }
    public void establecerSexo(String sexo) {
        if (esTextoValido(sexo)) {
            this.sexo = sexo.trim();
        }
    }
    public String obtenerSexo() {
        return sexo;
    }
    public void establecerDiaNacimiento(int diaNacimiento) {
        if (esFechaValida(diaNacimiento, mesNacimiento, anioNacimiento)) {
            this.diaNacimiento = diaNacimiento;
        }
    }
    public int obtenerDiaNacimiento() {
        return diaNacimiento;
    }
    public void establecerMesNacimiento(int mesNacimiento) {
        if (esFechaValida(diaNacimiento, mesNacimiento, anioNacimiento)) {
            this.mesNacimiento = mesNacimiento;
        }
    }
    public int obtenerMesNacimiento() {
        return mesNacimiento;
    }
    public void establecerAnioNacimiento(int anioNacimiento) {
        if (esFechaValida(diaNacimiento, mesNacimiento, anioNacimiento)) {
            this.anioNacimiento = anioNacimiento;
        }
    }
    public int obtenerAnioNacimiento() {
        return anioNacimiento;
    }

    public void establecerAlturaCm(double alturaCm) {
        if (esAlturaValida(alturaCm)) {
            this.alturaCm = alturaCm;
        }
    }
    public double obtenerAlturaCm() {
        return alturaCm;
    }
    public void establecerPesoKg(double pesoKg) {
        if (esPesoValido(pesoKg)) {
            this.pesoKg = pesoKg;
        }
    }
    public double obtenerPesoKg() {
        return pesoKg;
    }
    public int calcularEdad() {
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - anioNacimiento;

        boolean cumpleanosPendiente = hoy.getMonthValue() < mesNacimiento
                || (hoy.getMonthValue() == mesNacimiento && hoy.getDayOfMonth() < diaNacimiento);
        if (cumpleanosPendiente) {
            edad = edad - 1;
        }
        return edad;
    }
    public int calcularFrecuenciaMaxima() {
        int valorBase = 220;
        return valorBase - calcularEdad();
    }
    public double calcularFrecuenciaEsperadaMinima() {
        double porcentajeMinimo = 0.50;
        return calcularFrecuenciaMaxima() * porcentajeMinimo;
    }

    public double calcularFrecuenciaEsperadaMaxima() {
        double porcentajeMaximo = 0.85;
        return calcularFrecuenciaMaxima() * porcentajeMaximo;
    }
    public double calcularBMI() {
        double alturaMetros = alturaCm / 100;
        return pesoKg / (alturaMetros * alturaMetros);
    }
}
