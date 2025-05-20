package com.example.analisedado.model;

import java.util.List;

public class PlayerResponse {
    private List<Player> players;
    private Long tempoFinal;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Long getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal(Long tempoFinal) {
        this.tempoFinal = tempoFinal;
    }
}
