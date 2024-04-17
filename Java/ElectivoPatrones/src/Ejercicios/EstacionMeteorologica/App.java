package Ejercicios.EstacionMeteorologica;

public class App {
    public static void main(String[] args) {
        Tempertura t = new Tempertura();
        t.addObserver(new TermometroCelcius());
        t.addObserver(new TermometroFarenheit());
        t.setTemp(100.00);
    }
}
