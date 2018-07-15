package by.epam.insurance;

import by.epam.insurance.derivative.Derivative;
import by.epam.insurance.obligation.Obligation;
import by.epam.insurance.obligation.basis.Contract;
import by.epam.insurance.obligation.basis.ObligatoryObligation;
import by.epam.insurance.obligation.basis.VoluntaryObligation;
import by.epam.insurance.obligation.object.InsuranceObject;
import by.epam.insurance.obligation.object.MaterialObligation;
import by.epam.insurance.obligation.object.PersonalObligation;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        Obligation personalObligation = new PersonalObligation(
                "PERSONAL", 50, 40.55d, new InsuranceObject("Жизнь"));
        Obligation materialObligation = new MaterialObligation(
                "MATERIAL", 40, 50.00d, new InsuranceObject("Автомобиль"));
        Obligation voluntaryObligation = new VoluntaryObligation(
                "VOLUNTARY", 60, 30.00d, new Contract(10.00d));
        Obligation obligatoryObligation = new ObligatoryObligation(
                "OBLIGATORY", 30, 60.00d, new Contract(20.00d));


        Obligation[] obligations = new Obligation[]
                { personalObligation, materialObligation, voluntaryObligation, obligatoryObligation };


        Derivative derivative = new Derivative("MyDerivative", "01.09.2018", obligations);
        derivative.sortByDecreasingRisk();
        derivative.showObligationsData();


        System.out.println("---------------------------------------------------------------");


        List<Obligation> obligationList = derivative.search("A", 25, 55, 49, 61);
        for(Obligation obligation : obligationList){
            obligation.showObligationData();
        }


    }
}
