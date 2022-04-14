package ee.bcs.myApp.bank.transaction;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TransactionMapper {
    @Mapping(source = "accountId", target = "account.id")
    @Mapping(source = "accountCustomerId", target = "customer.id")
    @Mapping(source = "accountCustomerFirstName", target = "customer.firstName")
    @Mapping(source = "accountCustomerLastName", target = "customer.lastName")
    @Mapping(source = "accountCustomerIsikukood", target = "customer.isikukood")
    @Mapping(source = "accountAccountNumber", target = "account.accountNumber")
    @Mapping(source = "accountBalance", target = "account.balance")
    @Mapping(source = "accountLocked", target = "account.locked")
    Transaction transactionDtoToTransaction(TransactionDto transactionDto);

    @InheritInverseConfiguration(name = "transactionDtoToTransaction")
    TransactionDto transactionToTransactionDto(Transaction transaction);

    @InheritConfiguration(name = "transactionDtoToTransaction")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateTransactionFromTransactionDto(TransactionDto transactionDto, @MappingTarget Transaction transaction);
}
