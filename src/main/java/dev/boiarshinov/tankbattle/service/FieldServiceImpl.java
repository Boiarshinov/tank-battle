package dev.boiarshinov.tankbattle.service;

import dev.boiarshinov.tankbattle.exception.NotFoundException;
import one.util.streamex.StreamEx;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Service
public class FieldServiceImpl implements FieldService {

    private static final Map<Integer, Field> fields = new HashMap<>();

    /** Поле */ private static final Character F = 'F';
    /** Куст */ private static final Character B = 'B';
    /** Камень */ private static final Character S = 'S';
    /** Река */ private static final Character R = 'R';

    static {
        final List<Field> fieldList = List.of(
            new Field(
                0,
                "DOTA",
                new Character[][]{
                    new Character[]{F, F, F, S, F, F, F, F, F, F, F, S, F, F},
                    new Character[]{F, F, F, F, F, B, B, B, S, F, F, F, F, F},
                    new Character[]{F, F, F, R, F, B, F, B, F, F, F, B, F, B},
                    new Character[]{F, S, F, R, R, B, B, B, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, R, R, F, F, S, B, B, B, F, F},
                    new Character[]{F, F, B, B, B, R, F, F, F, B, F, B, S, F},
                    new Character[]{F, S, B, F, B, F, F, F, R, B, B, B, F, F},
                    new Character[]{F, F, B, B, B, S, F, F, R, R, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, B, B, B, R, R, F, S, F},
                    new Character[]{S, F, S, F, F, F, B, F, B, F, R, F, F, F},
                    new Character[]{F, F, F, F, F, S, B, B, B, F, F, F, F, F},
                    new Character[]{F, F, S, F, F, F, F, F, F, F, S, F, F, F},
                },
                List.of(
                    Field.PlayersPrepositionInfo.of(
                        List.of(
                            new Field.PlayerStartZone(
                                1, 0, 11
                            )
                        )
                    ),
                    Field.PlayersPrepositionInfo.of(
                        List.of(
                            new Field.PlayerStartZone(
                                1, 0, 11
                            ),
                            new Field.PlayerStartZone(
                                2, 13, 0
                            )
                        )
                    )
                ),
                "system"
            ),
            new Field(
                1,
                "Empty",
                new Character[][]{
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, F, F, F, F},
                },
                List.of(
                    Field.PlayersPrepositionInfo.of(
                        List.of(
                            new Field.PlayerStartZone(
                                1, 0, 11
                            )
                        )
                    ),
                    Field.PlayersPrepositionInfo.of(
                        List.of(
                            new Field.PlayerStartZone(
                                1, 0, 11
                            ),
                            new Field.PlayerStartZone(
                                2, 13, 0
                            )
                        )
                    ),
                    Field.PlayersPrepositionInfo.of(
                        List.of(
                            new Field.PlayerStartZone(
                                1, 0, 11
                            ),
                            new Field.PlayerStartZone(
                                2, 6, 0
                            ),
                            new Field.PlayerStartZone(
                                3, 13, 11
                            )
                        )
                    )
                ),
                "system"
            ),
            new Field(
                2,
                "Dzuba",
                new Character[][]{
                    new Character[]{B, B, B, R, F, F, S, S, F, F, F, F, F, F},
                    new Character[]{B, B, S, R, F, F, S, S, F, F, F, F, F, F},
                    new Character[]{B, B, B, R, F, F, F, F, F, F, F, F, F, F},
                    new Character[]{B, B, S, R, F, B, F, F, F, F, F, F, F, F},
                    new Character[]{B, B, B, R, F, B, F, F, F, F, F, F, F, F},
                    new Character[]{B, B, S, R, F, B, F, F, F, F, R, R, F, F},
                    new Character[]{F, F, R, R, F, F, F, F, B, F, R, S, B, B},
                    new Character[]{F, F, F, F, F, F, F, F, B, F, R, B, B, B},
                    new Character[]{F, F, F, F, F, F, F, F, B, F, R, S, B, B},
                    new Character[]{F, F, F, F, F, F, F, F, F, F, R, B, B, B},
                    new Character[]{F, F, F, F, F, F, S, S, F, F, R, S, B, B},
                    new Character[]{F, F, F, F, F, F, S, S, F, F, R, B, B, B},
                },
                List.of(
                    Field.PlayersPrepositionInfo.of(
                        List.of(
                            new Field.PlayerStartZone(
                                1, 0, 11
                            )
                        )
                    ),
                    Field.PlayersPrepositionInfo.of(
                        List.of(
                            new Field.PlayerStartZone(
                                1, 0, 11
                            ),
                            new Field.PlayerStartZone(
                                2, 13, 0
                            )
                        )
                    )
                ),
                "system"
            )
        );
        fields.putAll(
            StreamEx.of(fieldList)
                .mapToEntry(Field::getId, Function.identity())
                .toMap()
        );
    }

    @Override
    public Field findById(final Integer id) {
        return Optional.ofNullable(fields.get(id))
            .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<Field> findAll() {
        return StreamEx.of(fields.values())
            .filter(Objects::nonNull)
            .sortedBy(Field::getId)
            .toList();
    }
}
