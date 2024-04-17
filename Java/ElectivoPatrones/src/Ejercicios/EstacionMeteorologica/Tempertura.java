package Ejercicios.EstacionMeteorologica;

public class Tempertura extends Sujeto{
    private double temp;
    public void setTemp(double temp){
        this.temp=temp;
        notifyObservers();
    }
}
