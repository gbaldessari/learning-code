package cl.ucn.Taller2.utils;
/**
 * Class Herramientas
 */
public class Herramientas {
	/**
     * Add a space to the int[] and a value
     * @param lista A int[] to which you want to add a space
     * @param valor A int to add in the list
     * @return The int[] with a space and a value added
     */
	public static int[] appendInt(int[]lista, int valor) {
		int[] nuevaLista = new int[lista.length+1];
		for(int i = 0;i<lista.length;i++) {
			nuevaLista[i] = lista[i];
		}
		nuevaLista[lista.length] = valor;
		return nuevaLista;
	}
	/**
     * Add a space to the String[] and a value
     * @param lista A String[] to which you want to add a space
     * @param valor A String to add in the list
     * @return The String[] with a space and a value added
     */
	public static String[] appendStr(String[] lista, String valor) {
		String[] nuevaLista = new String[lista.length+1];
		for(int i = 0;i<lista.length;i++) {
			nuevaLista[i] = lista[i];
		}
		nuevaLista[lista.length] = valor;
		return nuevaLista;
	}
}