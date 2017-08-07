package edu.mum.tvtube.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

		@RequestMapping("/index")
		public String sayHello(Model model){
			model.addAttribute("name", "Prasanna");
			return "index.jsp";
		}
}
