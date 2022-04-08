package ut4;

import java.util.Scanner;
/**
 * <b>PROGRAMA PARA EL CÁLCULO DE LA PRIMA</b>
 * <p>
 * Se calcula la prima correspondiente para un empleado en función 
 * de unos parámetros que se introducen por teclado mediante petición previa
 * @version 1.0
 * @author Daniel Padra
 * 
 */
public class PrimaMainMetodos {
	
	/**
	 * Variable estática para la entrada de datos por teclado
	 */
	static Scanner  teclado=new Scanner(System.in);

	/**
	 * Método que inicia la ejecución del programa
	 * @param args Array de parámetros que recibe el método
	 */
	public static void main(String[] args) {

		int numEmple;
		String nomEmple;
		int meses;
		char esDirectivo;
		char respuesta;
		

		do {
			System.out.println("\nDATOS  EMPLEADO/A");
			numEmple=leerNumEmple();
			nomEmple=leerNomEmple();
			meses=leerMeses();
			esDirectivo=leerEsDirectivo();
			System.out.println("\n\tLe corresponde la prima "+hallarPrima(esDirectivo, meses));
			
			
			System.out.println("\n¿CALCULAR MÁS PRIMAS? (S/N): ");
			respuesta=teclado.nextLine().toUpperCase().charAt(0);
		}while(respuesta=='S');		
	}

/**
 * Método que halla el tipo de prima
 * @param esDirectivo Carácter que indica si el empleado es directivo o no
 * @param meses Entero que amacena la antiguedad del empleado en meses
 * @return 
 * <ul>
 * <li>P1 Si es directivo y tiene una antiguedad mayor o igual a 12 meses</li>
 * <li>P3 Si es directivo y tiene una antiguedad menor a 12 meses</li>
 * <li>P2 Si no es directivo y tiene una antiguedad mayor o igual a 12 meses</li>
 * <li>P4 Si no es directivo y tiene una antiguedad menor a 12 meses</li>
 * </ul>
 */
	public static String hallarPrima(char esDirectivo, int meses) {
		if(esDirectivo=='+') // ES DIRECTIVO
			if(meses>=12)
				return "P1";
			else
				return "P3";
		else 	// NO ES DIRECTIVO
			if(meses>=12)
				return "P2";
			else
				return "P4";
	}

	/**
	 * Método que lee por teclado el número de empleado
	 * @return Entero con el número de empleado
	 */
	public static int leerNumEmple() {	
		int numEmple;
		do{
			System.out.println("NÚMERO [100-999]: ");
			numEmple = teclado.nextInt();
		}while(numEmple<100 || numEmple>999);		
		teclado.nextLine();
		return numEmple;
	}
	
	/**
	 * Método que lee por teclado el nombre del empleado
	 * @return Cadena con el nombre del empleado
	 */
	public static String leerNomEmple() {
		String nomEmple;
		do {
			System.out.println("NOMBRE (max 10 caracteres): ");
			nomEmple = teclado.nextLine();
		}while(nomEmple.length()>10);		
		return nomEmple;
	}
	
	/**
	 * Método que lee por teclado la antiguedad del empleado
	 * @return Entero con el número de meses de antiguedad del empleado
	 */
	public static int leerMeses() {
		int meses;
		do {
			System.out.println("MESES DE TRABAJO: ");
			meses = teclado.nextInt();
		}while(meses<0);
		teclado.nextLine();
		return meses;
	}
	
	/**
	 * Método que lee por teclado si el empleado es directivo o no
	 * @return
	 * <ul>
	 * <li>+ Si el empleado es directivo</li>
	 * <li>- Si el empleado no es directivo</li>
	 * </ul>
	 */
	public static char leerEsDirectivo() {
		char esDirectivo;
		do {
			System.out.println("¿ES DIRECTIVO? (+/-): ");
			esDirectivo = teclado.nextLine().charAt(0);
		}while(esDirectivo!='+' && esDirectivo!='-');
		return esDirectivo;
	}
}
