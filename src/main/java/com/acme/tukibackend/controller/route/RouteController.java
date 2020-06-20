package com.acme.tukibackend.controller.route;


import com.acme.tukibackend.model.route.Route;
import com.acme.tukibackend.resource.route.RouteResource;
import com.acme.tukibackend.resource.route.SaveRouteResource;
import com.acme.tukibackend.service.route.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class RouteController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RouteService routeService;

    @GetMapping("/routes")
    public Page<RouteResource> getAllRoutes(Pageable pageable) {
        List<RouteResource> routes = routeService.getAllRoutes(pageable).getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int routesCount = routes.size();
        return new PageImpl<>(routes, pageable, routesCount);
    }

    @GetMapping("/routes/{id}")
    public RouteResource getRouteById(@PathVariable(name = "id") Long routeId) {
        return convertToResource(routeService.getRouteById(routeId));
    }

    @PostMapping("/routes")
    public RouteResource createRoute(@Valid @RequestBody SaveRouteResource resource) {
        return convertToResource(routeService.createRoute(convertToEntity(resource)));
    }

    @PutMapping("/routes/{id}")
    public RouteResource updateRoute(@PathVariable(name = "id") Long routeId, @Valid @RequestBody SaveRouteResource resource) {
        return convertToResource(routeService.updateRoute(routeId, convertToEntity(resource)));
    }


    private Route convertToEntity(SaveRouteResource resource) {
        return mapper.map(resource, Route.class);
    }

    private RouteResource convertToResource(Route entity) {
        return mapper.map(entity, RouteResource.class);
    }
}
