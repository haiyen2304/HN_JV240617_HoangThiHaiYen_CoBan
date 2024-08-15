package HN_JV240617_HoangThiHaiYen_CoBan;

import hackathon.ra.run.Input;

import java.util.Scanner;

public class BookManagement {
    public static int bookIndex = 0;
    public static Book[] books = new Book[100];

    public static void main(String[] args, Book[] books) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("****************JAVAVAVA-HACKATATHON-05-BASIC-MENU*************** \n" +
                        "1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n" +
                        "2. Hiển thị thông tin tất cả sách trong thư viện \n" +
                        "3. Sắp xếp sách theo lợi nhuận tăng dần \n" +
                        "4. Xóa sách theo mã sách \n" +
                        "5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả \n" +
                        "6. Thay đổi thông tin sách theo mã sách \n" +
                        "7. Thoát");
                System.out.print("Nhập lựa chọn (1 - 7): ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Console.message("(1). Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách \n");
                        int quantity = inputPositiveInt(scanner, "Nhập số lượng sách thêm mới");
                        scanner.nextLine();
                        for (int i = 0; i < quantity; i++) {
                            Book book = new Book();
                            Console.message("Nhập số lượng sách thứ " + bookIndex + "\n");
                            book.inputData(scanner);
                            books[bookIndex] = book;
                            Console.message("Nhập xong sách thứ "+ bookIndex + "\n");
                            bookIndex++;
                        }
                        break;
                    case 2:
                        Console.message("(2). Hiển thị thông tin tất cả sách trong thư viện \n");
                        System.out.printf("| %-10s | %-20s | %-20s | %-25s | %-10s | %-10s |%-10s |%-10s |\n",
                                "bookId", "bookName", "author", "descriptions","importPrice","exportPrice" ,"interest", "bookStatus" );
                        for(int i = 0; i < books.length; i++) {
                            books[i].displayData();
                        }
                        break;
                    case 3:
                        Console.message("(3). Sắp xếp sách theo lợi nhuận tăng dần \n");
                        Book[] sortedbooks2=new Book[bookIndex+1];
                        for(int i = 0; i < books.length; i++) {
                            sortedbooks2[i]=books[i];
                        }
                        for(int i = 0; i < bookIndex; i++) {
                            int minIndex=i;
                            for(int j = i+1; j < bookIndex; j++) {
                                if(sortedbooks2[i].getBookName().compareToIgnoreCase(sortedbooks2[j].getBookName())<0) {
                                    minIndex=j;
                                }
                            }
                            Book temp=sortedbooks2[minIndex];
                            sortedbooks2[minIndex]=sortedbooks2[i];
                            sortedbooks2[i]=temp;
                        }
                        System.out.printf("| %-10s | %-20s | %-20s | %-25s | %-10s | %-10s |%-10s |%-10s |\n",
                                "bookId", "bookName", "author", "descriptions","importPrice","exportPrice" ,"interest", "bookStatus" );
                        for(Book book : sortedbooks2) {
                            if(book!=null){
                                book.displayData();
                            }
                        }
                        break;
                    case 4:
                        Console.message("(4). Xóa sách theo mã sách");
                        int idDelete = Input.inputPositiveInt(scanner, "Nhập ID sách cần xóa: ");

                        int indexDelete=-1;
                        for(int i = 0; i < bookIndex; i++) {
                            if(books[i].getBookId()==idDelete){
                                indexDelete=i;
                                break;
                            }
                        }
                        if(indexDelete==-1){
                            Console.message("Không tìm thấy ID sách");
                        }else {
                            for(int i=indexDelete;i<bookIndex;i++) {
                                books[i]=books[i+1];
                            }
                            books[bookIndex]=null;
                            bookIndex--;
                            Console.message("Đã xóa xong \n");
                        }
                        break;
                    case 5:
                        Console.message("(5). Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
                        break;
                    case 6:
                        Console.message("(6). Thay đổi thông tin sách theo mã sách");
                        break;
                    case 7:
                        Console.exit("Thoát");
                        scanner.close();
                        return;
                    default:
                        Console.message("Lựa chọn chỉ từ 1 đến 7 \n");

                }
            } catch (Exception e) {
                Console.error("Hãy nhập lựa chọn" + e.getMessage());
                System.out.println();
                scanner.nextLine();
            }
        }
    }

    public static int inputPositiveInt(Scanner scanner, String msg) {
        System.out.print(msg);
        int number;

        while (true) {
            try {
                number = scanner.nextInt();
                if (number > 0) {
                    return number;
                }
                hackathon.ra.run.Console.message(msg);
            } catch (Exception e) {
                scanner.nextLine();
                hackathon.ra.run.Console.message(msg);
            }
        }
    }
}
