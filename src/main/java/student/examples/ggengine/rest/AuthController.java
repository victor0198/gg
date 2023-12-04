package student.examples.ggengine.rest;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import student.examples.ggengine.game.SignUpData;
import student.examples.ggengine.services.AuthService;
import student.examples.ggengine.services.GameService;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
@Validated
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> jonGame(@Valid @RequestBody SignUpData signUpData, HttpServletResponse response){

        log.info(signUpData.username + " " + signUpData.password);

        if(signUpData.username==null || signUpData.password==null) {
            return new ResponseEntity<>("{\"error\":\"fields can not be empty\"}", HttpStatus.BAD_REQUEST);
        }

        authService.signin(signUpData);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
