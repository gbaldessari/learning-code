package Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFile {
	public static void main(String[] args) throws FileNotFoundException {
		File arch = new File("archivoDePrueba.txt");
		Scanner scan = new Scanner(arch);
		
		while (scan.hasNextLine()) {
			String[] linea = scan.nextLine().split(",");
            System.out.println(linea[0].toUpperCase());
            System.out.println(linea[1].toLowerCase());
            System.out.println(linea[2]);
            double numero = Double.parseDouble(linea[2]);
            System.out.println(numero/2);
            System.out.println(linea[3]);
            int numero2 = Integer.parseInt(linea[3]);
            System.out.println(numero2*2);
		}
		scan.close();
	}
}