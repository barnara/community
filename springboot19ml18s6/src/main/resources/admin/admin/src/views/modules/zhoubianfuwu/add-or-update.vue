<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="100px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="商家名称" prop="shangjiamingcheng" >
					<el-input v-model="ruleForm.shangjiamingcheng" placeholder="商家名称" clearable  :readonly="ro.shangjiamingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="商家名称" prop="shangjiamingcheng" >
					<el-input v-model="ruleForm.shangjiamingcheng" placeholder="商家名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.dianputupian" label="店铺图片" prop="dianputupian" >
					<file-upload
						tip="点击上传店铺图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.dianputupian?ruleForm.dianputupian:''"
						@change="dianputupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.dianputupian" label="店铺图片" prop="dianputupian" >
					<img v-if="ruleForm.dianputupian.substring(0,4)=='http'&&ruleForm.dianputupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.dianputupian" width="100" height="100">
					<img v-else-if="ruleForm.dianputupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.dianputupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.dianputupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="占地面积" prop="zhandimianji" >
					<el-input v-model="ruleForm.zhandimianji" placeholder="占地面积" clearable  :readonly="ro.zhandimianji"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="占地面积" prop="zhandimianji" >
					<el-input v-model="ruleForm.zhandimianji" placeholder="占地面积" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua" >
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="联系电话" prop="lianxidianhua" >
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="负责人" prop="fuzeren" >
					<el-input v-model="ruleForm.fuzeren" placeholder="负责人" clearable  :readonly="ro.fuzeren"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="负责人" prop="fuzeren" >
					<el-input v-model="ruleForm.fuzeren" placeholder="负责人" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="textarea" v-if="type!='info'" label="主销产品" prop="zhuxiaochanpin" >
				<el-input
					style="min-width: 200px; max-width: 600px;"
					type="textarea"
					:rows="8"
					placeholder="主销产品"
					v-model="ruleForm.zhuxiaochanpin" >
				</el-input>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.zhuxiaochanpin" label="主销产品" prop="zhuxiaochanpin" >
				<span class="text">{{ruleForm.zhuxiaochanpin}}</span>
			</el-form-item>
			<el-form-item class="input" v-if="type!='info'"  label="地址" prop="fulladdress">
				<el-input @click.native="openMapDiolag(null)"  v-model="ruleForm.fulladdress" placeholder="请选择地址"></el-input>
			</el-form-item>
			<el-form-item class="input" v-else-if="ruleForm.fulladdress" label="地址" prop="fulladdress">
				<el-input v-model="ruleForm.fulladdress" placeholder="请选择地址" readonly></el-input>
			</el-form-item>
			<el-form-item v-if="type!='info'"  label="店铺简介" prop="dianpujianjie" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.dianpujianjie" 
					class="editor"
					myQuillEditor="dianpujianjie"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.dianpujianjie" label="店铺简介" prop="dianpujianjie" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.dianpujianjie"></span>
			</el-form-item>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					提交
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    
		<el-dialog
			width="50%"
			title="坐标查询"
			:visible.sync="mapVisiable"
			append-to-body>
			<el-amap-search-box class="search-box" :on-search-result="onSearchResult" :search-option="searchOption" ></el-amap-search-box>
			<div class="amap-wrapper">
				<el-amap class="amap-box" :vid="'amap-vue'" 
				:center="center"
				:zoom="zoom"
				:plugin="plugin"
				:events="events" >
				<el-amap-marker v-bind:key="marker" v-for="marker in markers" :position="marker" :events="events"></el-amap-marker>
				</el-amap>
			</div>
			<div>坐标：[{{ refColumn?(ruleForm[refColumn]?ruleForm[refColumn].split(';')[0]:''):ruleForm.longitude }}, {{ refColumn?(ruleForm[refColumn]?ruleForm[refColumn].split(';')[1]:''):ruleForm.latitude }}],地址：{{refColumn?ruleForm[refColumn + '2']:ruleForm.fulladdress}}</div>
		</el-dialog>

	</div>
