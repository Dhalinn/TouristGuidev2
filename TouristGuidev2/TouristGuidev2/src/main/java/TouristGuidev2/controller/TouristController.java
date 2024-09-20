package TouristGuidev2.controller;

import TouristGuidev2.model.TouristAttraction;
import TouristGuidev2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("attractions")
public class TouristController {

    private final TouristService touristService;


    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // Get /attractions
    @GetMapping
    public String getAllAttractions(Model model) {
        ArrayList<TouristAttraction> attractions = new ArrayList<>(touristService.getAllAttractions());
        model.addAttribute("attractions", attractions);
        return "attractions";
    }

    // Get /attractions/name
    @GetMapping("/{name}")
    public String getAttractionByName(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getAttractionByName(name);

        if (attraction != null) {
            model.addAttribute("attraction", attraction);
            return "attraction-details";  // Til detail side attraction/name/
        } else {
            return "not-found";
        }
    }
    // Get /attractions/add
    @GetMapping("/add")
    public String addAttractionForm(Model model) {
        model.addAttribute("attraction", new TouristAttraction());
        return "add-attraction"; //
    }
// Get /attraction/name/tags
    @GetMapping("/{name}/tags")
    public String showTags(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getAttractionByName(name);

        if (attraction != null) {
            model.addAttribute("attractionName", attraction.getName());
            model.addAttribute("tags", attraction.getTags()); //
            return "tags";
        } else {
            return "not-found"; //
        }
    }

    // Post /attractions/save
    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return "redirect:/attractions"; // Redirects til /attraction
    }

    // Get /attractions/name/edit
    @GetMapping("/{name}/edit")
    public String editAttractionForm(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
        model.addAttribute("attraction", attraction);
        return "edit-attraction"; // // Virker ikke endnu
    }

    // Post /attractions/update
    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.updateAttraction(attraction.getName(), attraction.getDescription());
        return "redirect:/attractions"; // Virker ikke endnu
    }

    // Post /attractions/delete/name
    @PostMapping("/delete/{name}")
    public String deleteAttraction(@PathVariable String name) {
        touristService.deleteAttraction(name);
        return "redirect:/attractions"; // Virker ikke endnu
    }
}
