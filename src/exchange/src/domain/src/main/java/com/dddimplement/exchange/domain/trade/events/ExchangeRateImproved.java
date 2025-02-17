package com.dddimplement.exchange.domain.trade.events;

import com.dddimplement.shared.domain.generic.DomainEvent;

public class ExchangeRateImproved extends DomainEvent {
    private final Integer newRate;

    public ExchangeRateImproved(Integer newRate) {
        super(EventsEnum.EXCHANGE_RATE_IMPROVED.name());
        this.newRate = newRate;
    }

    public Integer getNewRate() {
        return newRate;
    }
}
