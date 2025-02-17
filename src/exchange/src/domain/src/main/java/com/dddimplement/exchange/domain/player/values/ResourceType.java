package com.dddimplement.exchange.domain.player.values;

import com.dddimplement.shared.domain.generic.IValueObject;

public class ResourceType implements IValueObject {
    private final  ResourceTypeEnum type;

    public ResourceType(ResourceTypeEnum type) {
        this.type = type;
        validate();
    }

    public static ResourceType of(ResourceTypeEnum type)
    {
        return new ResourceType(type);
    }

    @Override
    public void validate() {
        if (this.type == null) {
            throw new IllegalArgumentException("Resource type cannot be null");
        }
    }
}
