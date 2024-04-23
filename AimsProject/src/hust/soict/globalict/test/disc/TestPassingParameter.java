package AimsProject.src.hust.soict.globalict.test.disc;

import AimsProject.src.hust.soict.globalict.aims.disc.DVD;

public class TestPassingParameter {
    public static void main(String[] args) {

        // TODO Auto-generated method stub
        DVD jungleDVD = new DVD("Jungle");
        DVD cinderellaDVD = new DVD("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DVD dvd, String title) {
//        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
//        dvd = new DVD(oldTitle);
    }
}