</template>
<script>
	import { 
		isNumber,
		isIntNumer,
		isMobile,
	} from "@/utils/validate";
	import Vue from 'vue'
	import VueAMap from 'vue-amap'
	window._AMapSecurityConfig = {
		securityJsCode: "8848c1c64023c00cf192ce109b97243c",
	};
	export default {
		data() {
			let self = this
			var validateMobile = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isMobile(value)) {
					callback(new Error("请输入正确的手机号码"));
				} else {
					callback();
				}
			};
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("请输入整数"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					shangjiamingcheng : false,
					dianputupian : false,
					zhandimianji : false,
					lianxidianhua : false,
					fuzeren : false,
					zhuxiaochanpin : false,
					dianpujianjie : false,
					discussnum : false,
					storeupnum : false,
					longitude : false,
					latitude : false,
					fulladdress : false,
				},
				refColumn: '',
				// 地图
				mapVisiable: false,
				zoom: 12,
				center: [116.410426, 39.934946],
				markers: [],
				searchOption: {
					citylimit: false
				},
				plugin: [{
					// 定位城市
					pName: "CitySearch",
					events: {
						init(o) {
							// o是高德地图定位插件实例
							o.getLocalCity(function(status, result) {
								if (status === "complete" && result.info === "OK") {
									// 查询成功，result即为当前所在城市信息
									self.center = [result.rectangle.split(';')[0].split(',')[0], result.rectangle.split(';')[0].split(',')[1]];
								}
							});
						}
					}
				}, ],
				events: {
					click (e) {
						let { lng, lat } = e.lnglat
						if(self.refColumn){
							
						}else {
							self.ruleForm.longitude = lng
							self.ruleForm.latitude = lat
						}
						
						// 这里通过高德 SDK 完成。
						/* eslint-disable */
						var geocoder = new AMap.Geocoder({
							radius: 1000,
							extensions: 'all'
						})
						geocoder.getAddress([lng, lat], function (status, result) {
							if (status === 'complete' && result.info === 'OK') {
								if (result && result.regeocode) {
									self.mapVisiable = false
									if(self.refColumn){
										self.ruleForm[self.refColumn] = lng + ';' + lat + ';' + result.regeocode.formattedAddress
										self.ruleForm[self.refColumn + '2'] = result.regeocode.formattedAddress
									}else {
										self.ruleForm.fulladdress = result.regeocode.formattedAddress
									}
									
								}
							}
						})
					}
				},
			
				ruleForm: {
					shangjiamingcheng: '',
					dianputupian: '',
					zhandimianji: '',
					lianxidianhua: '',
					fuzeren: '',
					zhuxiaochanpin: '',
					dianpujianjie: '',
					longitude: '',
					latitude: '',
					fulladdress: '',
				},

				rules: {
					shangjiamingcheng: [
					],
					dianputupian: [
					],
					zhandimianji: [
					],
					lianxidianhua: [
						{ validator: validateMobile, trigger: 'blur' },
					],
					fuzeren: [
					],
					zhuxiaochanpin: [
					],
					dianpujianjie: [
					],
					discussnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					storeupnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					longitude: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					latitude: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					fulladdress: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
		},
		mounted() {
			Vue.use(VueAMap)
			VueAMap.initAMapApiLoader({
				key: '7a7b5d185ffd9ca30f582ff9349716ea',
				plugin: ['AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor', 'AMap.Geocoder','AMap.CitySearch'],
				// 默认高德 sdk 版本为 1.4.4
				v: '1.4.4'
			})
		},
		methods: {
			// 打开坐标定位窗口
			openMapDiolag (value=null) {
				if(value){
					this.refColumn = value
				}else{
					this.refColumn = ''
				}
				this.mapVisiable = true
			},
			// 查询
			onSearchResult (pois) {
				let latSum = 0;
				let lngSum = 0;
				if (pois.length > 0) {
					pois.forEach(poi => {
						let {lng, lat} = poi;
						lngSum += lng;
						latSum += lat;
						this.markers.push([poi.lng, poi.lat]);
					});
					let center = {
						lng: lngSum / pois.length,
						lat: latSum / pois.length
					};
					this.center = [center.lng, center.lat];
				}
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='shangjiamingcheng'){
							this.ruleForm.shangjiamingcheng = obj[o];
							this.ro.shangjiamingcheng = true;
							continue;
						}
						if(o=='dianputupian'){
							this.ruleForm.dianputupian = obj[o];
							this.ro.dianputupian = true;
							continue;
						}
						if(o=='zhandimianji'){
							this.ruleForm.zhandimianji = obj[o];
							this.ro.zhandimianji = true;
							continue;
						}
						if(o=='lianxidianhua'){
							this.ruleForm.lianxidianhua = obj[o];
							this.ro.lianxidianhua = true;
							continue;
						}
						if(o=='fuzeren'){
							this.ruleForm.fuzeren = obj[o];
							this.ro.fuzeren = true;
							continue;
						}
						if(o=='zhuxiaochanpin'){
							this.ruleForm.zhuxiaochanpin = obj[o];
							this.ro.zhuxiaochanpin = true;
							continue;
						}
						if(o=='dianpujianjie'){
							this.ruleForm.dianpujianjie = obj[o];
							this.ro.dianpujianjie = true;
							continue;
						}
						if(o=='discussnum'){
							this.ruleForm.discussnum = obj[o];
							this.ro.discussnum = true;
							continue;
						}
						if(o=='storeupnum'){
							this.ruleForm.storeupnum = obj[o];
							this.ro.storeupnum = true;
							continue;
						}
						if(o=='longitude'){
							this.ruleForm.longitude = obj[o];
							this.ro.longitude = true;
							continue;
						}
						if(o=='latitude'){
							this.ruleForm.latitude = obj[o];
							this.ro.latitude = true;
							continue;
						}
						if(o=='fulladdress'){
							this.ruleForm.fulladdress = obj[o];
							this.ro.fulladdress = true;
							continue;
						}
					}
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `zhoubianfuwu/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.dianpujianjie = this.ruleForm.dianpujianjie.replace(reg,'../../../springboot19ml18s6/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.dianputupian!=null) {
						this.ruleForm.dianputupian = this.ruleForm.dianputupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `zhoubianfuwu/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.zhoubianfuwuCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.zhoubianfuwuCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			dianputupianUploadChange(fileUrls) {
				this.ruleForm.dianputupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		border-radius:  0px 0px 10px 10px;
		background-color: rgba(255, 255, 255, 1);
		margin: 0;
	}
	.add-update-preview {
		padding: 50px 60px 20px 60px;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 100%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		border: 2px solid #858181;
		border-radius: 10px;
		padding: 0 10px 0 0;
		color: #666;
		font-weight: 600;
		width: 100px;
		font-size: 16px;
		line-height: 36px;
		text-align: center;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 100px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0;
		margin: 0 0 0 30px;
		color: #333;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 14px;
		line-height: 40px;
		min-width: 50%;
	}
	
	.add-update-preview .el-input {
		margin: 0 0 0 30px;
		width: 100%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 2px solid #858181;
		border-radius: 5px;
		padding: 0 12px;
		color: #000;
		width: 50%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #999;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		margin: 0 0 0 30px;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 2px solid #858181;
		border-radius: 5px;
		padding: 0 12px;
		color: #000;
		width: 50%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #999;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 50%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 2px solid #858181;
		border-radius: 5px;
		padding: 0 10px;
		margin: 0 0 0 30px;
		color: #000;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #999;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor {
		margin: 0px 0px 0px 30px;
		width: 100%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 2px solid #858181;
		border-radius: 5px;
		padding: 0 10px 0 30px;
		color: #000;
		background: #fff;
		width: 50%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #999;
		background: none;
		width: auto;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0;
		margin: 0 0px 0 30px;
		color: #000;
		background: #fff;
		width: auto;
		font-size: 14px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0;
		margin: 0 0 0 30px;
		color: #000;
		background: #fff;
		width: auto;
		font-size: 14px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0;
		margin: 0 0 0 30px;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 14px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 2px solid #858181;
		cursor: pointer;
		border-radius: 5px;
		margin: 0 0 0 30px;
		color: #000;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 2px solid #858181;
		cursor: pointer;
		border-radius: 5px;
		margin: 0 0 0 30px;
		color: #000;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 2px solid #858181;
		cursor: pointer;
		border-radius: 5px;
		margin: 0 0 0 30px;
		color: #000;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		display: none;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 2px solid #858181;
		border-radius: 5px;
		padding: 12px;
		margin: 0 0 0 30px;
		color: #666;
		background: none;
		width: calc(100% - 30px);
		font-size: 14px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				margin: 0 0 0 30px;
				color: #999;
				background: none;
				width: auto;
				font-size: 14px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #151628;
			width: auto;
			font-size: 14px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #151628;
			width: auto;
			font-size: 14px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #151628;
			width: auto;
			font-size: 14px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #151628;
			width: auto;
			font-size: 14px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #151628;
			width: auto;
			font-size: 14px;
			min-width: 130px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
