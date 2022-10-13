function ReviewHtmlContents(){
}

ReviewHtmlContents.review_write_form=function(orders_no) {
	return `<div class="submit_a_review_area col-12" style="border: 1px solid #d6e6fb; padding:30px;">
                        <h4>Submit A Review</h4>
                        <!-- [Start]review_write_form -->
                        <!-- <form id="review_write_form" name="review_write_form" action="#" method="post"> -->
                        <form id="review_write_form" name="review_write_form" action="review_write_action" method="post">
                            <input type="hidden" class="" name="orders.orders_no" value="${orders_no}">
                                <div class="form-group">
                                    <span>Your Ratings</span>
                                    <input type="hidden" id="review_point" name="review_point" class="" value="">
<<<<<<< HEAD
=======
                                    
>>>>>>> branch 'master' of https://github.com/2022-05-JAVA-DEVELOPER/final-project-team3-brown_carrot_market.git
                                    <div class="stars">
                                        <input type="radio" name="star" class="star-0_5" id="star-0_5" onclick='setPoint(this.id);'>
                                        <label class="star-0_5" for="star-0_5">0.5</label>
                                        <input type="radio" name="star" class="star-1" id="star-1" onclick='setPoint(this.id);'>
                                        <label class="star-1" for="star-1">1</label>
                                        <input type="radio" name="star" class="star-1_5" id="star-1_5" onclick='setPoint(this.id);'>
                                        <label class="star-1_5" for="star-1_5">1.5</label>
                                        <input type="radio" name="star" class="star-2" id="star-2" onclick='setPoint(this.id);'>
                                        <label class="star-2" for="star-2">2</label>
                                        <input type="radio" name="star" class="star-2_5" id="star-2_5" onclick='setPoint(this.id);'>
                                        <label class="star-2_5" for="star-2_5">2.5</label>
                                        <input type="radio" name="star" class="star-3" id="star-3" onclick='setPoint(this.id);'>
                                        <label class="star-3" for="star-3">3</label>
                                        <input type="radio" name="star" class="star-3_5" id="star-3_5" onclick='setPoint(this.id);'>
                                        <label class="star-3_5" for="star-3_5">3.5</label>
                                        <input type="radio" name="star" class="star-4" id="star-4" onclick='setPoint(this.id);'>
                                        <label class="star-4" for="star-4">4</label>
                                        <input type="radio" name="star" class="star-4_5" id="star-4_5" onclick='setPoint(this.id);'>
                                        <label class="star-4_5" for="star-4_5">4.5</label>
                                        <input type="radio" name="star" class="star-5" id="star-5" onclick='setPoint(this.id);'>
                                        <label class="star-5" for="star-5">5</label>
                                        <span></span>
                                    </div>
<<<<<<< HEAD
=======
                                    
>>>>>>> branch 'master' of https://github.com/2022-05-JAVA-DEVELOPER/final-project-team3-brown_carrot_market.git
                                </div>
                                
                                <!--
                                <div class="form-group">
                                    <label for="name">Nickname</label>
                                    <input type="email" class="form-control" id="name" placeholder="Nazrul">
                                </div>
                                <div class="form-group">
                                    <label for="options">Reason for your rating</label>
                                    <select class="form-control small right py-0 w-100" id="options">
                                        <option>Quality</option>
                                        <option>Value</option>
                                        <option>Design</option>
                                        <option>Price</option>
                                        <option>Others</option>
                                    </select>
                                </div>
                                -->
                                
                                <div class="form-group">
                                    <label for="comments">Comments</label>
                                    <textarea class="form-control" id="comments" name="review_desc" rows="5" data-max-length="150"></textarea>
                                </div>
                                <div class="form-group">
                                	 <input type="hidden" class="" name="review_image" value="insert_test">
                                	 <form id="image_form"  name="image_form" enctype="multipart/form-data">
										<input multiple="multiple" type="file" name="file" />
										<input type="submit" value="전송" />
									 </form>
                                </div>
                                
                                <button type="button" class="btn btn-carrot mb-1">이미지삽입</button>
                                <!--<button type="submit" id="" class="btn btn-primary">Submit Review</button>-->
                                <button type="submit" id="btn_review_write_form" class="btn btn-primary">Submit Review</button>
                            </form>
                        <!-- [END]review_write_form -->
                	</div>`;
}
