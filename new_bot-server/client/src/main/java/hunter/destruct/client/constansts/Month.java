package hunter.destruct.client.constansts;

import lombok.Getter;

@Getter
public enum Month {

    JANUARY("Январь"),
    FEBRUARY("Февраль"),
    MARCH("Март"),
    APRIL("Апрель"),
    MAY("Май"),
    JUNE("Июнь"),
    JULY("Июль"),
    AUGUST("Август"),
    SEPTEMBER("Сентябрь"),
    OCTOBER("Октябрь"),
    NOVEMBER("Ноябрь"),
    DECEMBER("Декабрь");

    private String russianName;

    Month(String russianName) {
        this.russianName = russianName;
    }

    @Override
    public String toString() {
        return  russianName;
    }
}
