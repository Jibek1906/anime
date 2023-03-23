package com.list.anime.repository;

import com.list.anime.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeListRepository extends JpaRepository<Anime, Long> {
}