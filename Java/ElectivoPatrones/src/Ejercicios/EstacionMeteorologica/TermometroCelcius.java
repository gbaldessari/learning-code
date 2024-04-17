package Ejercicios.EstacionMeteorologica;

public class TermometroCelcius implements Observer {
    public void update(Sujeto s){
        double temp = ((Tempertura)s).getTemp();
        System.out.println(temp);
    }
}
