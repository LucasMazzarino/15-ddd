package com.dddimplement.exchange.application.counteroffer;

import com.buildingblocks.shared.application.Request;

public class CounterOfferRequest extends Request {
    private String playerId;
    private Integer counterOfferAmount;
    private String counterOfferType;

    public CounterOfferRequest(String aggregateId, String playerId, Integer counterOfferAmount, String counterOfferType) {
        super(aggregateId);
        this.playerId = playerId;
        this.counterOfferAmount = counterOfferAmount;
        this.counterOfferType = counterOfferType;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Integer getCounterOfferAmount() {
        return counterOfferAmount;
    }

    public void setCounterOfferAmount(Integer counterOfferAmount) {
        this.counterOfferAmount = counterOfferAmount;
    }

    public String getCounterOfferType() {
        return counterOfferType;
    }

    public void setCounterOfferType(String counterOfferType) {
        this.counterOfferType = counterOfferType;
    }
}