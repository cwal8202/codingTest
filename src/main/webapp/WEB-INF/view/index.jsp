<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<div class="container p-5">

	<c:choose>
		<c:when test="${list != null }">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성자</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lis" items="${list}">
						<tr>
							<td>${lis.id}</td>
							<td>${lis.title}</td>
							<td>${lis.content}</td>
							<td>${lis.author}</td>
							<td>
								<div class="d-flex">
									<form action="/board/${lis.id}/delete" method="post">
										<button class="btn btn-danger">삭제</button>
									</form>
									<form action="/board/${lis.id}/updateForm" method="get">
										<button class="btn btn-warning">수정</button>
									</form>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:forEach var="p" items="${page}">
				<p align = "right">${page.pageNo}</p>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p>아직 작성된 글이 없습니다</p>
		</c:otherwise>
	</c:choose>
</div>
<%@ include file="/WEB-INF/view/layout/footer.jsp"%>