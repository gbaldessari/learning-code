package Switch;
import java.util.Scanner;

public class Switch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese un numero: ");
		int dato = Integer.parseInt(scan.nextLine());
		switch(dato){
		case 1:
			System.out.println("uno");
			break;
		case 2:
			System.out.println("dos");
			break;
		case 3:
			System.out.println("tres");
			break;
		default:
			System.out.println("Ni uno, ni dos, ni tres");
		}
		scan.close();
	}
}