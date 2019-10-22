package com.ouyue.xiwennews.controller;
import com.ouyue.xiwennews.common.base.BaseResponse;
import com.ouyue.xiwennews.common.model.UserLikeF;
import com.ouyue.xiwennews.common.vo.UserLikeDetailV;
import com.ouyue.xiwennews.compont.CancelOrderSender;
import com.ouyue.xiwennews.service.UserLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Api(tags = "用户点赞")
@RestController
@RequestMapping("/userLike")
public class UserLikeController {

	@Autowired
	UserLikeService userLikeService;

	@Autowired
	CancelOrderSender cancelOrderSender;

	private final static Logger logger = LoggerFactory.getLogger(UserLikeController.class);
	private static int corePoolSize = Runtime.getRuntime().availableProcessors();
	//创建线程池  调整队列数 拒绝服务
	private static ThreadPoolExecutor executor  = new ThreadPoolExecutor(corePoolSize, corePoolSize+1, 10l, TimeUnit.SECONDS,
			new LinkedBlockingQueue<Runnable>(1000));



	@ApiOperation(value = "获取用户点赞详情")
	@ResponseBody
	@RequestMapping(value = "/getUserLikeDto", method = RequestMethod.GET)
	public BaseResponse<UserLikeDetailV> insertDto(@RequestParam String id) {
		BaseResponse response = new BaseResponse();
		UserLikeDetailV vo=userLikeService.getUserLikeDetail(Integer.valueOf(id));
		response.setModel(vo);
	 	cancelOrderSender.sendMessage(id,50000);
		return response;
	}


	@ApiOperation(value = "新增")
	@ResponseBody
	@RequestMapping(value = "/saveUserLikeDto", method = RequestMethod.POST)
	public BaseResponse<?> insertDto(@RequestBody @Valid UserLikeF request) {
		BaseResponse response = new BaseResponse();
		int num=userLikeService.insertDto(request);
		return response;
	}


}
