package com.entity;

public class Emp {
    private int empno;
    private String ename;
    private String JOB;
    private int mgr;
    private String HIREDATE;
    private int SAL;
    private int COMM;
    private int DEPTNO;

    public int getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public String getJOB() {
        return JOB;
    }

    public int getMgr() {
        return mgr;
    }

    public String getHIREDATE() {
        return HIREDATE;
    }

    public int getSAL() {
        return SAL;
    }

    public int getCOMM() {
        return COMM;
    }

    public int getDEPTNO() {
        return DEPTNO;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public void setHIREDATE(String HIREDATE) {
        this.HIREDATE = HIREDATE;
    }

    public void setSAL(int SAL) {
        this.SAL = SAL;
    }

    public void setCOMM(int COMM) {
        this.COMM = COMM;
    }

    public void setDEPTNO(int DEPTNO) {
        this.DEPTNO = DEPTNO;
    }

    public Emp() {
    }

    public Emp(int empno, String ename, String JOB, int mgr, String HIREDATE, int SAL, int COMM, int DEPTNO) {
        this.empno = empno;
        this.ename = ename;
        this.JOB = JOB;
        this.mgr = mgr;
        this.HIREDATE = HIREDATE;
        this.SAL = SAL;
        this.COMM = COMM;
        this.DEPTNO = DEPTNO;
    }
}
