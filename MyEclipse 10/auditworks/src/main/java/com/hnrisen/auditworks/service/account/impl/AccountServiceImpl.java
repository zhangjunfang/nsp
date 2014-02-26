package com.hnrisen.auditworks.service.account.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnrisen.auditworks.domain.Account;
import com.hnrisen.auditworks.mapper.reuse.AccountMapper;
import com.hnrisen.auditworks.service.account.AccountService;

@Service
public class AccountServiceImpl implements AccountService<Account> {
	
	/** The account mapper. */
	@Autowired
	private AccountMapper<Account> accountMapper;
	
	/**
	 * Sets the account mapper.
	 * 
	 * @param accountMapper
	 *            the new account mapper
	 */
	
	public void setAccountMapper(AccountMapper<Account> accountMapper) {
	
		this.accountMapper = accountMapper;
	}
	
	@Override
	public void remove(Account account) throws Exception {
	
		this.accountMapper.delete(account);
	}
	
	@Override
	public void create(Account account) throws Exception {
	
		this.accountMapper.insert(account);
	}
	
	@Override
	public void modify(Account account) throws Exception {
	
		this.accountMapper.update(account);
	}
	
	@Override
	public Account get(Account account) throws Exception {
	
		return this.accountMapper.selectOne(account);
	}
	
	@Override
	public List<Account> getAll(Account account) throws Exception {
	
		return this.accountMapper.selectAll(account);
	}
}
