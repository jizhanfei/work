package com.cty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cty.common.ImageUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping("upload")
public class UploadController {
	
	@RequestMapping("uploadPic")
	public void uploadPic(HttpServletRequest request,PrintWriter out,String fileName) throws IOException{
		MultipartHttpServletRequest mp = (MultipartHttpServletRequest) request;
		//根据文件名获取文件流
		CommonsMultipartFile cmr =  (CommonsMultipartFile) mp.getFile(fileName); 
		
		byte[] bt =  cmr.getBytes();
		//文件再服务器中可能重复
		String newFileName = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		newFileName = sdf.format(new Date());
		
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			newFileName = newFileName+i;
		}
		//获取图片后缀名
		String orifinalFilename = cmr.getOriginalFilename();
		//获得图片后缀
		String sufix = orifinalFilename.substring(orifinalFilename.lastIndexOf("."));
		String resource = ImageUtil.IMAGE_HOST;
		//创建jesy服务器，进行跨服务器上传
		Client client = Client.create();
		String imagePath=resource+"/upload/"+newFileName+sufix;
		//把文件关联到远程服务器
		WebResource wr =  client.resource(imagePath);
		wr.put(String.class, bt);
		
		String fullPath = imagePath;
		//文件相对路径
		String relativePath ="/upload/"+newFileName+sufix;
	
		//以json的格式传递给客户端
		String json = "{\"fullpath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\"}";
		String result="{\"fullPath\":\""+fullPath+"\",\"relativePath\":\""+relativePath+"\"}";

		out.print(result);
	}
}
