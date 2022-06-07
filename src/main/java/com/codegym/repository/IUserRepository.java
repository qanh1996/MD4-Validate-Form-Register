package com.codegym.repository;

import com.codegym.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<Users,Long> {
}
