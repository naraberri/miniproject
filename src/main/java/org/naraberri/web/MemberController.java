package org.naraberri.web;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.naraberri.domain.Criteria;
import org.naraberri.domain.MemberVO;
import org.naraberri.domain.PageMaker;
import org.naraberri.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@CrossOrigin
@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	MemberService ms;

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@GetMapping("/create")
	public void create() throws Exception {
		logger.info("Get create call.....");
	}

	@PostMapping("/create")
	public String pCreate(MemberVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("Post create call........");

		ms.create(vo);

		logger.info(vo.toString());

		rttr.addFlashAttribute("msg", "success");

		return "redirect:Page?page=1";
	}

	@GetMapping("/view")
	public void view(Model model, Integer mno) throws Exception {
		logger.info("view call........");
		model.addAttribute("read", ms.read(mno));

	}

	@GetMapping("/update")
	public void update() throws Exception {
		logger.info("Get update call.......");
	}

	@PostMapping("/update")
	public String pUpdate(MemberVO vo, int page, RedirectAttributes rttr) throws Exception {
		logger.info("Post update call........");
		ms.update(vo);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:Page?page=" + page + "&msg=success";
	}

	@PostMapping("/delete")
	public String pDelete(@RequestParam("mno") int mno, Criteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("Post delete call.......");
		ms.delete(mno);
		rttr.addFlashAttribute("page", cri.getPage());
		rttr.addFlashAttribute("msg", "success");

		return "redirect:Page?page=" + cri.getPage() + "&msg=success";
	}

	@GetMapping("/Page")
	public void Page(Model model, Integer page) throws Exception {
		logger.info("memberPage call........");
		model.addAttribute("Page", ms.Page(page));
		model.addAttribute("pageMaker", new PageMaker(page, ms.count(page)));
	}

	@GetMapping("/pageSearch")
	public String pageSearch(Model model, Criteria cri, Integer page) throws Exception {
		logger.info("pageSearch call.............");
		model.addAttribute("Page", ms.pageSearch(cri));
		model.addAttribute("pageMaker", new PageMaker(cri.getPage(), ms.countSearch(cri)));
		return "/member/Page";
	}

	@GetMapping("/sortCondition")
	public String listSort(Model model, Criteria cri) throws Exception {
		logger.info("sortCondition call......");
		model.addAttribute("Page", ms.sortCondition(cri));
		model.addAttribute("pageMaker", new PageMaker(cri.getPage(), ms.countSearch(cri)));
		return "member/Page";
	}

	@PostMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(MultipartFile file) throws Exception {

		UUID uid = UUID.randomUUID();

		String fileName = file.getOriginalFilename();

		String uploadName = uid + "_" + fileName;

		BufferedImage origin = ImageIO.read(file.getInputStream());
		BufferedImage destImg = new BufferedImage(origin.getWidth(), origin.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

		Graphics2D g = destImg.createGraphics();
		g.drawImage(origin, 0, 0, null);
		g.dispose();
		origin = destImg;

		destImg = Scalr.resize(origin, Scalr.Mode.FIT_EXACT, 150, Scalr.OP_ANTIALIAS);

		FileOutputStream fos = new FileOutputStream("C:\\yyy\\" + file.getOriginalFilename());
		FileOutputStream foss = new FileOutputStream("C:\\yyy\\" + uploadName);
		ImageIO.write(origin, "jpg", fos);

		ImageIO.write(destImg, "jpg", foss);

		fos.close();
		foss.close();

		return uploadName;
	}

	@GetMapping(value = "/show", produces = { "image/gif", "image/jpeg", "image/jpg", "image/png" }) // ����Ÿ��
	public @ResponseBody byte[] show(String name) throws Exception {

		InputStream in = new FileInputStream("C:\\yyy\\" + name);

		return IOUtils.toByteArray(in);

	}

	@PostMapping("/upload")
	public String upload(String sname, String scompany, MultipartFile profile, Model model) throws Exception {
		logger.info("sname : " + sname);
		logger.info("scompany : " + scompany);
		logger.info("profile : " + profile);

		model.addAttribute("uploadName", profile);

		return "success";
	}

	@GetMapping("/login")
	public void login() {
		logger.info("login get......");
	}

	@PostMapping("/login")
	public String pLogin(Model model, MemberVO vo) throws Exception {

		logger.info("login post..");
		logger.info("id: " + vo.getUserid());
		logger.info("pw: " + vo.getUserpw());

		boolean loginCheck = ms.login(vo);

		if (loginCheck == true) {
			logger.info("성공");

			model.addAttribute("value", vo.getUserid());

			return "/member/Page?page=1";

		}
		logger.info("실패");

		return "redirect:./loginFail";

	}

	@PostMapping("/logout")
	public String logout() throws Exception {

		logger.info("logout .....");

		return "redirect:./login";

	}

	@GetMapping("/loginFail")
	public void loginFail() {
		logger.info("loginFail call......");
	}

}
