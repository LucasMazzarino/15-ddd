package com.dddimplement.exchange.application.tradephase;

import com.buildingblocks.shared.application.Request;

public class TradePhaseRequest extends Request {
    private String playerId;
    private String offerId;
    private Integer offerAmount;
    private String offerType;
    private Integer counterOfferAmount;
    private String counterOfferType;

    public TradePhaseRequest(String playerId, String offerId, Integer offerAmount, String offerType, Integer counterOfferAmount, String counterOfferType) {
        super(null);
        this.playerId = playerId;
        this.offerId = offerId;
        this.offerAmount = offerAmount;
        this.offerType = offerType;
        this.counterOfferAmount = counterOfferAmount;
        this.counterOfferType = counterOfferType;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public Integer getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(Integer offerAmount) {
        this.offerAmount = offerAmount;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
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