package com.example.FinalExam;

public class Loan {
   private String clientno ;
   private String clientname;
    private  double loanamount ;
    private  int years ;
    private String loantype;

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public Loan(String clientno, String string, double loanamount, int years, String clientname) {
        this.clientname = clientname;
    }



    public String getClientno() {
        return clientno;
    }

    public void setClientno(String clientno) {
        this.clientno = clientno;
    }

    public double getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(double loanamount) {
        this.loanamount = loanamount;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype;
    }

    public Loan(String clientno, double loanamount, int years, String loantype) {
        this.clientno = clientno;
        this.loanamount = loanamount;
        this.years = years;
        this.loantype = loantype;
    }
}
