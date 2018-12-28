package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe utilitária para lidar com datas.
 * @author Leonardo Costa
 *
 */
public class DateUtils {

	/**
	 * Retorna um texto com o nome do Mês em portugues de um objeto Date
	 * 
	 * @param date
	 *            Objeto date que deseja obter o mes
	 * @return String com o nome do mes
	 * @author Leonardo Costa
	 */
	public static String getMount(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		DateFormat dateFormat = new SimpleDateFormat("MM");
		return mounthString(dateFormat.format(cal.getTime()));
	}

	/**
	 * Recebe uma String indicando o formato da data que se espera e um objeto
	 * do tipo Date. A função converte o objeto Date para uma String no formato
	 * recebido
	 * 
	 * @param format
	 *            String com o formato esperado para data
	 * @param date
	 *            objeto Date com a data que deseja formatar
	 * @return Retorna String com a data formatada
	 * @author Leonardo Costa
	 */
	public static String formatDate(String format, Date date) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * Retorna um texto com o nome do mes abreviado e em portugues de um objeto
	 * Date
	 * 
	 * @param date
	 *            Objeto date que deseja obter o mes abreviado
	 * @return String com o nome do mes abreviado
	 * @author Leonardo Costa
	 */
	public static String getAbbreviatedMounth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		DateFormat dateFormat = new SimpleDateFormat("MM");
		String mounth = mounthString(dateFormat.format(cal.getTime()));
		return mounth.substring(0, 3);
	}

	/**
	 * Retorna o número do mes de um objeto Date
	 * 
	 * @param date
	 *            Objeto date que deseja obter o número do mes
	 * @return String com o número do mes
	 * @author Leonardo Costa
	 */
	public static String getMounthNumber(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		DateFormat dateFormat = new SimpleDateFormat("MM");
		return dateFormat.format(cal.getTime());

	}

	/**
	 * Método auxiliar para devolver o nome do mes em portugues
	 * 
	 * @param mounthNumber
	 *            Número do mes que deseja obter o nome em portugues
	 * @return Nome do mes em portugues
	 * @throws IllegalArgumentException
	 *             caso o número do mes informado não seja válido
	 */
	private static String mounthString(String mounthNumber) {
		switch (mounthNumber) {
		case "01":
			return "Janeiro";
		case "02":
			return "Fevereiro";
		case "03":
			return "Março";
		case "04":
			return "Abril";
		case "05":
			return "Maio";
		case "06":
			return "Junho";
		case "07":
			return "Julho";
		case "08":
			return "Agosto";
		case "09":
			return "Setembro";
		case "10":
			return "Outubro";
		case "11":
			return "Novembro";
		case "12":
			return "Dezembro";
		default:
			throw new IllegalArgumentException("mes " + mounthNumber + " nao é um mes válido");
		}
	}

	public static Date getDate(String formatDate, String date) throws ParseException {
		SimpleDateFormat dt = new SimpleDateFormat(formatDate);
		return dt.parse(date);
	}

	public static Date sumDaysToDate(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return c.getTime();
	}

	/**
	 * 
	 * @param dataDe
	 *            Data Inicio
	 * @param dataAte
	 *            Data fim
	 * @return int diferenca de dias, e -1 caso de erro
	 * @author Leonardo Costa
	 */
	public static int getDiferencaDiasEntreDatas(String dataDe, String dataAte) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);

		try {
			Date d1 = df.parse(dataDe);

			Date d2 = df.parse(dataAte);

			long diferencaDias = (d2.getTime() - d1.getTime());
			return (int) (diferencaDias / 86400000L); //
		} catch (ParseException e) {
			return -1;
		}
	}

	/**
	 * @param Date
	 *            data - Data a ser adicionada dias
	 * @param qtd
	 *            Quantidade de dias a ser adicionado ou subtraido
	 * @return Date - data alterada pela quantidade de dias informado no
	 *         parametro
	 * @author Leonardo Costa
	 */
	public static Date addDiaData(Date data, int qtd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DAY_OF_YEAR, qtd);
		return calendar.getTime();
	}
	
	/**
	 * @param Date
	 *            data - Data a ser adicionada meses
	 * @param qtd
	 *            Quantidade de meses a ser adicionado ou subtraido
	 * @return Date - data alterada pela quantidade de meses informado no
	 *         parametro
	 * @author Leonardo Costa
	 */
	public static Date addMesData(Date data, int qtd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, qtd);
		return calendar.getTime();
	}
	
	/**
	 * @param Date
	 *            data - Data a ser adicionada anos
	 * @param qtd
	 *            Quantidade de anos a ser adicionado ou subtraido
	 * @return Date - data alterada pela quantidade de anos informado no
	 *         parametro
	 * @author Leonardo Costa
	 */
	public static Date addAnoData(Date data, int qtd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.YEAR, qtd);
		return calendar.getTime();
	}

	/**
	 * Zera a hora, minuto e segundo de uma data
	 * 
	 * @param date
	 * @param hourOfDay
	 * @param minute
	 * @param second
	 * @param ms
	 * 
	 *  @author Leonardo Costa
	 * 
	 * @return Date
	 */
	public static Date setTime(final Date date, final int hourOfDay, final int minute, final int second, final int ms) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.set(Calendar.HOUR_OF_DAY, hourOfDay);
		gc.set(Calendar.MINUTE, minute);
		gc.set(Calendar.SECOND, second);
		gc.set(Calendar.MILLISECOND, ms);
		return gc.getTime();
	}

}
