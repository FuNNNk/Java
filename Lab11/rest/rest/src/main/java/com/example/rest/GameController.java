package com.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    private final List<Player> players = new ArrayList<>();
    public GameController(){
        players.add(new Player(0,"Alex"));
        players.add(new Player(1,"Marcel"));
    }

    @GetMapping
    public List<Player> getPlayers(){
        return players;
    }
    @GetMapping("/count")
    public int countPlayers(){
        return players.size();
    }


    @PostMapping
    public int createPlayer(@RequestParam String name){
        int id = 1 + players.size();
        players.add(new Player(id,name));
        return id;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name){
        Player player = players.get(id);
        if(player == null){
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
        player.setName(name);
        return new ResponseEntity<>("Player updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id){
        Player player = players.get(id);
        if(player == null){
            return new ResponseEntity<>("Player not found", HttpStatus.GONE);
        }
        players.remove(player);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }
}
