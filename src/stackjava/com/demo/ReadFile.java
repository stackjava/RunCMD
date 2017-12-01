package stackjava.com.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadFile {
	public static void main(String[] args) {
		try {

			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",
					"type C:\\a.txt");
			// thực thi command line
			Process p = builder.start();

			// lấy kết quả trả về trên command line
			BufferedReader r = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (Exception ex) {
			System.out.println("loi ReadFile.main: " + ex.toString());
		}
	}
}
