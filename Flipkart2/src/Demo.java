/*<select class="list_of_cities">
					<option selected style="display:none;color:#eee;">Select Person</option>
					<%@ page import = "java.util.*, beans.OmniBean" %>
                    <%! ArrayList<OmniBean> fList;%>
                    <% fList = (ArrayList)request.getAttribute("fList"); %>
                    <%
					for( OmniBean ob : fList ){
						out.println("<option>" + ob.getName() + "</option>");
						}
					%>				
			</select>
			
			
			
			
			
			
			<form action="SaveOmniServlet" method="post">
			<div class="styled-input agile-styled-input-top">
				<input type="text" placeholder="Name" name="name" required>
			</div>
			<div class="styled-input">
				<input type="text" placeholder="Shoulder Length(inches)" name="shoulder" >
			</div>
			<div class="styled-input">
				<input type="text" placeholder="Bust(inches)" name="bust" required>
			</div>
			<div class="styled-input">
				<input type="text" placeholder="Waist(inches)" name="waist" >
			</div>
			<div class="styled-input">
				<input type="text" placeholder="Hip(inches)" name="hip" required>
			</div>
			<div class="styled-input">
				<input type="text" placeholder="Foot length(inches)" name="shoe" required>
			</div>
			<input type="submit" value="Submit">
		</form>*/