package stackjava.com.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Copy {
	public static void main(String[] args) {
		// ví dụ copy file write.jar thành abc.jar
		copy("C:\\users\\minion\\desktop\\write.jar", "C:\\users\\minion\\desktop\\abc.jar");
	}

	public static void copy(String from, String destination) {
		try {
			// tạo processbuilder
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "copy " + from + "   " + destination + "");
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
			System.out.println("finished!");
		} catch (Exception ex) {
			System.out.println("exception copy: " + ex.toString());
		}
	}
}
