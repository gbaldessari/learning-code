package ListaConNexo;

public class App {
	public static void main(String[] args) {
		ListaNexoDoble lista = new ListaNexoDoble();
		
		lista.insertarPrimero(1);
		lista.insertarPrimero(2);
		lista.insertarPrimero(3);
		
		double a = lista.getPrimero().getDato();
		if(a!=3) {System.out.println("Error");}
		else {System.out.println("Lets go");}
		
		a = lista.getUltimo().getDato();
		if(a!=1) {System.out.println("Error");}
		else {System.out.println("Lets go");}
		
		lista.insertar(4);
		a = lista.getUltimo().getDato();
		if(a!=4) {System.out.println("Error");}
		else {System.out.println("Lets go");}
		
		lista.mostrarLista();
		
		System.out.println(lista.getPos(2).getDato());
		
		lista.eliminarPos(2);
		lista.mostrarLista();
		
		lista.eliminarPrimero();
		lista.mostrarLista();
		
		lista.eliminarUltimo();
		lista.mostrarLista();
		
		lista.eliminarPos(0);
		lista.mostrarLista();
	}
}