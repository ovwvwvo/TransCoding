package transcoding;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class GBK2UTF8 {
	public static void main(String[] args) {

		String GBK_DirPath = "D:\\GBK_path"; // GBK文件存放路径

		String UTF8_DirPath = "D:\\UTF-8_path"; // UTF-8文件存储路径

		// 获取所有.java文件
		Collection<File> javaGbkFileCol = FileUtils.listFiles(new File(
				GBK_DirPath), new String[] { "java" }, true);
		System.out.println("start...");
		int i = 1;
		for (File javaGbkFile : javaGbkFileCol) {
			
			String utf8FilePath = UTF8_DirPath
					+ javaGbkFile.getAbsolutePath().substring(
							GBK_DirPath.length());
			// 使用GBK读取数据，然后用UTF-8写入数据
			try {
				FileUtils.writeLines(new File(utf8FilePath), "UTF-8",
						FileUtils.readLines(javaGbkFile, "GBK"));
				System.out.println("working...." + i + javaGbkFileCol.size());
			} catch (IOException e) {
				System.out.println("err...." + i);
			} finally {
				i++;
			}
		}
		System.out.println("end !!!");
	}
}
