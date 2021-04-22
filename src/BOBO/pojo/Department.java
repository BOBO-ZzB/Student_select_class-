package BOBO.pojo;

public class Department {

    private Integer dno;
    private String dname;
    private String dmanagerno;

    public Department(Integer dno, String dname, String dmanagerno) {
        this.dno = dno;
        this.dname = dname;
        this.dmanagerno = dmanagerno;
    }

    public Department() {
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDmanagerno() {
        return dmanagerno;
    }

    public void setDmanagerno(String dmanagerno) {
        this.dmanagerno = dmanagerno;
    }

    @Override
    public String toString() {
        return "department{" +
                "dno=" + dno +
                ", dname=" + dname +
                ", dmanagerno=" + dmanagerno +
                '}';
    }
}
