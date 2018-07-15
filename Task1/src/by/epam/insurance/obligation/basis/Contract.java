package by.epam.insurance.obligation.basis;


/**
 * Договор — сущность, которая устанавливается в зависимости
 * от признака обязательности (Добровольное || Обязательное).
 * Включает в себя страховую премию - плата за страхование,
 * которую страхователь обязан внести страховщику в соответствии
 * с договором страхования или законом.
 * */
public class Contract {

    private double insurancePremium;


    public Contract(double insurancePremium){
        this.insurancePremium = insurancePremium;
    }


    public double getInsurancePremium() {
        return insurancePremium;
    }


}
