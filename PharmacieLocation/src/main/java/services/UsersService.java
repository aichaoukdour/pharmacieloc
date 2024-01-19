package services;



import entities.Users;
import repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public int registerNewUser(String firstName, String lastName, String email, String password) {
        return UsersRepository.registerNewUser(firstName, lastName, email, password);
    }

    public List<String> checkUserEmail(String email) {
        try {
			return UsersRepository.checkUserEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public String checkUserPasswordByEmail(String email) {
        return UsersRepository.checkUserPasswordByEmail(email);
    }

    public Users getUserById(int id) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public Users getUserDetailsByEmail(String email) {
        return UsersRepository.GetUserDetailsByEmail(email);
    }
}

