package com.vaas.vaasbackend.repository;
import com.vaas.vaasbackend.entity.TblUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<TblUser, Integer>{

    Optional<TblUser> findByUserEmail(String userEmail);

    @Query(value = "select tbl_roles.role_name from tbl_roles,tbl_user_role where tbl_user_role.user_id = ? and tbl_roles.role_id = tbl_user_role.role_id group by tbl_roles.role_name",nativeQuery = true)
    List<String> getRole(Integer id);

    @Query(nativeQuery = true,value = "SELECT u.*\n" +
            "FROM tbl_users u\n" +
            "LEFT JOIN tbl_user_role ur ON u.user_id = ur.user_id\n" +
            "WHERE ur.user_role_id IS NULL;")
    List<TblUser> showUserWithNoRole();

    @Query(nativeQuery = true,value = "select count(*) from tbl_users")
    Integer totalUser();
}







