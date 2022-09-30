function UserHtmlContents(){
}
UserHtmlContents.user_left_menu_logout_content=function(){
	return  `<p>
				<strong>메뉴</strong>
			</p>
			<ul>
				<li><a href="user_main" id="a_user_main">회원홈</a></li>
				<li><a href="user_login_form" id="a_user_login_form">로그인</a></li>
				<li><a href="user_write_form" id="a_user_write_form">회원가입</a></li>
			</ul>`;
}			
UserHtmlContents.user_left_menu_login_content=function(user){
	return  `<p>
				<strong>메뉴</strong>
			</p>
			<ul>
				<li><a href=''>${user.name}</a></li>
				<li><a href='user_view' id="a_user_view">내정보</a></li>
				<li><a href="user_logout_action" id="a_user_logout_action">로그아웃</a></li>
			</ul>`;
}			
	
UserHtmlContents.user_main_content=function(){
	return `<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
				codebase="http://active.macromedia.com/flash4/cabs/swflash.cab#version=4,0,0,0"
				width="540px" height="350px">
				<param name="movie" value="image/FI_main.swf">
				<param name="play" value="true">
				<param name="loop" value="true">
				<param name="quality" value="high">
				<embed src="image/enter.png" scale="exactfit" play="true" loop="true"
					quality="high" style="margin: 10px;"
					pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"
					width="540px" height="350px"></embed>
			</object>`;
}

UserHtmlContents.user_login_form_content=function(){
	return `<table border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td><br>
							<table style="padding-left: 10px" border="0" cellpadding="0"
								cellspacing="0">
								<tbody>
									<tr>
										<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 -
												로그인</b></td>
									</tr>
								</tbody>
							</table> <!-- login Form  -->
							<form name="f" method="post" id="user_login_form">
								<table border="0" cellpadding="0" cellspacing="1" bgcolor="BBBBBB">
									<tbody>
										<tr>
											<td width="100" align="center" bgcolor="E6ECDE" height="22">사용자
												아이디</td>
											<td width="490" align="left" bgcolor="ffffff"
												style="padding-left: 10px"><input type="text"
												style="width: 150" name="userId" value="">&nbsp;&nbsp;<font
												color="red" id="msg1"></font></td>
										</tr>
										<tr>
											<td width="100" align="center" bgcolor="E6ECDE" height="22">비밀번호</td>
											<td width="490" align="left" bgcolor="ffffff"
												style="padding-left: 10px"><input type="password"
												style="width: 150" name="password" value="" >&nbsp;&nbsp;<font
												color="red" id="msg2"></font></td>
										</tr>
									</tbody>
								</table>
							</form> <br>
							<table border="0" cellpadding="0" cellspacing="1">
								<tbody>
									<tr>
										<td align="center">
										<input id="btn_user_login_action" type="button" value="로그인"> &nbsp; 
										<input id="btn_user_write_form" type="button" value="회원가입" ></td>
									</tr>
								</tbody>
							</table></td>
					</tr>
				</tbody>
			</table>`;
}

UserHtmlContents.user_view_content=function(loginUser) {
	return `<h5 class="mb-3">Account Details</h5>

                        <form action="#" method="post" id="user_modify_form">
                            <div class="row">
                                <div class="col-12 col-lg-6">
                                    <div class="form-group">
                                        <label for="user_id">ID *</label>
                                        <input type="text" class="form-control" name="user_id" value="${loginUser.user_id}">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="currentPass">Current Password (Leave blank to leave unchanged)</label>
                                        <input type="password" class="form-control" name="currentPass" value="${loginUser.user_pw}">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="newPass">New Password (Leave blank to leave unchanged)</label>
                                        <input type="password" class="form-control" name="user_pw">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="confirmPass">Confirm New Password</label>
                                        <input type="password" class="form-control" name="confirmPass">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user_name">Name *</label>
                                        <input type="text" class="form-control" name="user_name" value="${loginUser.user_name}">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user_email">Email *</label>
                                        <input type="email" class="form-control" name="user_email" value='${loginUser.user_email}'>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user_phone">Phone *</label>
                                        <input type="text" class="form-control" name="user_phone" value="${loginUser.user_phone}">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <!-- <button type="submit" class="btn btn-primary">Save Changes</button> -->
                                    <input type="button" id="btn_user_modify_action" class="btn btn-primary" value="Save Change">
                                </div>
                            </div>
                        </form>`;
}

UserHtmlContents.user_write_form_content=function(){
	return `<table width="0" border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td>
							<!--contents--> <br>
							<table style="padding-left: 10px" border="0" cellpadding="0"
								cellspacing="0">
								<tbody>
									<tr>
										<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 -
												회원 가입</b></td>
									</tr>
								</tbody>
							</table> <!-- write Form  -->
							<form id="user_write_form" name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tbody>
										<tr>
											<td width="100" align="center" bgcolor="E6ECDE" height="22">사용자
												아이디</td>
											<td width="490" bgcolor="ffffff" style="padding-left: 10px"
												align="left"><input type="text" style="width: 150px"
												name="userId"  value="">&nbsp;&nbsp;<font color="red" id="msg1"></font>
											</td>
										</tr>
										<tr>
											<td width="100" align="center" bgcolor="E6ECDE" height="22">비밀번호</td>
											<td width="490" bgcolor="ffffff" style="padding-left: 10px"
												align="left"><input type="password" style="width: 150px"
												name="password" id="password" value=""></td>
										</tr>
										<tr>
											<td width="100" align="center" bgcolor="E6ECDE" height="22">비밀번호
												확인</td>
											<td width="490" bgcolor="ffffff" style="padding-left: 10px"
												align="left"><input type="password" style="width: 150px"
												name="password2" value=""></td>
										</tr>
										<tr>
											<td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
											<td width="490" bgcolor="ffffff" style="padding-left: 10px"
												align="left"><input type="text" style="width: 150px"
												name="name" value=""></td>
										</tr>
										<tr>
											<td width="100" align="center" bgcolor="E6ECDE" height="22">이메일
												주소</td>
											<td width="490" bgcolor="ffffff" style="padding-left: 10px"
												align="left"><input type="text" style="width: 150px"
												name="email" value=""></td>
										</tr>
									</tbody>
								</table>
							</form> <br>
			
							<table border="0" cellpadding="0" cellspacing="1">
								<tbody>
									<tr>
										<td align="center"><input type="button" value="회원 가입"
											id="btn_user_write_action"> &nbsp;</td>
									</tr>
								</tbody>
							</table>
			
						</td>
					</tr>
				</tbody>
			</table>`;
}
	