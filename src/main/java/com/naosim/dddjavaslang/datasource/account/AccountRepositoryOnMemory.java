package com.naosim.dddjavaslang.datasource.account;

import com.naosim.dddjavaslang.domain.account.Account;
import com.naosim.dddjavaslang.domain.account.AccountRepository;
import com.naosim.dddjavaslang.domain.account.Password;
import com.naosim.dddjavaslang.domain.account.UserId;
import javaslang.collection.HashSet;
import javaslang.collection.Set;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryOnMemory implements AccountRepository {
    private Set<Account> accountTable = HashSet.empty();

    @Override
    public Account createAccount() {
        long time = System.currentTimeMillis();
        return new Account(new UserId("ID" + time), new Password("PW" + time));
    }

    @Override
    public void save(Account account) {
        accountTable = accountTable.add(account);
    }
}
