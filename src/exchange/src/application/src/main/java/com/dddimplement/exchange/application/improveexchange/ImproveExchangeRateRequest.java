package com.dddimplement.exchange.application.improveexchange;

import com.buildingblocks.shared.application.Request;

public class ImproveExchangeRateRequest extends Request {
    private final String tradeId;
    private final Integer valueOrdered;
    private final Integer valueReceived;

    public ImproveExchangeRateRequest(String tradeId, Integer valueOrdered, Integer valueReceived) {
        super(null);
        this.tradeId = tradeId;
        this.valueOrdered = valueOrdered;
        this.valueReceived = valueReceived;
    }

    public String getTradeId() {
        return tradeId;
    }

    public Integer getValueOrdered() {
        return valueOrdered;
    }

    public Integer getValueReceived() {
        return valueReceived;
    }
}