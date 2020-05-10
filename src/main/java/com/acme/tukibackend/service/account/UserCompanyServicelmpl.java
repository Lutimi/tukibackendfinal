package com.acme.tukibackend.service.account;

import com.acme.tukibackend.exception.ResourceNotFoundException;
import com.acme.tukibackend.model.account.User;
import com.acme.tukibackend.model.account.UserCompany;
import com.acme.tukibackend.repository.account.UserCompanyRepository;
import com.acme.tukibackend.repository.account.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserCompanyServicelmpl implements UserCompanyService {
    @Autowired
    private UserCompanyRepository userCompanyRepository;
    @Override
    public Page<UserCompany> getAllUserCompanies(Pageable pageable) {
        return null;
    }

    @Override
    public UserCompany getUserCompany(Long id) {
        return null;
    }

    @Override
    public UserCompany createUserCompany(UserCompany user) {
        return null;
    }

    @Override
    public UserCompany updateUserCompany(Long userId, UserCompany userDetails) {
        return null;
    }
}
