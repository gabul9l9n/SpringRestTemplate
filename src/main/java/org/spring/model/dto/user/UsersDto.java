package org.spring.model.dto.user;

import lombok.Data;

import java.util.List;

@Data
public class UsersDto {
    private List<UserDto> list;
}
