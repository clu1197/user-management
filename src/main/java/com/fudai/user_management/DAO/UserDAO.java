package com.fudai.user_management.DAO;

import com.fudai.user_management.POJO.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * A class that handles database operations for a specific entity.
 * Encapsulate all database access logic.
 */
@Repository // spring bean
public interface UserDAO extends CrudRepository<User, Integer> {
}
