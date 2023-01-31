package com.ensim.TP3.controller;

import com.ensim.TP3.model.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MeteoController {
    @Autowired
    ObjectMapper objectMapper;
    @PostMapping("/meteo")
    public String addresse(@RequestParam(name="address", required=false, defaultValue="Paris") String
                                   address, Model model) throws JsonProcessingException {
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

        url = "https://api.meteo-concept.com/api/forecast/daily/0?" +
                "token=49ebc7df4a3c06e8608243d8750cfb77291995a174bd8a7ec64f861f999d0ef3&latlng="
                + latitude + ',' + longitude + "&world=false";

        JsonNode result = restTemplate.getForObject(url, JsonNode.class);
        model.addAttribute("result", result.toString());

        result = restTemplate.getForObject(url, JsonNode.class);
        Weather forecast = objectMapper.readValue(result.toString(), Weather.class);


        model.addAttribute("forecast",forecast);

        return "meteo";
    }
}
