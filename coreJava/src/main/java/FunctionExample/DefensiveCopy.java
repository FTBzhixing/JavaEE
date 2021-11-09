package FunctionExample;

import java.util.Date;

public class DefensiveCopy {

    private final Date start;
    private final Date end;

    public DefensiveCopy(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(start.getTime());
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "After" + end);
        }

    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        DefensiveCopy defensiveCopy = new DefensiveCopy(start, end);
        //构造函数的保护性copy可以防止start的修改改变DefensiveCopy内start的值
        start.setYear(78);
        //getter函数的保护性copy可以防止end的修改改变DefensiveCopy内end的值
        defensiveCopy.getEnd().setYear(78);

    }
}
