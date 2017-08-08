package edu.mum.tvtube.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.tvtube.Domain.Episode;
import edu.mum.tvtube.Service.EpisodeService;

@Controller
@RequestMapping("/episode")
public class EpisodeController {
	@Autowired
	EpisodeService episodeService;
		

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String addEpisode(){
		return "episode/addEpisode";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String addEpisode(Episode episode){
		episodeService.create(episode);
		return "redirect:/episode/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getAllEpisodes(Model model){
		List<Episode> episodeList = episodeService.getAllEpisodes();
		 model.addAttribute("episodeList", episodeService.getAllEpisodes());
		 return "episode/episodeList";
	}

	@RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	public String showDetail(@PathVariable int id, Model model){	
		model.addAttribute("episode", episodeService.findEpisode(id));
		return "episode/episodeDetail";
	}
	
	@RequestMapping(value="/detail/{id}", method=RequestMethod.POST)
	public String update(Episode episode, @PathVariable int id) {
		episode.setId(id);
		episodeService.update(episode); 
		return "redirect:/episode/list";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
	public String delete(@PathVariable int id) {
		Episode episode = episodeService.findEpisode(id);
		episodeService.delete(episode); 
		return "redirect:/episode/list";
	}
}
