package student.examples.ggengine.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import student.examples.ggengine.events.SignInEventPublisher;
import student.examples.ggengine.services.GameService;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
@Slf4j
public class GameController {

    @Autowired
    GameService gameService;
    @Autowired
    SignInEventPublisher signInEventPublisher;

    @GetMapping("/join/{uuidString}")
    public ResponseEntity<?> jonGame(@PathVariable String uuidString){
        // join the player
        log.info(uuidString);
        if(!gameService.playerSigned(uuidString)){
            return new ResponseEntity<>("{\"status\": \"failed\", \"message\": \"unauthorized game access\"}", HttpStatus.UNAUTHORIZED);
        }

        signInEventPublisher.publishSigningInEvent(uuidString);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/leave/{id}")
    public Long leaveGame(@PathVariable Long id){
        return id;
    }
}
