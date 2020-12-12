package dev.boiarshinov.tankbattle.websocket;

import lombok.Value;

import java.util.List;

@Value
public class FightSnapshot {

    List<PlayerPositionSnapshot> playersSnapshot;

    @Value
    public static class PlayerPositionSnapshot {
        int playerNum;
        int vertical;
        int horizontal;
    }
}
