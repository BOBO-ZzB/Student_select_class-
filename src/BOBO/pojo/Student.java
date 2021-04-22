package BOBO.pojo;

public class Student {

    private Integer sno;
    private String sname;
    private String ssex;
    private int sage;
    private String sdept;

    public Student(Integer sno, String sname, String ssex, int sage, String sdept) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sage = sage;
        this.sdept = sdept;
    }

    public Student() {
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    @Override
    public String toString() {
        return "student{" +
                "sno=" + sno +
                ", sname=" + sname +
                ", ssex=" + ssex +
                ", sage=" + sage +
                ", sdept=" + sdept +
                '}';
    }
}
