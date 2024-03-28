package Ejercicios.Incremental;

class Incremental {
    private static int count = 0;
    private int numero;
    public Incremental(){
        numero=++count;
    }
    public String toString(){
        return "Incremental " + numero;
    }
}

class IncrementalSingleton {
    private static int count = 0;
    private static int numero;
    private static IncrementalSingleton instancia;
    private IncrementalSingleton(){}
    public static IncrementalSingleton getInstancia() {
        if (instancia == null) {
            instancia = new IncrementalSingleton();
        }
        numero=++count;
        return instancia;
    }
    public String toString() {
        return "Incremental " + numero;
    }
}
public class TestIncremental {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Incremental inc = new Incremental();
            System.out.println(inc);
        }
        for (int i = 0; i < 10; i++) {
            IncrementalSingleton inc = IncrementalSingleton.getInstancia();
            System.out.println(inc);
        }
    }
    
}
