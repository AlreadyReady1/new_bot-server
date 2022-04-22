package hunter.destruct.client.controller;

//todo: если что, есть дефолтный енам с месяцами - java.time.Month. Но русских наименований там, конечно, нет.
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

    //todo: удаляй нахер этот закомменченый код. Зачем ты его хранишь? Тут же ничего интересного даже нет
//    public static Month[] getWinterMonths() {
//
//        return new Month[]{DECEMBER, JANUARY, FEBRUARY};
//    }
//
//    public static Month[] getSummerMonths() {
//
//        return new Month[]{JUNE, JULY, AUGUST};
//    }

    //todo: у ломбока есть аннотация @Setter. Ставь ее перед полем, что бы не мешался сеттер в коде
    public String getName() {
        return name;
    }

    //todo: у ломбока есть аннотация @Getter. Ставь ее перед полем, что бы не мешался геттер в коде
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
