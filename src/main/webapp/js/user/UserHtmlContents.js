function UserHtmlContents(){
}

UserHtmlContents.user_view_content=function(sUser) {
	return `<h5 class="mb-3">Account Details</h5>
                        <form action="#" method="post" id="user_modify_form">
                            <div class="row">
                                <div class="col-12 col-lg-6">
                                    <div class="form-group">
                                        <label for="user_id">ID *</label>
                                        <input type="text" class="form-control" name="user_id" value="${sUser.user_id}">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="currentPass">Current Password (Leave blank to leave unchanged)</label>
                                        <input type="password" class="form-control" name="currentPass" value="${sUser.user_pw}">
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
                                        <input type="text" class="form-control" name="user_name" value="${sUser.user_name}">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user_email">Email *</label>
                                        <input type="email" class="form-control" name="user_email" value='${sUser.user_email}'>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label for="user_phone">Phone *</label>
                                        <input type="text" class="form-control" name="user_phone" value="${sUser.user_phone}">
                                    </div>
                                </div>
                                <div class="col-12">
                                    <!-- <button type="submit" class="btn btn-primary">Save Changes</button> -->
                                    <input type="button" id="btn_user_modify_action" class="btn btn-primary" value="Save Change">
                                </div>
                            </div>
                        </form>`;
}

UserHtmlContents.user_view_addresses=function(addressList){
	return `<p>지역은 최소 1개 이상 최대 2개까지 설정할 수 있어요.</p>
                        <div class="row">
                            <div class="col-12 col-lg-6 mb-5 mb-lg-0">
                                <i class="icofont-spinner icofont-spin"></i>
                                <!--<input type='radio' name='rd_address_no' class='rd_adress1' value="${addressList[0].address_no}" style='margin-bottom:16px'>-->
                                <!--<h6 class="mb-3" style='display:inline'>Address (1)</h6>-->
                                
                                <address>
                                <input type="hidden" name="address_no" value="${addressList[0].address_no}">
                                <input type="hidden" name="address_lat" value="${addressList[0].address_lat}">
                                <input type="hidden" name="address_lng" value="${addressList[0].address_lng}">
                                
                                <input type="button" id="btn_address_first" class="btn btn-outline-primary mb-1" name="address_name" value="${addressList[0].address_name}" >
                                <a href="#" id="btn_remove_first" class="btn btn-secondary mb-1 remove"><i class="icofont-ui-delete"></i></a><br/>
								
								<input id='range1' name="address_range" type="range" value="${addressList[0].address_range}" min="0" max="10" disabled>
                                <label for='range1' class = "range_val bigshop-label bigshop-label-info bigshop-label-pill" value="">${addressList[0].address_range}</label><br/>
                                </address>
                                
                                <!--<a href="#" id="btn_address_first" class="btn btn-primary btn-sm update">주소 수정</a>-->
                            </div>
                            <div class="col-12 col-lg-6 mb-5 mb-lg-0">
                                <address>
                                <input type="hidden" name="address_no" value="${addressList[1].address_no}">
                                <input type="hidden" name="address_lat" value="${addressList[1].address_lat}">
                                <input type="hidden" name="address_lng" value="${addressList[1].address_lng}">
                                
                                <input type="button" id="btn_address_second" class="btn btn-outline-primary mb-1" name="address_name"  value="${addressList[1].address_name}">
                                <a href="#" id="btn_remove_second" class="btn btn-secondary mb-1 remove"><i class="icofont-ui-delete"></i></a><br/>
                                
								<input id='range2' name="address_range" type="range" value="${addressList[1].address_range}" min="0" max="10" disabled>
                                <label for='range2' class = "range_val bigshop-label bigshop-label-info bigshop-label-pill" value="">${addressList[1].address_range}</label><br/>
                                </address>
                                
                                <!--<a href="#" id="btn_address_second" class="btn btn-primary btn-sm update">주소 수정</a>-->
                            
                            </div>
                            <button type="button" class="btn btn-primary mb-1 btn-sm">저장</button>
                        </div>`;
}
UserHtmlContents.user_view_addresses_one=function(addressList){
	return `<p>지역은 최소 1개 이상 최대 2개까지 설정할 수 있어요.</p>
                        <div class="row">
                            <div class="col-12 col-lg-6 mb-5 mb-lg-0">
                            	<i class="icofont-spinner icofont-spin"></i>
                                <address>
                                <input type="hidden" name="address_no" value="${addressList[0].address_no}">
                                <input type="hidden" name="address_lat" value="${addressList[0].address_lat}">
                                <input type="hidden" name="address_lng" value="${addressList[0].address_lng}">
                                
                                <input type="button" id="btn_address_first" class="btn btn-outline-primary mb-1 selected_addressNo" name="address_name" value="${addressList[0].address_name}" style="background:#0f99f3; color:#fff">
                                <a href="#" id="btn_remove_first" class="btn btn-secondary mb-1 remove"><i class="icofont-ui-delete"></i></a><br/>
                                
								<input id='range1' name="address_range" type="range" value="${addressList[0].address_range}" min="0" max="10">
                                <label for='range1' class = "range_val bigshop-label bigshop-label-info bigshop-label-pill" value="">${addressList[0].address_range}</label><br/>
                                </address>
                                <!--<a href="#" id="btn_address_first" class="btn btn-primary btn-sm update">주소 수정</a>-->
                            </div>
                            <div class="col-12 col-lg-6">
                                <!--<input type='radio' name='rd_address_no' class='rd_adress2' value="" disabled style='margin-bottom:16px'>-->
                                <!--<h6 class="mb-3">Address (2)</h6>-->
                                <address>
                                <input type="hidden" name="address_lat" value="">
                                <input type="hidden" name="address_lng" value="">
                                <input type="hidden" name="address_name" value="">

                                <input type="button" id="btn_address_new1" class="btn btn-outline-secondary mb-1 insert" name="" value="주소추가 +" style='border-color:#6c757d'>
                                </address>
                                <!--<a href="#" id="btn_address_new1" class="btn btn-primary btn-sm insert">주소 입력</a>-->
                            </div>
                        </div>`;
}
UserHtmlContents.user_view_addresses_zero=function(addressList){
	return `<p>지역은 최소 1개 이상 최대 2개까지 설정할 수 있어요.</p>
                        <div class="row">
                            <div class="col-12 col-lg-6 mb-5 mb-lg-0">
                                <!--<h6 class="mb-3">Address (1)</h6>-->
                                <address>
                               	<input type="hidden" name="address_lat" value="">
                                <input type="hidden" name="address_lng" value="">
                                <input type="hidden" name="address_name" value="">

                                <input type="button" id="btn_address_new1" class="btn btn-outline-secondary mb-1 insert" name="" value="주소추가 +" style='border-color:#6c757d'>
                                </address>
                                <!--<a href="#" id="btn_address_new1" class="btn btn-primary btn-sm insert">주소 입력</a>-->
                            </div>
                            <!--
                        	<div class="col-12 col-lg-6">
                                <h6 class="mb-3">Address (2)</h6>
                                <address>
                                <input type="hidden" name="address_lat" value="">
                                <input type="hidden" name="address_lng" value="">
                                <input type="hidden" name="address_name" value="">
                                
                                <input type="button" id="btn_address_new2" class="btn btn-outline-secondary mb-1 insert" name="" value="주소추가 +" style='border-color:#6c757d'>
                                </address>
                                <a href="#" id="btn_address_new2" class="btn btn-primary btn-sm insert">주소 입력</a>
                            </div>
                            -->
                        </div>`;
}

