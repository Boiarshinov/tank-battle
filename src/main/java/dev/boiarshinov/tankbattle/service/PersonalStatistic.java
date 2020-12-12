package dev.boiarshinov.tankbattle.service;

import lombok.Value;

@Value
public class PersonalStatistic {
    int userId;
    String name;
    Rang rang;
    int points;

    public PersonalStatistic(final int userId, final String name, final int points) {
        this.userId = userId;
        this.name = name;
        this.points = points;
        this.rang = Rang.fromPoints(points);
    }
}
