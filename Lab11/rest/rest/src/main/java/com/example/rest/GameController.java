package com.example.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private PlayersRepository playersRepository;

    @GetMapping
    public @ResponseBody Iterable<Player> getPlayers(){
        return playersRepository.findAll();
    }

    @PostMapping
    public @ResponseBody String createPlayer(@RequestParam String name){
        Player player = new Player();
        player.setName(name);
        playersRepository.save(player);
        return "Saved";
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String name){
        Player player = new Player();
        if(player == null){
            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
        }
        player.setName(name);
        return new ResponseEntity<>("Player updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id){
        Player player = new Player();
        if(player == null){
            return new ResponseEntity<>("Player not found", HttpStatus.GONE);
        }
        deletePlayer(id);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }
}
