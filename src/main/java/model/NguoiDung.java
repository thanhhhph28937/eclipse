package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "nguoidung" )
public class NguoiDung {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     @Column(nullable = false)
     String ten;
     @Column
     String email;
     @Column
     String sdt;
     @Column
     int trangthai;
     @Column
     String pass;
     @ManyToOne @JoinColumn(name = "idcv")
     Chucvu cv;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public Chucvu getCv() {
		return cv;
	}
	public void setCv(Chucvu cv) {
		this.cv = cv;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public NguoiDung(String ten, String pass) {
		
		this.ten = ten;
		this.pass = pass;
	}
	public NguoiDung() {
		
	}
	@Override
	public String toString() {
		return "NguoiDung [id=" + id + ", ten=" + ten + ", email=" + email + ", sdt=" + sdt + ", trangthai=" + trangthai
				+ ", pass=" + pass + ", cv=" + cv + "]";
	}
	
     
}
