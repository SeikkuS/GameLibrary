package com.example.GameLibrary.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.GameLibrary.domain.Game;
import com.example.GameLibrary.domain.GameRepository;
import com.example.GameLibrary.domain.GenreRepository;
import com.example.GameLibrary.domain.DeveloperRepository;

@Controller
public class GameLibController {
    @Autowired
    private GameRepository gRepository;
    @Autowired
    private DeveloperRepository devRepository;
    @Autowired
    private GenreRepository genRepository;
    
    // Ohjaa kirjautumissivulle
    @RequestMapping(value = { "/main", "/home", "/index", "/" })
    public String loginpage(Model model) {
        return "/login";
    }
    
    @RequestMapping(value= "/login")
	public String login() {
		return "login";
	}
	

    @RequestMapping(value = {"/gamelist" })
    public String gameList(Model model) {
        model.addAttribute("games", gRepository.findAll());
        return "/gamelist";
    }

    // Hae kaikki jonkun valmistajan pelit
    @RequestMapping(value = { "/gamesByDeveloper/{developer}" })
    public String gameListByDeveloper(@PathVariable("developer") String developer, Model model) {
        model.addAttribute("games", gRepository.findByDeveloper(developer));
        return "/gamelist";
    }
    
    // REST 
    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public @ResponseBody List<Game> GameListRest() {
        return (List<Game>) gRepository.findAll();
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Game> findGameRest(@PathVariable("id") Long gameId) {
    return gRepository.findById(gameId);
    }
    
    // Pelin lisäys (syötetään myös Genre Dropdown -lista)
    @RequestMapping(value = "/add")
    public String addGame(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("genres", genRepository.findAll());
        return "addgame";
    }

    // Pelin tallennus
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("game") @Valid Game game, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addgame";
        }
        gRepository.save(game);
    // ohjataan takaisin listaan
        return "redirect:/gamelist";
    }
    
    // Delete -ominaisuus -ohjataan takaisin listaan lopuksi
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteGame(@PathVariable("id") Long gameId, Model model) {
        gRepository.deleteById(gameId);
        return "redirect:/gamelist";
    }

    // Edit -ominaisuus (syötetään myös Genre Dropdown -lista)
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editGame(@PathVariable("id") Long gameId, Model model) {
        model.addAttribute("game", gRepository.findById(gameId));
        model.addAttribute("genres", genRepository.findAll());
        return "/editgame";
    }
}
