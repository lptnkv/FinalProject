package com.example.finalproject.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.finalproject.Database.Entities.User;

import java.util.List;

@Dao
public abstract class UserDao {
    @Query("SELECT * FROM user")
    public abstract List<User> getAll();

    @Query("SELECT * FROM user WHERE name = :name")
    public abstract List<User> getByName(String name);

    @Query("SELECT * FROM user WHERE isActive = 1")
    public abstract List<User> getByActive();

    @Update
    public abstract void update(User user);

    @Delete
    public abstract void delete(User user);

    @Insert
    public abstract void insert(User user);

    @Transaction
    public void updateActiveUser(User user){
        List<User> allUsers = getAll();
        for (int i = 0; i < allUsers.size(); i++){
            if (!allUsers.get(i).name.equals(user.name)){
                allUsers.get(i).isActive = true;
                update(allUsers.get(i));
            }
        }
    }
}
