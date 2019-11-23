<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
<section class="content">
	닉네임: <input type="text" value="${user.nickname}" id="nick" size="20" disabled/><br /> 보내는 메시지: <input
		type="text" id="message" size="60" /> <input type="button"
		onclick="start()" value="전송" /><br /> 받은 메시지:
	<textarea id="disp" cols="80" rows="20"></textarea>

</section>
<%@ include file="include/footer.jsp"%>

<script>

var webSocket = new WebSocket('ws://cyberadam.cafe24.com/websocket');
webSocket.onerror = function(event) {
	onError(event)
};
webSocket.onopen = function(event) {
	onOpen(event)
};
webSocket.onmessage = function(event) {
	onMessage(event)
};

function onMessage(event) {
	$('#disp').val($('#disp').val() + '\n' + event.data);
}
function onOpen(event) {
	document.getElementById('disp').value = '채팅 연결';
}

function onError(event) {
	alert(event.data);
}

function start() {
	webSocket.send($('#nick').val() + ":" + $('#message').val());
	$('#message').val('');
	return false;
}

</script>

