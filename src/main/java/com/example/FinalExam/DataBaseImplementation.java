package com.example.FinalExam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseImplementation  implements  DatabaseInterface{
    Connection con;
    public DataBaseImplementation(Connection con)
    {
        this.con = con;
    }

    @Override
    public void add(Loan ln) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO loantable VALUES ( ?, ? ,?,?,?)";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, ln.getClientno());
        query.setString(2, ln.getClientname());
        query.setString(3, String.valueOf(ln.getLoanamount()));
        query.setString(4, String.valueOf(ln.getYears()));
        query.setString(5, ln.getLoantype());

        query.executeUpdate();

    }

    @Override
    public Loan update(Loan ln, String clientno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("Update loantable set clientno=?, clientname=?,loanamount=?,years=?,loantype=?where clientno = ?");
        query.setString(1, ln.getClientno());
        query.setString(2, ln.getClientname());
        query.setString(3, String.valueOf(ln.getLoanamount()));
        query.setString(4, String.valueOf(ln.getYears()));
        query.setString(5, ln.getLoantype());

        query.setString(6, clientno);
        query.executeUpdate();
        return ln;
    }

    @Override
    public void delete(String clientno) throws SQLException {
        String quer1 = "Delete from loantable where clientno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno);
        query.executeUpdate();

    }

    @Override
    public List<Loan> display() throws ClassNotFoundException, SQLException {

        List<Loan> Loanlist = new ArrayList<Loan>();
        String quer1 = "Select * from loantable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet r = query.executeQuery();
        Loan obj1;

        while (r.next()) {
            obj1 = new Loan(r.getString("clientno"), r.getString("clientname"),
                    r.getDouble("loanamount"),r.getInt("years"),r.getString("loantype"));
            Loanlist.add(obj1);
        }
        return Loanlist;
    }
    public Loan search(String clientno) throws SQLException, ClassNotFoundException {

        String quer1 = "Select * from loantable where clientno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno);
        ResultSet r = query.executeQuery();
        if (!r.first()) {
            System.out.print("Record  you are trying ,not existing");
            return null;
        }
        Loan obj2 = null;
        obj2 = new Loan(r.getString("clientno"), r.getString("clientname"),
                r.getDouble("loanamount"),r.getInt("years"),r.getString("loantype"));
        return obj2;
    }
}