UserHtmlContents.user_profile_edit=function(){
	return `<h5 class="mb-3">프로필 수정</h5>
                    	<profile>
      	               <div class="mb-100" style="margin-bottom: 0px">
	                        <div class="col-xl-3">
	                            <img id="user_profile" class="img-circle" src='img/user_profile/newCarrot.jpg' alt="" style="width:200px; height:200px; margin:0 auto 0 auto 200px">
	                        </div>
                        	<form id="image_form"  name="image_form" enctype="multipart/form-data">
	                        	<input type="file" name="files" id="chooseF" hidden><br>
		                        <input type="submit" id="btn_submit" class="btn btn-outline-primary mb-1 edit_profile" value="사진 선택">
							</form> 
                        </div>
						<div class="shortcodes_content mb-100" style="margin-bottom: 0px">
	                        <button type="button" class="btn btn-outline-primary mb-1 remove_profile">사진 삭제</button>
						</div>
						</profile>`;
}


/*
UserHtmlContents.user_thumbnail=function(){
		return `<div class="user-thumbnail">
			    			<i class="fa fa-user-circle"></i>
                            </div>
                            <ul class="user-meta-dropdown">
                                <!-- <li class="user-title"><span>Hello,</span> Lim Sarah</li>-->
                                <li><a href="user_login">회원가입</a></li>
                                <li><a href="user_login"><i class="icofont-login"></i> 로그인</a></li>
                            </ul>`;
}	
UserHtmlContents.user_thumbnail_login=function(sUser){
		return `<div class="user-thumbnail">
                            <img src='img/user_profile/${sUser.user_profile}' alt="">
                            </div>
                            <ul class="user-meta-dropdown">
                                <li class="user-title"><span>안녕하세요,</span> ${sUser.user_name} 님</li>
                                <li><a href="user_my_account">마이페이지</a></li>
                                <li><a href="chat_room">Chatting</a></li>
                                <li><a href="user_logout_action"><i class="icofont-logout"></i> 로그아웃</a></li>
                            </ul>`;
}	*/