<<<<<<< HEAD
package tuan2AccNganHang;

public class DsAccount {
    private Account ds[];
    public int soluongHT = 0; // Số lượng tài khoản hiện tại

    // Constructor đúng (bỏ từ khóa void)
    public DsAccount(int soluong) {
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
=======

package tuan2AccNganHang;

public class DsAccount {
    private long accountNumber;
    private String accountName;
    private double blance;
    private final long BLANCEDEFAULT = 50000;

    // Constructor cho Account
    public DsAccount(long accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.blance = BLANCEDEFAULT; // Khởi tạo số dư mặc định
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBlance() {
        return blance;
    }

    public boolean deposit(double amountTienNap) throws Exception {
        if (amountTienNap > 0) {
            this.blance += amountTienNap;
            return true;
        } else {
            throw new Exception("Số tiền không được bé hơn không");
        }
    }

    @Override
    public String toString() {
        return String.format("%15d %-50s %15.2f", getAccountNumber(), getAccountName(), getBlance());
>>>>>>> 5c7533c (first commit)
    }
}
