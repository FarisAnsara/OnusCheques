package org.SpringBoot.onus;

import org.SpringBoot.onus.Exceptions.NameWithNullValueException;
import org.SpringBoot.onus.Models.Customer;
import org.SpringBoot.onus.Repositories.UserRepository;
import org.SpringBoot.onus.Services.UserControllerImpl;
import org.junit.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TestOnusCheque {

    @InjectMocks
    UserControllerImpl userControllerImpl;

    public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenNewCustomer_whenGenerateNewCustomer_thenSaveNewCustomer() {
        Customer customer = new Customer("Faris", "Ibrahim", "Daoud", "Ansara");
        when(userRepository.save(customer)).thenReturn(customer);
        Customer savedCustomer = userRepository.save(customer);
        verify(userRepository,times(1)).save(customer);
        assertNotNull(savedCustomer);
    }

    @Test
    public void givenFindAllCustomers_theReturnAllCustomers() {
        Customer customer = new Customer("Faris", "Ibrahim", "Daoud", "Ansara");
        Customer customer1 = new Customer("Tarik", "Ibrahim", "Daoud", "Ansara");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer1);
        userRepository.save(customer);
        userRepository.save(customer1);
        when(userRepository.findAll()).thenReturn(customerList);
        List<Customer> foundCustomers = (List<Customer>) userRepository.findAll();
        assertNotNull(foundCustomers);
        assertArrayEquals(foundCustomers.toArray(),customerList.toArray());
    }

    @Test
    public void givenNullCustomerFirstName_whenGivenName_thenThrow(){
        Customer customer = new Customer(null, "Ibrahim", "Daoud", "Ansara");
        NameWithNullValueException exception = assertThrows(NameWithNullValueException.class, () -> userControllerImpl.checkNullValueInName(customer));
        assertEquals("Cannot have first name empty", exception.getMessage());
    }

    @Test
    public void givenNullCustomerFatherName_whenGivenName_thenThrow() {
        Customer customer = new Customer("Faris", null, "Daoud", "Ansara");
        NameWithNullValueException exception = assertThrows(NameWithNullValueException.class, () -> userControllerImpl.checkNullValueInName(customer));
        assertEquals("Cannot have father's name empty", exception.getMessage());
    }

    @Test
    public void givenNullCustomerGrandfather_whenGivenName_thenThrow(){
        Customer customer = new Customer("Faris", "Ibrahim", null, "Ansara");
        NameWithNullValueException exception = assertThrows(NameWithNullValueException.class, () -> userControllerImpl.checkNullValueInName(customer));
        assertEquals("Cannot have grandfather's name empty", exception.getMessage());
    }

    @Test
    public void givenNullCustomerLastName_whenGivenName_thenThrow(){
        Customer customer = new Customer("Faris", "Ibrahim", "Daoud", null);
        NameWithNullValueException exception = assertThrows(NameWithNullValueException.class, () -> userControllerImpl.checkNullValueInName(customer));
        assertEquals("Cannot have last name empty", exception.getMessage());
    }

    Customer customerNullGrandpaName = new Customer("Faris", "Ibrahim", null, "Ansara");
    Customer customerNullLastName = new Customer("Faris", "Ibrahim", "Daoud", null);




//    @Test
//    void givenGenerateNewId_whenGenerate_thenReturnNewIdThatDoesntExcist() {
//
//    }

//    @Test
//    public void givenNewUser_whenAddedNewUserToUsers_thenReturnNewUserWhenGetAllUsers() {
//        User user = new User("Faris", "Ibrahim", "Daoud", "Ansara");
//        String name = "Faris Ibrahim Daoud Ansara";
//        .save(user);
//        String actualAccountNumber = String.valueOf(userRepository.findByName(name));
//        assertNotNull(actualAccountNumber);
//    }

//    @Test
//    public void givenNewUser_whenAddedNewUserToBank_thenReturnNewUserWhenGetAllUsers() {
//        Bank bank = new Bank();
//        User user = new User();
//        bank.add(user);
//        BankRepository bankRepository;
//        String actualAccountNumber = bankRepository.getAccountNumberByFullName(user.fullName);;
//        assertNotNull(actualAccountNumber);
//    }

