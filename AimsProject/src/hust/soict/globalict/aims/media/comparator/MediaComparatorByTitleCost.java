package AimsProject.src.hust.soict.globalict.aims.media.comparator;

import AimsProject.src.hust.soict.globalict.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        int compare = title1.compareTo(title2);
        if (compare != 0) {
            return compare;
        }
        Float cost1 = o1.getCost();
        Float cost2 = o2.getCost();
        return cost1.compareTo(cost2);
    }
}
