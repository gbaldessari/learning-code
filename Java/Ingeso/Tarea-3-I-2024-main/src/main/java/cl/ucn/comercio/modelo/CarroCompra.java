package cl.ucn.comercio.modelo;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="carro_compra")
public class CarroCompra {

    @Id
    @Column(name = "carrocompra_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idCarroCompra;
    String fecha;

    @OneToMany
    @Column(name = "producto")
    @JoinColumn(name = "carrocompra_id", referencedColumnName = "carrocompra_id")
    List<Producto> listaProducto;

    public int getIdCarroCompra() {
        return idCarroCompra;
    }

    public CarroCompra() {
        this.listaProducto = new ArrayList<Producto>();
    }

    public void anhadirProducto(Producto producto){
        listaProducto.add(producto);
    }

    public void eliminarProducto(Producto producto){

        int id = producto.getSerialNumber();
        int index = -1;
        for (int i=0; i<listaProducto.size(); i++) {
            if (id == listaProducto.get(i).serialNumber) {
                index = i;
                break;
            }
        }
        if (index !=-1)
            listaProducto.remove(index);
    }

    public void vaciarCarro(){

        listaProducto.clear();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}