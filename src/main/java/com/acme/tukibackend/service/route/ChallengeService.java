package com.acme.tukibackend.service.route;

import com.acme.tukibackend.model.route.Challenge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChallengeService {
    Page<Challenge> getAllChallenges(Pageable pageable);
    Challenge getChallengeById(Long challengeId);
    Challenge createChallenge(Challenge challenge);
    Challenge updateChallenge(Long challengeId, Challenge challengeDetails);
    }
