package cl.ucn.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="valores_clima")
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name="velocidad_viento")
    double velocidadViento;
    double lluvia;
    int anho;

    public int getId() {
        return id;
    }

    public double getVelocidadViento() {
        return velocidadViento;
    }

    public double getLluvia() {
        return lluvia;
    }

    public int getAnho() {
        return anho;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVelocidadViento(double velocidadViento) {
        this.velocidadViento = velocidadViento;
    }

    public void setLluvia(double lluvia) {
        this.lluvia = lluvia;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }
}
