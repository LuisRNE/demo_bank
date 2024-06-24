package com.lrne.bank.demo.repository;

import com.lrne.bank.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository  extends JpaRepository<Client,String> {
}
