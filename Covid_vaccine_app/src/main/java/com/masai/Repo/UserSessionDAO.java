package com.masai.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentUserSession;

@Repository
public interface UserSessionDAO extends JpaRepository<CurrentUserSession, Integer>{

}