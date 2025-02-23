package com.dddimplement.exchange.application.endturn;

import com.buildingblocks.shared.application.Request;

public class EndTurnRequest extends Request {
    private String playerId;

    public EndTurnRequest(String playerId) {
        super(null);
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}