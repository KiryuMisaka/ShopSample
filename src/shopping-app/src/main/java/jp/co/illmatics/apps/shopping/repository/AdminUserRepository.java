package jp.co.illmatics.apps.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.illmatics.apps.shopping.model.User;

import java.util.Optional;

public interface AdminUserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}