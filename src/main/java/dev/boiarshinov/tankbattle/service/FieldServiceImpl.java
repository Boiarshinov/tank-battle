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

    private static final Character F = 'F';
    private static final Character B = 'B';
    private static final Character S = 'S';
    private static final Character R = 'R';

    static {
        final List<Field> fieldList = List.of(
            new Field(
                1,
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
