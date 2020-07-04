package com.acme.tukibackend.controller.route;

import com.acme.tukibackend.model.route.Challenge;
import com.acme.tukibackend.resource.route.ChallengeResource;
import com.acme.tukibackend.resource.route.SaveChallengeResource;
import com.acme.tukibackend.service.route.ChallengeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "https://tukilatam.vercel.app", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class ChallengeController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ChallengeService challengeService;

    @GetMapping("/challenges")
    public Page<ChallengeResource> getAllChallenges(Pageable pageable) {
        List<ChallengeResource> challenges = challengeService.getAllChallenges(pageable).getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int challengesCount = challenges.size();
        return new PageImpl<>(challenges, pageable, challengesCount);
    }

    @GetMapping("/challenges/{id}")
    public ChallengeResource getChallengeById(@PathVariable(name = "id") Long challengeId) {
        return convertToResource(challengeService.getChallengeById(challengeId));
    }

    @PostMapping("/challenges/{routeId}")
    public ChallengeResource createChallenge(@PathVariable(name = "routeId") Long routeId,
            @Valid @RequestBody SaveChallengeResource resource) {
        return convertToResource(challengeService.createChallenge(routeId, convertToEntity(resource)));
    }

    @PutMapping("/challenges/{id}")
    public ChallengeResource updateChallenge(@PathVariable(name = "id") Long challengeId, @Valid @RequestBody SaveChallengeResource resource) {
        return convertToResource(challengeService.updateChallenge(challengeId, convertToEntity(resource)));
    }


    private Challenge convertToEntity(SaveChallengeResource resource) {
        return mapper.map(resource, Challenge.class);
    }

    private ChallengeResource convertToResource(Challenge entity) {
        return mapper.map(entity, ChallengeResource.class);
    }
}
