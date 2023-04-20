package tongatar111.shop.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tongatar111.shop.entity.User;
import tongatar111.shop.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    // UserDetailsService - интерфейс с единственным методом, назначением которого является реализация
    // логики поиски пользователя по имени пользователя и дальнейшее формирование объекта UserDetails;

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });
        return new UserDetailsImpl(user);


    }
}


