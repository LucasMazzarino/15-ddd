package com.dddimplement.exchange.application.startturn;

import com.buildingblocks.shared.application.Request;

public class StartTurnRequest extends Request {
    private String playerName;
    private String color;
    private String turnFase;

    public StartTurnRequest(String playerName, String color, String turnFase) {
        super(null);
        this.playerName = playerName;
        this.color = color;
        this.turnFase = turnFase;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTurnFase() {
        return turnFase;
    }

    public void setTurnFase(String turnFase) {
        this.turnFase = turnFase;
    }
}