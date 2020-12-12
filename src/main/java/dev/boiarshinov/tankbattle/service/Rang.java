package dev.boiarshinov.tankbattle.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.EnumSet;

@Getter
@RequiredArgsConstructor
public enum Rang {
    SQUADDIE(0),
    SERGEANT(10),
    LIEUTENANT(30),
    CAPTAIN(100),
    MAJOR(250),
    COLONEL(500),
    GENERAL(1000);

    private final int points;

    public static Rang fromPoints(final int points) {
        return EnumSet.allOf(Rang.class).stream()
            .filter(rang -> rang.getPoints() <= points)
            .max(Comparator.comparingInt(Rang::getPoints))
            .orElseThrow();
    }
}
