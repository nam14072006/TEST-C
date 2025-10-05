import java.util.*;

public class SinhVien {
    private String mssv;
    private String hoten;
    private String lop;
    private float diem1, diem2, diem3;

    // Constructor không tham số
    public SinhVien() {
        mssv = "";
        hoten = "";
        lop = "";
        diem1 = diem2 = diem3 = 0;
    }

    // Constructor có tham số
    public SinhVien(String mssv, String hoten, String lop, float d1, float d2, float d3) {
        this.mssv = mssv;
        this.hoten = hoten;
        this.lop = lop;
        diem1 = d1;
        diem2 = d2;
        diem3 = d3;
    }

    // Getter Setter
    public String getMssv() { return mssv; }
    public void setMssv(String mssv) { this.mssv = mssv; }

    public String getHoten() { return hoten; }
    public void setHoten(String hoten) { this.hoten = hoten; }

    public String getLop() { return lop; }
    public void setLop(String lop) { this.lop = lop; }

    public float getDiem1() { return diem1; }
    public void setDiem1(float d1) { this.diem1 = d1; }

    public float getDiem2() { return diem2; }
    public void setDiem2(float d2) { this.diem2 = d2; }

    public float getDiem3() { return diem3; }
    public void setDiem3(float d3) { this.diem3 = d3; }

    // Hàm nhập
    public void nhap(Scanner sc) {
        System.out.print("Nhập mã số sinh viên: ");
        mssv = sc.nextLine();

        System.out.print("Nhập họ tên sinh viên: ");
        hoten = sc.nextLine();

        System.out.print("Nhập lớp của sinh viên: ");
        lop = sc.nextLine();

        diem1 = nhapDiem(sc, "Nhập điểm 1 của sinh viên (0–10): ");
        diem2 = nhapDiem(sc, "Nhập điểm 2 của sinh viên (0–10): ");
        diem3 = nhapDiem(sc, "Nhập điểm 3 của sinh viên (0–10): ");
    }

    // Hàm nhập điểm (có kiểm tra hợp lệ)
    private float nhapDiem(Scanner sc, String message) {
        float diem;
        do {
            System.out.print(message);
            while (!sc.hasNextFloat()) {
                System.out.println("Vui lòng nhập số!");
                sc.next(); // bỏ giá trị sai
                System.out.print(message);
            }
            diem = sc.nextFloat();
            sc.nextLine(); // bỏ dòng thừa
            if (diem < 0 || diem > 10) {
                System.out.println("Điểm không hợp lệ! Vui lòng nhập trong khoảng 0–10.");
            }
        } while (diem < 0 || diem > 10);
        return diem;
    }

    // Hàm xuất
    public void xuat() {
        System.out.println("Mã số sinh viên: " + mssv);
        System.out.println("Họ tên sinh viên: " + hoten);
        System.out.println("Lớp của sinh viên: " + lop);
        System.out.println("Điểm trung bình: " + tinhdtb());
        System.out.println("Xếp loại: " + xeploai());
    }

    // Tính điểm trung bình
    public float tinhdtb() {
        return (diem1 + diem2 + diem3) / 3;
    }

    // Xếp loại
    public String xeploai() {
        float dtb = tinhdtb();
        if (dtb >= 8) return "Giỏi";
        else if (dtb >= 6.5) return "Khá";
        else if (dtb >= 5) return "Trung bình";
        else return "Yếu";
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SinhVien sv1 = new SinhVien();
        System.out.println("=== Nhập thông tin SV1 ===");
        sv1.nhap(sc);

        System.out.println("\n=== Thông tin SV1 ===");
        sv1.xuat();

        SinhVien sv2 = new SinhVien("SV002", "Nguyen Van B", "CNTT1", 7, 8, 6);
        System.out.println("\n=== Thông tin SV2 (dùng constructor có tham số) ===");
        sv2.xuat();
    }
}
