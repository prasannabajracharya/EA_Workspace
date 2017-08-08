package edu.mum.tvtube.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.tvtube.Domain.Cast;
import edu.mum.tvtube.Service.CastService;

@Controller
@RequestMapping("/cast")
public class CastController {
	@Autowired
	CastService castService;
		
	@RequestMapping()
	public String goHome(){
		return "cast/castList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String addCast(){
		return "cast/addCast";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String addCast(Cast cast){
		castService.create(cast);
		return "redirect:/cast/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getAllCasts(Model model){
		List<Cast> castList = castService.getAllCasts();
		 model.addAttribute("castList", castService.getAllCasts());
		 return "cast/castList";
	}

	@RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	public String showDetail(@PathVariable int id, Model model){	
		model.addAttribute("cast", castService.findCast(id));
		return "cast/castDetail";
	}
	
	@RequestMapping(value="/detail/{id}", method=RequestMethod.POST)
	public String update(Cast cast, @PathVariable int id) {
		cast.setCastId(id);
		castService.update(cast); 
		return "redirect:/cast/list";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable int id) {
		System.out.println("****** ID : " + id);
		Cast cast = castService.findCast(id);
		castService.delete(cast); 
		return "redirect:/cast/list";
	}
}
