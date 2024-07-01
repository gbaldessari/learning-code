package cl.ucn.comercio.modelo.adapters;

import cl.ucn.comercio.modelo.Producto;

import java.util.List;

public interface ProveedorAdapter {

    int getRut();

    String getNombre();

    List<Producto> getCelulares(String parametro);
}
