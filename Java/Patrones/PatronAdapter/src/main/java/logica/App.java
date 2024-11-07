package logica;

import dominio.ProyectorAdapter;
import dominio.ProyectorLGAdaptado;
import dominio.ProyectorSamsungAdaptado;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<ProyectorAdapter> proyectores = new ArrayList<>();
        proyectores.add(new ProyectorLGAdaptado());
        proyectores.add(new ProyectorSamsungAdaptado());
        for (ProyectorAdapter proyector : proyectores) {
            proyector.start();
        }
    }
}
