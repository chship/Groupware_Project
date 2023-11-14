package com.kdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.dao.ApprovalResponsiblesDAO;
import com.kdt.dto.ApprovalResponsiblesDTO;

@Service
public class ApprovalResponsiblesService {
	@Autowired
	private ApprovalResponsiblesDAO dao;
	
	public List<Integer> getDocIdByUserId(String id) {
		return dao.getDocIdByUserId(id);
	}
	public List<Integer> getPendingDocIdByUserId(String id) {
		return dao.getPendingDocIdByUserId(id);
	}
	public List<Integer> getApproveDocIdByUserId(String id) {
		return dao.getApproveDocIdByUserId(id);
	}
	public List<Integer> getReturnDocIdByUserId(String id) {
		return dao.getReturnDocIdByUserId(id);
	}
	
	public List<String> getManagerIdList(int docId) {
		return dao.getManagerIdList(docId);
	}
	public int updateStatus(ApprovalResponsiblesDTO dto) {
		System.out.println(dto.getDoc_id());
		return dao.updateStatus(dto);
	}
}
