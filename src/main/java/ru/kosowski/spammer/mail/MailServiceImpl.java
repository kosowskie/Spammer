package ru.kosowski.spammer.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kosowski.spammer.client.controller.NewsClient;

import java.util.Random;

@Service
public class MailServiceImpl implements MailService{
    private NewsClient newsClient;
    private Random random;

    @Autowired
    public MailServiceImpl(NewsClient newsClient){
        this.newsClient = newsClient;
        this.random = new Random();
    }

    public String getTitle(){
        return newsClient.getNews().getNews().get(random.nextInt(newsClient.getNews().getNews().size()-1)).getTitle();
    }

    public String getContent(){
        return newsClient.getNews().getNews().get(random.nextInt(newsClient.getNews().getNews().size()-1)).getDescription();
    }
}