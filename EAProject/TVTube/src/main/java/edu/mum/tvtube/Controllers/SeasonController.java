package edu.mum.tvtube.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.tvtube.Domain.Season;
import edu.mum.tvtube.Service.SeasonService;

@Controller
@RequestMapping("/season")
public class SeasonController {
	@Autowired
	SeasonService seasonService;
		
	@RequestMapping()
	public String goHome(){
		return "season/seasonList";
	}
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String addSeason(){
		return "season/addSeason";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String addSeason(Season season){
		seasonService.create(season);
		return "redirect:/season/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getAllSeasons(Model model){
		List<Season> seasonList = seasonService.getAllSeasons();
		 model.addAttribute("seasonList", seasonService.getAllSeasons());
		 return "season/seasonList";
	}

	@RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	public String showDetail(@PathVariable int id, Model model){	
		model.addAttribute("season", seasonService.findSeason(id));
		return "season/seasonDetail";
	}
	
	@RequestMapping(value="/detail/{id}", method=RequestMethod.POST)
	public String update(Season season, @PathVariable int id) {
		season.setId(id);
		seasonService.update(season); 
		return "redirect:/season/list";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable int id) {
		System.out.println("****** ID : " + id);
		Season season = seasonService.findSeason(id);
		seasonService.delete(season); 
		return "redirect:/season/list";
	}
}
