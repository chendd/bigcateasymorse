package demo.springmvc;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class SubmitDemoController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(SubmitDemoController.class);

	@RequestMapping("/demo/form.do")
	public String getForm(){
		return "/demo/form";
	}
	@RequestMapping("/demo/submit.do")
	public String submit(User user){
		return "redirect:/demo/show.do";
	}
	@RequestMapping("/demo/show.do")
	public String show(){
		return "/demo/show";
	}
	/**
	 * 自定义登陆界面的实现
	 * @return
	 */
	@RequestMapping("/demo/login.do")
	public String login(){
		return "/demo/login";
	}
	@RequestMapping("/demo/welcome.do")
	public String loginSuccess(){
		return "/demo/welcome";
	}
	
}
