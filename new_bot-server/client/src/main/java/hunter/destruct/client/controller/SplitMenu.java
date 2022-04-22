package hunter.destruct.client.controller;

import hunter.destruct.client.controller.diagrams.PieChart;

//todo: wtf, что это за кошмар? :D
//todo: сделай 1(!) метод, который будет принимать нужную для формирования диаграммы информацию
//todo: Для этого вовсе не нужно его в отдельный класс выводить. Реализуй его в самом контроллере, только не делай его статическим
public class SplitMenu {

    public static void callJan(){PieChart.callPieChart();}
    public static void callFeb(){PieChart.callPieChart();}
    public static void callMar(){PieChart.callPieChart();}
    public static void callApr(){PieChart.callPieChart();}
    public static void callMay(){PieChart.callPieChart();}
    public static void callJun(){PieChart.callPieChart();}
    public static void callJul(){PieChart.callPieChart();}
    public static void callAug(){PieChart.callPieChart();}
    public static void callSep(){PieChart.callPieChart();}
    public static void callOct(){PieChart.callPieChart();}
    public static void callNow(){PieChart.callPieChart();}
    public static void callDec(){PieChart.callPieChart();}

    //добавить методы для остальных

}
