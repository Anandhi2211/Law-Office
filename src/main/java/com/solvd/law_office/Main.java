package com.solvd.law_office;


import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.dao.AttorneyRepository;
import com.solvd.law_office.dao.impl.AttorneyRepositoryImpl;
import com.solvd.law_office.service.AttorneyService;
import com.solvd.law_office.service.impl.AttorneyServiceImpl;

public class Main {
    public static void main(String[] args)
    {

        AttorneyRepository attorneyRepository = new AttorneyRepositoryImpl();
        attorneyRepository.create();
        System.out.println("Done");
    }
}