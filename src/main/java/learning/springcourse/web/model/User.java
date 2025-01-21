package learning.springcourse.web.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;


@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String fio;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createAt;

    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @ManyToMany(fetch = FetchType.EAGER) // Загружаем роли
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles; // Возвращаем роли как authorities для Spring Security
    }

    @Override
    public String getPassword() {
        return null; // Здесь должен быть пароль пользователя
    }

    @Override
    public String getUsername() {
        return email; // Используем email как имя пользователя
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Учетная запись не истекла
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Учетная запись не заблокирована
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Учетные данные не истекли
    }

    @Override
    public boolean isEnabled() {
        return true; // Учетная запись включена
    }

    public User() {

    }



    public User(String email, String phone, String fio, LocalDateTime createAt, LocalDateTime updateAt) {
        this.email = email;
        this.phone = phone;
        this.fio = fio;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
