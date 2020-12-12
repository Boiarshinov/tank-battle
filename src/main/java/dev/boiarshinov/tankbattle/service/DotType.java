package dev.boiarshinov.tankbattle.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum DotType {
    FIELD('F'),
    BUSHES('B'),
    RIVER('R'),
    STONE('S');

    private final Character oneLetter;
}
