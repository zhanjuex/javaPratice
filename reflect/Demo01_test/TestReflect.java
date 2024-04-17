import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TestReflect {
    static private int number = 11;
    private String text;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        TestReflect.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    private Date date;
    private List<String> stringList;

    public TestReflect() {
        stringList = new ArrayList<>();
    }
}