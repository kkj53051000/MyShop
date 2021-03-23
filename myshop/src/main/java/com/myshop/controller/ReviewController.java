package com.myshop.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myshop.domain.Productinfo;
import com.myshop.domain.Review;
import com.myshop.domain.Reviewimg;
import com.myshop.domain.User;
import com.myshop.dto.UserSession;
import com.myshop.service.ProductinfoService;
import com.myshop.service.ReviewService;
import com.myshop.service.ReviewimgService;
import com.myshop.service.UserService;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MultipartConfig(
		fileSizeThreshold=1024*1024,
		maxFileSize=1024*1024*5,
		maxRequestSize=1024*1024*5*5
)


@Controller
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductinfoService productinfoService;
	@Autowired
	private ReviewimgService reviewimgService;
	
	@GetMapping("/review-upload")
	public String reviewUploadPage(){
		return "review-upload";
	}
	/*
	@PostMapping("/review/uplaod")
	public String ReviewUpload(MultipartHttpServletRequest mtfrequest, HttpServletRequest request, HttpSession session) throws IOException {
		UserSession userSession = (UserSession)session.getAttribute("user");
		User user = userService.findUser(userSession.getId());
		
		
		List<MultipartFile> imgList = mtfrequest.getFiles("imgList");
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa : "+imgList.size());
		
		String content = request.getParameter("content");
		//long productId = Long.parseLong(request.getParameter("id"));
		
		long productId = 1;
		
		System.out.println("productId : " + productId);
		
		Productinfo productinfo = productinfoService.getInfo(productId);
		
		Review review = new Review(content, user, productinfo);
		
		reviewService.saveReview(review);
		
		for(int i=0; i<imgList.size(); i++) {
			
			Part filePart = imgList.get(i);
			
			String fileName = imgList.get(i).getSubmittedFileName();
			
			String realPath = request.getServletContext().getRealPath("/upload");
			System.out.println(realPath.indexOf("webapp"));
			
			String temp = "";
			
			for(int j=0; j < realPath.indexOf("webapp"); j++) {
				temp += realPath.charAt(j);
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
			
			Reviewimg reviewimg = new Reviewimg(clientPath, review);
			reviewimgService.saveReviewimg(reviewimg);
		}
	
		return "success";
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	public static class ReviewRequest{
		public Part imgList;
	}
	*/
	@PostMapping("/review/uplaod")
    public String ReviewUpload(MultipartHttpServletRequest mtfRequest, HttpServletRequest request, HttpSession session) {
        UserSession userSession = (UserSession)session.getAttribute("user");
        User user = userService.findUser(userSession.getId());
        
        
        List<MultipartFile> fileList = mtfRequest.getFiles("files");
        
        
        String content = request.getParameter("content");
        
        System.out.println("----------------------------------------------- 파일 사이즈 : "+ fileList.size());
        
        long productId = Long.parseLong(request.getParameter("id"));
        Productinfo productinfo = productinfoService.getInfo(productId);
         
        String realPath = request.getServletContext().getRealPath("/upload");
        
        String temp = "";
        
        for(int i=0; i < realPath.indexOf("webapp"); i++) {
            temp += realPath.charAt(i);
        }
        
        String publicRealPath = temp + "resources" +  File.separator + "public" + File.separator + "upload" + File.separator;
        
        Review review = new Review(content, user, productinfo);
        
        reviewService.saveReview(review);
        
         for(MultipartFile mf : fileList) {
        	 
        	
        	 
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            
            
            
            long fileSize = mf.getSize(); // 파일 사이즈
            
            String filePath = publicRealPath + originFileName;
            
            String clientPath = "/public/upload/" + originFileName;
            
            //System.out.println("clientPath : " + clientPath);
            
            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);
            
            Reviewimg reviewimg = new Reviewimg(clientPath, review);
            reviewimgService.saveReviewimg(reviewimg);
 
            try {
                mf.transferTo(new File(filePath));
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    
        return "redirect:/";
    }

	
	@GetMapping("/review")
	public String Review(HttpServletRequest request, Model model) {
		
		long reviewId = Long.parseLong(request.getParameter("id"));
		
		Review review = reviewService.findReview(reviewId);
		
		List<Reviewimg> reviewimgs = reviewimgService.getReviewimgs(reviewId);
		
		
		model.addAttribute("review", review);
		model.addAttribute("reviewimgs", reviewimgs);
		
		return "review-page";
	}
}
