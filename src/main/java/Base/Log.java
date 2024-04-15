package Base;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

	private static FileWriter fileWriter;
	private static PrintWriter writer;
	static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
	static DateTimeFormatter data = DateTimeFormatter.ofPattern(" dd/MM/yyyy - HH:mm:ss");

	public static void criarArquivoLog(String nomeArquivo) {
		try {
			String caminhoCompleto = System.getProperty("user.dir") + "/src/main/java/registroDeLog/";
			String nome = nomeArquivo +"-"+ LocalDateTime.now().format(formato) + ".txt";
			
			fileWriter = new FileWriter(caminhoCompleto + nome);
			writer = new PrintWriter(fileWriter);
		} catch (IOException e) {

			e.printStackTrace();

		}
	}
	
	

	public static void registrar(String mensagem) {
		if (writer != null) {
			writer.println(mensagem + LocalDateTime.now().format(data));
			writer.flush();
		}
	}
	
	public static void line() {
		if (writer != null) {
			writer.println("==============================================================");
			writer.flush();
		}
	}

	public static void div() {
		if (writer != null) {
			writer.println("----------------------------------------------");
			writer.flush();
		}
	}
	
	public static void nomeTeste(String titulo) {
		if (writer != null) {
			Log.line();
			writer.println("-----" + titulo + "-----");
			writer.flush();
		}
	}
	
	public static void encerrarLog() {
		if (writer != null) {
			writer.close();
		}
	}
}
