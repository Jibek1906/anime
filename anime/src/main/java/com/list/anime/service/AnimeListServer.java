package com.list.anime.service;

import com.list.anime.domain.Anime;
import com.list.anime.repository.AnimeListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeListServer {
    @Autowired
    private AnimeListRepository repo;
    public List<Anime> listAll() {
        return repo.findAll();
    }

    public void save(Anime std) {
        repo.save(std);
    }

    public Anime get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
