package LacksDataBaseProject;

import LacksDataBaseProject.Exceptions.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class LacksOperationsTest {

    LacksOperations testLackOperations;

    @Before
    public void setUpTestLackOperations () {
        this.testLackOperations = new LacksOperations();
    }

    @Test
    public void createMissingLackData() {
    }

    @Test
    public void userForwarderCheckUserTest() throws ForwarderAccessException {
        //given
        User testUser = mock(User.class);
        when(testUser.getRole()).thenReturn(Role.FORWARDER);
        //when
        //then
        assertEquals(true, testLackOperations.checkUserRole(testUser));
    }

    @Test (expected = ForwarderAccessException.class)
    public void userNotForwarderCheckUserTest() throws ForwarderAccessException {
        //given
        User testUser = mock(User.class);
        when(testUser.getRole()).thenReturn(Role.PURCHASER);
        //when
        //then
        assertEquals(false, testLackOperations.checkUserRole(testUser));
    }

    @Test
    public void ifSequentialSetLackIdTest() throws ZeroDataException {
        //given
        Lack testLack = new Lack("testItemID", "testItemName", 0, null, null, null, 0, null, null, null, 0, null, null);
        Lack testLack2 = new Lack("testItemID", "testItemName", 0, null, null, null, 0, null, null, null, 0, null, null);
        //when
        testLackOperations.setLackID(testLack);
        testLackOperations.setLackID(testLack2);
        //then
        assertEquals(1, testLack.getLackID());
        assertEquals(2, testLack2.getLackID());
    }

    @Test
    public void setForwarderSkypeIdWhenUserForwarderInSetForwarderSkypeIdTest() throws ForwarderAccessException {
        //given
        User testUser = mock (User.class);
        Lack testLack = mock(Lack.class);
        when(testUser.getRole()).thenReturn(Role.FORWARDER);
        //when
        testLackOperations.setForwarderSkypeID(testLack, testUser);
        //then
        verify(testLack, times(1)).setForwarderSkypeID(testUser.getSkypeID());
    }

    @Test
    public void ifProperDataLacksSetDateAndTimeTest() throws WrongDateFormatException, ForwarderAccessException {
        //given
        User testUser = mock(User.class);
        Lack testLack = new Lack("testItemID", "testItemName", 0, null, null, null, 0, null, null, null, 0, null, null);
        when(testUser.getRole()).thenReturn(Role.FORWARDER);
        //when
        testLackOperations.setLacksSetDateAndTime(testLack, testUser);
        //then
        assertEquals("2018-12-06 11:51", testLack.getLacksDateAndTime());
    }

    @Test
    public void userForwarderInOpenStatusTest() throws ForwarderAccessException {
        //given
        User testUser = mock(User.class);
        Lack testLack = mock(Lack.class);
        when(testUser.getRole()).thenReturn(Role.FORWARDER);
        //when
        testLackOperations.openStatus(testLack, testUser);
        //then
        verify(testLack, times(1)).setStatus(true);
    }

    @Test
    public void userForwarderInsetDefaultOrderedAmount() throws LessThanZeroException, ForwarderAccessException {
        //given
        User testUser = mock(User.class);
        Lack testLack = mock(Lack.class);
        when(testUser.getRole()).thenReturn(Role.FORWARDER);
        //when
        testLackOperations.setDefaultOrderedAmount(testLack, testUser);
        //then
        verify(testLack, times(1)).setOrderedAmount(0);
    }

    @Test
    public void userForwarderInSetDefaultExpectedDeliveryDateAndTimeTest() throws WrongDateFormatException, ForwarderAccessException {
        //given
        User testUser = mock(User.class);
        Lack testLack = mock(Lack.class);
        when(testUser.getRole()).thenReturn(Role.FORWARDER);
        //when
        testLackOperations.setDefaultExpectedDeliveryDateAndTime(testLack, testUser);
        //then
        verify(testLack, times(1)).setExpectedDeliveryDateAndTime(null);
    }

    @Test
    public void userForwarderInSetDefaultPurchaserAdditionalComment() throws ForwarderAccessException {
        //given
        User testUser = mock(User.class);
        Lack testLack = mock(Lack.class);
        when(testUser.getRole()).thenReturn(Role.FORWARDER);
        //when
        testLackOperations.setDefaultPurchaserAdditionalComment(testLack, testUser);
        //then
        verify(testLack, times(1)).setPurchaserAdditionalComment(null);
    }

    @Test
    public void notNullUserSendPurchaserAlertTest() throws ForwarderAccessException, UserLackException {
        //given
        User testUser = mock(User.class);
        Lack testLack = mock(Lack.class);
        Supplier testSupplier = mock(Supplier.class);
        when(testUser.getRole()).thenReturn(Role.FORWARDER);
        when(testLack.getSupplier()).thenReturn(testSupplier);
        when(testLack.getSupplier().getUser()).thenReturn(testUser);
        when(testUser.getUserName()).thenReturn("testUserName");
        //when
        //then
        assertEquals("Sending Alert to testUserName", testLackOperations.sendPurchaserAlert(testLack, testUser));
    }

    @Test (expected=UserLackException.class)
    public void nullUserSendPurchaserAlertTest() throws ForwarderAccessException, UserLackException {
        //given
        User testUser = mock(User.class);
        Lack testLack = mock(Lack.class);
        Supplier testSupplier = mock(Supplier.class);
        when(testUser.getRole()).thenReturn(Role.FORWARDER);
        when(testLack.getSupplier()).thenReturn(testSupplier);
        when(testLack.getSupplier().getUser()).thenReturn(null);
        when(testUser.getUserName()).thenReturn("testUserName");
        //when
        //then
        assertEquals("Sending Alert to testUserName", testLackOperations.sendPurchaserAlert(testLack, testUser));
    }

    @Test
    public void sendForwarderAlert() {
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("tear down class");
        System.out.flush();
    }
}