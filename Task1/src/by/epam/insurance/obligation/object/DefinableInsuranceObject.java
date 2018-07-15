package by.epam.insurance.obligation.object;


/**
 * Задаёт поведение ОБЯЗАТЕЛЬСТВУ по объекту страхования
 * */
public interface DefinableInsuranceObject {

    void setInsuranceObject(InsuranceObject insuranceObject);
    InsuranceObject getInsuranceObject();

}
