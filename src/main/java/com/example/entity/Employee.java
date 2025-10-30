package com.example.entity;

public class Employee {
    private int empno;
    private String ename;
    private String job;
    private double sal;

    public Employee(int empno, String ename, String job, double sal) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "The Employee with id: "+this.getEmpno()+" stands for "+this.getEname()
                +" works as "+this.getJob()+" and earns an amount of Rs. "+this.getSal();
    }
}
