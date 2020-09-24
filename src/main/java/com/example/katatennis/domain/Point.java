package com.example.katatennis.domain;

public enum Point {
    Love,
    Fifteen,
    Thirty,
    Forty,
    Advantage,
    Game {
        /**
         * @return Game as next value of Game
         */
        @Override
        public Point increment() {
            return Game;
        };
    };

    /**
     * @return next value of enum Point
     */
    public Point increment() {
        return values()[ordinal() + 1];
    }
}
