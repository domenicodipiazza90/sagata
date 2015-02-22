<%@ page import="java.io.File"%>

<%
	String ul = "img/photo";
	File dir = new File(request.getRealPath(ul));
	File[] listFile = dir.listFiles();
	for (File f : listFile) {
		String path = ul + "/" + f.getName();
%>
<img src="<%=path %>" class="photo">
<%
	}
%>
<p>
	<em>* Tieni premuta l'immagine per ingrandirla.</em>
</p>
