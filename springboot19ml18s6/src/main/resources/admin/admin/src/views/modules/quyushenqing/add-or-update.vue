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
				<el-form-item class="input" v-if="type!='info'"  label="骑手账号" prop="qishouzhanghao" >
					<el-input v-model="ruleForm.qishouzhanghao" placeholder="骑手账号" clearable  :readonly="ro.qishouzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="骑手账号" prop="qishouzhanghao" >
					<el-input v-model="ruleForm.qishouzhanghao" placeholder="骑手账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="骑手姓名" prop="qishouxingming" >
					<el-input v-model="ruleForm.qishouxingming" placeholder="骑手姓名" clearable  :readonly="ro.qishouxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="骑手姓名" prop="qishouxingming" >
					<el-input v-model="ruleForm.qishouxingming" placeholder="骑手姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.touxiang" label="头像" prop="touxiang" >
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="touxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.touxiang" label="头像" prop="touxiang" >
					<img v-if="ruleForm.touxiang.substring(0,4)=='http'&&ruleForm.touxiang.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang" width="100" height="100">
					<img v-else-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="联系方式" prop="dianhua" >
					<el-input v-model="ruleForm.dianhua" placeholder="联系方式" clearable  :readonly="ro.dianhua"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="联系方式" prop="dianhua" >
					<el-input v-model="ruleForm.dianhua" placeholder="联系方式" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="订单编号" prop="dingdanbianhao" >
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" clearable  :readonly="ro.dingdanbianhao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="订单编号" prop="dingdanbianhao" >
					<el-input v-model="ruleForm.dingdanbianhao" placeholder="订单编号" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="配送时间" prop="peisongshijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.peisongshijian" 
						type="datetime"
						:readonly="ro.peisongshijian"
						placeholder="配送时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.peisongshijian" label="配送时间" prop="peisongshijian" >
					<el-input v-model="ruleForm.peisongshijian" placeholder="配送时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info'&& !ro.zhengmingcailiao" label="证明材料" prop="zhengmingcailiao" >
					<file-upload
						tip="点击上传证明材料"
						action="file/upload"
						:limit="1"
						:type="3"
						:multiple="true"
						:fileUrls="ruleForm.zhengmingcailiao?ruleForm.zhengmingcailiao:''"
						@change="zhengmingcailiaoUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item v-else-if="ruleForm.zhengmingcailiao" label="证明材料" prop="zhengmingcailiao" >
					<el-button class="downBtn" type="text" size="small" @click="download($base.url+ruleForm.zhengmingcailiao)">
						<span class="icon iconfont icon-xiazai6"></span>
						下载
					</el-button>
				</el-form-item>
				<el-form-item v-else-if="!ruleForm.zhengmingcailiao" label="证明材料" prop="zhengmingcailiao" >
					<el-button class="unBtn" type="text" size="small">
						<span class="icon iconfont icon-xihuan"></span>
						暂无
					</el-button>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="申请时间" prop="shenqingshijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.shenqingshijian" 
						type="datetime"
						:readonly="ro.shenqingshijian"
						placeholder="申请时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.shenqingshijian" label="申请时间" prop="shenqingshijian" >
					<el-input v-model="ruleForm.shenqingshijian" placeholder="申请时间" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="textarea" v-if="type!='info'" label="备注" prop="beizhu" >
				<el-input
					style="min-width: 200px; max-width: 600px;"
					type="textarea"
					:rows="8"
					placeholder="备注"
					v-model="ruleForm.beizhu" >
				</el-input>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.beizhu" label="备注" prop="beizhu" >
				<span class="text">{{ruleForm.beizhu}}</span>
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
	export default {
		data() {
			return {
				id: '',
				type: '',
			
			
				ro:{
					qishouzhanghao : false,
					qishouxingming : false,
					touxiang : false,
					dianhua : false,
					dingdanbianhao : false,
					peisongshijian : false,
					zhengmingcailiao : false,
					shenqingshijian : false,
					beizhu : false,
					sfsh : false,
					shhf : false,
				},
			
				ruleForm: {
					qishouzhanghao: '',
					qishouxingming: '',
					touxiang: '',
					dianhua: '',
					dingdanbianhao: '',
					peisongshijian: '',
					zhengmingcailiao: '',
					shenqingshijian: '',
					beizhu: '',
					shhf: '',
				},

				rules: {
					qishouzhanghao: [
					],
					qishouxingming: [
					],
					touxiang: [
					],
					dianhua: [
					],
					dingdanbianhao: [
					],
					peisongshijian: [
					],
					zhengmingcailiao: [
					],
					shenqingshijian: [
					],
					beizhu: [
					],
					sfsh: [
					],
					shhf: [
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
			this.ruleForm.shenqingshijian = this.getCurDateTime()
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
						if(o=='qishouzhanghao'){
							this.ruleForm.qishouzhanghao = obj[o];
							this.ro.qishouzhanghao = true;
							continue;
						}
						if(o=='qishouxingming'){
							this.ruleForm.qishouxingming = obj[o];
							this.ro.qishouxingming = true;
							continue;
						}
						if(o=='touxiang'){
							this.ruleForm.touxiang = obj[o];
							this.ro.touxiang = true;
							continue;
						}
						if(o=='dianhua'){
							this.ruleForm.dianhua = obj[o];
							this.ro.dianhua = true;
							continue;
						}
						if(o=='dingdanbianhao'){
							this.ruleForm.dingdanbianhao = obj[o];
							this.ro.dingdanbianhao = true;
							continue;
						}
						if(o=='peisongshijian'){
							this.ruleForm.peisongshijian = obj[o];
							this.ro.peisongshijian = true;
							continue;
						}
						if(o=='zhengmingcailiao'){
							this.ruleForm.zhengmingcailiao = obj[o];
							this.ro.zhengmingcailiao = true;
							continue;
						}
						if(o=='shenqingshijian'){
							this.ruleForm.shenqingshijian = obj[o];
							this.ro.shenqingshijian = true;
							continue;
						}
						if(o=='beizhu'){
							this.ruleForm.beizhu = obj[o];
							this.ro.beizhu = true;
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
						if(((json.qishouzhanghao!=''&&json.qishouzhanghao) || json.qishouzhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.qishouzhanghao = json.qishouzhanghao
							this.ro.qishouzhanghao = true;
						}
						if(((json.qishouxingming!=''&&json.qishouxingming) || json.qishouxingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.qishouxingming = json.qishouxingming
							this.ro.qishouxingming = true;
						}
						if(((json.dianhua!=''&&json.dianhua) || json.dianhua==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.dianhua = json.dianhua
							this.ro.dianhua = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `quyushenqing/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.touxiang!=null) {
						this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
					}
					if(this.ruleForm.zhengmingcailiao!=null) {
						this.ruleForm.zhengmingcailiao = this.ruleForm.zhengmingcailiao.replace(new RegExp(this.$base.url,"g"),"");
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
								url: `quyushenqing/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.quyushenqingCrossAddOrUpdateFlag = false;
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
				this.parent.quyushenqingCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			touxiangUploadChange(fileUrls) {
				this.ruleForm.touxiang = fileUrls;
			},
			zhengmingcailiaoUploadChange(fileUrls) {
				this.ruleForm.zhengmingcailiao = fileUrls;
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
