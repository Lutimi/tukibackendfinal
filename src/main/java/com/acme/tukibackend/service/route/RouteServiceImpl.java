package com.acme.tukibackend.service.route;

import com.acme.tukibackend.exception.ResourceNotFoundException;
import com.acme.tukibackend.model.route.Route;
import com.acme.tukibackend.repository.route.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route getRouteById(Long routeId) {
        return routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route", "Id", routeId));
    }

    @Override
    public Page<Route> getAllRoutes(Pageable pageable) {
        return routeRepository.findAll(pageable);
    }

    @Override
    public Route createRoute(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Long routeId, Route routeDetails ) {
        return routeRepository.findById(routeId).map(route -> {
            route.setTitle(routeDetails.getTitle());
            route.setContent(routeDetails.getContent());
            route.setDescription(routeDetails.getDescription());
            return routeRepository.save(route);
        }).orElseThrow(() -> new ResourceNotFoundException("Route", "Id", routeId));
    }
}
