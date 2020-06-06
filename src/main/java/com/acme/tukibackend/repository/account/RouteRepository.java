package com.acme.tukibackend.repository.account;

import com.acme.tukibackend.model.account.Routes;
import com.acme.tukibackend.model.account.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository  extends JpaRepository<Routes, Long> {

}
