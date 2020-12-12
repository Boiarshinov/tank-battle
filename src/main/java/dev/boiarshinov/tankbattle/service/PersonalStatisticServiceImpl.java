package dev.boiarshinov.tankbattle.service;

import dev.boiarshinov.tankbattle.exception.NotFoundException;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PersonalStatisticServiceImpl implements PersonalStatisticService {

    private static final Map<Integer, PersonalStatistic> statisticByUserId = new HashMap<>();

    static {
        final List<PersonalStatistic> personalStatistics = List.of(
            new PersonalStatistic(1, "Biba", 150),
            new PersonalStatistic(2, "Boba", 34)
        );

        statisticByUserId.putAll(StreamEx.of(personalStatistics)
            .mapToEntry(PersonalStatistic::getUserId, Function.identity())
            .toMap());
    }

    @Override
    public PersonalStatistic getFor(final Integer userId) {
        return Optional.ofNullable(statisticByUserId.get(userId))
            .orElseThrow(NotFoundException::new);
    }
}
