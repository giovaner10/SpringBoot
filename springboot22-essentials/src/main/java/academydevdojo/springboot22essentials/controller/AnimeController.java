package academydevdojo.springboot22essentials.controller;

import java.time.LocalDateTime;
import java.util.List;
import academy.devdojo.springboot.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import academy.devdojo.springboot.domain.Anime;
import academy.devdojo.springboot.service.AnimeService;
import academy.devdojo.springboot.util.DataUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RestController
@RequestMapping(path = "animes") //no plural
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final DataUtil dataUtil = new DataUtil();
    private final AnimeService animeService = new AnimeService();

    @GetMapping(path="lista")
    public ResponseEntity<List<Anime>> list(){
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
    }

    @GetMapping( path="food")
    public String food(){
        return dataUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()); // List.of(new String("é como muito prazer e satisfação que eu to comecando no spring boot"));
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id){
        return new ResponseEntity<>(animeService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Anime> replace(@RequestBody Anime anime){
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
