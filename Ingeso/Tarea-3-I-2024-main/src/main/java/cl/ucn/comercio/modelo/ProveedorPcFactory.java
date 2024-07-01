package cl.ucn.comercio.modelo;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="proveedor")
public class ProveedorPcFactory {

    @Id
    @Column(name="rut_proveedor")
    int rutProveedor;
    String nombre;

    @OneToMany
    @Column(name = "producto")
    @JoinColumn(name = "rut_proveedor", referencedColumnName = "rut_proveedor")
    List<Producto> listaProducto;

    public int getRutProveedor() {
            return rutProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getPCFactoryCelularAnho(int anho){

        return this.listaProducto.stream().filter(p -> p.getAnho() == anho)
                .collect(Collectors.toList());
    }
}

