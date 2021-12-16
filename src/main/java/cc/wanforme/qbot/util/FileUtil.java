package cc.wanforme.qbot.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;


/** 文件工具类
 * @author wanne
 * 2020年9月21日
 */
public class FileUtil {

	
	/** 检查文件重名并重命名
	 * @param path 相对路径或绝对路径
	 * @return
	 */
	public static String checkAndRenameFile(String path){
		int count = 0;
		String newname = path;
		
		int in = path.lastIndexOf('.');
		String part1 = path;
		String suffix = "";
		if(in > 0 )  {
//			newname =  +"("+count+")" +path.substring(in);
			part1 = path.substring(0, in);
			suffix = path.substring(in);
		}
		
		do {
			File file = new File(newname);
			if( !Files.exists(file.toPath(), LinkOption.NOFOLLOW_LINKS) ) {
				break;
			}
			
			count++;
			newname = part1+"("+count+")" +suffix;
		} while(true);
		
		
		return newname;
	}

	/** 检查端点续传，如果是续传，则在输入流中进行偏移
	 * @param request 
	 * @param inputStream
	 * @throws IOException
	 */
	protected static void offsetPointer(InputStream inputStream, HttpServletRequest request) throws IOException {
		long pos=0; //文件读取的位置
		String range = request.getHeader("Range");
		System.out.println("Range: "+range);
		if(range != null) {//断点续载
			/* "Content-Range: bytes x-(y-1)/y" 例如: Content-Range: bytes 16-14385736/14385737*/
			try {
				pos = Long.parseLong(range.replace("bytes=", "").split("-")[0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.err.println("Range: "+range+" is not a number!");
			}
		}
		
		inputStream.skip(pos);
	}
	
	/** 上传文件*/
	public static void saveFile(MultipartFile file, File saveFile) throws IOException {
		if(!saveFile.getParentFile().exists()) {
			saveFile.getParentFile().mkdirs();
		}
		
		try (InputStream is = file.getInputStream();
			 FileOutputStream fos = new FileOutputStream(saveFile);) {
			byte[] bs = new byte[10240];
			int len = 0;
			while ( (len = is.read(bs)) != -1) {
				fos.write(bs, 0, len);
			}
		}
	}
	
	
	/** 保存文件
	 * @param stream
	 * @param outPath 输出文件
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void saveFile(InputStream stream, String outPath) 
			throws IOException {
		File file = new File(outPath).getAbsoluteFile();
		File parentFile = file.getParentFile();
		
		if(parentFile != null && 
				(!parentFile.exists() || !parentFile.isDirectory())) {
			parentFile.mkdirs();
		}
		
		try(FileOutputStream fos = new FileOutputStream(file)) {
			int len = 0;
			byte[] bs = new byte[10240];
			while( (len = stream.read(bs)) != -1) {
				fos.write(bs, 0, len);
			}
		}
	}
	
	/** 保存文件
	 * @param stream
	 * @param outPath 输出文件
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void saveFile(byte[] bs, String outPath) 
			throws IOException {
		File file = new File(outPath).getAbsoluteFile();
		File parentFile = file.getParentFile();
		
		if(parentFile != null && 
				(!parentFile.exists() || !parentFile.isDirectory())) {
			parentFile.mkdirs();
		}
		
		int size = 2048;
		try(FileOutputStream fos = new FileOutputStream(file)) {
			for(int i=0; i<bs.length; i++) {
				int start = i;
				int len = size;
				
				if((start+len)>=bs.length) {
					len = bs.length-start;
				}
				fos.write(bs, start, len);
			}
		}
	}
	
	public static void main(String[] args) {
		String url = "https://i.pixiv.cat/img-original/img/2021/11/13/12/29/34/94101036_p0.png";
		String path = "94101036_p0.png";
		
		
	}
	
}
