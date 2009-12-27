package demo.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourcesController {
	@RequestMapping("/resources.do")
	public String getResources() {
		System.out.println("执行到了这里");
		return "resources";
	}
}
