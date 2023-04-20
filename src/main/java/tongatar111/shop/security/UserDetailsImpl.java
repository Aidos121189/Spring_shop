package tongatar111.shop.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tongatar111.shop.entity.User;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {


    // UserDetails - интерфейс, описывающий пользователя системы с точки зрения SpringSecurity;

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return "ROLE_" + user.getRole().name();
                    }
                }
        );
    }


    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
