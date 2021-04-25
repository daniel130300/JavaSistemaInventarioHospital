/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Cache;

import Models.Models.UsuarioModel;


public class UsuariosCache 
{
    private static boolean DatosCompartidos = false;
    private static UsuarioModel usuario;

    public boolean isDatosCompartidos() {
        return DatosCompartidos;
    }

    public void setDatosCompartidos(boolean DatosCompartidos) {
        UsuariosCache.DatosCompartidos = DatosCompartidos;
    }
    
    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usr) {
        UsuariosCache.usuario = usr;
    }  
}
