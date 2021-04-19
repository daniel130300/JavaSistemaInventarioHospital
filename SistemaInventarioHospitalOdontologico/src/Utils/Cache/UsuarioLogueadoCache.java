/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Cache;

import Models.Models.PrivilegiosModel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author danie
 */
public class UsuarioLogueadoCache 
{  
    private static Integer UsrId;
    private static String UsrUsuario;
    private static String UsrNombre;
    private static String UsrApellido;
    private static String UsrCorreo;
    private static ArrayList<PrivilegiosModel> privilegios;

    public static Integer getUsrId() {
        return UsrId;
    }

    public static void setUsrId(Integer UsrId) {
        UsuarioLogueadoCache.UsrId = UsrId;
    }

    public static String getUsrUsuario() {
        return UsrUsuario;
    }

    public static void setUsrUsuario(String UsrUsuario) {
        UsuarioLogueadoCache.UsrUsuario = UsrUsuario;
    }

    public static String getUsrNombre() {
        return UsrNombre;
    }

    public static void setUsrNombre(String UsrNombre) {
        UsuarioLogueadoCache.UsrNombre = UsrNombre;
    }

    public static String getUsrApellido() {
        return UsrApellido;
    }

    public static void setUsrApellido(String UsrApellido) {
        UsuarioLogueadoCache.UsrApellido = UsrApellido;
    }

    public static String getUsrCorreo() {
        return UsrCorreo;
    }

    public static void setUsrCorreo(String UsrCorreo) {
        UsuarioLogueadoCache.UsrCorreo = UsrCorreo;
    }

    public static ArrayList<PrivilegiosModel> getPrivilegios() {
        return privilegios;
    }

    public static void setPrivilegios(ArrayList<PrivilegiosModel> privilegios) {
        UsuarioLogueadoCache.privilegios = privilegios;
    }    
          
    public static  HashMap<String, HashMap<Integer, String>> getHashUsrPrivilegios()
    {
        //Modulos generales
        HashMap<String, HashMap<Integer, String>> privilegiosModulos = new HashMap<>();
        
        //Submodulos
        HashMap<Integer, String> privilegiosVentas = new HashMap<>();
        HashMap<Integer, String> privilegiosSuministros = new HashMap<>();
        HashMap<Integer, String> privilegiosProveedores = new HashMap<>();
        HashMap<Integer, String> privilegiosCompras = new HashMap<>();
        HashMap<Integer, String> privilegiosBodega = new HashMap<>();
        HashMap<Integer, String> privilegiosUsuarios = new HashMap<>();
        HashMap<Integer, String> privilegiosAlertas = new HashMap<>();
        
        for(PrivilegiosModel privilegio: UsuarioLogueadoCache.privilegios)
        {
            switch(privilegio.getPriIdModulo())
            {
                case 1:
                    privilegiosVentas.put(privilegio.getPriId(), privilegio.getPriDescripcion());
                    privilegiosModulos.put("ventas", privilegiosVentas); 
                break;
                
                case 2:
                    privilegiosSuministros.put(privilegio.getPriId(), privilegio.getPriDescripcion());
                    privilegiosModulos.put("suministros", privilegiosSuministros); 
                break;
                
                 case 3:
                    privilegiosProveedores.put(privilegio.getPriId(), privilegio.getPriDescripcion());
                    privilegiosModulos.put("proveedores", privilegiosProveedores);
               break;
               
               case 4:
                    privilegiosCompras.put(privilegio.getPriId(), privilegio.getPriDescripcion());
                    privilegiosModulos.put("compras", privilegiosCompras);
               break;

               case 5:
                    privilegiosBodega.put(privilegio.getPriId(), privilegio.getPriDescripcion());
                    privilegiosModulos.put("bodega", privilegiosBodega);
               break;
               
               case 6:
                    privilegiosUsuarios.put(privilegio.getPriId(), privilegio.getPriDescripcion());
                    privilegiosModulos.put("usuarios", privilegiosUsuarios);
               break;
               
               case 7:
                    privilegiosAlertas.put(privilegio.getPriId(), privilegio.getPriDescripcion());
                    privilegiosModulos.put("alertas", privilegiosAlertas);
               break;
            }
        }
       
       return privilegiosModulos;
    }
}
