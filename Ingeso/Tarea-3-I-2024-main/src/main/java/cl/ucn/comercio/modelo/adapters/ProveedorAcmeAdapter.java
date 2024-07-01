package cl.ucn.comercio.modelo.adapters;

import cl.ucn.comercio.modelo.Producto;
import cl.ucn.comercio.modelo.Proveedor;

import java.util.List;

public class ProveedorAcmeAdapter implements ProveedorAdapter{
    Proveedor proveedor;
    public ProveedorAcmeAdapter(){
        proveedor = new Proveedor();
    }
    @Override
    public int getRut() {
        return proveedor.getRutProveedor();
    }

    @Override
    public String getNombre() {
        return proveedor.getNombre();
    }

    @Override
    public List<Producto> getCelulares(String parametro) {
        return proveedor.getAcmeCelularesMarca(parametro);
    }
}
