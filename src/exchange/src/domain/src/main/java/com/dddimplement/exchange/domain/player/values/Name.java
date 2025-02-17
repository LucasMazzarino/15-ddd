package com.dddimplement.exchange.domain.player.values;

import com.dddimplement.shared.domain.generic.IValueObject;

public class Name implements IValueObject {
    private final  String name;

    private Name(String name) {
        this.name = name;
        validate();
    }

    public static Name of(String name) {
        return new Name(name);
    }

    @Override
    public void validate() {

    }
}
