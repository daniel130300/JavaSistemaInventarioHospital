
package Models.Models;

/**
*
* @author Héctor López
* Clase que se encarga de definir el modelo para los datos del JList 
* privilegioseleccionados y privilegiosdisponibles en MatenimientoUsuariosView
*/

public class PrivilegiosModel 
{
    private Integer PriId;
    private String PriDescripcion;
    private Integer PriIdModulo;

    public Integer getPriId() {
        return PriId;
    }

    public void setPriId(Integer PriId) {
        this.PriId = PriId;
    }

    public String getPriDescripcion() {
        return PriDescripcion;
    }

    public void setPriDescripcion(String PriDescripcion) {
        this.PriDescripcion = PriDescripcion;
    }

    public Integer getPriIdModulo() {
        return PriIdModulo;
    }

    public void setPriIdModulo(Integer PriIdModulo) {
        this.PriIdModulo = PriIdModulo;
    }   
}
