package com.example.FinalExam;

import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {
    public void add(Loan ln) throws ClassNotFoundException, SQLException;

    public Loan update(Loan ln, String clientno) throws SQLException, ClassNotFoundException;

    public void delete(String clientno) throws SQLException;

    public List<Loan> display() throws ClassNotFoundException, SQLException;


}
