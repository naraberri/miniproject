package org.naraberri.web;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.naraberri.domain.Criteria;
import org.naraberri.domain.MemberVO;
import org.naraberri.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class TestDAO {

	@Autowired
	private DataSource ds;
	@Autowired
	private MemberDAO mdao;

	@Test
	public void testDS() throws Exception {
		Connection con = ds.getConnection();
		System.out.println(con);
		con.close();
	}

	@Test
	public void testDBConnection() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://192.168.0.15:3306/bit88?useSSL="
				+ "false&serverTimezone=Asia/Seoul", 														// 붙어야한다.
				"localhost", "bit88");

		System.out.println(con);
	}

	@Test
	public void testInsert() throws Exception {
		MemberVO vo = new MemberVO();

		vo.setUserid("nnn");
		vo.setUserpw("nnn");
		vo.setUsername("이수연");
		vo.setEmail("onecolor@onecolor.net");

		System.out.println(vo);
		
		mdao.create(vo);

	}
	
	@Test
	public void testRead() throws Exception{
		System.out.println(mdao.read(3));
	}
	
	@Test
	public void testUpdate() throws Exception {

		MemberVO vo = new MemberVO();
		
		vo.setUserpw("ggg");
		vo.setUsername("김진수");
		vo.setEmail("hashtag@hashtag.com");
		vo.setMno(7);
		
		mdao.update(vo);

	}
	
	@Test
	public void testDelete() throws Exception{
		mdao.delete(21);
	}
	
	@Test
	public void testPage() throws Exception {
		System.out.println(mdao.Page(1));
	}
	
	@Test
	public void testcount() throws Exception {
		System.out.println(mdao.count(1));
	}
	
	@Test
	public void testSearch() throws Exception {

		Criteria cri = new Criteria(0, "e", "com");

		mdao.countSearch(cri);

	}
	
	@Test
	public void sortCondition() throws Exception{
		Criteria cri = new Criteria(1, "", "");
		
		mdao.sortCondition(cri);
	}
	
	@Test
	public void testLogin() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setUserid("gonoble");
		vo.setUserpw("gonoble");
		boolean s = mdao.login(vo);
		System.out.println(s);
		
	}
 
}
