package com.acme.tukibackend.repository.account;
import com.acme.tukibackend.model.account.UserCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserCompanyRepository  extends JpaRepository<UserCompany,Long> {
}
