package hunter.destruct.client.controller;

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

    private String name;
//    private double destructMessage;

    Month(String name) {
        this.name = name;
//        this.destructMessage = destructMessage;
    }

//    public static Month[] getWinterMonths() {
//
//        return new Month[]{DECEMBER, JANUARY, FEBRUARY};
//    }
//
//    public static Month[] getSummerMonths() {
//
//        return new Month[]{JUNE, JULY, AUGUST};
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public double getdestructMessage() {
//        return destructMessage;
//    }
//
//    public void setdestructMessage(int daysCount) {
//        this.destructMessage = daysCount;
//    }

    @Override
    public String toString() {
        return "Month{" +
                "name='" + name + '\'' +
//                ", destructMessageCount=" + destructMessage +
                '}';
    }
}
