package academydevdojo.springboot22essentials.client;

import academydevdojo.springboot22essentials.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}",
                Anime.class, 19,24);

        Anime anime = new RestTemplate().getForObject("http://localhost:8080/animes/{id}",
                Anime.class, 19,24);

        log.info(anime);
    }
}
