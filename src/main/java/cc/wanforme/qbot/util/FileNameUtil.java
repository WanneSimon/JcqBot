package cc.wanforme.qbot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/** 文件名工具
 * @author wang_jian
 * @since 2021年6月30日
 */
public class FileNameUtil {

	
	/** 分割文件名；返回 不带扩展名的名字 和 扩展名；<br>
	 * 例如：abc.txt => [ "abc", ".txt" ]<br>
	 * 当 name 中没有扩展名时，返回数组中第二个为空字符串
	 * @param name
	 * @return
	 */
	public static String[] splite(String name) {
		String nameNoSuffix = name;
		String suffix = "";
		int dot = name.lastIndexOf('.');
		if(dot != -1) {
			nameNoSuffix = name.substring(0, dot);
			suffix = name.substring(dot);
		}
		return new String[]{ nameNoSuffix, suffix };
	}
	
	
	/** 获取文件名的扩展名
	 * @see #splite(String)
	 * @param name
	 * @return
	 */
	public static String getSuffix(String name) {
		return splite(name)[1];
	}
	
	/** 获取没有扩展名的文件名
	 * @see #splite(String)
	 * @param name
	 * @return
	 */
	public static String getNameNoSuffix(String name) {
		return splite(name)[0];
	}
	
	
	public synchronized static File checkAndRenameFile(String path, boolean createFile) throws IOException {
		return checkAndRenameFile(new File(path), createFile);
	}
	
	public synchronized static File checkAndRenameFile(File file, boolean createFile) throws IOException {
		file = checkAndRenameFile(file);
		
		// file = file.getAbsoluteFile();
		if(createFile) {
			if(file.getParentFile() != null && !file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
		}
		
		return file;
	}
	
	public static File checkAndRenameFile(String path) throws IOException {
		return checkAndRenameFile(new File(path));
	}
	
	/** 检查文件重名的情况，如果重名，则重命名 （使用windows的自动重命名方式，用小括号括起来，括号内写数字）<br>
	 * 如果检查之后要创建文件，建议使用 {@link #checkAndRenameFile(String, boolean)}，因为加锁安全
	 * @param path
	 * @param createFile 尝试找到可用名字时，是否立即创建文件，可用于防止多个线程
	 * @return 最后没有重名的文件对象
	 * @throws IOException 
	 */
	public static File checkAndRenameFile(File file) throws IOException {
		int dot = file.getName().lastIndexOf('.');
		if(dot==-1) {
			dot=file.getName().length();
		}
		
		String name = file.getName().substring(0, dot);
		String ex = file.getName().substring(dot, file.getName().length());
		
		int count = 0;
		while(file.exists()) {
			count++;
			file = new File(name+'('+count+')'+ex);
		}
		
		return file;
	}
	
	/**
	 * @param file
	 * @param newFile
	 * @param override 如果新文件已存在，是否覆盖
	 * @throws IOException 
	 */
	public static void renameFile(File file, File newFile, boolean override) throws IOException {
		try(FileInputStream is = new FileInputStream(file);
				FileOutputStream os = new FileOutputStream(newFile)) {
			int len = 0;
			byte[] bs = new byte[1024];
			while ( (len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
		}
		file.delete();
	}
	
//	public static void main(String[] args) {
//		System.out.println(Arrays.toString(splite("a.txt")));
//		System.out.println(Arrays.toString(splite("abc")));
//		System.out.println(Arrays.toString(splite("678.")));
//		System.out.println(Arrays.toString(splite(".ignore")));
//	}
	
}
