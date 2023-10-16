package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chucvu")
public class Chucvu {
	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
	 @Column(nullable = false)
	 String ma;
	 @Column(nullable = false)
	 String tencv;
	 @Column
	 int trangthai;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTencv() {
		return tencv;
	}
	public void setTencv(String tencv) {
		this.tencv = tencv;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	@Override
	public String toString() {
		return "Chucvu [id=" + id + ", ma=" + ma + ", tencv=" + tencv + ", trangthai=" + trangthai + "]";
	}
	 

}
