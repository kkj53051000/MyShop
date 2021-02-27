package com.myshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.domain.Notice;
import com.myshop.repository.NoticeRepository;

@Service
@Transactional
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;
	
	public void saveNotice(Notice notice) {
		noticeRepository.insertNotice(notice);
	}
	
	public List<Notice> getAllNotice(){
		List<Notice> notices = noticeRepository.selectAllNotices();
		
		return notices;
	}
}
