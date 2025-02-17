package com.dddimplement.exchange.domain.trade.values;

import com.dddimplement.shared.domain.generic.IValueObject;

public class TradeState implements IValueObject {
    private final Boolean state;

    private TradeState(Boolean state) {
        this.state = state;
        validate();
    }

    public static TradeState of(Boolean state) {
        return new TradeState(state);
    }

    @Override
    public void validate() {

    }
}
