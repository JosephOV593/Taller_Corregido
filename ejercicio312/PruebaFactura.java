package ejercicio312;

import javax.swing.JOptionPane;

public class PruebaFactura {

    public static void main(String[] args) {

        String numeroPieza = JOptionPane.showInputDialog("Número de pieza:");
        String descripcionPieza = JOptionPane.showInputDialog("Descripción de la pieza:");

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de artículos:"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio por artículo (use punto decimal):"));

        ejercicio312.Factura factura = new ejercicio312.Factura(numeroPieza, descripcionPieza, cantidad, precio);

        JOptionPane.showMessageDialog(null,
                "Número de pieza: " + factura.obtenerNumeroPieza()
                        + "\nDescripción: " + factura.obtenerDescripcionPieza()
                        + "\nCantidad: " + factura.obtenerCantidad()
                        + "\nPrecio por artículo: $" + factura.obtenerPrecioPorArticulo()
                        + "\nMonto de la factura: $" + factura.obtenerMontoFactura(),
                "Factura inicial", JOptionPane.INFORMATION_MESSAGE);

        int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Nueva cantidad (pruebe también con 0 o un negativo):"));
        factura.establecerCantidad(nuevaCantidad);

        JOptionPane.showMessageDialog(null,
                "Cantidad guardada: " + factura.obtenerCantidad()
                        + "\nNuevo monto de la factura: $" + factura.obtenerMontoFactura(),
                "Factura actualizada", JOptionPane.INFORMATION_MESSAGE);
    }
}