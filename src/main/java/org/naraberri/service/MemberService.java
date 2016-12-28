package org.naraberri.service;

import java.util.List;

import org.naraberri.domain.Criteria;
import org.naraberri.domain.MemberVO;

public interface MemberService {

	public void create(MemberVO vo) throws Exception;

	public MemberVO read(Integer mno) throws Exception;

	public void update(MemberVO vo) throws Exception;

	public void delete(Integer mno) throws Exception;

	public List<MemberVO> Page(int page) throws Exception;

	public List<MemberVO> pageSearch(Criteria cri) throws Exception;

	public int count(int page) throws Exception;

	public int countSearch(Criteria cri) throws Exception;

	public List<MemberVO> sortCondition(Criteria cri) throws Exception;

	public boolean login(MemberVO vo) throws Exception;

}
