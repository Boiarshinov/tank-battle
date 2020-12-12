package dev.boiarshinov.tankbattle.controller;

import dev.boiarshinov.tankbattle.exception.UnauthorizedException;
import dev.boiarshinov.tankbattle.service.PersonalStatistic;
import dev.boiarshinov.tankbattle.service.PersonalStatisticService;
import dev.boiarshinov.tankbattle.service.Rang;
import dev.boiarshinov.tankbattle.service.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import one.util.streamex.StreamEx;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/personal/statistic", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PersonalStatisticController {

    private final PersonalStatisticService service;

    private static final Map<String, User> usersByToken = new HashMap<>();

    static {
        usersByToken.put("1fdf04de", new User(1));
    }

    @GetMapping
    @Operation(parameters = {
        @Parameter(
            in = ParameterIn.HEADER,
            name = "Auth-Token",
            example = "1fdf04de")
    })
    public PersonalStatistic getPersonalStatistic(
        @Parameter(hidden = true)
        @RequestHeader(name = "Auth-token") String token
    ) {
        final User user = Optional.ofNullable(usersByToken.get(token))
            .orElseThrow(UnauthorizedException::new);
        return service.getFor(user.getUserId());
    }

    @GetMapping("/rangs")
    public List<RangResponse> getAllRangs() {
        return StreamEx.of(EnumSet.allOf(Rang.class))
            .map(RangResponse::of)
            .sortedBy(RangResponse::getRang)
            .toList();
    }

    @Value
    private static class RangResponse {
        Rang rang;
        int points;

        public static RangResponse of(final Rang rang) {
            return new RangResponse(rang, rang.getPoints());
        }
    }

}
