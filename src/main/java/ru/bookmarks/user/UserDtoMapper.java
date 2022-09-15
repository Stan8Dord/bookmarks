package ru.bookmarks.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class UserDtoMapper {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd, hh:mm:ss");

    public static UserDto userToUserDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                formatter.format(user.getRegistrationDate()), user.getState());
    }

    public static List<UserDto> userToUserDto(Iterable<User> users) {
        List<UserDto> dtos = new ArrayList<>();

        for (User user : users) {
            dtos.add(userToUserDto(user));
        }

        return dtos;
    }

    public static User userDtoToUser(UserDto uDto) {
        User user = new User();
        LocalDateTime ldt = LocalDateTime.parse(uDto.getRegistrationDate(), formatter);

        user.setFirstName(uDto.getFirstName());
        user.setLastName(uDto.getLastName());
        user.setEmail(uDto.getEmail());
        user.setRegistrationDate(Instant.from(ldt));
        user.setState(uDto.getState());

        return user;
    }
}
