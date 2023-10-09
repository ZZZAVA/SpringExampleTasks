package org.example.abstraction.sevice;

import org.example.repository.UserRepo;
import reactor.core.publisher.Mono;

public interface UserService {
	Mono<UserDto> getById(Long id);

	record UserDto(
		Long id,
		String name
	){
		public static UserDto fromDbEntity(UserRepo.User user){
			return new UserDto(
				user.id(),
				user.name()
			);
		}
	}
}
