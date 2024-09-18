package Repository;

import Entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository{
    Optional<User> findByEmail(String email);
 }
