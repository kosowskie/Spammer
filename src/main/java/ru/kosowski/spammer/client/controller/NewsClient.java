package ru.kosowski.spammer.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import ru.kosowski.spammer.client.model.NewsModel;

@Controller
public class NewsClient {
    private RestTemplate restTemplate;

    public NewsClient() {
        this.restTemplate = new RestTemplate();
    }

    public NewsModel getNews(){
        NewsModel newsModel = restTemplate.getForObject("https://api.currentsapi.services/v1/latest-news?apiKey=PPGqLsqfhCEgU2AohL-qUu0Z-UlQln6Y-ZsFKg2ke2OElInS", NewsModel.class);
        return newsModel;
    }
}