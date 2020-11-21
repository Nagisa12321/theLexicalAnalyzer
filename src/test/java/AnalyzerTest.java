
import com.JtChen.KeywordJudgment;

import static org.junit.Assert.*;

public class AnalyzerTest {

    @org.junit.Test
    public void isKeyword() {
//        assertEquals(true,KeywordJudgment.isKeyWord("main"));
        System.out.println(KeywordJudgment.isErrorLetter('@'));
        System.out.println(KeywordJudgment.isKeyWord(" "));
    }
}