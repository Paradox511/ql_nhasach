/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NoiQuyPhatDAO;
import DTO.NoiQuyPhatDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class NoiQuyPhatBUS {
    public ArrayList<NoiQuyPhatDTO> list_PM;
    /*
      Xử lý các lệnh trong SQL
     */
    private NoiQuyPhatDAO pmDAO;
    
    public NoiQuyPhatBUS() throws Exception {
//        list_PM = new ArrayList<>();
//        pmDAO = new NoiQuyPhatDAO();
//        list_PM = pmDAO.docDB();
    }
    
    
    public void add(NoiQuyPhatDTO pn) {
        list_PM.add(pn);
    }
    
    public void deleteAll() {
        list_PM.removeAll(list_PM);
    }
    
    public void docDB() throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new NoiQuyPhatDAO();
        list_PM = pmDAO.docDB();
    }
    public void docDB(String Ma) throws Exception {
        list_PM = new ArrayList<>();
        pmDAO = new NoiQuyPhatDAO();
        String condition=" Ma='"+Ma+"'";
        list_PM = pmDAO.docDB(condition);
    }
    public ArrayList<NoiQuyPhatDTO> getList_PM() {
        return list_PM;
    }

    public void setList_PM(ArrayList<NoiQuyPhatDTO> list_PM) {
        this.list_PM = list_PM;
    }

    
    public int getNumb() {
        return list_PM.size();
    }
    
    public NoiQuyPhatDTO getInfor(int i){
        int iCount =0;
        for (NoiQuyPhatDTO hd : list_PM) {
            if (iCount == i)
                return hd;
            iCount++;
        }
        return null;
    }
    
    public int demSoChuSo(int nInput){
	if (nInput < 10) {
		return 1;
	}
	return 1 + demSoChuSo(nInput / 10);
    }
    
    public int getDefaultMaPN() {
        if (list_PM.isEmpty()) return 0; 
        else {
            ArrayList<Integer> mangMa = new ArrayList<Integer>();
            int iNumb = 0;
            for (NoiQuyPhatDTO a : list_PM) 
                    mangMa.add(a.getMa());
            while(1==1){
                if(!mangMa.contains(iNumb))
                    return iNumb;
                iNumb++;
            }
            
        }
    }    
    
    /**
     * thêm 1 tài khoản vào danh sách và database
     * @return true nếu thành công
     */
    public Boolean them(NoiQuyPhatDTO tk) throws Exception{
        if ( pmDAO.them(tk) ) {
            list_PM.add(tk);
            return true;
        }
        return false;
    }
    
    /**
     //xóa 1 tài khoản khỏi danh sách và database
     * @return true nếu thành công
     */
    public Boolean xoa(NoiQuyPhatDTO tk) throws Exception {
        if ( pmDAO.xoa(tk) ) {
            
            // duyệt từng phẩn tử
            for ( NoiQuyPhatDTO phieuMuon : list_PM ) {
                if (phieuMuon.getMa()==tk.getMa()){
                    list_PM.remove(phieuMuon);
                    return true;
                }
            }
        }
        
        return false;
    }
}
