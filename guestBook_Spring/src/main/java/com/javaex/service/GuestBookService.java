package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestBookDao;
import com.javaex.vo.GuestBookVo;

@Service
public class GuestBookService {

	@Autowired
	private GuestBookDao gbDao;
	
	
	public List<GuestBookVo> showList() {
		List<GuestBookVo> gbList = gbDao.showList();
		return gbList;
	}
	
	public void add(GuestBookVo gbVo) {
		gbDao.add(gbVo);
	}
	
	public int find(GuestBookVo gbVo) {
		int no = gbDao.find(gbVo);
		return no;
	}
	
	public void delete(int no) {
		gbDao.delete(no);
	}
	
}
