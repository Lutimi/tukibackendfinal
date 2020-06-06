package com.acme.tukibackend.service.route;

import com.acme.tukibackend.model.route.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RouteService {
    Page<Route> getAllRoutes(Pageable pageable);
    Route getRouteById(Long routeId);
    Route createRoute(Route route);
    Route updateRoute(Long routeId, Route routeDetails);
    }
