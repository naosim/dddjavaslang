package com.naosim.dddjavaslang.domain.account;

public interface AccountRepository {
    Account createAccount();
    void save(Account account);
}
