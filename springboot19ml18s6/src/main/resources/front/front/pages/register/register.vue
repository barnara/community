<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"48rpx 24rpx 24rpx","background":"url(http://codegen.caihongy.cn/20241211/73f47ee0ebab4dbaa00adc26ff65743f.jpg) no-repeat center top / cover,#fff","height":"auto"}'>
		<view :style='{"border":"2rpx solid #fff","padding":"24rpx 80rpx 0 20rpx","margin":"240rpx 0 0","borderRadius":"20rpx","textAlign":"center","background":"rgba(255,255,255,.3)","display":"block","width":"100%","position":"relative","height":"auto"}'>
			<image :style='{"margin":"0 auto 24rpx auto","borderRadius":"8rpx","top":"-240rpx","left":"33%","display":"block","width":"240rpx","position":"absolute","height":"200rpx"}' src="http://codegen.caihongy.cn/20241210/a070a7bee956481aa8b99c71013ebc1b.png" mode="aspectFill"></image>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">居民账号：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.juminzhanghao"  type="text"  class="uni-input" name="" placeholder="居民账号" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">密码：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">确认密码：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">居民姓名：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.juminxingming"  type="text"  class="uni-input" name="" placeholder="居民姓名" />
			</view>
            <view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">性别：</view>
				<picker :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 180rpx)","height":"auto"}' v-if="tableName=='jumin'"  @change="juminxingbieChange" :value="juminxingbieIndex" :range="juminxingbieOptions">
					<view>
						<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
            <view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" @tap="jumintouxiangTap" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">头像：</view>
				<image :style='{"width":"180rpx","margin":"0px 0 0","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"180rpx","margin":"0px 0 0","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">联系电话：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.lianxidianhua"  type="text"  class="uni-input" name="" placeholder="联系电话" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">身份证：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.shenfenzheng"  type="text"  class="uni-input" name="" placeholder="身份证" />
			</view>
            <view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">楼宇名称：</view>
				<picker :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 180rpx)","height":"auto"}' v-if="tableName=='jumin'"  @change="juminlouyumingchengChange" :value="juminlouyumingchengIndex" :range="juminlouyumingchengOptions">
					<view>
						<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' class="uni-input">{{ruleForm.louyumingcheng?ruleForm.louyumingcheng:"请选择楼宇名称"}}</view>
					</view>
				</picker>
			</view>
            <view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">单元号：</view>
				<picker :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 180rpx)","height":"auto"}' v-if="tableName=='jumin'"  @change="jumindanyuanhaoChange" :value="jumindanyuanhaoIndex" :range="jumindanyuanhaoOptions">
					<view>
						<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' class="uni-input">{{ruleForm.danyuanhao?ruleForm.danyuanhao:"请选择单元号"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">车牌号：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.chepaihao"  type="text"  class="uni-input" name="" placeholder="车牌号" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">邮箱：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.email" type="text" class="uni-input" name="" placeholder="邮箱" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin' && true" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">验证码：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0 24rpx","margin":"0","color":"rgb(0, 0, 0)","borderRadius":"8rpx 0 0 8rpx","textAlign":"left","background":"rgba(255, 255, 255,.8)","width":"calc(100% - 360rpx)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="emailcode" type="text" class="uni-input" name="" placeholder="请输入邮箱验证码" />
				<button :style='{"border":"0px solid #ddd","padding":"0px","margin":"0px","alignItems":"center","color":"#fff","display":"flex","justifyContent":"center","borderRadius":"0 8rpx 8rpx 0","background":"#666","borderWidth":"0px 0px 0px 0","width":"180rpx","lineHeight":"80rpx","height":"80rpx"}' type="primary" v-if="isEndFlag" @tap="sendemailcode" class="bg-red">发送验证码</button>
				<button :style='{"border":"0px solid #ddd","padding":"0px","margin":"0px","alignItems":"center","color":"#fff","display":"flex","justifyContent":"center","borderRadius":"0 8rpx 8rpx 0","background":"#666","borderWidth":"0px 0px 0px 0","width":"180rpx","lineHeight":"80rpx","height":"80rpx"}' type="primary" v-if="!isEndFlag" disabled="disabled" class="bg-red">{{SecondToDate}}</button>
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">密保问题：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.pquestion"  type="text"  class="uni-input" name="" placeholder="密保问题" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='jumin'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">密保答案：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.panswer"  type="text"  class="uni-input" name="" placeholder="密保答案" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">骑手账号：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.qishouzhanghao"  type="text"  class="uni-input" name="" placeholder="骑手账号" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">骑手姓名：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.qishouxingming"  type="text"  class="uni-input" name="" placeholder="骑手姓名" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">密码：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">确认密码：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
            <view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" @tap="qishoutouxiangTap" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">头像：</view>
				<image :style='{"width":"180rpx","margin":"0px 0 0","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"180rpx","margin":"0px 0 0","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
            <view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">性别：</view>
				<picker :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 180rpx)","height":"auto"}' v-if="tableName=='qishou'"  @change="qishouxingbieChange" :value="qishouxingbieIndex" :range="qishouxingbieOptions">
					<view>
						<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">年龄：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.nianling"  type="text"  class="uni-input" name="" placeholder="年龄" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">电话：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.dianhua"  type="text"  class="uni-input" name="" placeholder="电话" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">邮箱：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.email" type="text" class="uni-input" name="" placeholder="邮箱" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou' && true" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">验证码：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0 24rpx","margin":"0","color":"rgb(0, 0, 0)","borderRadius":"8rpx 0 0 8rpx","textAlign":"left","background":"rgba(255, 255, 255,.8)","width":"calc(100% - 360rpx)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="emailcode" type="text" class="uni-input" name="" placeholder="请输入邮箱验证码" />
				<button :style='{"border":"0px solid #ddd","padding":"0px","margin":"0px","alignItems":"center","color":"#fff","display":"flex","justifyContent":"center","borderRadius":"0 8rpx 8rpx 0","background":"#666","borderWidth":"0px 0px 0px 0","width":"180rpx","lineHeight":"80rpx","height":"80rpx"}' type="primary" v-if="isEndFlag" @tap="sendemailcode" class="bg-red">发送验证码</button>
				<button :style='{"border":"0px solid #ddd","padding":"0px","margin":"0px","alignItems":"center","color":"#fff","display":"flex","justifyContent":"center","borderRadius":"0 8rpx 8rpx 0","background":"#666","borderWidth":"0px 0px 0px 0","width":"180rpx","lineHeight":"80rpx","height":"80rpx"}' type="primary" v-if="!isEndFlag" disabled="disabled" class="bg-red">{{SecondToDate}}</button>
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">密保问题：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.pquestion"  type="text"  class="uni-input" name="" placeholder="密保问题" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='qishou'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">密保答案：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.panswer"  type="text"  class="uni-input" name="" placeholder="密保答案" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='wuyerenyuan'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">工号：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.gonghao"  type="text"  class="uni-input" name="" placeholder="工号" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='wuyerenyuan'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">姓名：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.xingming"  type="text"  class="uni-input" name="" placeholder="姓名" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='wuyerenyuan'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">密码：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='wuyerenyuan'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">确认密码：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
            <view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='wuyerenyuan'" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">性别：</view>
				<picker :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 180rpx)","height":"auto"}' v-if="tableName=='wuyerenyuan'"  @change="wuyerenyuanxingbieChange" :value="wuyerenyuanxingbieIndex" :range="wuyerenyuanxingbieOptions">
					<view>
						<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
            <view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='wuyerenyuan'" @tap="wuyerenyuantupianTap" class="">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">图片：</view>
				<image :style='{"width":"180rpx","margin":"0px 0 0","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"120rpx"}' v-if="ruleForm.tupian" class="avator" :src="baseUrl+ruleForm.tupian" mode=""></image>
                <image :style='{"width":"180rpx","margin":"0px 0 0","borderRadius":"8rpx","objectFit":"cover","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='wuyerenyuan'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">联系电话：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.lianxidianhua"  type="text"  class="uni-input" name="" placeholder="联系电话" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='wuyerenyuan'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">密保问题：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.pquestion"  type="text"  class="uni-input" name="" placeholder="密保问题" />
			</view>
			<view :style='{"border":"0","margin":"0 0 24rpx 0","borderRadius":"20rpx","flexWrap":"wrap","background":"none","display":"flex","width":"calc(100% - 0px)","height":"auto"}' v-if="tableName=='wuyerenyuan'" class="uni-form-item uni-column">
				<view :style='{"width":"auto","lineHeight":"80rpx","fontSize":"28rpx","minWidth":"180rpx","color":"#333","textAlign":"right"}' class="label">密保答案：</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","textAlign":"left","flex":"1","background":"rgba(255, 255, 255,.8)","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}'  v-model="ruleForm.panswer"  type="text"  class="uni-input" name="" placeholder="密保答案" />
			</view>
			<button :style='{"border":"0","padding":"0 40rpx","margin":"24rpx auto","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#a4adb3","display":"inline-block","width":"calc(100% - 0px)","lineHeight":"88rpx","fontSize":"36rpx","minWidth":"200rpx","height":"88rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                juminxingbieOptions: [],
                juminxingbieIndex: 0,
                juminlouyumingchengOptions: [],
                juminlouyumingchengIndex: 0,
                jumindanyuanhaoOptions: [],
                jumindanyuanhaoIndex: 0,
                qishouxingbieOptions: [],
                qishouxingbieIndex: 0,
                wuyerenyuanxingbieOptions: [],
                wuyerenyuanxingbieIndex: 0,
				ruleForm: {
                juminzhanghao: '',
                mima: '',
                juminxingming: '',
                xingbie: '',
                touxiang: '',
                lianxidianhua: '',
                shenfenzheng: '',
                louyumingcheng: '',
                danyuanhao: '',
                chepaihao: '',
                email: '',
                pquestion: '',
                panswer: '',
                qishouzhanghao: '',
                qishouxingming: '',
                mima: '',
                touxiang: '',
                xingbie: '',
                nianling: '',
                dianhua: '',
                email: '',
                pquestion: '',
                panswer: '',
                gonghao: '',
                xingming: '',
                mima: '',
                xingbie: '',
                tupian: '',
                lianxidianhua: '',
                pquestion: '',
                panswer: '',
				},
				emailcode: "",
				// 倒计时定时器
				inter: null,
				// 倒计时
				count: 10,
				//倒计时结束标识
				isEndFlag: true,
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
			SecondToDate: function() {
				var time = this.count;
				time = parseInt(time) + "秒后重发";
				return time;
			}
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='jumin'){
                this.juminxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.juminxingbieOptions[0]
			}
			if(this.tableName=='jumin'){
                res = await this.$api.option(`louyumingcheng`,`louyumingcheng`,{});
                this.juminlouyumingchengOptions = res.data;
                this.juminlouyumingchengOptions.unshift("请选择楼宇名称");
			}
			if(this.tableName=='jumin'){
                res = await this.$api.option(`danyuanhao`,`danyuanhao`,{});
                this.jumindanyuanhaoOptions = res.data;
                this.jumindanyuanhaoOptions.unshift("请选择单元号");
			}
                        // 自定义下拉框值
			if(this.tableName=='qishou'){
                this.qishouxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.qishouxingbieOptions[0]
			}
                        // 自定义下拉框值
			if(this.tableName=='wuyerenyuan'){
                this.wuyerenyuanxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.wuyerenyuanxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {
			// 发送邮箱验证码
			async sendemailcode(){
				if(!this.ruleForm.email){
					this.$utils.msg(`邮箱不能为空`);
					return
				}
				if(this.ruleForm.email&&(!this.$validate.isEmail(this.ruleForm.email))){
					this.$utils.msg(`请输入正常的邮件格式`);
					return
				}
				if (this.count > 0) {
					this.isEndFlag = false;
					var _this = this;
					this.inter = setInterval(function() {
						_this.count = _this.count - 1;
						if (_this.count <= 0) {
							clearInterval(_this.inter);
							_this.count=60;
							_this.isEndFlag = true;
						}
					}, 1000);
				}
				let res = await this.$api.sendemail(`${this.tableName}`, this.ruleForm.email);
				if (res.code == 0) {
					this.$utils.msg(`发送成功`);
				} else {
					this.$utils.errMsg(`服务器异常，请稍后重试`);
					return;
				}
			},

            // 下拉变化
            juminxingbieChange(e) {
                    this.juminxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.juminxingbieOptions[this.juminxingbieIndex]
            },
            jumintouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            // 下拉变化
            juminlouyumingchengChange(e) {
                    this.juminlouyumingchengIndex = e.target.value
                    this.ruleForm.louyumingcheng = this.juminlouyumingchengOptions[this.juminlouyumingchengIndex]
            },
            // 下拉变化
            jumindanyuanhaoChange(e) {
                    this.jumindanyuanhaoIndex = e.target.value
                    this.ruleForm.danyuanhao = this.jumindanyuanhaoOptions[this.jumindanyuanhaoIndex]
            },
            qishoutouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },
            // 下拉变化
            qishouxingbieChange(e) {
                    this.qishouxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.qishouxingbieOptions[this.qishouxingbieIndex]
            },
            // 下拉变化
            wuyerenyuanxingbieChange(e) {
                    this.wuyerenyuanxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.wuyerenyuanxingbieOptions[this.wuyerenyuanxingbieIndex]
            },
            wuyerenyuantupianTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.tupian = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.juminzhanghao) && `jumin` == this.tableName){
					this.$utils.msg(`居民账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `jumin` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`jumin` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`jumin` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if(`jumin` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
					this.$utils.msg(`身份证应输入身份证格式`);
					return
				}
				if(`jumin` == this.tableName && this.ruleForm.email&&(!this.$validate.isEmail(this.ruleForm.email))){
					this.$utils.msg(`邮箱应输入邮件格式`);
					return
				}
				if(`jumin` == this.tableName && this.ruleForm.pquestion==''){
				    this.$utils.msg(`密保问题不能为空`);
				    return
				}
				if(`jumin` == this.tableName && this.ruleForm.panswer==''){
				    this.$utils.msg(`密保答案不能为空`);
				    return
				}
				if((!this.ruleForm.qishouzhanghao) && `qishou` == this.tableName){
					this.$utils.msg(`骑手账号不能为空`);
					return
				}
				if((!this.ruleForm.qishouxingming) && `qishou` == this.tableName){
					this.$utils.msg(`骑手姓名不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `qishou` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`qishou` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`qishou` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
					this.$utils.msg(`年龄应输入整数`);
					return
				}
				if(`qishou` == this.tableName && this.ruleForm.dianhua&&(!this.$validate.isMobile(this.ruleForm.dianhua))){
					this.$utils.msg(`电话应输入手机格式`);
					return
				}
				if(`qishou` == this.tableName && this.ruleForm.email&&(!this.$validate.isEmail(this.ruleForm.email))){
					this.$utils.msg(`邮箱应输入邮件格式`);
					return
				}
				if(`qishou` == this.tableName && this.ruleForm.pquestion==''){
				    this.$utils.msg(`密保问题不能为空`);
				    return
				}
				if(`qishou` == this.tableName && this.ruleForm.panswer==''){
				    this.$utils.msg(`密保答案不能为空`);
				    return
				}
                if(`wuyerenyuan` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`wuyerenyuan` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if(`wuyerenyuan` == this.tableName && this.ruleForm.pquestion==''){
				    this.$utils.msg(`密保问题不能为空`);
				    return
				}
				if(`wuyerenyuan` == this.tableName && this.ruleForm.panswer==''){
				    this.$utils.msg(`密保答案不能为空`);
				    return
				}
				await this.$api.registerEmail(`${this.tableName}`, this.ruleForm, this.emailcode);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
