package com.jk.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUtil {
	
	private static final String url = "upload";
	
	/**
	 *   poi  上传文件方法
	 *
	 */
	public static String FileUpload(MultipartFile file, HttpServletRequest request){

		//保存文件的目标目录
       String savePath = request.getSession().getServletContext().getRealPath(url);
		
		//获取源文件后缀名称
		//12345.jpg
		int suffixIndex = file.getOriginalFilename().lastIndexOf(".");
		//  .jpg
		String suffixName = file.getOriginalFilename().substring(suffixIndex);

		String newFileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
		
		//检测目标目录是否存在
		File targetFile = new File(savePath, newFileName);
		if(!targetFile.exists()){
			//创建目标目录
			targetFile.mkdirs();
		}

		try {
			// 使用transferTo（dest）方法将上传文件写到服务器上指定的文件。
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		savePath = url + "/" + newFileName;
		return savePath;
	}

	/**
	 * 文件下载方法
	 * @param filePath 文件路径
	 * @return
	 */
	public static ResponseEntity<byte[]> FileDownload(String filePath, String fileName){

		ResponseEntity<byte[]> entity = null;

		//获取源文件地址

		//获取源文件
		File sourceFile = new File(filePath);

		//设置头部信息（文件信息包括文件名称和下载文件类型）
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		//文件下载
		try {
			entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(sourceFile), headers, HttpStatus.CREATED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entity;
	}

	/**
	 * 文件上传方法  图片
	 * @return
	 */

	public static String upload(MultipartFile file, HttpServletRequest request) {

		if (file != null && file.getSize() > 0) {
			// 上传文件的名字
			String name = file.getOriginalFilename();
			// 获取后缀名
			String suffix = name.substring(name.lastIndexOf("."));
			// 生成唯一标示
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();
			// 文件名 唯一
			String prefix = format.format(date);

			String realPath = request.getServletContext().getRealPath("upload");

			File fileTemp = new File(realPath, prefix + suffix);
			if (!fileTemp.getParentFile().exists()) {
				fileTemp.getParentFile().mkdirs();
				try {
					fileTemp.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			try {
				file.transferTo(fileTemp);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return prefix + suffix;
		} else {
			return "not found";
		}

	}



}
