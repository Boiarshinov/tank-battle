package dev.boiarshinov.tankbattle.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FightController {

    @MessageMapping("/fight")
    @SendTo("/biba/snapshots")
    public FightSnapshot lolkek() {
        return new FightSnapshot(
            List.of(
                new FightSnapshot.PlayerPositionSnapshot(1, 0, 13),
                new FightSnapshot.PlayerPositionSnapshot(1, 11, 0)
            )
        );
    }
}
