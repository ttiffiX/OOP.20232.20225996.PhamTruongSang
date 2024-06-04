package AimsProject.src.hust.soict.globalict.aims;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.src.hust.soict.globalict.aims.media.*;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Aims {
    public static void defaultStore(Store store) {
        DVD dvd1 = new DVD(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD(3, "Aladin", "Animation", 18.99f);
        ArrayList<String> authors = new ArrayList<>();
        authors.add("HMD");
        Book book1 = new Book(4, "Sherlock Holmes", "Detective", 100.0f, authors);
        CD cd1 = new CD(5, "Story of my life", "Something", "Me", 200f);
        Track track1 = new Track("Baby Blue", 100);
        Track track2 = new Track("Free Bird", 0);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(cd1);
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("________________________________");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("Store options:");
        System.out.println("________________________________");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Media Details options:");
        System.out.println("________________________________");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void updateStoreMenu() {
        System.out.println("Update Store options:");
        System.out.println("________________________________");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void addMediaMenu() {
        System.out.println("Media options:");
        System.out.println("________________________________");
        System.out.println("1. Add a CD to store");
        System.out.println("2. Add a DVD to store");
        System.out.println("3. Add a book to store");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void cartMenu() {
        System.out.println("Cart options:");
        System.out.println("________________________________");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("________________________________");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    public static void main(String[] args) throws Exception {
        Store store = new Store();
        Cart cart = new Cart();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String title;
        int mainOption;
        int storeOption = 1;
        int mediaOption = 1;
        int cartOption = 1;
        int filterOption = 1;
        int sortOption = 1;
        int updateStoreOption = 1;
        int addMediaOption = 1;
        Media storeMedia, cartMedia;
        defaultStore(store);

        while (true) {
            showMenu();
            mainOption = scanner.nextInt();
            switch (mainOption) {
                case 1:
                    while (storeOption != 0) {
                        System.out.println();
                        store.displayStore();
                        storeMenu();
                        storeOption = scanner.nextInt();
                        switch (storeOption) {
                            case 1:
                                scanner.nextLine();
                                do {
                                    System.out.print("Please enter the title of the media you want to see: ");
                                    title = scanner.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia == null) {
                                        System.out.println("This media item is not in store");
                                    }
                                } while (storeMedia == null);
                                System.out.println(storeMedia);

                                while (mediaOption != 0) {
                                    System.out.println();
                                    mediaDetailsMenu();
                                    mediaOption = scanner.nextInt();
                                    switch (mediaOption) {
                                        case 0:
                                            break;
                                        case 1:
                                            cart.addMedia(storeMedia);
                                            System.out.println();
                                            System.out.println("Updated cart:");
                                            cart.displayItem();
                                            break;
                                        case 2:
                                            if (storeMedia instanceof DVD tempMedia) {
                                                tempMedia.play();
                                            } else if (storeMedia instanceof CD tempMedia) {
                                                tempMedia.play();
                                            } else {
                                                System.out.println("This media can't be played");
                                            }
                                            break;


                                        default:
                                            System.out.println("Invalid option!");
                                            break;
                                    }
                                }
                                break;

                            case 2:
                                scanner.nextLine();
                                store.displayStore();
                                do {
                                    System.out.print("Please enter the title of the media you want to add to cart: ");
                                    title = scanner.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia == null) {
                                        System.out.println("This media item is not in the store");
                                    }
                                } while (storeMedia == null);
                                cart.addMedia(storeMedia);
                                System.out.println();
                                System.out.println("Updated cart:");
                                cart.displayItem();
                                break;

                            case 3:
                                scanner.nextLine();
                                store.displayStore();
                                do {
                                    System.out.print("Please enter the title of the media you want to play: ");
                                    title = scanner.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia == null) {
                                        System.out.println("This media item is not in the store");
                                    }
                                } while (storeMedia == null);
                                if (storeMedia instanceof DVD tempMedia) {
                                    tempMedia.play();
                                } else if (storeMedia instanceof CD tempMedia) {
                                    tempMedia.play();
                                } else {
                                    System.out.println("This media can't be played");
                                }
                                break;

                            case 4:
                                while (cartOption != 0) {
                                    System.out.println();
                                    cart.displayItem();
                                    if (cart.sizeCart() == 0) {
                                        System.out.println("The cart is empty.");
                                        break;
                                    }
                                    cartMenu();
                                    cartOption = scanner.nextInt();
                                    switch (cartOption) {
                                        case 1:
                                            System.out.print("Please enter 1 to filter by id or 2 to filter by title: ");
                                            filterOption = scanner.nextInt();
                                            switch (filterOption) {
                                                case 1:
                                                    int idFilter = 1;
                                                    System.out.print("Please enter id: ");
                                                    idFilter = scanner.nextInt();
                                                    cartMedia = cart.searchCart(idFilter);
                                                    if (cartMedia != null) {
                                                        System.out.println();
                                                        System.out.println("Media item found:");
                                                        System.out.println(cartMedia);
                                                    } else System.out.println("No result.");
                                                    break;

                                                case 2:
                                                    scanner.nextLine();
                                                    String titleFilter = "";
                                                    System.out.print("Please enter title: ");
                                                    titleFilter = scanner.nextLine();
                                                    cartMedia = cart.searchCart(titleFilter);
                                                    if (cartMedia != null) {
                                                        System.out.println();
                                                        System.out.println("Media item found:");
                                                        System.out.println(cartMedia);
                                                    } else {
                                                        System.out.println("No result.");
                                                    }
                                                    break;

                                                default:
                                                    System.out.println("Invalid option. Please choose between 1 or 2");
                                                    break;
                                            }
                                            break;
                                        case 2:
                                            cart.displayItem();
                                            System.out.print("Please enter 1 to sort by title or 2 to sort by cost: ");
                                            sortOption = scanner.nextInt();
                                            switch (sortOption) {
                                                case 1:
                                                    cart.sortByTitle();
                                                    break;
                                                case 2:
                                                    cart.sortByCost();
                                                    break;
                                                default:
                                                    System.out.println("Invalid option.");
                                                    break;
                                            }
                                            break;

                                        case 3:
                                            scanner.nextLine();
                                            cart.displayItem();
                                            do {
                                                System.out.print("Enter title of media you want to remove: ");
                                                title = scanner.nextLine();
                                                cartMedia = cart.searchCart(title);
                                                if (cartMedia == null) {
                                                    System.out.println("The media item with given title is not in the cart");
                                                }
                                            } while (cartMedia == null);
                                            cart.removeMedia(cartMedia);
                                            System.out.println("Updated cart:");
                                            cart.displayItem();
                                            break;

                                        case 4:
                                            scanner.nextLine();
                                            store.displayStore();
                                            do {
                                                System.out.print("Please enter the title of the media you want to play: ");
                                                title = scanner.nextLine();
                                                storeMedia = store.searchStore(title);
                                                if (storeMedia == null) {
                                                    System.out.println("This media item is not in the store");
                                                }
                                            } while (storeMedia == null);
                                            if (storeMedia instanceof DVD tempMedia) {
                                                tempMedia.play();
                                            } else if (storeMedia instanceof CD tempMedia) {
                                                tempMedia.play();
                                            } else {
                                                System.out.println("This media can't be played");
                                            }
                                            break;

                                        case 5:
                                            System.out.println("An order is created");
                                            cart = new Cart();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid option.");
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                    break;
                case 2:
                    store.displayStore();
                    while (updateStoreOption != 0) {
                        System.out.println();
                        updateStoreMenu();
                        updateStoreOption = scanner.nextInt();
                        switch (updateStoreOption) {
                            case 1:
                                while (addMediaOption != 0) {
                                    System.out.println();
                                    addMediaMenu();
                                    addMediaOption = scanner.nextInt();
                                    switch (addMediaOption) {
                                        case 1:
                                            int id1 = random.nextInt(1000);
                                            scanner.nextLine();
                                            System.out.println("Please provide the details of the media you want to add");
                                            do {
                                                System.out.print("Title: ");
                                                title = scanner.nextLine();
                                                storeMedia = store.searchStore(title);
                                                if (storeMedia != null) {
                                                    System.out.println("Media item with same title already exists in store");
                                                }
                                            } while (storeMedia != null);

                                            System.out.print("Category: ");
                                            String category1;
                                            category1 = scanner.nextLine();

                                            System.out.print("Artist name: ");
                                            String artist;
                                            artist = scanner.nextLine();

                                            float cost1 = -1f;
                                            while (cost1 < 0) {
                                                System.out.print("Cost: ");
                                                cost1 = scanner.nextFloat();
                                                if (cost1 < 0) {
                                                    System.out.println("Invalid input.");
                                                }
                                            }
                                            CD cd = new CD(id1, title, category1, artist, cost1);

                                            int trackCount = 0;
                                            while (trackCount <= 0) {
                                                System.out.print("Enter number of tracks : ");
                                                trackCount = scanner.nextInt();
                                                if (trackCount <= 0) {
                                                    System.out.println("Invalid input.");
                                                }
                                            }
                                            for (int i = 0; i < trackCount; i++) {
                                                scanner.nextLine();
                                                System.out.print("Enter track title: ");
                                                title = scanner.nextLine();
                                                int length = -1;
                                                while (length < 0) {
                                                    System.out.print("Enter track length: ");
                                                    length = scanner.nextInt();
                                                    if (length < 0) {
                                                        System.out.println("Invalid input.");
                                                    }
                                                }
                                                Track track = new Track(title, length);
                                                cd.addTrack(track);
                                            }
                                            System.out.println();
                                            store.addMedia(cd);
                                            System.out.println("Updated store");
                                            store.displayStore();
                                            break;

                                        case 2:
                                            int id2 = random.nextInt(1000);
                                            scanner.nextLine();
                                            System.out.println("Please provide the details of the media you want to add");
                                            do {
                                                System.out.print("Title: ");
                                                title = scanner.nextLine();
                                                storeMedia = store.searchStore(title);
                                                if (storeMedia != null) {
                                                    System.out.println("Media item with same title already exists in store");
                                                }
                                            } while (storeMedia != null);

                                            System.out.print("Category: ");
                                            String category2;
                                            category2 = scanner.nextLine();

                                            System.out.print("director: ");
                                            String director;
                                            director = scanner.nextLine();

                                            float cost2 = -1f;
                                            while (cost2 < 0) {
                                                System.out.print("Cost: ");
                                                cost2 = scanner.nextFloat();
                                                if (cost2 < 0) {
                                                    System.out.println("Invalid input.");
                                                }
                                            }

                                            int length = -1;
                                            while (length < 0) {
                                                System.out.print("Enter track length: ");
                                                length = scanner.nextInt();
                                                if (length < 0) {
                                                    System.out.println("Invalid input.");
                                                }
                                            }
                                            DVD dvd = new DVD(id2, title, category2, director, length, cost2);
                                            System.out.println();
                                            store.addMedia(dvd);
                                            System.out.println("Updated store");
                                            store.displayStore();
                                            break;

                                        case 3:
                                            int id3 = random.nextInt(1000);
                                            scanner.nextLine();
                                            System.out.println("Please provide the details of the media you want to add");
                                            do {
                                                System.out.print("Title: ");
                                                title = scanner.nextLine();
                                                storeMedia = store.searchStore(title);
                                                if (storeMedia != null) {
                                                    System.out.println("Media item with same title already exists in store");
                                                }
                                            } while (storeMedia != null);

                                            System.out.print("Category: ");
                                            String category3;
                                            category3 = scanner.nextLine();

                                            float cost3 = -1f;
                                            while (cost3 < 0) {
                                                System.out.print("Cost: ");
                                                cost3 = scanner.nextFloat();
                                                if (cost3 < 0) {
                                                    System.out.println("Invalid input.");
                                                }
                                            }

                                            int authorCount = 0;
                                            String author;
                                            while (authorCount <= 0) {
                                                System.out.print("Enter number of authors: ");
                                                authorCount = scanner.nextInt();
                                                if (authorCount <= 0) {
                                                    System.out.println("Invalid input.");
                                                }
                                            }

                                            Book book = new Book(id3, title, category3, cost3);
                                            scanner.nextLine();
                                            for (int i = 0; i < authorCount; i++) {
                                                System.out.print("Enter author name: ");
                                                author = scanner.nextLine();
                                                book.addAuthor(author);
                                            }
                                            System.out.println();
                                            store.addMedia(book);
                                            System.out.println("Updated store");
                                            store.displayStore();
                                            break;

                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid option.");
                                            break;
                                    }
                                }
                                break;

                            case 2:
                                scanner.nextLine();
                                store.displayStore();
                                do {
                                    System.out.print("Enter title of the media you want to remove: ");
                                    title = scanner.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia == null) {
                                        System.out.println("The media item is not in store");
                                    }
                                } while (storeMedia == null);

                                System.out.println();
                                store.removeMedia(storeMedia);
                                System.out.println("Updated store:");
                                store.displayStore();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }

                    }
                    break;
                case 3:
                    while (cartOption != 0) {
                        System.out.println();
                        cart.displayItem();
                        if (cart.sizeCart() == 0) {
                            System.out.println("The cart is empty.");
                            break;
                        }
                        cartMenu();
                        cartOption = scanner.nextInt();
                        switch (cartOption) {
                            case 1:
                                System.out.print("Please enter 1 to filter by id or 2 to filter by title: ");
                                filterOption = scanner.nextInt();
                                switch (filterOption) {
                                    case 1:
                                        int idFilter = 1;
                                        System.out.print("Please enter id: ");
                                        idFilter = scanner.nextInt();
                                        cartMedia = cart.searchCart(idFilter);
                                        if (cartMedia != null) {
                                            System.out.println();
                                            System.out.println("Media item found:");
                                            System.out.println(cartMedia);
                                        } else System.out.println("No result.");
                                        break;

                                    case 2:
                                        scanner.nextLine();
                                        String titleFilter = "";
                                        System.out.print("Please enter title: ");
                                        titleFilter = scanner.nextLine();
                                        cartMedia = cart.searchCart(titleFilter);
                                        if (cartMedia != null) {
                                            System.out.println();
                                            System.out.println("Media item found:");
                                            System.out.println(cartMedia);
                                        } else {
                                            System.out.println("No result.");
                                        }
                                        break;

                                    default:
                                        System.out.println("Invalid option. Please choose between 1 or 2");
                                        break;
                                }
                                break;
                            case 2:
                                cart.displayItem();
                                System.out.print("Please enter 1 to sort by title or 2 to sort by cost: ");
                                sortOption = scanner.nextInt();
                                switch (sortOption) {
                                    case 1:
                                        cart.sortByTitle();
                                        break;
                                    case 2:
                                        cart.sortByCost();
                                        break;
                                    default:
                                        System.out.println("Invalid option.");
                                        break;
                                }
                                break;

                            case 3:
                                scanner.nextLine();
                                cart.displayItem();
                                do {
                                    System.out.print("Enter title of media you want to remove: ");
                                    title = scanner.nextLine();
                                    cartMedia = cart.searchCart(title);
                                    if (cartMedia == null) {
                                        System.out.println("The media item with given title is not in the cart");
                                    }
                                } while (cartMedia == null);
                                cart.removeMedia(cartMedia);
                                System.out.println("Updated cart:");
                                cart.displayItem();
                                break;

                            case 4:
                                scanner.nextLine();
                                store.displayStore();
                                do {
                                    System.out.print("Please enter the title of the media you want to play: ");
                                    title = scanner.nextLine();
                                    storeMedia = store.searchStore(title);
                                    if (storeMedia == null) {
                                        System.out.println("This media item is not in the store");
                                    }
                                } while (storeMedia == null);
                                if (storeMedia instanceof DVD tempMedia) {
                                    tempMedia.play();
                                } else if (storeMedia instanceof CD tempMedia) {
                                    tempMedia.play();
                                } else {
                                    System.out.println("This media can't be played");
                                }
                                break;

                            case 5:
                                System.out.println("An order is created");
                                cart = new Cart();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid option.");
                                break;
                        }
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
