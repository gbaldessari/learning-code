package cl.ucn.comercio.modelo.adapters;

import cl.ucn.comercio.modelo.Producto;
import cl.ucn.comercio.modelo.ProveedorAfel;

import java.util.List;

public class ProveedorAfelAdapter implements ProveedorAdapter{

    private ProveedorAfel proveedorAfel;

    public ProveedorAfelAdapter(){
        proveedorAfel = new ProveedorAfel();
    }
    @Override
    public int getRut() {
        return proveedorAfel.getRutProveedor();
    }

    @Override
    public String getNombre() {
        return proveedorAfel.getNombre();
    }

    @Override
    public List<Producto> getCelulares(String parametro) {
        try {
            return proveedorAfel.getAfelCelularTamanho(Integer.parseInt(parametro));
        }catch (NumberFormatException e){
            e.printStackTrace();
            return null;
        }

    }
}
