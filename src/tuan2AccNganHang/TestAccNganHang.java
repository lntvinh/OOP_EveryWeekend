<<<<<<< HEAD
package tuan2AccNganHang;

import java.util.Scanner;

public class TestAccNganHang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DsAccount dsAccount = new DsAccount(5);  // Khởi tạo với kích thước ban đầu là 5

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Hệ Thống Quản Lý Tài Khoản ---");
            System.out.println("1. Tạo tài khoản mới");
            System.out.println("2. Nạp tiền vào tài khoản");
            System.out.println("3. Tìm kiếm tài khoản theo số tài khoản");
            System.out.println("4. Hiển thị tất cả các tài khoản");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Tạo tài khoản mới
                    try {
                        System.out.print("Nhập số tài khoản: ");
                        long soTaiKhoan = scanner.nextLong();
                        scanner.nextLine();  // Bỏ qua ký tự xuống dòng

                        System.out.print("Nhập tên tài khoản: ");
                        String tenTaiKhoan = scanner.nextLine();

                        Account taiKhoanMoi = new Account(soTaiKhoan, tenTaiKhoan);
                        dsAccount.them(taiKhoanMoi);
                        System.out.println("Tạo tài khoản thành công!");
                    } catch (Exception e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                case 2: // Nạp tiền vào tài khoản
                    try {
                        System.out.print("Nhập số tài khoản: ");
                        long soTaiKhoan = scanner.nextLong();

                        System.out.print("Nhập số tiền muốn nạp: ");
                        double soTien = scanner.nextDouble();

                        int index = dsAccount.timKiem(soTaiKhoan);
                        if (index != -1) {
                            Account taiKhoan = dsAccount.getDs()[index];
                            taiKhoan.deposit(soTien);
                            System.out.println("Nạp tiền thành công!");
                        } else {
                            System.out.println("Tài khoản không tồn tại.");
                        }
                    } catch (Exception e) {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                case 3: // Tìm kiếm tài khoản
                    System.out.print("Nhập số tài khoản cần tìm: ");
                    long soTaiKhoan = scanner.nextLong();

                    int index = dsAccount.timKiem(soTaiKhoan);
                    if (index != -1) {
                        Account taiKhoan = dsAccount.getDs()[index];
                        System.out.println("Thông tin tài khoản: ");
                        System.out.println(taiKhoan.toString());
                    } else {
                        System.out.println("Không tìm thấy tài khoản.");
                    }
                    break;

                case 4: // Hiển thị tất cả các tài khoản
                    System.out.println("Danh sách tất cả các tài khoản: ");
                    for (int i = 0; i < dsAccount.soluongHT; i++) {
                        System.out.println(dsAccount.getDs()[i].toString());
                    }
                    break;

                case 5: // Thoát chương trình
                    exit = true;
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }

        scanner.close();
=======

package tuan2AccNganHang;

public class TestAccNganHang {
    private Account ds[];
    public int soluongHT = 0; // Số lượng tài khoản hiện tại

    // Constructor đúng (bỏ từ khóa void)
    public TestAccNganHang(int soluong) {
        ds = new Account[soluong];
    }

    // Tăng kích thước của mảng nếu đầy
    public void TangKichThuoc() {
        Account temp[] = new Account[ds.length * 2];
        for (int i = 0; i < ds.length; i++) {
            temp[i] = ds[i];
        }
        ds = temp;
    }

    // Thêm 1 tài khoản
    public void them(Account ac) throws Exception {
        if (soluongHT == ds.length)
            TangKichThuoc();

        if (timKiem(ac.getAccountNumber()) == -1) // không tìm thấy
        {
            ds[soluongHT] = ac;
            soluongHT++;
        } else {
            throw new Exception("Trùng mã");
        }
    }

    // Tìm kiếm tài khoản
    public int timKiem(long accountNumber) {
        for (int i = 0; i < soluongHT; i++) {
            if (accountNumber == ds[i].getAccountNumber())
                return i;
        }
        return -1;
    }

    // Getter để truy cập danh sách tài khoản
    public Account[] getDs() {
        return ds;
>>>>>>> 5c7533c (first commit)
    }
}
