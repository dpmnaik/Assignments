package com.Tekion.Cricket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CricketGameController {
    @GetMapping("/startCricket")
    public MatchResult playGame()
    {
       return new MatchController().getMatchResult();
    }

}
