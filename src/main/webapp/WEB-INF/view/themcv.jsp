<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2>Them cong viec</h2>
    <form action="/add" method="post">
    <p>Ma cong viec:<input value="${cv.maCongViec}" name="maCongViec"> </p>
    <p>Tieu de:<input value="${cv.tieuDe}" name="tieuDe" > </p>
    <p>Mo ta:<input value="${cv.moTa}" name="moTa" > </p>
    <p>Thoi gian bat dau:<input value="${cv.duKienBatDau}" name="duKienBatDau"> </p>
        <p>Thoi gian ket thuc:<input value="${cv.duKienKetThuc}" name="duKienKetThuc"> </p>
    
    <p>Muc do uu tien:
    <select name="mucDo">
    <option value="thap">Thap
    <option value="tb">Trung binh
    <option value="cao">Cao
    </select>
     </p>
    <p>Phan loai:<input value="${cv.phanLoai}" name="phanLoai"> </p>
    <button>Them</button>
    </form>
</body>
</html>