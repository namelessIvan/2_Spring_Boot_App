package learning.springcourse.web.service;

import learning.springcourse.web.model.User;
import learning.springcourse.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public User createUser(String email, String phone, String fio, String username) {
        User user = new User(); // Создаем нового пользователя
        user.setEmail(email);
        user.setPhone(phone);
        user.setFio(fio);
        user.setUsername(username);
        user.setCreateAt(LocalDateTime.now()); // Устанавливаем дату создания
        user.setUpdateAt(LocalDateTime.now()); // Устанавливаем дату обновления

        return userRepository.save(user); // Сохраняем пользователя в базе данных
    }

}
