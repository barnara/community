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
				<el-form-item class="input" v-if="type!='info'"  label="活动名称" prop="huodongmingcheng" >
					<el-input v-model="ruleForm.huodongmingcheng" placeholder="活动名称" clearable  :readonly="ro.huodongmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="活动名称" prop="huodongmingcheng" >
					<el-input v-model="ruleForm.huodongmingcheng" placeholder="活动名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.huodongtupian" label="活动图片" prop="huodongtupian" >
					<file-upload
						tip="点击上传活动图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.huodongtupian?ruleForm.huodongtupian:''"
						@change="huodongtupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.huodongtupian" label="活动图片" prop="huodongtupian" >
					<img v-if="ruleForm.huodongtupian.substring(0,4)=='http'&&ruleForm.huodongtupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.huodongtupian" width="100" height="100">
					<img v-else-if="ruleForm.huodongtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.huodongtupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.huodongtupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="举办时间" prop="jubanshijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.jubanshijian" 
						type="date"
						:readonly="ro.jubanshijian"
						placeholder="举办时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.jubanshijian" label="举办时间" prop="jubanshijian" >
					<el-input v-model="ruleForm.jubanshijian" placeholder="举办时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="举办地点" prop="jubandidian" >
					<el-input v-model="ruleForm.jubandidian" placeholder="举办地点" clearable  :readonly="ro.jubandidian"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="举办地点" prop="jubandidian" >
					<el-input v-model="ruleForm.jubandidian" placeholder="举办地点" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="联系电话" prop="lianxidianhua" >
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" clearable  :readonly="ro.lianxidianhua"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="联系电话" prop="lianxidianhua" >
					<el-input v-model="ruleForm.lianxidianhua" placeholder="联系电话" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="发布时间" prop="fabushijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.fabushijian" 
						type="datetime"
						:readonly="ro.fabushijian"
						placeholder="发布时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian" >
					<el-input v-model="ruleForm.fabushijian" placeholder="发布时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="textarea" v-if="type!='info'" label="报名条件" prop="baomingtiaojian" >
				<el-input
					style="min-width: 200px; max-width: 600px;"
					type="textarea"
					:rows="8"
					placeholder="报名条件"
					v-model="ruleForm.baomingtiaojian" >
				</el-input>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.baomingtiaojian" label="报名条件" prop="baomingtiaojian" >
				<span class="text">{{ruleForm.baomingtiaojian}}</span>
			</el-form-item>
			<el-form-item v-if="type!='info'"  label="活动内容" prop="huodongneirong" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.huodongneirong" 
					class="editor"
					myQuillEditor="huodongneirong"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.huodongneirong" label="活动内容" prop="huodongneirong" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.huodongneirong"></span>
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
    

	</div>
</template>
<script>
	import { 
		isIntNumer,
		isMobile,
	} from "@/utils/validate";
	export default {
		data() {
			var validateMobile = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isMobile(value)) {
					callback(new Error("请输入正确的手机号码"));
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
					huodongmingcheng : false,
					huodongtupian : false,
					baomingtiaojian : false,
					jubanshijian : false,
					jubandidian : false,
					lianxidianhua : false,
					fabushijian : false,
					huodongneirong : false,
					sfsh : false,
					shhf : false,
					thumbsupnum : false,
					crazilynum : false,
					clicktime : false,
					discussnum : false,
					storeupnum : false,
				},
			
				ruleForm: {
					huodongmingcheng: '',
					huodongtupian: '',
					baomingtiaojian: '',
					jubanshijian: '',
					jubandidian: '',
					lianxidianhua: '',
					fabushijian: '',
					huodongneirong: '',
					shhf: '',
					clicktime: '',
				},

				rules: {
					huodongmingcheng: [
					],
					huodongtupian: [
					],
					baomingtiaojian: [
					],
					jubanshijian: [
					],
					jubandidian: [
					],
					lianxidianhua: [
						{ validator: validateMobile, trigger: 'blur' },
					],
					fabushijian: [
					],
					huodongneirong: [
					],
					sfsh: [
					],
					shhf: [
					],
					thumbsupnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					crazilynum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					clicktime: [
					],
					discussnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					storeupnum: [
						{ validator: validateIntNumber, trigger: 'blur' },
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
			this.ruleForm.fabushijian = this.getCurDateTime()
		},
		methods: {
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
						if(o=='huodongmingcheng'){
							this.ruleForm.huodongmingcheng = obj[o];
							this.ro.huodongmingcheng = true;
							continue;
						}
						if(o=='huodongtupian'){
							this.ruleForm.huodongtupian = obj[o];
							this.ro.huodongtupian = true;
							continue;
						}
						if(o=='baomingtiaojian'){
							this.ruleForm.baomingtiaojian = obj[o];
							this.ro.baomingtiaojian = true;
							continue;
						}
						if(o=='jubanshijian'){
							this.ruleForm.jubanshijian = obj[o];
							this.ro.jubanshijian = true;
							continue;
						}
						if(o=='jubandidian'){
							this.ruleForm.jubandidian = obj[o];
							this.ro.jubandidian = true;
							continue;
						}
						if(o=='lianxidianhua'){
							this.ruleForm.lianxidianhua = obj[o];
							this.ro.lianxidianhua = true;
							continue;
						}
						if(o=='fabushijian'){
							this.ruleForm.fabushijian = obj[o];
							this.ro.fabushijian = true;
							continue;
						}
						if(o=='huodongneirong'){
							this.ruleForm.huodongneirong = obj[o];
							this.ro.huodongneirong = true;
							continue;
						}
						if(o=='thumbsupnum'){
							this.ruleForm.thumbsupnum = obj[o];
							this.ro.thumbsupnum = true;
							continue;
						}
						if(o=='crazilynum'){
							this.ruleForm.crazilynum = obj[o];
							this.ro.crazilynum = true;
							continue;
						}
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
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
					url: `shequhuodong/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.huodongneirong = this.ruleForm.huodongneirong.replace(reg,'../../../springboot19ml18s6/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.huodongtupian!=null) {
						this.ruleForm.huodongtupian = this.ruleForm.huodongtupian.replace(new RegExp(this.$base.url,"g"),"");
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
								url: `shequhuodong/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.shequhuodongCrossAddOrUpdateFlag = false;
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
				this.parent.shequhuodongCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			huodongtupianUploadChange(fileUrls) {
				this.ruleForm.huodongtupian = fileUrls;
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
