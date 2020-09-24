package com.example.katatennis.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Game {

    private final @NonNull Player playerOne;
    private final @NonNull Player playerTwo;
}
