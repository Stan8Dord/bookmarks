package ru.bookmarks.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    @Transactional
    public List<UserDto> getAllUsers() {
        List<User> users = repository.findAll();

        return UserDtoMapper.userToUserDto(users);
    }

    @Override
    @Transactional
    public UserDto saveUser(UserDto userDto) {
        User user = repository.save(UserDtoMapper.userDtoToUser(userDto));

        return UserDtoMapper.userToUserDto(user);
    }
}
