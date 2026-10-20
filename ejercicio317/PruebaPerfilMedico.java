package ejercicio312;


public class Factura {

    private String numeroPieza;
    private String descripcionPieza;
    private int cantidad;
    private double precioPorArticulo;


    public Factura(String numeroPieza, String descripcionPieza, int cantidad, double precioPorArticulo) {
        establecerNumeroPieza(numeroPieza);
        establecerDescripcionPieza(descripcionPieza);
        establecerCantidad(cantidad);
        establecerPrecioPorArticulo(precioPorArticulo);
    }

    public void establecerNumeroPieza(String numeroPieza) {
        this.numeroPieza = numeroPieza;
    }

    public String obtenerNumeroPieza() {
        return numeroPieza;
    }

    public void establecerDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    public String obtenerDescripcionPieza() {
        return descripcionPieza;
    }

    public void establecerCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        } else {
            this.cantidad = 0;
        }
    }

    public int obtenerCantidad() {
        return cantidad;
    }

    public void establecerPrecioPorArticulo(double precioPorArticulo) {
        if (precioPorArticulo > 0) {
            this.precioPorArticulo = precioPorArticulo;
        } else {
            this.precioPorArticulo = 0.0;
        }
    }

    public double obtenerPrecioPorArticulo() {
        return precioPorArticulo;
    }

    /**
     * Calcula el monto de la factura: cantidad de artículos x precio por artículo.
     * @return el monto total como double
     */
    public double obtenerMontoFactura() {
        return cantidad * precioPorArticulo;
    }
}