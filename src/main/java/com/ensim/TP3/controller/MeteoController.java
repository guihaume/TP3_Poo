package com.ensim.TP3.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MeteoController {

    @PostMapping("/meteo")
    public String addresse(@RequestParam(name="address", required=false, defaultValue="Paris") String
                                   address, Model model) {
        model.addAttribute("nomTemplate", address);
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api-adresse.data.gouv.fr/search/?q="+address+"&limit=1";
        JsonNode jsonResponse = restTemplate.getForObject(url, JsonNode.class);

        model.addAttribute("reponse", jsonResponse);

        JsonNode coordinates = jsonResponse.path("features").get(0).path("geometry").path("coordinates");
        double longitude = coordinates.get(0).asDouble();
        double latitude = coordinates.get(1).asDouble();


        model.addAttribute("latitude", latitude);
        model.addAttribute("longitude", longitude);



        return "meteo";
    }
}
