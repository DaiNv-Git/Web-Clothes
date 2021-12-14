package com.example.demo.Service;

import com.example.demo.Model.news;
import com.example.demo.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsRepository newsrepo;
    public List<news>getAllNews(){
        List<news> news = newsrepo.findAll();
        return news;
    }
    public news getDetail(int id){
        return newsrepo.findById(id).get();
    }
    public void delete(int id){
        newsrepo.deleteById(id);
    }
    public news addNews(news news){
      return   newsrepo.save(news);
    }
    public news updateNews(news news){
       return newsrepo.save(news);
    }
}
