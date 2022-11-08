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
import com.example.GameLibrary.domain.DeveloperRepository;

@Controller
public class GameLibController {
    @Autowired
    private GameRepository gRepository;
    @Autowired
    private DeveloperRepository devRepository;

    @RequestMapping(value = { "/main", "/home", "/index", "/" })
    public String homepage(Model model) {
        return "/homepage";
    }

    @RequestMapping(value = { "/games", "/gamelist" })
    public String gameList(Model model) {
        model.addAttribute("games", gRepository.findAll());
        return "/gamelist";
    }

    // Hae kaikki jonkun valmistajan vaatteet
    @RequestMapping(value = { "/gamesByDeveloper/{developer}" })
    public String gameListByDeveloper(@PathVariable("developer") String developer, Model model) {
        model.addAttribute("games", gRepository.findByDeveloper(developer));
        return "/gamelist";
    }

   // @RequestMapping(value = "/games", method = RequestMethod.GET)
   // public @ResponseBody List<Game> GameListRest() {
   //     return (List<Game>) gRepository.findAll();
    //}

   // @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    //public @ResponseBody Optional<Garmet> findGarmetRest(@PathVariable("id") Long garmetId) {
     //   return garmetRepository.findById(garmetId);
    //}

    @RequestMapping(value = "/add")
    public String addGame(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("developers", devRepository.findAll());
        return "/addGame";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("game") @Valid Game game, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/addGame";
        }
        gRepository.save(game);
        return "redirect:/games";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteGame(@PathVariable("id") Long gameId, Model model) {
        gRepository.deleteById(gameId);
        return "redirect:/games";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editGame(@PathVariable("id") Long gameId, Model model) {
        model.addAttribute("game", gRepository.findById(gameId));
        model.addAttribute("developers", devRepository.findAll());
        return "/editGame";
    }
}
