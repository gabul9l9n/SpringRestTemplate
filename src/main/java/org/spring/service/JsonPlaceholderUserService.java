package org.spring.service;

import org.spring.model.dto.user.UserDto;
import org.spring.model.entity.address.Address;
import org.spring.model.entity.company.Company;
import org.spring.model.entity.geo.Geo;
import org.spring.model.entity.user.User;
import org.spring.repository.JsonPlaceholderUserRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class JsonPlaceholderUserService {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/users";
    private final JsonPlaceholderUserRepository userRepository;
    private final RestTemplate restTemplate;

    public JsonPlaceholderUserService(JsonPlaceholderUserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<List<UserDto>> getUsers() {
        return restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserDto>>() {
                }
        );
    }

    public List<User> findAllByRestTemplate() {
        return Objects.requireNonNull(getUsers().getBody()).stream()
                .map(this::toUser).collect(Collectors.toList());
    }

    private User toUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getUsername(),
                userDto.getEmail(),
                new Address(0,
                        userDto.getAddress().getStreet(),
                        userDto.getAddress().getSuite(),
                        userDto.getAddress().getCity(),
                        userDto.getAddress().getZipcode(),
                        new Geo(0,
                                userDto.getAddress().getGeo().getLat(),
                                userDto.getAddress().getGeo().getLng())
                ),
                userDto.getPhone(),
                userDto.getWebsite(),
                new Company(0,
                        userDto.getCompany().getName(),
                        userDto.getCompany().getCatchPhrase(),
                        userDto.getCompany().getBs()

                )
        );
    }

    public void saveAll() {
        userRepository.saveAll(new ArrayList<>(Objects.requireNonNull(findAllByRestTemplate())));
    }
}
