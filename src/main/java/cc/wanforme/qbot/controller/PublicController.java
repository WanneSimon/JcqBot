package cc.wanforme.qbot.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.wanforme.qbot.util.FileUtil;
import cc.wanforme.qbot.util.PathResource;

@Controller
@RequestMapping("/")
public class PublicController {
	private static final Logger log = LoggerFactory.getLogger(PublicController.class);
	
	@GetMapping("/file")
	@ResponseBody
	public void downloadFile(@RequestParam("p") String path, 
			HttpServletRequest request, HttpServletResponse response) {

		File file = new File(path);
		
		// 设置 6 分钟的缓存
		int cacheSeconds = 360; // 6*60
		response.setHeader("Cache-Control", "max-age="+cacheSeconds);
		
		// 3. 下载文件 
//		BufferedInputStream bis;
		try (InputStream fis = PathResource.loadResource(file.getPath())){
			FileUtil.downloadFile2Client(fis, file.getName(),
					true, request, response);
		} catch (IOException e) {
			log.error("文件不存在! " + path, e);
			this.writeError("文件不存在！", response);
		}
		
	}
	
	@GetMapping("/image")
	@ResponseBody
	public void downloadImage(@RequestParam("p") String path, 
			HttpServletRequest request, HttpServletResponse response) {

		File file = new File(path);
		
		// 设置 6 分钟的缓存 
		int cacheSeconds = 360; // 6*60
		response.setHeader("Cache-Control", "max-age="+cacheSeconds);
		
		// 3. 下载文件 
//		BufferedInputStream bis;
		try (InputStream fis = PathResource.loadResource(file.getPath())){
			FileUtil.downloadFile2Client(fis, file.getName(),
					true, request, response);
		} catch (IOException e) {
			log.error("文件不存在! " + path, e);
			this.writeError("文件不存在！", response);
		}
		
	}
	
	
	private void writeError(String msg, HttpServletResponse response) {
		try {
			response.getOutputStream().write(msg.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
