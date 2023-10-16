package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "congviec")
public class ViecCanLam implements Serializable{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     @Column(nullable = false)
     String maCongViec;
     @Column(nullable = false)
     String tieuDe;
     @Column
     String moTa;
     @Column
     @Temporal(TemporalType.DATE)
     Date duKienBatDau;
     @Column
     @Temporal(TemporalType.DATE)
     Date duKienKetThuc;
     @Column
     String mucDo;
     @Column
     String phanLoai;
     @Column
     int tinhTrang;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMaCongViec() {
		return maCongViec;
	}
	public void setMaCongViec(String maCongViec) {
		this.maCongViec = maCongViec;
	}
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public Date getDuKienBatDau() {
		return duKienBatDau;
	}
	public void setDuKienBatDau(Date duKienBatDau) {
		this.duKienBatDau = duKienBatDau;
	}
	public Date getDuKienKetThuc() {
		return duKienKetThuc;
	}
	public void setDuKienKetThuc(Date duKienKetThuc) {
		this.duKienKetThuc = duKienKetThuc;
	}
	public String getMucDo() {
		return mucDo;
	}
	public void setMucDo(String mucDo) {
		this.mucDo = mucDo;
	}
	public String getPhanLoai() {
		return phanLoai;
	}
	public void setPhanLoai(String phanLoai) {
		this.phanLoai = phanLoai;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
     

     
     
}
