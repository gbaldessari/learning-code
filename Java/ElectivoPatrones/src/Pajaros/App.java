package Pajaros;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Pajaro> pajaros = new ArrayList<>();
        Pajaro loro = new Loro();
        Pajaro pinguino = new Pinguino();
        pajaros.add(pinguino);
        pajaros.add(loro);
        for (Pajaro pajaro : pajaros) {
            pajaro.caminar();
        }
    }
}
