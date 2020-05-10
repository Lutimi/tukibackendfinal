package com.acme.tukibackend.service.account;
import com.acme.tukibackend.model.account.UserCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
public interface UserCompanyService {
    Page<UserCompany> getAllUserCompanies(Pageable pageable);
    UserCompany getUserCompany(Long id);
    UserCompany createUserCompany(UserCompany user);
    UserCompany updateUserCompany(Long userId, UserCompany userDetails );

}
