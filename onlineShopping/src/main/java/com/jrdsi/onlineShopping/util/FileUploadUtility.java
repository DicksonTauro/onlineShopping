package com.jrdsi.onlineShopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABSOLUTE_PATH = "D:/online-shopping-repository/onlineShopping/onlineShopping/src/main/webapp/assets/images/";
	
	private static String  REAL_PATH  = ""; 
	
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class); 
	
	
	
	public static void uploadFile(HttpServletRequest req, MultipartFile file, String code){
		
		//get the real path tomcat server deployment path
		
		REAL_PATH = req.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);
		
		if(!new File(ABSOLUTE_PATH).exists()){ //to make sure all the directory exists if not
			new File(ABSOLUTE_PATH).mkdirs(); // create the directory
		}
		
		if(!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			
			//server upload
			file.transferTo(new File(REAL_PATH +code+".jpg"));
			
			//project directory upload
			file.transferTo(new File(ABSOLUTE_PATH+code+".jpg"));
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

}
