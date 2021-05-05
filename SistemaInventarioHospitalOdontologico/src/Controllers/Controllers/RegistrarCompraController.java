/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.Controllers;

import Utils.PlaceHolders.TextPrompt;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class RegistrarCompraController 
{
       
    public static void setPlaceHolders(JTextField txtNumeroFactura, JTextField txtNumeroTransferencia, JTextField txtNumeroOrden,
            JTextField txtNombreProducto, JTextArea txtDescripcionProducto, JTextField txtFechaCaducidad, JTextField txtCantidad, JTextField txtPrecio, JTextField txtBuscar)
    {
        TextPrompt placeholderFactura = new TextPrompt(" Ingrese el número de la factura ", txtNumeroFactura);
        TextPrompt placeholderNombre = new TextPrompt(" Ingrese el número de transferencia ", txtNumeroTransferencia);
        TextPrompt placeholderCorreo = new TextPrompt(" Ingrese número de la orden de compra ", txtNumeroOrden);
        TextPrompt placeholderNombreProducto = new TextPrompt(" Nombre del producto ", txtNombreProducto);
        TextPrompt placeholderDescripcionProducto = new TextPrompt(" Descripción del producto ", txtDescripcionProducto);
        TextPrompt placeholderFechaCaducidad = new TextPrompt(" Año-Mes-Día ", txtFechaCaducidad);
        TextPrompt placeholderContacto = new TextPrompt(" Ingrese la cantidad ", txtCantidad);
        TextPrompt placeholderDescripcion = new TextPrompt(" Ingrese el precio ", txtPrecio);
        TextPrompt placeholderBuscar = new TextPrompt(" Ingrese su búsqueda ", txtBuscar);
    }
    
    
}
