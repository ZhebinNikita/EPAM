package by.epam.insurance.obligation.basis;


/**
 * Задаёт поведение ОБЯЗАТЕЛЬСТВУ по признаку обязательности.
 * Требуется заключить договор.
 * Добровольное: по усмотрению страхователя.
 * Обязательное: в силу закона требуется заключить договор.
 * */
public interface SignableContract {

    void setContract(Contract contract);
    Contract getContract();

}
