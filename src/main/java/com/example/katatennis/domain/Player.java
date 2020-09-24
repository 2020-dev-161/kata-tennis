package com.example.katatennis.domain;

import lombok.Data;
import lombok.NonNull;

import static com.example.katatennis.domain.Point.Love;

@Data
public class Player {

    private final @NonNull String name;
    private Point point = Love;

    public void incrementPoint() {
        setPoint(point.increment());
    }
}
