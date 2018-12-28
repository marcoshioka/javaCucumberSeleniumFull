package utils;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe utilitária para trabalho com String, sejam 
 * manipulações ou tratativas necessárias em variáveis String.
 * 
 * @since 26/04/2018
 * @author Leonardo Costa
 *
 */
public class StringUtils {

//	final static Logger logger = Logger.getLogger(StringUtils.class);

	/**
	 * Remove caracteres especiais.
	 * @param caracter caracter especial
	 * @return String formatada sem caracter especial
	 * @author Leonardo Costa
	 */
	public static String removeAll(String caracter) {
		return removeEspecialChars(caracter).toLowerCase().trim();
	}

	/**
	 * Remove caracteres especiais.
	 * @param caracter caracter especial
	 * @return String formatada sem caracter especial
	 * @author Leonardo Costa 
	 */
	public static String removeEspecialChars(String caracter) {
		return Normalizer.normalize(caracter, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	/**
	 * Metodo recebe uma String de valores separados por ";" e devolve um List
	 * <String> com os valores separados
	 * 
	 * @author Leonardo Costa
	 * @param String
	 * @throws Exception
	 */
	public static List<String> splitStringToList(String row) {
		List<String> rowList = new ArrayList<String>();
		String[] rowSplit = row.split(";");

		for (String r : rowSplit) {
			rowList.add(removeAll(r));
		}
		return rowList;
	}

	/**
	 * Remove zeros.
	 * @param linha
	 * @return 
	 */
	public static String removeZeros(String linha) {
		return linha.replaceFirst("0*", "");
	}

}
