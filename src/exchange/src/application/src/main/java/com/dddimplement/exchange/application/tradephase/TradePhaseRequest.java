package com.dddimplement.exchange.application.tradephase;

import com.buildingblocks.shared.application.Request;

public class TradePhaseRequest extends Request {
    private String playerId;
    private String offerId;
    private Integer offerAmount;
    private String offerType;

    public TradePhaseRequest(String aggregateId, String playerId, String offerId, Integer offerAmount, String offerType) {
        super(aggregateId);
        this.playerId = playerId;
        this.offerId = offerId;
        this.offerAmount = offerAmount;
        this.offerType = offerType;
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
}