## Read Me First
The following tools have been used for development:

* Debian 10
* IntelliJ Community Edition 2020.2
* Adopt OpenJDK 14
* Spring Boot 2.3.4
* Lombok (to reduce boilerplate code)

## Reference Documentation

The domain models are;
- Point, an abstraction for the numbering system Love, Fifteen, Thirty, Forty, Advantage and Game.
- Player with a name (String) and a point (Point Enum)
- Game, which consist of two players
all domain model contain state, no behaviour.

The service models are;
- Score, the scoring engine with the peculiar tennis logic
- Tennis, the API

SpringBoot is used to wire the components together.
It has a demo mode that plays one game of tennis with random scoring.

Unit-tests with Mockito is used to test most of the logic.

## Design considerations

I tried to keep things as simple as possible, POJO's with state and no behaviour.
Service models with behaviour and not state.
Most of the code is refactored towards single responsibilities.

# How to run the application
The application has a demo mode, please run:
java -jar target/katatennis-0.0.1-SNAPSHOT.jar

or run the maven install or test command to see the output of the unit-tests.
