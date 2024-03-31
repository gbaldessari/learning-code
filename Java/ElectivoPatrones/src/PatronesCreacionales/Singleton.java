package PatronesCreacionales;

public class Singleton {
    private static Singleton instancia;
    private Singleton (){}
    public static Singleton getSingleton(){
        if (instancia == null) {
            instancia = new Singleton();
            System.out.println("Instancia creada");
        }
        return instancia;
    }
}
