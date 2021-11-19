package academydevdojo.springboot22essentials.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import academy.devdojo.springboot.domain.Anime;

@Service
public class AnimeService {
    private static List<Anime> animes;
    static {
        animes = new ArrayList<>(List.of( new Anime("dbz", 1L), new Anime("dbccz", 2L)));
    }


    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(Long id){
        return animes.stream().filter(anime ->
                anime.getId().equals(id)).findFirst().orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "nao encontrado"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3,  4));
        animes.add(anime);
        return anime;
    }

    public void delete(Long id) {
        animes.remove(findById(id));

    }

    public void replace(Anime anime) {
        delete(anime.getId());
        animes.add(anime);
    }


}