//    @Test
//    public void givenPayerCheckBalanceUpdated_whenCashCheque() {
//        cheque.setAmount(100);
//        cheque.setSerialNumber("125490030390013010150041470");
//        Payer payer = new Payer();
//        payer.setBalance(500);
//        payer.cashCheque(cheque);
//        int actualBalance = user.getBalance();
//        int expectedBalance = 400;
//        assertEquals(actualBalance,expectedBalance);
//    }
//
//    @Test
//    public void givenBfdChecckBalanceUpdated_whenCashCheque() {
//        cheque.setAmount(100);
//        cheque.setSerialNumber("125490030390013010150041470");
//        Bdf bdf = new Bdf();
//        bdf.setBalance(500);
//        bdf.cashCheque(cheque);
//        int actualBalance = user.getBalance();
//        int expectedBalance = 600;
//        assertEquals(actualBalance,expectedBalance);
//    }
//
//    @Test
//    public void givenNewBank_whenAddedNewBank_thenNewBankAdded() {
//        Bank bank = new Bank();
//        bank.setName(HSBC);
//        BankRepository bankRepository = new BankRepository();
//        bankRepository.addBank();
//        int actualBankId = bankRepository.findBankByName(name);
//        int expectedId = 9;
//        assertEquals(actualBankId, expectedId);
//    }
//
//    @Test
//    public void givenDuplicateCheque_whenGivenCheque_thenThrowException() {
//        String chequeSerialNumber = "123456";
//        ChequeIsDuplicateException exception = assertThrows(ChequeIsDuplicateException.class, () -> cheque.setSerialNumber(chequeSerialNumber));
//        assertEquals("Duplicate Cheque Found", exception.getMessage());
//    }
//
//    @Test
//    public void givenInvalidBank_whenGivenBankNumberFromMarker_thenThrowException() {
//        String bank = "09";
//        BankIsInvalidException exception = assertThrows(BankIsInvalidException.class, () -> cheque.setBankNumber(bank));
//        assertEquals("Bank is invalid", exception.getMessage());
//    }
//
//    @Test
//    public void givenInvalidBranch_whenGivenBranchNumberFromMarker_thenThrowException() {
//        String branch = "1029";
//        BranchIsInvalidException exception = assertThrows(BranchIsInvalidException.class, () -> cheque.setBranchNumber(branch));
//        assertEquals("Branch is invalid", exception.getMessage());
//    }
//
//    @Test
//    public void givenInvalidPayerAccount_whenGivenAccountNumbers_thenThrowException() {
//        String accountNumber = "123456789123456789";
//        PayerAccountIsInvalidException exception = assertThrows(PayerAccountIsInvalidException.class, () -> cheque.addPayerAccount(accountNumber));
//        assertEquals("Payer account is invalid", exception.getMessage());
//    }
//
//    @Test
//    public void givenInvalidBfdAccount_whenGivenAccountNumbers_thenThrowException() {
//        String accountNumber = "123456789123456789";
//        BfdAccountIsInvalidException exception = assertThrows(BfdAccountIsInvalidException.class, () -> cheque.addBfdAccount(accountNumber));
//        assertEquals("BFD (payee) account is invalid", exception.getMessage());
//    }
//
//    @Test
//    public void givenInsufficientBalanceInPayerAccount_whenCashingCheque_thenThrowException() {
//        String chequeMarker = "125490030390013010150041470";
//        InsufficientBalanceException exception = assertThrows(InsufficientBalanceException.class, () -> cheque.cash(chequeMarker));
//        assertEquals("Insufficient money in account", exception.getMessage());
//    }
//
//    @Test
//    public void givenWrongNumberOfCharactersInMarker_whenCashingCheque_thenThrowException() {
//        String chequeMarker = "12";
//        MarkerIsWrongNumberOfCharactersException exception = assertThrows(MarkerIsWrongNumberOfCharactersException.class, () -> cheque.cash(chequeMarker));
//        assertEquals("Insufficient money in account", exception.getMessage());
//    }
//
//    @Test
//    public void givenWrongCurrency_whenInputCurrency_thenThrowException() {
//        String currency = "USD";
//        InvalidCurrencyException exception = assertThrows(InvalidCurrencyException.class, () -> cheque.setCurrency(currency));
//        assertEquals("Invalid currency input", exception.getMessage());
//    }
//
//    @Test
//    public void givenChequeIsNotOnus_whenCashingCheque_thenThrowException() {
//        String chequeMarker = "125490020390013010150041470"; //the 02 after the 90 changes the bank
//        NotAnOnusChequeOperationException exception = assertThrows(NotAnOnusChequeOperationException.class, () -> cheque.cash(chequeMarker));
//        assertEquals("This is not an Onus cheque operation as the payer and the Bdf (payee) are not in the same bank.", exception.getMessage());
//    }
//
//    @Test
//    public void givenPostDateAfterTodaysDate_whenCashingCheck_thenThrowException() {
//        String date = "18092024";
//        NotAnOnusChequeOperationException exception = assertThrows(NotAnOnusChequeOperationException.class, () -> cheque.postDate(date));
//        assertEquals("This is not an Onus cheque operation as the post date is after today's date.", exception.getMessage());
//    }

}