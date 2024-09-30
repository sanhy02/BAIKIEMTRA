package model;

/**
 *
 * Họ tên sinh viên: K Pa Y San Hy
 */
public class KhachHang {
    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;            

    //constructor
    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    //setter và getter

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public void setSonhankhau(int sonhankhau) {
        this.sonhankhau = sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }
    
    //phương thức tính toán    

    public double getTieuThu()
    {
      return chisomoi - chisocu;
    }
    
    public double getDinhMuc()
    {
       return sonhankhau * 4;
    }
    
    
    public double tinhTienTra()
    {
        double tieuThu = getTieuThu();
        int dinhMuc = (int) getDinhMuc();
        double tienTra = 0;
        
        if(tieuThu <= dinhMuc){
            tienTra = tieuThu * 6700;
        }else {
            double vuotDinhMuc = tieuThu - dinhMuc;
            
            tienTra = dinhMuc * 6700;
            
            if(vuotDinhMuc <= (sonhankhau *2)){
            tienTra = vuotDinhMuc * 12900;
        }else {
            double vuot6m3 = vuotDinhMuc - (sonhankhau * 2);
            tienTra = (sonhankhau * 2) * 12900;
            tienTra = vuot6m3 * 14400;
            }
        }
        
        double thueGTGT = tienTra * 0.05;
        double thueTDVTN = tienTra * 0.25;
        double thuetrenTDVTN = tienTra * 0.08;
        
       return tienTra + thueGTGT + thueTDVTN + thuetrenTDVTN;
    }         
}
