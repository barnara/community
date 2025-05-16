<template>
	<div :style='{"padding":"0","fontSize":"16px"}'>
		<el-form
			:style='{"padding":"50px 60px 20px 60px","borderColor":"#eee","borderStyle":"solid","borderWidth":"0px 0 0"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			label-width="100px"
		>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jumin'"  label="居民账号" prop="juminzhanghao">
					<el-input v-model="ruleForm.juminzhanghao" readonly placeholder="居民账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jumin'"  label="居民姓名" prop="juminxingming">
					<el-input v-model="ruleForm.juminxingming"  placeholder="居民姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='jumin'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in juminxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='jumin'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="jumintouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jumin'"  label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua"  placeholder="联系电话" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jumin'"  label="身份证" prop="shenfenzheng">
					<el-input v-model="ruleForm.shenfenzheng"  placeholder="身份证" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='jumin'"  label="楼宇名称" prop="louyumingcheng">
					<el-select v-model="ruleForm.louyumingcheng"  placeholder="请选择楼宇名称">
						<el-option
							v-for="(item,index) in juminlouyumingchengOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='jumin'"  label="单元号" prop="danyuanhao">
					<el-select v-model="ruleForm.danyuanhao"  placeholder="请选择单元号">
						<el-option
							v-for="(item,index) in jumindanyuanhaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jumin'"  label="车牌号" prop="chepaihao">
					<el-input v-model="ruleForm.chepaihao"  placeholder="车牌号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jumin'"  label="邮箱" prop="email">
					<el-input v-model="ruleForm.email"  placeholder="邮箱" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jumin'"  label="密保问题" prop="pquestion">
					<el-input v-model="ruleForm.pquestion"  placeholder="密保问题" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='jumin'"  label="密保答案" prop="panswer">
					<el-input v-model="ruleForm.panswer"  placeholder="密保答案" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='qishou'"  label="骑手账号" prop="qishouzhanghao">
					<el-input v-model="ruleForm.qishouzhanghao" readonly placeholder="骑手账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='qishou'"  label="骑手姓名" prop="qishouxingming">
					<el-input v-model="ruleForm.qishouxingming"  placeholder="骑手姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='qishou'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="qishoutouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='qishou'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in qishouxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='qishou'"  label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling"  placeholder="年龄" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='qishou'"  label="电话" prop="dianhua">
					<el-input v-model="ruleForm.dianhua"  placeholder="电话" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='qishou'"  label="邮箱" prop="email">
					<el-input v-model="ruleForm.email"  placeholder="邮箱" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='qishou'"  label="密保问题" prop="pquestion">
					<el-input v-model="ruleForm.pquestion"  placeholder="密保问题" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='qishou'"  label="密保答案" prop="panswer">
					<el-input v-model="ruleForm.panswer"  placeholder="密保答案" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='wuyerenyuan'"  label="工号" prop="gonghao">
					<el-input v-model="ruleForm.gonghao" readonly placeholder="工号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='wuyerenyuan'"  label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming"  placeholder="姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='wuyerenyuan'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in wuyerenyuanxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='wuyerenyuan'" label="图片" prop="tupian">
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="wuyerenyuantupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='wuyerenyuan'"  label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua"  placeholder="联系电话" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='wuyerenyuan'"  label="密保问题" prop="pquestion">
					<el-input v-model="ruleForm.pquestion"  placeholder="密保问题" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='wuyerenyuan'"  label="密保答案" prop="panswer">
					<el-input v-model="ruleForm.panswer"  placeholder="密保答案" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='users'" label="用户名" prop="username">
					<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='users'" label="头像" prop="image">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.image?ruleForm.image:''"
						@change="usersimageUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0","margin":"20px 0 0"}'>
					<el-button class="btn3" :style='{"border":"0px solid #ccc","cursor":"pointer","padding":"0 10px","margin":"0 10px 0 0","color":"#fff","borderRadius":"4px","background":"#151628","width":"auto","fontSize":"14px","minWidth":"130px","height":"40px"}' type="primary" @click="onUpdateHandler">
						<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","display":"none","height":"40px"}'></span>
						提交
					</el-button>
				</el-form-item>
		</el-form>
	</div>
