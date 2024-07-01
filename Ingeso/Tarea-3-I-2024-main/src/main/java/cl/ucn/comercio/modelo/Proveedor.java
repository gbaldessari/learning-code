package cl.ucn.comercio.modelo;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="proveedor")
public class Proveedor {

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

    public List<Producto> getAcmeCelularesMarca(String marca){

        return this.listaProducto.stream().filter(p -> p.getMarca().equals(marca))
                .collect(Collectors.toList());
    }
}