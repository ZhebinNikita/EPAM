package by.epam.insurance.obligation.object;


import by.epam.insurance.obligation.Obligation;

/**
 * По обьекту страхования - личное.
 * */
public class PersonalObligation extends Obligation implements DefinableInsuranceObject {

    private InsuranceObject insuranceObject;


    public PersonalObligation(){
        super();
    }
    public PersonalObligation(String name, int riskLevel, double cost, InsuranceObject insuranceObject){
        super(name, riskLevel, cost);
        this.insuranceObject = insuranceObject;
    }


    @Override
    public void setInsuranceObject(InsuranceObject insuranceObject) {
        this.insuranceObject = insuranceObject;
    }

    @Override
    public InsuranceObject getInsuranceObject() {
        return this.insuranceObject;
    }


    @Override
    public void showObligationData() {
        System.out.println("\nPersonal Obligation: \nname: " + this.name + "; \nrisk level: " + this.riskLevel
                + "%; \ncost: " + this.cost + "$; \ninsurance object: " + this.insuranceObject.getInsuranceObject() + ".\n");
    }


}
