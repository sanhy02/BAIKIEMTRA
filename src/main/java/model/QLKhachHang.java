package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import gui.FileHelper;


/**
 *
 * Họ tên sinh viên: K Pa Y San Hy
 */
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

   
    public void DocKhachHang(String filename) {
         ArrayList<String> input = FileHelper.readFileText(filename);
         dsKhachHang.clear();
         for (String item : input){
         String[] thongTin = item.split(";");
         String maso = thongTin[0];
         String hoten = thongTin[1];
         int sonhankhau = Integer.parseInt(thongTin[2]);
         double chisocu = Double.parseDouble(thongTin[3]);
         double chisomoi = Double.parseDouble(thongTin[4]);
         
         KhachHang kh = new KhachHang(maso, hoten, sonhankhau, chisocu, chisomoi);
         
         dsKhachHang.add(kh);
         }
    }

    public boolean GhiHoaDon(String filename) {
        ArrayList<String> input = new ArrayList<>();
        for (KhachHang kh : dsKhachHang){
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getSonhankhau() + ";" + kh.getChisocu() + ";" + kh.getChisomoi();
            input.add(info);
        }
        return true;
    }

   
    public void sapXepTheoMucTieuThu() {
         Collections.sort(dsKhachHang, new Comparator<KhachHang>() {
            @Override
            public int compare(KhachHang kh1, KhachHang kh2) {
                return Double.compare(kh2.getTieuThu(), kh1.getTieuThu());
            }
        });           
    }
    
    public double getTieuThuCaoNhat()
    {
        if (dsKhachHang.isEmpty()){
            return  0;
                    }
        double max = dsKhachHang.get(0).getTieuThu();
        for (KhachHang kh : dsKhachHang) {
            if (kh.getTieuThu()> max) {
                max = kh.getTieuThu();
            }
        } 
        
        return max;     
    }
    
    public double getTieuThuTrungBinh()
    {
        double tongTieuThu = 0;
        for (KhachHang kh : dsKhachHang) {
            tongTieuThu += kh.getTieuThu();
        }
        return tongTieuThu / dsKhachHang.size();
            
    }
}
