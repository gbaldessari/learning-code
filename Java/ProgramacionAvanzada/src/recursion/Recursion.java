package recursion;

public class Recursion {
	public static void main(String[] args) {
        Factorial f= new Factorial();
        System.out.println("Factorial utilizando un método recursivo:");
        System.out.println("El factorial de 3 es: "+f.facR(3));
        System.out.println("El factorial de 6 es: "+f.facR(6));
        System.out.println();
        System.out.println("Factorial utilizando un método iterativo:");
        System.out.println("El factorial de 3 es: "+f.facI(3));
        System.out.println("El factorial de 6 es: "+f.facI(6));
        System.out.println();
    }
}
