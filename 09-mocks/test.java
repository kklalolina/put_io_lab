package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import org.mockito.internal.matchers.Null;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    /*@Test
    void loadExpensesTEST() {
        ExpenseRepository rep = new ExpenseRepository();
        assertEquals(Collections.EMPTY_LIST,rep.getExpenses());
    }*/

    @Test
    void loadExpensesTEST2() {
        MyDatabase mydata = new MyDatabase();
        ExpenseRepository rep = new ExpenseRepository(mydata);
        assertEquals(Collections.EMPTY_LIST,rep.getExpenses());
    }

    public void testTestedMethod() {

        IFancyDatabase mockObject = mock(IFancyDatabase.class);

        ExpenseRepository rep = new ExpenseRepository(mockObject);

        when(mockObject.queryAll()).thenReturn(Collections.emptyList());
        rep.loadExpenses();
        verify(mockObject).connect();
        verify(mockObject).queryAll();


        verify(mockObject).close();

        assertEquals(Collections.EMPTY_LIST,rep.getExpenses());

    }
    @Test
    void saveExpensesTest(){
        IFancyDatabase mockObject = mock(IFancyDatabase.class);
        InOrder inOrd = inOrder(mockDb);
        when(mockObject.queryAll()).thenReturn(Collections.emptyList());
        ExpenseRepository rep = new ExpenseRepository((mockObject));
        IntStream.range(0,5).forEach(i -> rep.addExpense(new Expense()));
        rep.saveExpenses();
        verify(mockObject, times(5)).persist(any(Expense.class));
        inOrd.verify(mockObject).connect();
        inOrd.verify(mockObject).close();
    }
}
