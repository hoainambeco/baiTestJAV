package ASM;

import java.util.Scanner;

public class ASM {

    static int slnv;
    static String[] maNV, ten, email;
    static double[] luong;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        menu();
    }

    public static void menu() {
        Scanner s = new Scanner(System.in);
        System.out.println("chương trình quản lý nhân viên");
        System.out.println("1. nhập danh sách nhân viên từ bàn phím");
        System.out.println("2. xuất danh sách nhân viên");
        System.out.println("3. tìm và hiện thị nhân viên theo mã nhân viên");
        System.out.println("4. xóa nhân viên theo mã nhân viên");
        System.out.println("5. cập nhật thông tin nhân viên theo mã nhân viên");
        System.out.println("6. tìm các nhân viên theo khoảng lương");
        System.out.println("7. sắp xếp nhân viên theo họ tên");
        System.out.println("8. sắp xếp nhân viên theo lương");
        System.out.println("9. xuất 5 nhân viên có lương cao nhất");
        System.out.println("10. thoát");
        int cn = s.nextInt();
        switch (cn) {
            case 1:
                nhap();
                break;
            case 2:
                xuat();
                break;
            case 3:
                tim();
                break;
            case 4:
                xoa();
                break;
            case 5:
                capnhat();
                break;
            case 6:
                timluong();
                break;
            case 7:
                sapxep();
                break;
            case 8:
                sapxepluong();
                break;
            case 9:
                maxluong();
                break;
            case 10:
                break;
            default:
                break;
        }
    }

    public static void nhap() {
        Scanner s = new Scanner(System.in);
        System.out.println("mời bạn nhập số lượng nhân viên: ");
        slnv = Integer.parseInt(s.next());
        maNV = new String[slnv];
        ten = new String[slnv];
        email = new String[slnv];
        luong = new double[slnv];
        for (int i = 0; i < slnv; i++) {
            System.out.println("mã nhân viên:");
            maNV[i] = s.next();
            System.out.println("tên nhân viên:");
            ten[i] = s.next();
            System.out.println("email nhân viên:");
            email[i] = s.next();
            System.out.println("lương nhân viên:");
            luong[i] = Double.parseDouble(s.next());
        }
        menu();
    }

    static void xuat() {
        System.out.println("xuất thông tin nhân viên");
        for (int i = 0; i < slnv; i++) {
            System.out.printf("Mã nhân viên: %s\n", maNV[i]);
            System.out.printf("Tên nhân viên: %s\n", ten[i]);
            System.out.printf("email nhân viên: %s\n", email[i]);
            System.out.printf("lương nhân viên: %.1f\n",luong[i]);
            System.out.println("");
        }
        menu();
    }

    static void tim() {
        System.out.println("mời bạn nhập vào mã nhân viên");
        Scanner s = new Scanner(System.in);
        String ma = s.next();
        for (int i = 0; i < slnv; i++) {
            if (maNV[i].equalsIgnoreCase(ma)== true) {
                System.out.printf("Thông tin nhân viên có mã nhân viên là: %s\n", ma);
                System.out.printf("mã nhân viên: %s\n Tên: %s\n Email: %s\n Lương: %.1f\n", maNV[i], ten[i], email[i],luong[i]);
                menu();
            }
            else if(maNV[i].equalsIgnoreCase(ma)== false){
                System.out.println("mã nhân viên bạn vừa nhập không có trong hệ thống. bạn vui lòng nhập lai");
                tim();
            }
        }
    }

    static void xoa() {
        System.out.println("xóa nhân viên theo mã nhân viên");
        Scanner s = new Scanner(System.in);
        String ma = s.nextLine();
        for (int i = 0; i < slnv; i++) {
            if (maNV[i].equalsIgnoreCase(ma)) {
                removeItemString(maNV, i);
                removeItemString(ten, i);
                removeItemString(email, i);
                removeItemDouble(luong, i);
                menu();
            }
            else{
                System.out.println("mã nhân viên bạn vừa nhập không có trong hệ thống. bạn vui lòng nhập lai");
                xoa();
            }
        }
    }

    private static void removeItemString(String[] maNV, int i) {
    }

    static String[] removeStrings(String[] arr, int index) {
        if (arr == null || index < 0 || index > arr.length) {
            return arr;
        }
        String[] anotherArray = new String[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    static double[] removeItemDouble(double[] arr, int index) {
        if (arr == null || index < 0 || index > arr.length) {
            return arr;
        }
        double[] anotherArray = new double[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    static void capnhat() {
        System.out.println("cập nhật thông tin nhân viên theo mã nhân viên");
        Scanner s = new Scanner(System.in);
        String ma = s.next();
        for (int i = 0; i < slnv; i++) {
            if (maNV[i].equalsIgnoreCase(ma)) {
                System.out.println("mời bạn cập nhật các thông tin sau");
                System.out.printf("Tên nhân viên ");
                ten[i] = s.next();
                System.out.printf("Email nhân viên ");
                email[i] = s.next();
                System.out.printf("lương nhân viên ");
                luong[i] = Double.parseDouble(s.next());
            }
            else{
                System.out.println("mã nhân viên bạn vừa nhập không có trong hệ thống. bạn vui lòng nhập lai");
                capnhat();
            }
        }
        menu();
    }

    static void timluong() {
        System.out.println("tìm nhân viên theo lương");
        Scanner s = new Scanner(System.in);
        System.out.println("nhập lương min");
        double luongmin = Double.parseDouble(s.next());
        System.out.println("nhập lương max");
        double luongmax = Double.parseDouble(s.next());
        for (int i = 0; i < slnv; i++) {
            if (luongmin <= luong[i] && luong[i] <= luongmax) {
                System.out.printf("mã nhân viên: %s\n", maNV[i]);
                System.out.printf("tên nhân viên: %s\n", ten[i]);
                System.out.printf("email nhân viên: %s\n", email[i]);
                System.out.printf("lương nhân viên: %.1\n", luong);
            }
        }
        menu();
    }

    static void sapxep() {
        System.out.println("sắp xếp theo tên");
        for (int i = 0; i < slnv - 1; i++) {
            for (int j = i + 1; j < slnv; j++) {
                if (ten[i].charAt(0) > ten[j].charAt(0)) {
                    String nameTam = ten[i];
                    ten[i] = ten[j];
                    ten[j] = nameTam;

                    String maTam = maNV[i];
                    maNV[i] = maNV[j];
                    maNV[j] = maTam;

                    String emailTam = email[i];
                    email[i] = email[j];
                    email[j] = emailTam;

                    double luongtam = luong[i];
                    luong[i] = luong[j];
                    luong[j] = luongtam;
                }
            }

        }
        xuat();
        menu();
    }

    static void sapxepluong() {
        System.out.println("sắp xếp theo Lương");
        for (int i = 0; i < slnv - 1; i++) {
            for (int j = i + 1; j < slnv; j++) {
                if (luong[i] > luong[j]) {
                    String nameTam = ten[i];
                    ten[i] = ten[j];
                    ten[j] = nameTam;

                    String maTam = maNV[i];
                    maNV[i] = maNV[j];
                    maNV[j] = maTam;

                    String emailTam = email[i];
                    email[i] = email[j];
                    email[j] = emailTam;

                    double luongtam = luong[i];
                    luong[i] = luong[j];
                    luong[j] = luongtam;
                }
            }
        }
        xuat();
        menu();
    }

    static void maxluong() {
        System.out.println("xuất 5 nhân viên có mức lương cao nhất");
        sapxepluong();
        if (slnv > 5) {
            for (int i = 0; i < 5; i++) {
                System.out.printf("mã nhân viên: %s\n", maNV[i]);
                System.out.printf("tên nhân viên: %s\n", ten[i]);
                System.out.printf("email nhân viên: %s\n", email[i]);
                System.out.printf("lương nhân viên: %.1\n", luong);
            }

        } else {
            xuat();
        }
        menu();
    }
}

