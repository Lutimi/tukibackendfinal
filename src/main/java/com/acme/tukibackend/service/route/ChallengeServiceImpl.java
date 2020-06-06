package com.acme.tukibackend.service.route;

import com.acme.tukibackend.exception.ResourceNotFoundException;
import com.acme.tukibackend.model.route.Challenge;
import com.acme.tukibackend.repository.route.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    @Override
    public Challenge getChallengeById(Long challengeId) {
        return challengeRepository.findById(challengeId)
                .orElseThrow(() -> new ResourceNotFoundException("Challenge", "Id", challengeId));
    }

    @Override
    public Page<Challenge> getAllChallenges(Pageable pageable) {
        return challengeRepository.findAll(pageable);
    }

    @Override
    public Challenge createChallenge(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    @Override
    public Challenge updateChallenge(Long challengeId, Challenge challengeDetails ) {
        return challengeRepository.findById(challengeId).map(challenge -> {
            challenge.setTitle(challengeDetails.getTitle());
            challenge.setDescription(challengeDetails.getDescription());
            challenge.setLatitude(challengeDetails.getLatitude());
            challenge.setLongitude(challengeDetails.getLongitude());
            challenge.setTukicoins(challengeDetails.getTukicoins());
            challenge.setRoute(challengeDetails.getRoute());
            return challengeRepository.save(challenge);
        }).orElseThrow(() -> new ResourceNotFoundException("Challenge", "Id", challengeId));
    }
}
