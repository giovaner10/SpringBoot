package academydevdojo.springboot22essentials.repository;

import academydevdojo.springboot22essentials.domain.Anime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DisplayName("Test for Anime Repository")
class AnimeRepositoryTest {

    @Autowired
    private  AnimeRepository animeRepository;

    @Test
    @DisplayName("save creates sucess")
    void save_PersistAnime_WhenSucessful(){

        Anime animeSaved = this.animeRepository.save(createAnime());
        Assertions.assertThat(animeSaved).isNotNull();
        Assertions.assertThat(animeSaved.getId()).isNotNull();
        Assertions.assertThat(animeSaved.getName()).isEqualTo(createAnime().getName());
    }

    private Anime createAnime(){
        return Anime.builder().name("created_for_ANIME_test")
                .build();
    }

}