/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Estados;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Estados 
{
    private HashMap<String, Integer> Estados = new HashMap<>();

    public Estados() 
    {
        Estados.put("Activo", 1);
        Estados.put("Inactivo", 0);
    }
    
    public Integer getValueEstado(String key)
    {
        return Estados.get(key);
    }
    
    public String getEstadoKey(Integer valor)
    {
        for(Map.Entry<String, Integer> entrada : Estados.entrySet()) 
        {
            if (Objects.equals(valor, entrada.getValue())) 
            {
                return entrada.getKey();
            }
        }
        
        return null;
    }    
}
