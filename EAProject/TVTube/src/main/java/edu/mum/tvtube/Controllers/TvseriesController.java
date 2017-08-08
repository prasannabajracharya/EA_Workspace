package edu.mum.tvtube.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.tvtube.Domain.Tvseries;
import edu.mum.tvtube.Service.TvseriesService;

@Controller
@RequestMapping("/tvseries")
public class TvseriesController {
	@Autowired
	TvseriesService tvseriesService;
		

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String addTvseries(){
		return "tvseries/addTvseries";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String addTvseries(Tvseries tvseries){
		tvseriesService.create(tvseries);
		return "redirect:/tvseries/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getAllTvseriess(Model model){
		List<Tvseries> tvseriesList = tvseriesService.getAllTvseriess();
		 model.addAttribute("tvseriesList", tvseriesService.getAllTvseriess());
		 return "tvseries/tvseriesList";
	}

	@RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	public String showDetail(@PathVariable int id, Model model){	
		model.addAttribute("tvseries", tvseriesService.findTvseries(id));
		return "tvseries/tvseriesDetail";
	}
	
	@RequestMapping(value="/detail/{id}", method=RequestMethod.POST)
	public String update(Tvseries tvseries, @PathVariable int id) {
		tvseries.setId(id);
		tvseriesService.update(tvseries); 
		return "redirect:/tvseries/list";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable int id) {
		Tvseries tvseries = tvseriesService.findTvseries(id);
		tvseriesService.delete(tvseries); 
		return "redirect:/tvseries/list";
	}
}
