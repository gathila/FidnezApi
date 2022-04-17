package com.fidnez.repository;


import com.fidnez.domain.Customer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Repository
public class CustomerDAOImpl {

    private String csvFilePath = "";
    public void load() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath))) {
            CSVParser records = CSVParser.parse(bufferedReader, CSVFormat.EXCEL.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            for (CSVRecord record : records) {
                System.out.println(record.get(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> findByInput(Customer customer) {
        Session session = sessionFactory.openSession();
        String SELECT = "FROM Customer C WHERE FirstName = :FirstName";
        Query q = session.createQuery(SELECT, Customer.class);
        q.setParameter("name","bob");
        List<Customer> resultList = (List<Customer>) q.list();
        return resultList;
    }
}
