package jp.co.illmatics.apps.shopping.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jp.co.illmatics.apps.shopping.model.User;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class AdminLoginUser extends org.springframework.security.core.userdetails.User {
 	private static final long serialVersionUID = 1L;
// DBより検索したUserエンティティ
  // アプリケーションから利用されるのでフィールドに定義
  private User user;

  /**
   * データベースより検索したuserエンティティよりSpring Securityで使用するユーザー認証情報の
   * インスタンスを生成する
   *
   * @param user userエンティティ
   */
  public AdminLoginUser(User user) {
    super(user.getEmail(), user.getPassword(), user.getEnable(), true, true,
        true, convertGrantedAuthorities(user.getRoles()));
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  /**
   * カンマ区切りのロールをSimpleGrantedAuthorityのコレクションへ変換する
   *
   * @param roles カンマ区切りのロール
   * @return SimpleGrantedAuthorityのコレクション
   */
  static Set<GrantedAuthority> convertGrantedAuthorities(String roles) {
    if (roles == null || roles.isEmpty()) {
      return Collections.emptySet();
    }
    Set<GrantedAuthority> authorities = Stream.of(roles.split(","))
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toSet());
    return authorities;
  }

}