</template>
<script>
// 校验引入
import { 
	isIntNumer,
	isEmail,
	isMobile,
	checkIdCard,
} from "@/utils/validate";

export default {
	data() {
		return {
			ruleForm: {},
			flag: '',
			usersFlag: false,
			juminxingbieOptions: [],
			juminlouyumingchengOptions: [],
			jumindanyuanhaoOptions: [],
			qishouxingbieOptions: [],
			wuyerenyuanxingbieOptions: [],
			};
		},
		mounted() {
			var table = this.$storage.get("sessionTable");
			this.flag = table;
			this.$http({
				url: `${this.$storage.get("sessionTable")}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {

					this.ruleForm = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.juminxingbieOptions = "男,女".split(',')
			this.$http({
				url: `option/louyumingcheng/louyumingcheng`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.juminlouyumingchengOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.$http({
				url: `option/danyuanhao/danyuanhao`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.jumindanyuanhaoOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.qishouxingbieOptions = "男,女".split(',')
			this.wuyerenyuanxingbieOptions = "男,女".split(',')
		},
		methods: {
		jumintouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		qishoutouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		wuyerenyuantupianUploadChange(fileUrls) {
			this.ruleForm.tupian = fileUrls;
		},
		usersimageUploadChange(fileUrls) {
			this.ruleForm.image = fileUrls;
		},
		onUpdateHandler() {
			if((!this.ruleForm.juminzhanghao)&& 'jumin'==this.flag){
				this.$message.error('居民账号不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'jumin'==this.flag){
				this.$message.error('密码不能为空');
				return
			}







			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}


			if( 'jumin' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}


			if( 'jumin' ==this.flag && this.ruleForm.shenfenzheng&&(!checkIdCard(this.ruleForm.shenfenzheng))){
				this.$message.error(`身份证应输入身份证格式`);
				return
			}








			if( 'jumin' ==this.flag && this.ruleForm.email&&(!isEmail(this.ruleForm.email))){
				this.$message.error(`邮箱应输入邮箱格式`);
				return
			}




			if((!this.ruleForm.qishouzhanghao)&& 'qishou'==this.flag){
				this.$message.error('骑手账号不能为空');
				return
			}


			if((!this.ruleForm.qishouxingming)&& 'qishou'==this.flag){
				this.$message.error('骑手姓名不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'qishou'==this.flag){
				this.$message.error('密码不能为空');
				return
			}



			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}




			if( 'qishou' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}


			if( 'qishou' ==this.flag && this.ruleForm.dianhua&&(!isMobile(this.ruleForm.dianhua))){
				this.$message.error(`电话应输入手机格式`);
				return
			}


			if( 'qishou' ==this.flag && this.ruleForm.email&&(!isEmail(this.ruleForm.email))){
				this.$message.error(`邮箱应输入邮箱格式`);
				return
			}













			if(this.ruleForm.tupian!=null) {
				this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
			}


			if( 'wuyerenyuan' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}




			if('users'==this.flag && this.ruleForm.username.trim().length<1) {
				this.$message.error(`用户名不能为空`);
				return	
			}
			if(this.flag=='users'){
				this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
			}
			this.$http({
				url: `${this.$storage.get("sessionTable")}/update`,
				method: "post",
				data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					if(this.flag=='users'){
						this.$storage.set('headportrait',this.ruleForm.image)
					}
					this.$message({
						message: "修改信息成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							window.location.reload();
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
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
	
	.add-update-preview .el-input /deep/ .el-input__inner {
				border: 2px solid #858181;
				border-radius: 5px;
				padding: 0 12px;
				color: #000;
				width: 50%;
				font-size: 16px;
				height: 40px;
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
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
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
	
	.add-update-preview .btn3 {
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
			}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
