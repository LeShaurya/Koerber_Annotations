package com.bankApp.repositories;

import com.bankApp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.balance = :balance WHERE a.id = :id")
    void updateBalance(@Param("id") int id,@Param("balance") double balance);

    @Query("SELECT a FROM Account a WHERE a.id = :id")
    Account findById(@Param("id") int id);
}
