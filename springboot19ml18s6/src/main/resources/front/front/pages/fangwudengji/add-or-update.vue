<template>
<view class="content">
	<view :style='{"width":"100%","padding":"40rpx 0 0","position":"relative","background":"#fff","height":"100%"}'>
		<form :style='{"width":"100%","padding":"0 0 48rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">楼宇名称</view>
				<picker :disabled="ro.louyumingcheng" :style='{"width":"100%","flex":"1","height":"auto"}' @change="louyumingchengChange" :value="louyumingchengIndex" :range="louyumingchengOptions">
					<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","width":"100%","lineHeight":"80rpx","fontSize":"28rpx"}' class="uni-input">{{ruleForm.louyumingcheng?ruleForm.louyumingcheng:"请选择楼宇名称"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">单元号</view>
				<picker :disabled="ro.danyuanhao" :style='{"width":"100%","flex":"1","height":"auto"}' @change="danyuanhaoChange" :value="danyuanhaoIndex" :range="danyuanhaoOptions">
					<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","width":"100%","lineHeight":"80rpx","fontSize":"28rpx"}' class="uni-input">{{ruleForm.danyuanhao?ruleForm.danyuanhao:"请选择单元号"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">楼层</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.louceng" v-model="ruleForm.louceng" placeholder="楼层"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">房间号</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.fangjianhao" v-model="ruleForm.fangjianhao" placeholder="房间号"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">住宅面积</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.zhuzhaimianji" v-model="ruleForm.zhuzhaimianji" placeholder="住宅面积"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">产权</view>
				<picker :disabled="ro.chanquan" :style='{"width":"100%","flex":"1","height":"auto"}' @change="chanquanChange" :value="chanquanIndex" :range="chanquanOptions">
					<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","width":"100%","lineHeight":"80rpx","fontSize":"28rpx"}' class="uni-input">{{ruleForm.chanquan?ruleForm.chanquan:"请选择产权"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">房屋类型</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.fangwuleixing" v-model="ruleForm.fangwuleixing" placeholder="房屋类型"  type="text"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">房屋状态</view>
				<picker :disabled="ro.fangwuzhuangtai" :style='{"width":"100%","flex":"1","height":"auto"}' @change="fangwuzhuangtaiChange" :value="fangwuzhuangtaiIndex" :range="fangwuzhuangtaiOptions">
					<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","width":"100%","lineHeight":"80rpx","fontSize":"28rpx"}' class="uni-input">{{ruleForm.fangwuzhuangtai?ruleForm.fangwuzhuangtai:"请选择房屋状态"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">居民账号</view>
				<picker :disabled="ro.juminzhanghao" :style='{"width":"100%","flex":"1","height":"auto"}' @change="juminzhanghaoChange" :value="juminzhanghaoIndex" :range="juminzhanghaoOptions">
					<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","width":"100%","lineHeight":"80rpx","fontSize":"28rpx"}' class="uni-input">{{juminzhanghaoOptions[juminzhanghaoIndex]}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">居民姓名</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled v-model="ruleForm.juminxingming" placeholder="居民姓名"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">联系电话</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled v-model="ruleForm.lianxidianhua" placeholder="联系电话"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">更新时间</view>
				<input :disabled="ro.gengxinshijian" :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.gengxinshijian" placeholder="更新时间" @tap="toggleTab('gengxinshijian')"></input>
			</view>
            
			
			<view :style='{"width":"100%","margin":"40rpx 0","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0","margin":"0 40rpx 0 0","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#a4adb3","width":"250rpx","lineHeight":"80rpx","fontSize":"32rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="gengxinshijianConfirm" ref="gengxinshijian" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				louyumingcheng: '',
				danyuanhao: '',
				louceng: '',
				fangjianhao: '',
				zhuzhaimianji: '',
				chanquan: '',
				fangwuleixing: '',
				fangwuzhuangtai: '',
				juminzhanghao: '',
				juminxingming: '',
				lianxidianhua: '',
				gengxinshijian: '',
				},
				louyumingchengOptions: [],
				louyumingchengIndex: 0,
				danyuanhaoOptions: [],
				danyuanhaoIndex: 0,
				chanquanOptions: [],
				chanquanIndex: 0,
				fangwuzhuangtaiOptions: [],
				fangwuzhuangtaiIndex: 0,
				juminzhanghaoOptions: [],
				juminzhanghaoIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   louyumingcheng : false,
				   danyuanhao : false,
				   louceng : false,
				   fangjianhao : false,
				   zhuzhaimianji : false,
				   chanquan : false,
				   fangwuleixing : false,
				   fangwuzhuangtai : false,
				   juminzhanghao : false,
				   juminxingming : false,
				   lianxidianhua : false,
				   gengxinshijian : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			this.ruleForm.gengxinshijian =  this.$utils.getCurDateTime();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.louyumingcheng = this.user.louyumingcheng
			this.ro.louyumingcheng = true;
			this.ruleForm.danyuanhao = this.user.danyuanhao
			this.ro.danyuanhao = true;


			// 下拉框
			res = await this.$api.option(`louyumingcheng`,`louyumingcheng`,{});
			this.louyumingchengOptions = res.data;
			this.louyumingchengOptions.unshift("请选择楼宇名称");
			// 下拉框
			res = await this.$api.option(`danyuanhao`,`danyuanhao`,{});
			this.danyuanhaoOptions = res.data;
			this.danyuanhaoOptions.unshift("请选择单元号");
			// 自定义下拉框值
			this.chanquanOptions = "40年产权,70年产权".split(',')
			// 自定义下拉框值
			this.fangwuzhuangtaiOptions = "售出,未售出".split(',')
			// 下2
			res = await this.$api.option(`jumin`,`juminzhanghao`,{});
			this.juminzhanghaoOptions = res.data;

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`fangwudengji`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='louyumingcheng'){
						this.ruleForm.louyumingcheng = obj[o];
						this.ro.louyumingcheng = true;
						continue;
					}
					if(o=='danyuanhao'){
						this.ruleForm.danyuanhao = obj[o];
						this.ro.danyuanhao = true;
						continue;
					}
					if(o=='louceng'){
						this.ruleForm.louceng = obj[o];
						this.ro.louceng = true;
						continue;
					}
					if(o=='fangjianhao'){
						this.ruleForm.fangjianhao = obj[o];
						this.ro.fangjianhao = true;
						continue;
					}
					if(o=='zhuzhaimianji'){
						this.ruleForm.zhuzhaimianji = obj[o];
						this.ro.zhuzhaimianji = true;
						continue;
					}
					if(o=='chanquan'){
						this.ruleForm.chanquan = obj[o];
						this.ro.chanquan = true;
						continue;
					}
					if(o=='fangwuleixing'){
						this.ruleForm.fangwuleixing = obj[o];
						this.ro.fangwuleixing = true;
						continue;
					}
					if(o=='fangwuzhuangtai'){
						this.ruleForm.fangwuzhuangtai = obj[o];
						this.ro.fangwuzhuangtai = true;
						continue;
					}
					if(o=='juminzhanghao'){
						this.ruleForm.juminzhanghao = obj[o];
						this.ro.juminzhanghao = true;
						continue;
					}
					if(o=='juminxingming'){
						this.ruleForm.juminxingming = obj[o];
						this.ro.juminxingming = true;
						continue;
					}
					if(o=='lianxidianhua'){
						this.ruleForm.lianxidianhua = obj[o];
						this.ro.lianxidianhua = true;
						continue;
					}
					if(o=='gengxinshijian'){
						this.ruleForm.gengxinshijian = obj[o];
						this.ro.gengxinshijian = true;
						continue;
					}
				}
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},
			// 下二随
			async juminzhanghaoChange (e) {
				this.juminzhanghaoIndex = e.target.value
				this.ruleForm.juminzhanghao = this.juminzhanghaoOptions[this.juminzhanghaoIndex]
				let res = await this.$api.follow(`jumin`, `juminzhanghao`,{
					columnValue: this.ruleForm.juminzhanghao
				});
				if(res.data.juminxingming){
					this.ruleForm.juminxingming = res.data.juminxingming
				}
				if(res.data.lianxidianhua){
					this.ruleForm.lianxidianhua = res.data.lianxidianhua
				}
			},

			// 多级联动参数


			// 日长控件选择日期时间
			gengxinshijianConfirm(val) {
				console.log(val)
				this.ruleForm.gengxinshijian = val.result;
				this.$forceUpdate();
			},

			// 下拉变化
			louyumingchengChange(e) {
				this.louyumingchengIndex = e.target.value
				this.ruleForm.louyumingcheng = this.louyumingchengOptions[this.louyumingchengIndex]
			},
			// 下拉变化
			danyuanhaoChange(e) {
				this.danyuanhaoIndex = e.target.value
				this.ruleForm.danyuanhao = this.danyuanhaoOptions[this.danyuanhaoIndex]
			},
			// 下拉变化
			chanquanChange(e) {
				this.chanquanIndex = e.target.value
				this.ruleForm.chanquan = this.chanquanOptions[this.chanquanIndex]
			},
			// 下拉变化
			fangwuzhuangtaiChange(e) {
				this.fangwuzhuangtaiIndex = e.target.value
				this.ruleForm.fangwuzhuangtai = this.fangwuzhuangtaiOptions[this.fangwuzhuangtaiIndex]
			},


			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				//跨表计算判断
				var obj;
				if(this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`fangwudengji`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`fangwudengji`, this.ruleForm);
						}else{
							oet = await this.$api.add(`fangwudengji`, this.ruleForm);
						}
						if(this.cross){
							uni.setStorageSync('crossCleanType',true);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`fangwudengji`, this.ruleForm);
					}else{
						oet = await this.$api.add(`fangwudengji`, this.ruleForm);
					}
					if(this.cross){
						uni.setStorageSync('crossCleanType',true);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
