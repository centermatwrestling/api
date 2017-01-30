package com.centermat.api.io.rest;

import com.centermat.api.driver.EventMatchupDriver;
import com.centermat.api.model.*;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/eventMatchups")
@Api(position = 2, tags = {"Event Matchups"},description = "<a href='http://www.centermatwrestling.com/components/components/cmw-components/'>Web Component</a>")
public class EventMatchupRestController extends AbstractRestController<EventMatchup> {

    private final TeamRestController teamRestController;

    @Autowired
    public EventMatchupRestController(EventMatchupDriver driver, TeamRestController teamRestController) {
        super(EventMatchup.class, driver);
        this.teamRestController = teamRestController;
    }

    @RequestMapping(value = "/{id}/bouts", method = RequestMethod.GET)
    public List<Bout> bouts(@PathVariable UUID id) {
        if(id.equals(example_id)) {
            return generateBoutExamples();
        }
        return new ArrayList<>();
    }

    @Override
    public EventMatchup getExample() {
        return EventMatchup.builder()
                .id(UUID.randomUUID())
                .teams(Lists.newArrayList(
                        new TeamMatchup(Team.builder().id(UUID.randomUUID()).name("Test team1").build()),
                        new TeamMatchup(Team.builder().id(UUID.randomUUID()).name("Test team1").build())))
                .build();
    }

    private List<Bout> generateBoutExamples() {
        final Team team2 = teamRestController.getExample();
        final Team team = teamRestController.getExample();
        List<Bout> bouts = new ArrayList<>();
        for (Integer integer : Lists.newArrayList(109, 112, 125, 137, 149, 162, 174, 184, 197, 285)) {
            final Bout bout = Bout.builder()
                    .weightClass(WeightClass.builder().weight(integer).build())
                    .boutMatchupList(Lists.newArrayList(
                            BoutMatchup.builder()
                                    .wrestler(Wrestler.builder()
                                            .firstName("Wrestler " + integer)
                                            .team(team)
                                            .build())

                                    .build(),
                            BoutMatchup.builder()
                                    .wrestler(Wrestler.builder()
                                            .firstName("Wrestler " + integer + " (2)")
                                            .team(team2)
                                            .build())
                                    .build())
                    ).build();
            bouts.add(bout);
        }

        return bouts;
    }
}
