package stackjava.com.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class CdSource {
	public static void main(String[] args) {
		try {

			// liet ke cac file trong thu muc hien hanh
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "dir");

			// run command line at: C:\\ (nó tương ứng với lệnh cd C:/
			builder.directory(new File("C:\\"));

			// thực thi command line
			Process p = builder.start();

			// lấy kết quả trả về trên command line
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while (true) {
				line = r.readLine();
				if (line == null) {
					break;
				}
				System.out.println(line);
			}
		} catch (Exception ex) {
			System.out.println("loi CdSource.main: " + ex.toString());
		}
	}
}
