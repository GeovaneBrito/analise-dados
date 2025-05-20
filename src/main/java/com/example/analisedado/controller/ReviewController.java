package com.example.analisedado.controller;

import com.example.analisedado.model.Player;
import com.example.analisedado.model.PlayerResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ReviewController {

    @Autowired
    private HttpSession httpSession;

    @PostMapping("/users")
    public String users( @RequestBody List<Player> player){
        long tempoInicial  = System.currentTimeMillis();
        httpSession.setAttribute("player", player);
        long tempoFinal = System.currentTimeMillis();
        long tempoTotal = tempoFinal - tempoInicial;
        return "Tempo de execucao : " + tempoTotal + " ms";
    }

    @GetMapping("/superusers")
    public ResponseEntity<PlayerResponse> superUsers(){
        long tempoInicial  = System.currentTimeMillis();
        Object objectSession = httpSession.getAttribute("player");
        if(objectSession ==null){
            return new ResponseEntity(new Erro("produto nao encontrado"), HttpStatus.NOT_FOUND);
        }
        List<Player> player =(List<Player>) objectSession;
        List<Player> superUsers = new ArrayList<>();
        for(Player p: player){
            if(p.getScore()>=900 && p.isActive())
                superUsers.add(p);
        }


        if(superUsers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        long tempoFinal = System.currentTimeMillis();
        long tempoTotal = tempoFinal - tempoInicial;
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setPlayers(superUsers);
        playerResponse.setTempoFinal(tempoTotal);
        return ResponseEntity.ok(playerResponse);
    }

    @GetMapping("/top-countries")
    public ResponseEntity<Map<String, Long>> topCountries(){
        String tempoInicial = String.valueOf(new Date().getTime());
        Object objectSession = httpSession.getAttribute("player");
        if(objectSession ==null){
            return new ResponseEntity(new Erro("produto nao encontrado"), HttpStatus.NOT_FOUND);
        }
        List<Player> player =(List<Player>) objectSession;
        List<Player> superUsers = new ArrayList<>();
        for(Player p: player){
            if(p.getScore()>=900 && p.isActive())
                superUsers.add(p);
        }


        if(superUsers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        String tempoFinal = String.valueOf(new Date().getTime());
        return ResponseEntity.ok(superUsers.stream().collect(Collectors.groupingBy(Player::getCountry, Collectors.counting())));
    }

    @GetMapping("/active-users-per-day")
    public ResponseEntity<List<Player>> activeUsersPerDay(){
        Object objectSession = httpSession.getAttribute("player");
        if(objectSession ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<Player> player =(List<Player>) objectSession;
        return ResponseEntity.ok(player);
    }

    @GetMapping("/evaluation")
    public ResponseEntity<List<Player>> evaluation(){
        Object objectSession = httpSession.getAttribute("player");
        if(objectSession ==null) {
            return new ResponseEntity(new Erro("produto nao encontrado"), HttpStatus.NOT_FOUND);
        }
        List<Player> player =(List<Player>) objectSession;
        return ResponseEntity.ok(player);
    }



}
