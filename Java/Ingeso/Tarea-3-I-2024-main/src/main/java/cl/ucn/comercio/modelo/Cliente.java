package cl.ucn.comercio.modelo;


import jakarta.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @Column(name = "rut")
    int rut;
    String nombre;
    String direccion;
    int celular;
    String email;
    @OneToOne
    @JoinColumn(name = "carrocompra_id", referencedColumnName = "carrocompra_id")
    CarroCompra carroCompra;
    @OneToOne
    @JoinColumn(name = "orden_id", referencedColumnName = "orden_id")
    Orden orden;

    public Cliente(){

    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CarroCompra getCarroCompra() {
        return carroCompra;
    }

    public void setCarroCompra(CarroCompra carroCompra) {
        this.carroCompra = carroCompra;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}