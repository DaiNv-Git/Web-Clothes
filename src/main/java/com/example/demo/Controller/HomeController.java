package com.example.demo.Controller;

import com.example.demo.Model.news;
import com.example.demo.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin
public class HomeController {
    @Autowired
    NewsService nService;
    @GetMapping("/news")
    public List<news> getAll(){
        return nService.getAllNews();
    }
    @GetMapping("/news/{id}")
    public news getDetail(@PathVariable("id") int id){
        return nService.getDetail(id);
    }
    @PostMapping("/insert")
    public ResponseEntity<news> getInsert(@RequestBody news news){
      news newss=  nService.addNews(news);
      return new ResponseEntity<>(newss,HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<news> getUpdate(@RequestBody news news, @PathVariable("id") int id){
     news newss =  nService.updateNews(news);
     return new ResponseEntity<>(newss, HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public  void deleteNews(@PathVariable("id") int id){
        nService.delete(id);
    }
}
