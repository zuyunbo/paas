package com.cloud.text;

import java.util.Optional;

public interface HasEntity extends Document {

    default Optional<Object> getObject() {
        return Optional.ofNullable(get("1"));
    }

}
