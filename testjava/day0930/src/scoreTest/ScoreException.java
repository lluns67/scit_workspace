//성적이 60점 미만이면 이 익셉션을 사용하여 메ㅣ지 출력!

package scoreTest;

public class ScoreException extends RuntimeException {
    public ScoreException(String message) {
        super(message);
    }
}
