<template>
<view class="content">
	<view :style='{"width":"100%","padding":"40rpx 0 0","position":"relative","background":"#fff","height":"100%"}'>
		<form :style='{"width":"100%","padding":"0 0 48rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">缴费单号</view>
				<view :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","lineHeight":"80rpx","fontSize":"28rpx"}' class="right-input">
					{{ruleForm.jiaofeidanhao}}
				</view>
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
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">楼宇名称</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled v-model="ruleForm.louyumingcheng" placeholder="楼宇名称"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">单元号</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' disabled v-model="ruleForm.danyuanhao" placeholder="单元号"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">缴费类型</view>
				<picker :disabled="ro.jiaofeileixing" :style='{"width":"100%","flex":"1","height":"auto"}' @change="jiaofeileixingChange" :value="jiaofeileixingIndex" :range="jiaofeileixingOptions">
					<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","width":"100%","lineHeight":"80rpx","fontSize":"28rpx"}' class="uni-input">{{ruleForm.jiaofeileixing?ruleForm.jiaofeileixing:"请选择缴费类型"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">缴费金额</view>
				<input :style='{"border":"2rpx solid #666","padding":"0px 24rpx","margin":"0px","color":"rgb(0, 0, 0)","borderRadius":"8rpx","flex":"1","background":"rgba(255, 255, 255, 0)","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.jiaofeijine" v-model.number="ruleForm.jiaofeijine" placeholder="缴费金额" type="digit"></input>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">登记时间</view>
				<picker  :disabled="ro.dengjishijian" :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.dengjishijian" @change="dengjishijianChange">
					<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","width":"100%","lineHeight":"80rpx","fontSize":"28rpx"}' class="uni-input">{{ruleForm.dengjishijian?ruleForm.dengjishijian:"请选择登记时间"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 40rpx","margin":"0 0 8rpx 0","borderColor":"#ccc","alignItems":"center","borderRadius":"0","borderWidth":"0 0 0px 0","background":"#fff","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"padding":"0 20rpx 0 0","color":"#333","textAlign":"right","width":"160rpx","lineHeight":"80rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">截止日期</view>
				<picker :start="jiezhiriqistarttime" :disabled="ro.jiezhiriqi" :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.jiezhiriqi" @change="jiezhiriqiChange">
					<view :style='{"border":"2rpx solid #666","padding":"0 20rpx","color":"#666","borderRadius":"8rpx","width":"100%","lineHeight":"80rpx","fontSize":"28rpx"}' class="uni-input">{{ruleForm.jiezhiriqi?ruleForm.jiezhiriqi:"请选择截止日期"}}</view>
				</picker>
			</view>
          
			
			<view :style='{"width":"100%","margin":"40rpx 0","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0","margin":"0 40rpx 0 0","color":"rgb(255, 255, 255)","borderRadius":"8rpx","background":"#a4adb3","width":"250rpx","lineHeight":"80rpx","fontSize":"32rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

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
				jiaofeidanhao: this.getUUID(),
				juminzhanghao: '',
				juminxingming: '',
				louyumingcheng: '',
				danyuanhao: '',
				jiaofeileixing: '',
				jiaofeijine: '',
				dengjishijian: '',
				jiezhiriqi: '',
				ispay: '',
				},
				juminzhanghaoOptions: [],
				juminzhanghaoIndex: 0,
				jiaofeileixingOptions: [],
				jiaofeileixingIndex: 0,
				jiezhiriqistarttime: '',
				// 登录用户信息
				user: {},
				ro:{
				   jiaofeidanhao : false,
				   juminzhanghao : false,
				   juminxingming : false,
				   louyumingcheng : false,
				   danyuanhao : false,
				   jiaofeileixing : false,
				   jiaofeijine : false,
				   dengjishijian : false,
				   jiezhiriqi : false,
				   ispay : false,
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
			this.ruleForm.dengjishijian = this.$utils.getCurDate();
			this.jiezhiriqistarttime = this.$utils.getCurDate()
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取


			// 下2
			res = await this.$api.option(`jumin`,`juminzhanghao`,{});
			this.juminzhanghaoOptions = res.data;
			// 自定义下拉框值
			this.jiaofeileixingOptions = "水费,电费,维修费,物业费,煤气费".split(',')

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
				res = await this.$api.info(`jiaofeitongzhi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='jiaofeidanhao'){
						this.ruleForm.jiaofeidanhao = obj[o];
						this.ro.jiaofeidanhao = true;
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
					if(o=='jiaofeileixing'){
						this.ruleForm.jiaofeileixing = obj[o];
						this.ro.jiaofeileixing = true;
						continue;
					}
					if(o=='jiaofeijine'){
						this.ruleForm.jiaofeijine = obj[o];
						this.ro.jiaofeijine = true;
						continue;
					}
					if(o=='dengjishijian'){
						this.ruleForm.dengjishijian = obj[o];
						this.ro.dengjishijian = true;
						continue;
					}
					if(o=='jiezhiriqi'){
						this.ruleForm.jiezhiriqi = obj[o];
						this.ro.jiezhiriqi = true;
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
				if(res.data.louyumingcheng){
					this.ruleForm.louyumingcheng = res.data.louyumingcheng
				}
				if(res.data.danyuanhao){
					this.ruleForm.danyuanhao = res.data.danyuanhao
				}
			},

			// 多级联动参数

			dengjishijianChange(e) {
				this.ruleForm.dengjishijian = e.target.value;
				this.$forceUpdate();
			},
			jiezhiriqiChange(e) {
				this.ruleForm.jiezhiriqi = e.target.value;
				this.$forceUpdate();
			},


			// 下拉变化
			jiaofeileixingChange(e) {
				this.jiaofeileixingIndex = e.target.value
				this.ruleForm.jiaofeileixing = this.jiaofeileixingOptions[this.jiaofeileixingIndex]
			},


			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				if(!this.ruleForm.id) {
					this.ruleForm.ispay = '未支付'
				}
				if(this.ruleForm.jiaofeidanhao){
					this.ruleForm.jiaofeidanhao = String(this.ruleForm.jiaofeidanhao)
				}
				//跨表计算判断
				var obj;
				if((!this.ruleForm.jiaofeidanhao)){
					this.$utils.msg(`缴费单号不能为空`);
					return
				}
				if((!this.ruleForm.danyuanhao)){
					this.$utils.msg(`单元号不能为空`);
					return
				}
				if((!this.ruleForm.jiaofeileixing)){
					this.$utils.msg(`缴费类型不能为空`);
					return
				}
				if((!this.ruleForm.jiaofeijine)){
					this.$utils.msg(`缴费金额不能为空`);
					return
				}
				if(this.ruleForm.jiaofeijine&&(!this.$validate.isNumber(this.ruleForm.jiaofeijine))){
					this.$utils.msg(`缴费金额应输入数字`);
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
					let res = await this.$api.list(`jiaofeitongzhi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`jiaofeitongzhi`, this.ruleForm);
						}else{
							oet = await this.$api.add(`jiaofeitongzhi`, this.ruleForm);
						}
						if(this.isAuth('jiaofeitongzhi','支付')&&this.cross) {
							uni.showModal({
								title: '提交成功！',
								content: '是否跳转支付？',
								success: async function(res) {
									if (res.confirm) {
										that.$utils.jump(`./detail?id=${oet.data}&userid=` + uni.getStorageSync("appUserid"))
									}else {
										if(that.cross){
											uni.setStorageSync('crossCleanType',true);
										}
										that.$utils.msgBack('提交成功');
									}
								}
							})
						}else {
							if(this.cross){
								uni.setStorageSync('crossCleanType',true);
							}
							this.$utils.msgBack('提交成功');
						}
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`jiaofeitongzhi`, this.ruleForm);
					}else{
						oet = await this.$api.add(`jiaofeitongzhi`, this.ruleForm);
					}
					if(this.isAuth('jiaofeitongzhi','支付')&&this.cross) {
						uni.showModal({
							title: '提交成功！',
							content: '是否跳转支付？',
							success: async function(res) {
								if (res.confirm) {
									that.$utils.jump(`./detail?id=${oet.data}&userid=` + uni.getStorageSync("appUserid"))
								}else {
									if(that.cross){
										uni.setStorageSync('crossCleanType',true);
									}
									that.$utils.msgBack('提交成功');
								}
							}
						})
					}else {
						if(this.cross){
							uni.setStorageSync('crossCleanType',true);
						}
						this.$utils.msgBack('提交成功');
					}
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
