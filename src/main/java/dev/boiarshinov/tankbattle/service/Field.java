package dev.boiarshinov.tankbattle.service;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
public class Field {
    Integer id;
    Dimensions dimensions;
    Character[][] dotes;
    List<PlayersPrepositionInfo> playersPrepositions;
    String creator;

    public Field(
        final Integer id,
        final Character[][] dotes,
        final List<PlayersPrepositionInfo> playersPrepositions,
        final String creator
    ) {
        this.id = id;
        this.dotes = dotes;
        this.playersPrepositions = playersPrepositions;
        this.creator = creator;
        this.dimensions = Dimensions.of(dotes);
    }

    @Value
    @Builder
    public static class Dimensions {
        int horizontal;
        int vertical;

        public static Dimensions of(Character[][] dots) {
            final int vertical = dots.length;
            final int horizontal = dots[0].length;

            return Dimensions.builder()
                .horizontal(horizontal)
                .vertical(vertical)
                .build();
        }
    }

    @Value
    public static class PlayersPrepositionInfo {
        int playersCount;
        List<PlayerStartZone> startZones;

        public static PlayersPrepositionInfo of(final List<PlayerStartZone> startZones) {
            return new PlayersPrepositionInfo(startZones.size(), startZones);
        }
    }

    @Value
    public static class PlayerStartZone {
        int playerNum;
        int horizontal;
        int vertical;
    }
}
