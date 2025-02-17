package com.dddimplement.exchange.domain.trade.events;

import com.dddimplement.shared.domain.generic.DomainEvent;

public class NewTradeReceived extends DomainEvent {
    private final String tradeId;
    private final Integer newRate;

    public NewTradeReceived(String tradeId, Integer newRate) {
        super(EventsEnum.NEW_OFFER_RECEIVED.name());
        this.tradeId = tradeId;
        this.newRate = newRate;
    }

    public String getOfferId() {
        return tradeId;
    }

    public Integer getNewRate() {
        return newRate;
    }
}
