package netcracker.project.petshop.controller;

import netcracker.project.petshop.service.PetshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetshopController {
    @Autowired
    private PetshopService petShopService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showPetshopPage() {
        return "petshop";
    }

    @RequestMapping(value = "/animalList", method = RequestMethod.GET)
    public String viewAnimals(Model model) {
        model.addAttribute("animals", petShopService.getAnimalList());
        return "animalList";
    }
}
