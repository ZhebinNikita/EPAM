package by.epam.insurance.obligation.object;


/**
 * Объект страхования — сущность, не противоречащая закону
 * и подлежащая страхованию.
 * */
public class InsuranceObject {

    private String insuranceObject;


    public InsuranceObject(String insuranceObject){
        this.insuranceObject = insuranceObject;
    }


    public String getInsuranceObject() {
        return insuranceObject;
    }


}
