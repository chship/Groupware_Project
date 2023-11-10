package com.kdt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kdt.dto.ApprovalDTO;
import com.kdt.dto.MembersDTO;
import com.kdt.dto.MembersDTO1;
import com.kdt.services.ApprovalService;
import com.kdt.services.MembersService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/approval/document")
@Controller
public class ApprovalController {
	@Autowired
	private HttpSession session;
	@Autowired
	private MembersService mService;
	@Autowired
	private ApprovalService appService;
	

	@RequestMapping("/write")
	public String write(Model model) throws Exception {
		MembersDTO1 userDTO = (MembersDTO1) session.getAttribute("userDTO");
		List<MembersDTO> approvalMembers = mService.selectApprovalMembers(userDTO);
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("approvalMembers", approvalMembers);
		
		System.out.println(approvalMembers);
		
		return "/approval/document/write";
	}
	
	@RequestMapping("/lists/all")
	public String listsAll(Model model) throws Exception {
		return "/approval/document/lists/all";
	}
	
	@RequestMapping("/insertApproval")
	public String insertApproval(String title, String contents, MultipartFile[] files) throws Exception {
		MembersDTO1 userDTO = (MembersDTO1) session.getAttribute("userDTO");
		ApprovalDTO appdto = new ApprovalDTO(0, userDTO.getId(), title, contents, false);
		String uploadPath = "c:/uploads";
		
		System.out.println(files);
		
		appService.insert(appdto, files, uploadPath);
		
		return "redirect:/approval/document/lists/all";
	}
	
	@RequestMapping(value="/left_item")
	public String toLeft_item(String selectItem, Model model) {
		model.addAttribute("selectItem", selectItem);
		
		return "/approval/document/left_item";
	}
}
