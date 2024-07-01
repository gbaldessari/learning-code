package cl.ucn.comercio.modelo.adapters;

import cl.ucn.comercio.modelo.Producto;
import cl.ucn.comercio.modelo.ProveedorPcFactory;

import java.util.List;

public class ProveedorPcFactoryAdapter implements ProveedorAdapter{

    private ProveedorPcFactory proveedorPcFactory;
    public ProveedorPcFactoryAdapter(){
        proveedorPcFactory = new ProveedorPcFactory();
    }
    @Override
    public int getRut() {
        return proveedorPcFactory.getRutProveedor();
    }

    @Override
    public String getNombre() {
        return proveedorPcFactory.getNombre();
    }

    @Override
    public List<Producto> getCelulares(String parametro) {
        try {
            return proveedorPcFactory.getPCFactoryCelularAnho(Integer.parseInt(parametro));
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
