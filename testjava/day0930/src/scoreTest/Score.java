package scoreTest;

public class Score implements Comparable<Score> {
    private String id;
    private String name;
    private int it;
    private int japan;
    private double avg;

    public Score() {
    }

    public Score(String id, String name, int it, int japan) {
        this.id = id;
        this.name = name;
        this.it = it;
        this.japan = japan;
        this.avg = (it + japan) / 2.0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIt() {
        return it;
    }

    public void setIt(int it) {
        this.it = it;
    }

    public int getJapan() {
        return japan;
    }

    public void setJapan(int japan) {
        this.japan = japan;
    }

    @Override
    public String toString() {
        String temp = String.format("학번: %s, 이름 : %s, IT: %d, Japan: %d, Averae: %.2f",
                                    id,name,it,japan,avg);
        return temp;
    }

    @Override
    public int compareTo(Score o) {
        return id.compareTo(o.getId());

    }

    public double getAvg() {
        return avg;
    }
}
//평균이 60점 미만이면 익셉션 처리하시오