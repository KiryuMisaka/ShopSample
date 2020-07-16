package jp.co.illmatics.apps.shopping.model;

import java.util.List;

public interface AccountService {
  List<User> findAll();
  void register(String name, String email, String password, String[] roles);
}