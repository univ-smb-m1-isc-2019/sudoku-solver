import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class SudokuTest {

    @Test
    public void testMain (){
        Sudoku s= new Sudoku("sudoku");
        assertThat(s.getName()).isEqualTo("sudoku");
    }
}
