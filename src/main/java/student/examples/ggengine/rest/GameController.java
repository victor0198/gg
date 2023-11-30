package student.examples.ggengine.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import student.examples.ggengine.events.StartGameEventPublisher;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
@Slf4j
public class GameController {
    @Autowired
    StartGameEventPublisher startGameEventPublisher;

    @GetMapping("/join/{id}")
    public Long jonGame(@PathVariable Long id){

        // take an ID of the player

        // signal the start of the new game
        startGameEventPublisher.publishCustomEvent();

        return id;
    }

    @GetMapping("/leave/{id}")
    public Long leaveGame(@PathVariable Long id){
        return id;
    }
}
