package ecommerce.bl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import ecommerce.dl.UserRepository;
import ecommerce.domain.User;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repo;

  //Create User
  public User createUser(User user) {
    if (user != null) {
      System.out.println("Validando Usuario:\n\n\n ");
      if (user.getEmail() == null || user.getEmail().isEmpty()) {
        throw new RuntimeException("El email es requerido");
      }
      if (user.getPassword() == null || user.getPassword().isEmpty()) {
        throw new RuntimeException("El password es requerido");
      }
      if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
        throw new RuntimeException("El nombre es requerido");
      }
      if (user.getLastName() == null || user.getLastName().isEmpty()) {
        throw new RuntimeException("El apellido es requerido");
      }
      if (user.getPhone() == null || user.getPhone().isEmpty()) {
        throw new RuntimeException("El teléfono es requerido");
      }
      if (user.getAge() == 0) {
        throw new RuntimeException("La edad es requerida");
      }
      if (user.getNickName() == null || user.getNickName().isEmpty()) {
        throw new RuntimeException("El nickname es requerido");
      }

      // Crear usuario
      System.out.println("Creando Usuario: ");
      return repo.save(user);
    } else {
      throw new RuntimeException("Ocurrió un error al crear el usuario");
    }
  }

  //Get User
  public User getUser(Integer id) {
    try {
      User user = repo.findById(id).get();
      return user;
    } catch (Exception e) {
      throw new RuntimeException("Ocurrió un error al obtener el usuario" + e);
    }
  }
  
  //Update User
  public User updateUser(User user, String id) {
    if (user != null) {
      System.out.println("Validating User:\n\n\n");
      if (user.getEmail() == null || user.getEmail().isEmpty()) {
        throw new RuntimeException("Email is required");
      }
      if (user.getPassword() == null || user.getPassword().isEmpty()) {
        throw new RuntimeException("Password is required");
      }
      if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
        throw new RuntimeException("First name is required");
    }
      if (user.getLastName() == null || user.getLastName().isEmpty()) {
        throw new RuntimeException("Last name is required");
      }
      if (user.getPhone() == null || user.getPhone().isEmpty()) {
        throw new RuntimeException("Phone number is required");
      }
      if (user.getAge() == 0) {
        throw new RuntimeException("Age is required");
      }
      if (user.getNickName() == null || user.getNickName().isEmpty()) {
        throw new RuntimeException("Nickname is required");
      }

    // Update user
    // Retrieve the existing user from the repository
    User existingUser = repo.findById(Integer.parseInt(id))
            .orElseThrow(() -> new RuntimeException("User not found"));

    // Update the properties of the existing user
    existingUser.setEmail(user.getEmail());
    existingUser.setPassword(user.getPassword());
    existingUser.setFirstName(user.getFirstName());
    existingUser.setLastName(user.getLastName());
    existingUser.setPhone(user.getPhone());
    existingUser.setAge(user.getAge());
    existingUser.setNickName(user.getNickName());
    if (user.getCountry() != null && !user.getCountry().isEmpty()) {
      existingUser.setCountry(user.getCountry());
    }
    if (user.getState() != null && !user.getState().isEmpty()) {
      existingUser.setState(user.getState());
    }
    if (user.getCity() != null && !user.getCity().isEmpty()) {
      existingUser.setCity(user.getCity());
    }
    if (user.getStreet() != null && !user.getStreet().isEmpty()) {
      existingUser.setStreet(user.getStreet());
    }
    if (user.getZipCode() != null && !user.getZipCode().isEmpty()) {
      existingUser.setZipCode(user.getZipCode());
    }
    if (user.getExternalNumber() != null && !user.getExternalNumber().isEmpty()) {
      existingUser.setExternalNumber(user.getExternalNumber());
    }
    if (user.getInternalNumber() != null && !user.getInternalNumber().isEmpty()) {
      existingUser.setInternalNumber(user.getInternalNumber());
    }
    if(user.getSuburb() != null && !user.getSuburb().isEmpty()) {
      existingUser.setSuburb(user.getSuburb());
    }

    // Save the updated user back to the repository
    System.out.println("Updating User: ");
    return repo.save(existingUser);
  } else {
      throw new RuntimeException("Error occurred while updating the user");
  }
}

}