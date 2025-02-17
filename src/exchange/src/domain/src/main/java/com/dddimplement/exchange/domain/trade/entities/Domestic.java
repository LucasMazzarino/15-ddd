package com.dddimplement.exchange.domain.trade.entities;

import com.dddimplement.exchange.domain.trade.values.DomesticId;
import com.dddimplement.exchange.domain.trade.values.ExchangeRate;
import com.dddimplement.exchange.domain.trade.values.Value;
import com.dddimplement.shared.domain.generic.Entity;

public class Domestic extends Entity<DomesticId> {
    private ExchangeRate exchangeRate;

    // region Constructors
    public Domestic(DomesticId identity, ExchangeRate exchangeRate) {
        super(identity);
        this.exchangeRate = exchangeRate;
    }

    public Domestic(ExchangeRate exchangeRate) {
        super(new DomesticId());
        this.exchangeRate = exchangeRate;
    }
    // endregion

    //region Getters and Setters

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    //endregion

    //region Methods
    public void improveRate(Value newValueOrdered) {
        this.exchangeRate = ExchangeRate.of(newValueOrdered, this.exchangeRate.getValueReceived());
    }
    //endregion
}
