package com.myshop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myshop.domain.Notice;
import com.myshop.domain.Product;
import com.myshop.domain.User;
import com.myshop.dto.UserSession;
import com.myshop.service.NoticeService;
import com.myshop.service.UserService;
import com.myshop.vo.NoticeForm;

@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*5,
		maxRequestSize=1024*1024*5*5
)

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/notice-upload")
	public String noticeUploadPage() {
		return "notice-upload";
	}
	
	@PostMapping("/notice/upload")
	public String noticeUplaod(NoticeForm noticeForm, HttpServletRequest request, HttpSession session) throws IOException, ServletException {
		
		
		UserSession userSession = (UserSession)session.getAttribute("user");
		User user = userService.findUser(userSession.getId());
		
		Part filePart = request.getPart("img");
		String fileName = filePart.getSubmittedFileName();
	
		if(fileName.equals("")) {
			Notice notice = new Notice(noticeForm.getTitle(), noticeForm.getContent(), null, user);
			noticeService.saveNotice(notice);
			
			return "redirect:/";
		}	
		
		String realPath = request.getServletContext().getRealPath("/upload");
		System.out.println(realPath.indexOf("webapp"));
		
		String temp = "";
		
		for(int i=0; i < realPath.indexOf("webapp"); i++) {
			temp += realPath.charAt(i);
		}
		
		String publicRealPath = temp + "resources" +  File.separator + "public" + File.separator + "upload" + File.separator;
		
		String filePath = publicRealPath + fileName;
		
		String clientPath = "/public/upload/" + fileName;
		
		InputStream fis = filePart.getInputStream();
		FileOutputStream fos = new FileOutputStream(filePath);
		
		byte[] buffer = new byte[1024];
		
		int size = 0;
		while((size = fis.read(buffer)) != -1) {
			fos.write(buffer, 0, size);
		}
		
		Notice notice = new Notice(noticeForm.getTitle(), noticeForm.getContent(), clientPath, user);
		noticeService.saveNotice(notice);
		
		return "redirect:/";
	}
	
	@GetMapping("/notice/list")
	public String noticeList(Model model) {
		
		List<Notice> notices = noticeService.getAllNotice();
		
		for(int i=0; i<notices.size(); i++) {
			System.out.println("notice " + i + "번째 제목 " + notices.get(i).getTitle());
		}
		
		model.addAttribute("notices", notices);
		
		return "notice-list";
	}
}
