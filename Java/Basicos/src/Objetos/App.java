package Objetos;

public class App {
	public static void main(String[] args) {
		
		Estudiante e1 = new Estudiante("Tuna Felgie","69.420.666-K");
		Estudiante e2 = new Estudiante("Runa Foss","12.345.678-9");
		
		System.out.println(e1.getNombre());
		System.out.println(e2.getNombre());
		
		Avion a1 = new Avion("1111","toyota","SAS",100);
		Avion a2 = new Avion("2222","asus","SOS",200);
		Avion a3 = new Avion("3333","columbia","SES",300);
		
		Avion[] lista = new Avion[3];
		
		lista[0] = a1;
		lista[1] = a2;
		lista[2] = a3;
		
		for(int i = 0;i<lista.length;i++) {
			System.out.println(lista[i].getModelo());
		}
	}
}