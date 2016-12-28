package org.naraberri.service;

import java.util.List;

import org.naraberri.domain.Criteria;
import org.naraberri.domain.MemberVO;
import org.naraberri.persistence.MemberDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO mdao;

	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	@Override
	public void create(MemberVO vo) throws Exception {
		mdao.create(vo);

	}

	@Override
	public MemberVO read(Integer mno) throws Exception {
		return mdao.read(mno);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		mdao.update(vo);

	}

	@Override
	public void delete(Integer mno) throws Exception {
		mdao.delete(mno);

	}

	@Override
	public List<MemberVO> Page(int page) throws Exception {
		return mdao.Page(page);
	}

	@Override
	public List<MemberVO> pageSearch(Criteria cri) throws Exception {
		return mdao.pageSearch(cri);
	}

	@Override
	public int count(int page) throws Exception {
		int total = 0;

		total = mdao.count(page);

		return total;
	}

	@Override
	public int countSearch(Criteria cri) throws Exception {
		int total = 0;

		total = mdao.countSearch(cri);

		return total;
	}

	@Override
	public List<MemberVO> sortCondition(Criteria cri) throws Exception {

		return mdao.sortCondition(cri);
	}

	public boolean login(MemberVO vo) throws Exception {
		boolean tf = mdao.login(vo);
		System.out.println(tf + " true or false ");

		return mdao.login(vo);

	}

}
