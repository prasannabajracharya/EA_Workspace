package edu.mum.tvtube.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.tvtube.Domain.Cast;
import edu.mum.tvtube.Service.CastService;

@Controller
public class CastController {
	@Autowired
	CastService castService;
		
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String showCast(){
		return "addCast";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String addCast(Cast cast){
		System.out.println(cast.getName());
		castService.create(cast);
		return "redirect:/create";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getAllCasts(Model model){
		List<Cast> castList = castService.getAllCasts();
		for(Cast cast:castList){
			System.out.println(cast.getName());
		}
		 model.addAttribute("castList", castService.getAllCasts());
		 return "castList";
	}
}
