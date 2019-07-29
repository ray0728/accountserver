package com.rcircle.service.account.mapper;

import com.rcircle.service.account.model.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface AccountMapper {
    public int create(Account account);

    public int setAccountStatus(@Param("uid") int uid, @Param("status") int status);

    public int deleteAccount(@Param("uid") int uid);

    public int deleteAllRoleMap(List<Integer> ids);

    public int deleteRoleMap(@Param("id") int id);

    public int addRoleForAccount(@Param("uid") int uid, @Param("rid") int rid);

    public Account getDetialByName(@Param("username")String username, @Param("email")String email);

    public Account getDetialByUid(@Param("uid")int uid);

    public int updateLoginTime(Account account);

    public List<String> getAllUsername();

    public List<Account> getAllAccount();

    public int updateAccount(Account account);
    
    public int updateAvatar(@Param("uid") int uid, @Param("avatar")String avatar_path);
}
