package ssm.springframework.springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping({"", "/", "/index"})
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping("/oups")
	public String oopsHandler() {
		return "notImplemented";
	}
}
