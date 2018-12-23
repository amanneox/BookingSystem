package com.api.api.controller;

import com.api.api.exception.ResourceNotFoundException;
import com.api.api.model.GameModel;
import com.api.api.repository.GameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GameController {

    @Autowired
    private GameRepo GameRepo;

    @GetMapping("/game")
    public Page<GameModel> getGames(Pageable pageable) {
        return GameRepo.findAll(pageable);
    }


    @GetMapping("/game/{GameId}")
    public Optional<GameModel> getGameById(@PathVariable Long GameId) {
        return GameRepo.findById(GameId);

    }

    @PostMapping("/game")
    public GameModel createGame(@Valid @RequestBody GameModel game) {
        return GameRepo.save(game);
    }

    @PostMapping("/game/update/{GameId}")
    public GameModel updateGame(@PathVariable Long GameId,
                                @Valid @RequestBody GameModel GameRequest) {
        return GameRepo.findById(GameId)
                .map(game -> {

                    game.setName(GameRequest.getName());
                    game.setDescription(GameRequest.getDescription());
                    return GameRepo.save(game);
                }).orElseThrow(() -> new ResourceNotFoundException("game not found with id " + GameId));
    }


    @PostMapping("/game/delete/{GameId}")
    public ResponseEntity<?> deleteGame(@PathVariable Long GameId) {
        return GameRepo.findById(GameId)
                .map(game -> {
                    GameRepo.delete(game);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("game not found with id " + GameId));
    }
}
