
package Models.Models;

/**
*
* @author Francisco Godoy
* Clase que se encarga de establecer el modelo de datos para los proveedores
*/
public class ProveedorModel 
{    
    // **************************************************
    // Variables
    // **************************************************
    
    private Integer ProId;
    private String ProRTN;
    private String ProNombre;
    private String ProCorreo;
    private String ProTelefono;
    private String ProTelefono2;
    private String ProTelefono3;
    private String RubId;
    private String ProContacto;
    private String ProDireccion;
    private String ProEstado;

    public String getProTelefono2() {
        return ProTelefono2;
    }

    public void setProTelefono2(String ProTelefono2) {
        this.ProTelefono2 = ProTelefono2;
    }

    public String getProTelefono3() {
        return ProTelefono3;
    }

    public void setProTelefono3(String ProTelefono3) {
        this.ProTelefono3 = ProTelefono3;
    }

    public String getRubId() {
        return RubId;
    }

    public void setRubId(String RubId) {
        this.RubId = RubId;
    }

    // **************************************************
    // Getters y Setters
    // **************************************************
    
    public Integer getProId() 
    {
        return ProId;
    }

    public void setProId(Integer ProId) 
    {
        this.ProId = ProId;
    }
    public String getProEstado() {
        return ProEstado;
    }

    public void setProEstado(String ProEstado) 
    {
        this.ProEstado = ProEstado;
    }    

    public String getProRTN() 
    {
        return ProRTN;
    }

    public void setProRTN(String ProRTN) 
    {
        this.ProRTN = ProRTN;
    }

    public String getProNombre() 
    {
        return ProNombre;
    }

    public void setProNombre(String ProNombre) 
    {
        this.ProNombre = ProNombre;
    }

    public String getProTelefono() 
    {
        return ProTelefono;
    }

    public void setProTelefono(String ProTelefono) 
    {
        this.ProTelefono = ProTelefono;
    }

    public String getProCorreo() 
    {
        return ProCorreo;
    }

    public void setProCorreo(String ProCorreo) 
    {
        this.ProCorreo = ProCorreo;
    }
    
    public String getProContacto() {
        return ProContacto;
    }

    public void setProContacto(String ProContacto) 
    {
        this.ProContacto = ProContacto;
    }

    public String getProDireccion() 
    {
        return ProDireccion;
    }

    public void setProDireccion(String ProDireccion) 
    {
        this.ProDireccion = ProDireccion;
    }
}
