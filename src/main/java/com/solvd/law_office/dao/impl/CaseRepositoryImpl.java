package com.solvd.law_office.dao.impl;

import com.solvd.law_office.ConnectionPool;
import com.solvd.law_office.bin.CaseFiled;
import com.solvd.law_office.dao.CaseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CaseRepositoryImpl implements CaseRepository {
    private static final Logger logger = LogManager.getLogger(CaseRepositoryImpl.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();
    @Override
    public void insert(CaseFiled caseFiled, int lawFirmId) {
    }
}
