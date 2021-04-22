package BOBO.pojo;

public class Sct {

    private Integer sct_no;
    private int sno;
    private int cno;
    private int tno;
    private int grade;

    public Sct(Integer sct_no, int sno, int cno, int tno, int grade) {
        this.sct_no = sct_no;
        this.sno = sno;
        this.cno = cno;
        this.tno = tno;
        this.grade = grade;
    }

    public Sct() {
    }

    public Integer getSct_no() {
        return sct_no;
    }

    public void setSct_no(Integer sct_no) {
        this.sct_no = sct_no;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Sct{" +
                "sct_no=" + sct_no +
                ", sno=" + sno +
                ", cno=" + cno +
                ", tno=" + tno +
                ", grade=" + grade +
                '}';
    }
}
