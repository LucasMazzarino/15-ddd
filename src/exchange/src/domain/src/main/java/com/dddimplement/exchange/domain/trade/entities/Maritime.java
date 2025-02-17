package com.dddimplement.exchange.domain.trade.entities;

import com.dddimplement.exchange.domain.trade.values.ExchangeRate;
import com.dddimplement.exchange.domain.trade.values.MaritimeId;
import com.dddimplement.exchange.domain.trade.values.Value;
import com.dddimplement.shared.domain.generic.Entity;

public class Maritime extends Entity<MaritimeId> {
 private ExchangeRate exchangeDesired;

 // region Constructors
    public Maritime(MaritimeId identity, ExchangeRate exchangeRate) {
        super(identity);
        this.exchangeDesired = exchangeRate;
    }

    public Maritime(ExchangeRate exchangeRate) {
        super(new MaritimeId());
        this.exchangeDesired = exchangeRate;
    }
 // endregion

 //region Getters and Setters
    public ExchangeRate getExchangeRate() {
        return exchangeDesired;
    }

    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeDesired = exchangeRate;
    }
    //endregion

    //region Methods
    public void improveRate(Value newValueOrdered) {
        this.exchangeDesired = ExchangeRate.of(newValueOrdered, this.exchangeDesired.getValueReceived());
    }
    //endregion
}
