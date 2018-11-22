package LacksDataBaseProject;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    private Item testItem;

    @Before
    public void setUpTestItem () {
        this.testItem = new Item("itemTestID", "itemTestName");
    }

    @Test
    public void properConstructor () {
        //given
        //when
        //then
        assertEquals("itemTestID", testItem.getItemID());
        assertEquals("itemTestName", testItem.getItemName());
    }

    @Test (expected = NullPointerException.class)
    public void nullIDConstructor () {
        //given
        Item nullIDtestItem = new Item(null, "itemTestName");
        //when
        //then
        assertEquals(null, nullIDtestItem.getItemID());
        assertEquals("itemTestName", nullIDtestItem.getItemName());
    }

    @Test (expected = NullPointerException.class)
    public void nullNameConstructor () {
        //given
        Item nullIDtestItem = new Item("itemTestID", null);
        //when
        //then
        assertEquals("itemTestName", nullIDtestItem.getItemID());
        assertEquals(null, nullIDtestItem.getItemName());
    }

    @Test (expected = NullPointerException.class)
    public void emptyIDConstructor () {
        //given
        Item nullIDtestItem = new Item("", "itemTestName");
        //when
        //then
        assertEquals("", nullIDtestItem.getItemID());
        assertEquals("itemTestName", nullIDtestItem.getItemName());
    }

    @Test (expected = NullPointerException.class)
    public void emptyNameConstructor () {
        //given
        Item nullIDtestItem = new Item("itemTestID", "");
        //when
        //then
        assertEquals("itemTestName", nullIDtestItem.getItemID());
        assertEquals("", nullIDtestItem.getItemName());
    }

    @Test
    public void setItemIDNotNull() {
        //given
        String testItemID = "itemNewTestID";
        //when
        testItem.setItemID(testItemID);
        //then
        assertEquals("itemNewTestID", testItem.getItemID());
    }

    @Test (expected = NullPointerException.class)
    public void setItemIDNull() {
        //given
        String testItemID = null;
        //when
        testItem.setItemID(testItemID);
        //then
        assertEquals(null, testItem.getItemID());
    }

    @Test (expected = NullPointerException.class)
    public void setItemIDEmpty() {
        //given
        String testItemID = "";
        //when
        testItem.setItemID(testItemID);
        //then
        assertEquals("", testItem.getItemID());
    }

    @Test
    public void setItemNameNotNull() {
        //given
        String testItemName = "itemNewTestName";
        //when
        testItem.setItemName(testItemName);
        //then
        assertEquals("itemNewTestName", testItem.getItemName());
    }

    @Test (expected = NullPointerException.class)
    public void setItemNameNull() {
        //given
        String testItemName =  null;
        //when
        testItem.setItemName(testItemName);
        //then
        assertEquals(null, testItem.getItemName());
    }

    @Test (expected = NullPointerException.class)
    public void setItemNameEmpty() {
        //given
        String testItemName = "";
        //when
        testItem.setItemName(testItemName);
        //then
        assertEquals("", testItem.getItemName());
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tear down class");
        System.out.flush();
    }
}