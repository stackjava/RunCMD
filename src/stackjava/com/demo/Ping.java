package stackjava.com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping {
	public static void main(String[] args) {
		try {
		// kiểm tra ping google.com (gửi 5 gói tin)
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "ping stackjava.com -t");
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
	} catch (IOException ex) {
		System.out.println("loi Ping: " + ex.toString());
	}
	}
}

/*
 * Cú pháp: ping ip/host/[/t][/a][/l][/n]
 * 
 * - Ip: địa chỉ IP của máy cần kiểm tra; host là tên của máy tính cần kiểm tra
 * kết nối mạng (có thể sử dụng địa chỉ IP hoặc tên của máy tính).
 * 
 * - /t: sử dụng để máy tính liên tục "ping" đến máy tính đích, bấm Ctrl +C để
 * dừng.
 * 
 * - /a: nhận địa chỉ IP từ tên máy tính (host).
 * 
 * - /l: xác định độ rộng của gói tin gửi đi kiểm tra.
 * 
 * - /n: Xác định số gói tin gửi đi.
 */
