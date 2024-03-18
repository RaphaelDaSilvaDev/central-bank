package com.raphaelsilva.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Bank {
    private final int id;
    private final int agency;
    private List<Account> accounts = new ArrayList<>();

    public Bank(int id, int agency) {
        this.id = id;
        this.agency = agency;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public int getId() {
        return id;
    }

    public int getAgency() {
        return agency;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", agency=" + agency +
                ", accounts=" + accounts +
                '}';
    }

    public int createAccount(int clientId){
        int id = generateId();
        accounts.add(new Account(id, clientId));
        System.out.println("Conta " + id + " criada com sucesso!");
        return id;
    }

    public void addIncome (int id, BigDecimal payment){
        Account account = getAccount(id);
        String action = account.addIncome(payment);
        System.out.println(action);
    }

    public void addWithdrawal (int id, BigDecimal payment)  {
        Account account = getAccount(id);
        String action = account.addWithdrawal(payment);
        System.out.println(action);
    }

    public void getAccountInfo(int accountId, int clientId) {
        Account account = getAccount(accountId);
        if(account.getClientId() == clientId){
            System.out.println(account);
        }else{
            System.out.println("Erro ao acessar conta!");
        }
    }

    private Account getAccount(int id){
        return accounts.stream().filter(account -> account.getId() == id).toList().getFirst();
    }

    private int generateId(){
        Random random = new Random();

        return random.nextInt(900000) + 100000;
    }
}
