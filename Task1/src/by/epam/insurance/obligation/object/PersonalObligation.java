package by.epam.insurance.obligation.object;


import by.epam.insurance.obligation.Obligation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * По обьекту страхования - личное.
 * */
public class PersonalObligation extends Obligation implements DefinableInsuranceObject {

    private final static Logger LOG = LogManager.getRootLogger();
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
        try {
            System.out.println("\nPersonal Obligation: \nname: " + this.name + "; \nrisk level: " + this.riskLevel
                    + "%; \ncost: " + this.cost + "$; \ninsurance object: " + this.insuranceObject.getInsuranceObject() + ".\n");
        } catch (Exception e) {
            LOG.error("Some Obligation Data are missing! ", e);
        }
    }


}
