package stackjava.com.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Delete {
	public static void main(String[] args) {
		String filePath = "a.txt";
		try {
			// tạo processbuilder
			ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "del \"" + filePath + "\" ");

			// run command line at: D:\\ (nó tương ứng với lệnh cd D:/
			builder.directory(new File("D:\\"));

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
			System.out.println("loi delete: " + ex.toString());
		}
	}

}
/*
 * Syntax DEL [options] [/A:file_attributes] files_to_delete
 * 
 * Key files_to_delete : This can be a filename, a list of files or a Wildcard
 * Nếu fileName là 1 folder thì tất cả các file trong folder bị xóa nhưng folder
 * thì không options /P Give a Yes/No Prompt before deleting. /F Ignore
 * read-only setting and delete anyway (FORCE) /S Delete from all Subfolders
 * (DELTREE) /Q Quiet mode, do not give a Yes/No Prompt before deleting.
 * 
 * /A Select files to delete based on file_attributes
 * 
 * file_attributes: R Read-only -R NOT Read-only S System -S NOT System H Hidden
 * -H NOT Hidden A Archive -A NOT Archive
 * 
 * Wildcards: These can be combined with part of a filename
 * 
 * Match any characters ? Match any ONE character
 * 
 * 
 * Examples:
 * 
 * Delete "Hello World.txt"
 * 
 * DEL "Hello World.txt"
 * 
 * Delete all files that start with the letter A
 * 
 * DEL A*
 * 
 * Delete all files that end with the letter A
 * 
 * DEL *A.*
 * 
 * Delete all files with a .doc extension:
 * 
 * DEL *.doc
 * 
 * Delete all read only files:
 * 
 * DEL /a:R *
 * 
 * Delete all files including any that are read only:
 * 
 * DEL /F *
 */