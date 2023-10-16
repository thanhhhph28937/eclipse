<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
         <h1 align="center">Danh sach cong viec</h1>

<div class="container mt-3 mb-3">
    <form method="post" action="add" >
        <div class="mt-3">
            <label for="maCongViec">Ma cong viec:</label>
            <input class="form-control" id="maCongViec" name="maCongViec" value="${vcl.maCongViec}" required>
                    
       
        </div>
        <div class="mt-2" style="color: red">${mes}</div>
        <div class="mt-3">
            <label for="tieuDe">Tieu de:</label>
            <input class="form-control" id="tieuDe" name="tieuDe" value="${vcl.tieuDe}" required>
        </div>
        <div class="mt-3">
            <label for="moTa">Mo ta:</label>
            <textarea class="form-control" id="moTa" name="moTa" required
                >${vcl.moTa}</textarea>
        </div>
        <div class="mt-3">
            <label for="duKienBatDau">Thoi gian bat dau:</label>
            <input class="form-control" type="date" name="duKienBatDau" id="duKienBatDau" required
                value="${vcl.duKienBatDau}">
        </div>
         <div class="mt-2" style="color: red">${mess}</div>
        <div class="mt-3">
            <label for="duKienKetThuc">Thoi gian ket thuc:</label>
            <input class="form-control" type="date" id="duKienKetThuc" name="duKienKetThuc" required value="${vcl.duKienKetThuc}">
        </div>
           <div class="mt-3">
            <label for="mucDo">Muc do uu tien:</label>
            <select class="form-control"  id="mucDo" name="mucDo" >
            <option value="thap">Thap
             <option value="trung binh">Trung binh
              <option value="cao">Cao
            </select>
        </div>
      
        <button class="mt-3 btn btn-primary" onclick="return check()">Them </button>
    </form>
</div>

         

 
 <div class="container mt-3">
    <table class="table">
        <thead>
        <tr>
            <th style="width: 10%">Ma</th>
            <th style="width:10%">Tieu de</th>
            <th style="width: 20%">Mo ta</th>
            <th style="width: 10%">Thoi gian bat dau</th>
            <th style="width: 10%">Thoi gian ket thuc</th>
            <th style="width: 10%">Muc do uu tien</th>
            <th style="width: 10%">Tinh trang</th>
            <th style="width: 20%">Action</th>
        </tr>
        </thead>
        <c:forEach items="${list}" var="i">
            <tr>
                <td>${i.maCongViec}</td>
                <td>${i.tieuDe}</td>
                <td>${i.moTa}</td>
                 <td>${i.duKienBatDau}</td>
                <td>${i.duKienKetThuc}</td>
                 <td> ${i.mucDo}</td>
                <td>
                    <c:if test="${i.tinhTrang==1}">Da xong</c:if>
                    <c:if test="${i.tinhTrang==0}">Chua xong</c:if>
                </td>
               
                <td>
         <a href="/thanh_duanxuong/congviec/complete?id=${i.id}">Hoan thanh</a>
         <a href="/thanh_duanxuong/congviec/delete?id=${i.id}" onclick="return confirm('Ban muon xoa khong')">Xoa</a>
         <a href="/thanh_duanxuong/congviec/detail?id=${i.id}">Chi tiet</a>
         </td>
            </tr>
        </c:forEach>
        <c:if test="${list.size() == 0}">
            <tr>
                <td colspan="6">No item found</td>
            </tr>
        </c:if>
    </table>
   
</div>

 
       
         