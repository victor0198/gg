package student.examples.ggengine.services;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import student.examples.ggengine.game.PlayerFactory;
import student.examples.ggengine.game.SignUpData;

import java.sql.*;

@Service
@Getter
@Setter
@Slf4j
public class AuthService {
    @Autowired
    GameService gameService;
    @Autowired
    PlayerFactory playerFactory;

    public void signin(SignUpData signUpData) {
        gameService.getAllParticipants().add(playerFactory.createPlayer(signUpData));

        log.info(gameService.getAllParticipants().toString());

    }
}
