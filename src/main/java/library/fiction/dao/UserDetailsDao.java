package library.fiction.dao;

import library.fiction.model.User;

public interface UserDetailsDao {
    User findUserByUsername(String usernname);
}
