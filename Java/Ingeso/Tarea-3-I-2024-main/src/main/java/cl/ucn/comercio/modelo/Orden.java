package cl.ucn.comercio.modelo;


import jakarta.persistence.*;

@Entity
@Table(name="orden")
public class Orden {

    @Id
    @Column(name="orden_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int numeroOrden;
    boolean confirmado;
    boolean enviado;
    boolean entregado;

    public Orden(){

    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }
}