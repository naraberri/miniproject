package org.naraberri.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.naraberri.domain.Criteria;
import org.naraberri.domain.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	protected SqlSession sqlSession;

	private static String NAME = "org.naraberri.dao.MemberMapper";

	@Override
	public void create(MemberVO vo) throws Exception {
		sqlSession.insert(NAME + ".create", vo);
	}

	@Override
	public MemberVO read(Integer mno) throws Exception {
		return sqlSession.selectOne(NAME + ".read", mno);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		sqlSession.update(NAME + ".update", vo);
	}

	@Override
	public void delete(Integer mno) throws Exception {
		sqlSession.delete(NAME + ".delete", mno);
	}

	@Override
	public List<MemberVO> Page(int page) throws Exception {
		return sqlSession.selectList(NAME + ".Page", (page - 1) * 10);
	}

	@Override
	public List<MemberVO> pageSearch(Criteria cri) throws Exception {
		return sqlSession.selectList(NAME + ".listSearch", cri);
	}

	@Override
	public int count(int page) throws Exception {
		int total = sqlSession.selectOne(NAME + ".count");

		return total;
	}

	@Override
	public int countSearch(Criteria cri) throws Exception {
		int total = sqlSession.selectOne(NAME + ".countSearch", cri);

		return total;
	}

	@Override
	public List<MemberVO> sortCondition(Criteria cri) throws Exception {

		return sqlSession.selectList(NAME + ".sortCondition", cri);

	}

	public boolean login(MemberVO vo) throws Exception {

		String loginCheck = sqlSession.selectOne(NAME + ".login", vo);

		System.out.println(vo.getUserid());
		System.out.println(vo.getUserpw());
		if (loginCheck == null) {
			return false;
		}
		return true;

	}

}
