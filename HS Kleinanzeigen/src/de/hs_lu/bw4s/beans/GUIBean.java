package de.hs_lu.bw4s.beans;

public class GUIBean {

	public GUIBean() {
		
	}

	public String getHeadlineHtml(){
		String html = "";
		
		html += "<table>\n";
		html +=	"	<tr>\n";
		html +=	"		<td>\n";
		
		html +=	"		</td>\n";
		html +=	"		<td>\n";
	
		html +=	"				<img src='../img/01.png' alt='HWG Lu'\n";
		html +=	"					title='Hochschule Ludwigshafen'\n";
		html +=	"					width='150'\n";
		html +=	"				/>\n";
		html +=	"			</a>\n";
		html +=	"		</td>\n";
		html +=	"	</tr>\n";
		html +=	"</table>\n";
		
		return html;
	}
}
