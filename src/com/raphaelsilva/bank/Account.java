package com.raphaelsilva.bank;

import com.raphaelsilva.client.Client;

import java.math.BigDecimal;

class Account {
    private int id;
    private int clientId;
    private BigDecimal balance;
    private boolean isActive;

    public Account(int id, int clientId) {
        this.id = id;
        this.clientId = clientId;
        this.balance = BigDecimal.valueOf(0.0);
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Conta: '" + id + '\'' + ", ID Cliente: " + clientId + '\'' + ", Saldo: " + balance + '\'' + ", Ativo: " + isActive;
    }

    public String addIncome (BigDecimal payment){
        this.balance = this.balance.add(payment);
        return "O valor de " + payment + " foi adicionado a sua conta!";
    }

    public String addWithdrawal (BigDecimal payment) {
        if(this.balance.compareTo(payment) > 0){
            this.balance = this.balance.subtract(payment);
            return "Pagamento de " + payment + " efetuado com sucesso!";
        }else {
            System.out.println("Você não tem saldo suficiente!");
            return "";
        }
    }
}
