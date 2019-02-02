package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.LessThanZeroException;
import LacksDataBaseProject.Exceptions.WrongDateFormatException;
import LacksDataBaseProject.Exceptions.ZeroDataException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LackTest {

    private Item item;
    private int requiredAmount;
    private String unitOfMeasure;
    private String forwarderAdditionalComment;
    private Supplier supplier;
    private int lackID;
    private String forwarderSkypeID;
    private String lacksDateAndTime;
    private Boolean status;
    private int orderedAmount;
    private String expectedDeliveryDateAndTime;
    private String purchaserAdditionalComment;

    private Lack testLack;

    @Before
    public void setUpTestLack() {
        this.testLack = new Lack("testItemID", "testItemName", 0, null, null, null, 0, null, null, null, 0, null, null);
    }

    @Test
    public void setNotZeroRequiredAmountTest() throws ZeroDataException {
        //given
        requiredAmount = 1;
        //when
        testLack.setRequiredAmount(requiredAmount);
        //then
        assertEquals(1, testLack.getRequiredAmount());
    }

    @Test(expected = ZeroDataException.class)
    public void setZeroRequiredAmountTest() throws ZeroDataException {
        //given
        requiredAmount = 0;
        //when
        testLack.setRequiredAmount(requiredAmount);
        //then
        assertEquals(0, testLack.getRequiredAmount());
    }

    @Test
    public void setNotNullUnitOfMeasureTest() {
        //given
        unitOfMeasure = "EUR pallet";
        //when
        testLack.setUnitOfMeasure(unitOfMeasure);
        //then
        assertEquals("EUR pallet", testLack.getUnitOfMeasure());
    }

    @Test (expected = NullPointerException.class)
    public void setNullUnitOfMeasureTest() {
        //given
        unitOfMeasure  = null;
        //when
        testLack.setUnitOfMeasure(unitOfMeasure );
        //then
        assertEquals(null, testLack.getUnitOfMeasure());
    }

    @Test (expected = NullPointerException.class)
    public void setEmptyUnitOfMeasureTest() {
        //given
        unitOfMeasure  = "";
        //when
        testLack.setUnitOfMeasure(unitOfMeasure );
        //then
        assertEquals("", testLack.getUnitOfMeasure());
    }

    @Test
    public void setNotNullForwarderAdditionalCommentTest() {
        //given
        forwarderAdditionalComment = "forwarder test comment";
        //when
        testLack.setForwarderAdditionalComment(forwarderAdditionalComment );
        //then
        assertEquals("forwarder test comment", testLack.getForwarderAdditionalComment());
    }

    @Test
    public void setNullForwarderAdditionalCommentTest() {
        //given
        forwarderAdditionalComment  = null;
        //when
        testLack.setForwarderAdditionalComment(forwarderAdditionalComment);
        //then
        assertEquals(null, testLack.getForwarderAdditionalComment());
    }

    @Test
    public void setNotNullSupplierTest() {
        //given
       supplier = new Supplier("test supplier");
        //when
        testLack.setSupplier(supplier);
        //then
        assertEquals("test supplier", testLack.getSupplier().supplierName);
    }

    @Test (expected = NullPointerException.class)
    public void setNullSupplierTest() {
        //given
        supplier = null;
        //when
        testLack.setSupplier(supplier);
        //then
        assertEquals(null, testLack.getSupplier());
    }

    @Test
    public void setNotZeroLackIDTest() throws ZeroDataException {
        //given
        lackID = 1;
        //when
        testLack.setLackID(lackID);
        //then
        assertEquals(1, testLack.getLackID());
    }

    @Test (expected = ZeroDataException.class)
    public void setZeroLackIDTest() throws ZeroDataException {
        //given
        lackID = 0;
        //when
        testLack.setLackID(lackID);
        //then
        assertEquals(0, testLack.getLackID());
    }

    @Test (expected = ZeroDataException.class)
    public void setNegativeLackIDTest() throws ZeroDataException {
        //given
        lackID = -1;
        //when
        testLack.setLackID(lackID);
        //then
        assertEquals(-1, testLack.getLackID());
    }

    @Test
    public void setNotNullForwarderSkypeIDTest() {
        //given
        forwarderSkypeID = "forwarder test ID";
        //when
        testLack.setForwarderSkypeID(forwarderSkypeID);
        //then
        assertEquals("forwarder test ID", testLack.getForwarderSkypeID());
    }

    @Test (expected = NullPointerException.class)
    public void setNullForwarderSkypeIDTest() {
        //given
        forwarderSkypeID = null;
        //when
        testLack.setForwarderSkypeID(forwarderSkypeID);
        //then
        assertEquals(null, testLack.getForwarderSkypeID());
    }

    @Test (expected = NullPointerException.class)
    public void setEmptyForwarderSkypeIDTest() {
        //given
        forwarderSkypeID = "";
        //when
        testLack.setForwarderSkypeID(forwarderSkypeID);
        //then
        assertEquals("", testLack.getForwarderSkypeID());
    }

    @Test
    public void setCorrectFormatLacksDateAndTimeTest() throws WrongDateFormatException {
        //given
       lacksDateAndTime = "2010-10-10 10:10";
        //when
        testLack.setLacksDateAndTime(lacksDateAndTime);
        //then
        assertEquals("2010-10-10 10:10", testLack.getLacksDateAndTime());
    }

    @Test (expected = WrongDateFormatException.class)
    public void setWrongFormatLacksDateAndTimeTest() throws WrongDateFormatException {
        //given
        lacksDateAndTime = "2010-10 10:10";
        //when
        testLack.setLacksDateAndTime(lacksDateAndTime);
        //then
        assertEquals("2010-10 10:10", testLack.getLacksDateAndTime());
    }

    @Test (expected = NullPointerException.class)
    public void setNullLacksDateAndTimeTest() throws WrongDateFormatException {
        //given
        lacksDateAndTime = null;
        //when
        testLack.setLacksDateAndTime(lacksDateAndTime);
        //then
        assertEquals(null, testLack.getLacksDateAndTime());
    }

    @Test (expected = NullPointerException.class)
    public void setEmptyLacksDateAndTimeTest() throws WrongDateFormatException {
        //given
        lacksDateAndTime = "";
        //when
        testLack.setLacksDateAndTime(lacksDateAndTime);
        //then
        assertEquals("", testLack.getLacksDateAndTime());
    }

    @Test
    public void setNotNullStatusTest() {
        //given
        status = true;
        //when
        testLack.setStatus(status);
        //then
        assertEquals(true, testLack.getStatus());
    }

    @Test (expected = NullPointerException.class)
    public void setNullStatusTest() {
        //given
        status = null;
        //when
        testLack.setStatus(status);
        //then
        assertEquals(null, testLack.getStatus());
    }

    @Test
    public void setDefaultOrderedAmountTest() throws LessThanZeroException {
        //given
        orderedAmount = 0;
        //when
        testLack.setOrderedAmount(orderedAmount);
        //then
        assertEquals(0, testLack.getOrderedAmount());
    }

    @Test (expected=LessThanZeroException.class)
    public void setNegativeOrderedAmountTest() throws LessThanZeroException {
        //given
        orderedAmount = -1;
        //when
        testLack.setOrderedAmount(orderedAmount);
        //then
        assertEquals(-1, testLack.getOrderedAmount());
    }

    @Test
    public void setCorrectFormatExpectedDeliveryDateAndTimeTest() throws WrongDateFormatException {
        //given
        expectedDeliveryDateAndTime = "2010-10-10 10:10";
        //when
        testLack.setExpectedDeliveryDateAndTime(expectedDeliveryDateAndTime);
        //then
        assertEquals("2010-10-10 10:10", testLack.getExpectedDeliveryDateAndTime());
    }

    @Test (expected = WrongDateFormatException.class)
    public void setWrongFormatExpectedDeliveryDateAndTimeTest() throws WrongDateFormatException {
        //given
        expectedDeliveryDateAndTime = "2010-10 10:10";
        //when
        testLack.setExpectedDeliveryDateAndTime(expectedDeliveryDateAndTime);
        //then
        assertEquals("2010-10 10:10", testLack.getExpectedDeliveryDateAndTime());
    }

    @Test (expected = NullPointerException.class)
    public void setEmptyExpectedDeliveryDateAndTimeTest() throws WrongDateFormatException {
        //given
        expectedDeliveryDateAndTime = "";
        //when
        testLack.setExpectedDeliveryDateAndTime(expectedDeliveryDateAndTime);
        //then
        assertEquals("", testLack.getExpectedDeliveryDateAndTime());
    }

    @Test
    public void setNotNullPurchaserAdditionalCommentTest() {
        //given
        purchaserAdditionalComment = "purchaser test comment";
        //when
        testLack.setPurchaserAdditionalComment(purchaserAdditionalComment);
        //then
        assertEquals("purchaser test comment", testLack.getPurchaserAdditionalComment());
    }

    @Test
    public void setNullPurchaserAdditionalCommentTest() {
        //given
        purchaserAdditionalComment = null;
        //when
        testLack.setPurchaserAdditionalComment(purchaserAdditionalComment);
        //then
        assertEquals(null, testLack.getPurchaserAdditionalComment());
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tear down class");
        System.out.flush();
    }
}