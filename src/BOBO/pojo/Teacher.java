package BOBO.pojo;

public class Teacher {

    private Integer tno;
    private String tname;
    private String tsex;
    private int tage;
    private String teb;
    private String tpt;
    private String cno1;
    private String cno2;
    private String cno3;

    public Teacher(Integer tno, String tname, String tsex, int tage, String teb, String tpt, String cno1, String cno2, String cno3) {
        this.tno = tno;
        this.tname = tname;
        this.tsex = tsex;
        this.tage = tage;
        this.teb = teb;
        this.tpt = tpt;
        this.cno1 = cno1;
        this.cno2 = cno2;
        this.cno3 = cno3;
    }

    public Teacher() {
    }

    public Integer getTno() {
        return tno;
    }

    public void setTno(Integer tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public int getTage() {
        return tage;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    public String getTeb() {
        return teb;
    }

    public void setTeb(String teb) {
        this.teb = teb;
    }

    public String getTpt() {
        return tpt;
    }

    public void setTpt(String tpt) {
        this.tpt = tpt;
    }

    public String getCno1() {
        return cno1;
    }

    public void setCno1(String cno1) {
        this.cno1 = cno1;
    }

    public String getCno2() {
        return cno2;
    }

    public void setCno2(String cno2) {
        this.cno2 = cno2;
    }

    public String getCno3() {
        return cno3;
    }

    public void setCno3(String cno3) {
        this.cno3 = cno3;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "tno=" + tno +
                ", tname=" + tname +
                ", tsex=" + tsex +
                ", tage=" + tage +
                ", teb=" + teb +
                ", tpt=" + tpt +
                ", cno1=" + cno1 +
                ", cno2=" + cno2 +
                ", cno3=" + cno3 +
                '}';
    }
}
