package ejercicio317;

import java.time.LocalDate;

public class PerfilMedico {

    private String primerNombre;
    private String apellido;
    private String sexo;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;
    private double alturaCm;   // la altura se guarda en centímetros
    private double pesoKg;     // el peso se guarda en kilogramos

    public PerfilMedico(String primerNombre, String apellido, String sexo,
                        int diaNacimiento, int mesNacimiento, int anioNacimiento,
                        double alturaCm, double pesoKg) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anioNacimiento = anioNacimiento;
        this.alturaCm = alturaCm;
        this.pesoKg = pesoKg;
    }

    public void establecerPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public void establecerApellido(String apellido) {
        this.apellido = apellido;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void establecerSexo(String sexo) {
        this.sexo = sexo;
    }

    public String obtenerSexo() {
        return sexo;
    }

    public void establecerDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public int obtenerDiaNacimiento() {
        return diaNacimiento;
    }

    public void establecerMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public int obtenerMesNacimiento() {
        return mesNacimiento;
    }

    public void establecerAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int obtenerAnioNacimiento() {
        return anioNacimiento;
    }

    public void establecerAlturaCm(double alturaCm) {
        this.alturaCm = alturaCm;
    }

    public double obtenerAlturaCm() {
        return alturaCm;
    }

    public void establecerPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public double obtenerPesoKg() {
        return pesoKg;
    }


    /**
     * Calcula la edad en años cumplidos.
     * Se toma la fecha de hoy del sistema (LocalDate.now()) y se resta el año de nacimiento;
     * si este año todavía no ha llegado el cumpleaños, se resta 1.
     */
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
