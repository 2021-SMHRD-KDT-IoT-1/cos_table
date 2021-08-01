package kr.or.smhrd.a3rd_cos_table;

public class CoslistVO {

    //생성자, toString 메소드 구현

    private String name;
    private String date;
    private String result;

    public CoslistVO(String name, String date, String result) {
        this.name = name;
        this.date = date;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CoslistVO{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
