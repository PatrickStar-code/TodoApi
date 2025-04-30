package com.todo.todo.Service;

import aj.org.objectweb.asm.commons.Remapper;
import com.todo.todo.Controller.Responses.UserResponse;
import com.todo.todo.Model.TodoEntity;
import com.todo.todo.Model.UserEntity;
import com.todo.todo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> updateUser(Long id, UserEntity userEntity) {
        Optional<UserEntity> response = userRepository.findById(id);
        if(response.isPresent()) {
            UserEntity user = response.get();
            user.setId(id);
            user.setUsername(userEntity.getUsername());
            user.setEmail(userEntity.getEmail());

            if(userEntity.getPassword() == null || userEntity.getPassword().isEmpty()) {
                user.setPassword(response.get().getPassword());
            }
            else {
                user.setPassword(userEntity.getPassword());
            }

            return Optional.of(userRepository.save(user));
        }
        else
        {
            return Optional.empty();
        }
    }

}
