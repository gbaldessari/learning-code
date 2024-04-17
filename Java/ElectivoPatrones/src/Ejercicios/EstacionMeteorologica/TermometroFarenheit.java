package Ejercicios.EstacionMeteorologica;

public class TermometroFarenheit implements Observer {
    public update(Sujeto s){
        double temp = ((Tempertura)s).getTemp();
        temp = (temp * 9.5)+32;
        System.out.println(temp);
    }
}
