// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.emineo.roo.reverse.domain;

import ch.emineo.roo.reverse.domain.Transaction;
import ch.emineo.roo.reverse.domain.UserTransaction;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

privileged aspect Transaction_Roo_DbManaged {
    
    @OneToMany(mappedBy = "transactionsTransactionid")
    private Set<UserTransaction> Transaction.userTransactions;
    
    @Column(name = "AMOUNT")
    @NotNull
    private Double Transaction.amount;
    
    @Column(name = "DATE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date Transaction.date;
    
    @Column(name = "MESSAGE", length = 255)
    @NotNull
    private String Transaction.message;
    
    @Column(name = "TRANSACTIONTYPE", length = 255)
    @NotNull
    private String Transaction.transactiontype;
    
    public Set<UserTransaction> Transaction.getUserTransactions() {
        return userTransactions;
    }
    
    public void Transaction.setUserTransactions(Set<UserTransaction> userTransactions) {
        this.userTransactions = userTransactions;
    }
    
    public Double Transaction.getAmount() {
        return amount;
    }
    
    public void Transaction.setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Date Transaction.getDate() {
        return date;
    }
    
    public void Transaction.setDate(Date date) {
        this.date = date;
    }
    
    public String Transaction.getMessage() {
        return message;
    }
    
    public void Transaction.setMessage(String message) {
        this.message = message;
    }
    
    public String Transaction.getTransactiontype() {
        return transactiontype;
    }
    
    public void Transaction.setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }
    
}
