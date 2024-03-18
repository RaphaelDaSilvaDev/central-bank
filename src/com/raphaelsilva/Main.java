package com.raphaelsilva;

import com.raphaelsilva.bank.Bank;
import com.raphaelsilva.client.Client;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Client raphael = new Client("Raphael", "123.321.123-55", LocalDate.of(1999, Month.APRIL, 7));
        System.out.println(raphael);
        Bank centralBank = new Bank(1, 1);
        System.out.println(centralBank);
        int accountId = centralBank.createAccount(raphael.getId());
        System.out.println(centralBank.getAccounts());

        centralBank.addIncome(accountId, BigDecimal.valueOf(1000.0));
        centralBank.getAccountInfo(accountId, raphael.getId());
        centralBank.addWithdrawal(accountId, BigDecimal.valueOf(2000.0));
        centralBank.addWithdrawal(accountId, BigDecimal.valueOf(100.0));

        centralBank.getAccountInfo(accountId, 123);


        System.out.println(centralBank.getAccounts());

    }
}