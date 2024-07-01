package cl.ucn.comercio.modelo;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="proveedor")
public class ProveedorAfel {

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

    public List<Producto> getAfelCelularTamanho(int pulgadas){

        return this.listaProducto.stream().filter(p -> p.getTamanho() == pulgadas)
                .collect(Collectors.toList());
    }
}