package org.SpringBoot.onus;

import org.SpringBoot.onus.Exceptions.CustomerExceptions.NameWithNullValueException;
import org.SpringBoot.onus.Repositories.BankRepository;
import org.SpringBoot.onus.Repositories.BranchRepository;
import org.SpringBoot.onus.Services.CustomerServices.CustomerControllerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringJUnitConfig
@RunWith(SpringRunner.class)
@WebMvcTest
public class TestOnusCheque {

    @Autowired
    private MockMvc mvc;
    @InjectMocks
     CustomerControllerImpl customerControllerImpl = new CustomerControllerImpl();

    @InjectMocks
    CustomerController customerController = mock(CustomerController.class);

    @Mock
    CustomerRepository customerRepository;
    @Mock
    BankRepository bankRepository;
    @Mock
    BranchRepository branchRepository;

    @BeforeEach
    public void init() {
//        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenNewCustomer_whenGenerateNewCustomer_thenSaveNewCustomer() {
        Customer customer = new Customer("Faris", "Ibrahim", "Daoud", "Ansara");
        when(customerRepository.save(customer)).thenReturn(customer);
        Customer savedCustomer = customerRepository.save(customer);
        verify(customerRepository,times(1)).save(customer);
        assertNotNull(savedCustomer);
    }

    @Test
    public void givenFindAllCustomers_theReturnAllCustomers() {
        Customer customer = new Customer("Faris", "Ibrahim", "Daoud", "Ansara");
        Customer customer1 = new Customer("Tarik", "Ibrahim", "Daoud", "Ansara");
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer1);
        customerRepository.save(customer);
        customerRepository.save(customer1);
        when(customerRepository.findAll()).thenReturn(customerList);
        List<Customer> foundCustomers = (List<Customer>) customerRepository.findAll();
        assertNotNull(foundCustomers);
        assertArrayEquals(foundCustomers.toArray(),customerList.toArray());
    }

    @Test
    public void givenAddNewCustomer_whenAddCustomer_thenAddCustomer() {
    }

    @Test
    public void givenNullCustomerFirstName_whenGivenName_thenThrow() throws Exception {
        String exceptionParam = "check all fields have values";
        mvc.perform(MockMvcRequestBuilders.get("/post-users", exceptionParam)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof NameWithNullValueException))
                .andExpect(result -> assertEquals("check all fields have values", result.getResolvedException().getMessage()));
    }

    @Test
    public void givenNullCustomerFatherName_whenGivenName_thenThrow() {
        Customer customer = new Customer("Faris", null, "Daoud", "Ansara");
        when(customerController.addUser(customer)).thenThrow(new NameWithNullValueException("Cannot have father's name empty"));
        assertThrows(NameWithNullValueException.class, ( ) -> customerController.addUserTest(customer));
    }

    @Test
    public void givenNullCustomerGrandfather_whenGivenName_thenThrow(){
        Customer customer = new Customer("Faris", "Ibrahim", null, "Ansara");
        when(customerController.addUser(customer)).thenThrow(new NameWithNullValueException("Cannot have grand-father's name empty"));
        assertThrows(NameWithNullValueException.class, ( ) -> customerController.addUserTest(customer));
    }

    @Test
    public void givenNullCustomerLastName_whenGivenName_thenThrow() {
        Customer customer = new Customer("Faris", "Ibrahim", "Daoud", null);
        when(customerController.addUser(customer)).thenThrow(new NameWithNullValueException("Cannot have last name empty"));
        assertThrows(NameWithNullValueException.class, ( ) -> customerController.addUserTest(customer));
    }

    @Test
    public void givenNewBank_whenGenerateNewBank_thenSaveNewBank() {
        Customer customer = new Customer("Faris", "Ibrahim", "Daoud", "Ansara");
//        Branch branch = new Branch("Shemiesani");
//        Bank bank = new Bank("HSBC", branch, Collections.singleton(customer));
//        when(bankRepository.save(bank)).thenReturn(bank);
//        Bank savedBank = bankRepository.save(bank);
//        verify(bankRepository,times(1)).save(bank);
//        assertNotNull(savedBank);
    }

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