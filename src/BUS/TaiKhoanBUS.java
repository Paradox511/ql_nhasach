package BUS;

import DAO.TaiKhoanDAO;
import DTO.TaiKhoan;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//import MyCustom.MyDialog;

public class TaiKhoanBUS {

    public static  ArrayList<TaiKhoan> dstk = new ArrayList();

    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

    public String getTenDangNhapTheoMa(String ma) {
        int maNV = Integer.parseInt(ma);
        return taiKhoanDAO.getTenDangNhapTheoMa(maNV);
    }

    public String getQuyenTheoMa(String ma) {
        int maNV = Integer.parseInt(ma);
        return taiKhoanDAO.getQuyenTheoMa(maNV);
    }
  /*  public static void docDSTK(){
        if(dstk==null)dstk=new ArrayList<TaiKhoan>();
        dstk=taiKhoanDAO.
    }
    public ArrayList<TaiKhoan> getdstk(){
         if(dstk==null){
          docDSNV();
      }
      return EmployeeBUS.dsnv;
    }
*/
    public void datLaiMatKhau(String ma, String tenDangNhap) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.datLaiMatKhau(maNV, tenDangNhap);
        if (flag) {
             JOptionPane.showMessageDialog(null,"Đặt lại thành công! Mật khẩu mới là: " + tenDangNhap + "");
        } else {
           JOptionPane.showMessageDialog(null,"Đặt lại thất bại!");
        }
    }

    public void datLaiQuyen(String ma, String quyen) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.datLaiQuyen(maNV, quyen);
        if (flag) {
            JOptionPane.showMessageDialog(null,"Đặt lại thành công!");
        } else {
           JOptionPane.showMessageDialog(null,"Đặt lại thất bại!");
        }
    }

    public boolean kiemTraTrungTenDangNhap(String tenDangNhap) {
        return taiKhoanDAO.kiemTraTrungTenDangNhap(tenDangNhap);
    }

    public boolean themTaiKhoan(String ma, String tenDangNhap, String quyen) {
        int maNV = Integer.parseInt(ma);
        if (tenDangNhap.trim().equals("")) {
           JOptionPane.showMessageDialog(null,"Không được để trống Tên đăng nhập!");
            return false;
        }
    /*    if (kiemTraTrungTenDangNhap(tenDangNhap)) {
            MyDialog dlg = new MyDialog("Tên đăng nhập bị trùng! Có thể tài khoản bị khoá, thực hiện mở khoá?", MyDialog.WARNING_DIALOG);
            if (dlg.getAction() == MyDialog.OK_OPTION) {
                moKhoaTaiKhoan(ma);
                return true;
            }
            return false;
        }*/
        boolean flag = taiKhoanDAO.themTaiKhoan(maNV, tenDangNhap, quyen);
        if (flag) {
            JOptionPane.showMessageDialog(null,"Cấp tài khoản thành công! Mật khẩu là " + tenDangNhap);
        } else {
            JOptionPane.showMessageDialog(null,"Cấp tài khoản thất bại! Tài khoản đã tồn tại");
        }
        return flag;
    }

    public void khoaTaiKhoan(String ma) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.khoaTaiKhoan(maNV);
        if (flag) {
            JOptionPane.showMessageDialog(null,"Khoá tài khoản thành công!");
        } else {
            JOptionPane.showMessageDialog(null,"Khoá tài khoản thất bại!");
        }
    }

    public void moKhoaTaiKhoan(String ma) {
        int maNV = Integer.parseInt(ma);
        boolean flag = taiKhoanDAO.moKhoaTaiKhoan(maNV);
        if (flag) {
            JOptionPane.showMessageDialog(null,"Mở khoá tài khoản thành công!");
        } else {
           JOptionPane.showMessageDialog(null,"Mở khoá tài khoản thất bại!");
        }
    }

    public boolean doiMatKhau(String matKhauCu, String matKhauMoi, String nhapLaiMatKhau) {
        if(!matKhauMoi.equals(nhapLaiMatKhau)) {
           JOptionPane.showMessageDialog(null,"Mật khẩu mới không khớp!");
            return false;
        }
        boolean flag = taiKhoanDAO.doiMatKhau(matKhauCu, matKhauMoi);
        if (flag) {
           JOptionPane.showMessageDialog(null,"Đổi thành công!");
        } else {
            JOptionPane.showMessageDialog(null,"Mật khẩu cũ nhập sai!");
        }
        return flag;
    }
    
    public int getTrangThai(String maNV) {
        int ma = Integer.parseInt(maNV);
        return taiKhoanDAO.getTrangThai(ma);
    }

}
