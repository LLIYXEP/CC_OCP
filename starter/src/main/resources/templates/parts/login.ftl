<#macro login path isRegisterForm>

<form action="${path}" method="post">
    <div class="form-group row">
    	<label class="col-sm-2 col-form-label" for="username"> User Name : </label>
    	<div  class="col-sm-6">
    		<input class="form-control ${(usernameError??)?string('is-invalid', '')}" value="<#if user??>${user.username}</#if>" type="text" name="username" id="username" placeholder="User name"/>
    		<#if usernameError??>
				<div class="invalid-feedback">
					${usernameError}
				</div>
			</#if>
    	</div>
    </div>
    <div class="form-group row">
    	<label for="password" class="col-sm-2 col-form-label"> Password: </label>
    	<div  class="col-sm-6">
    		<input class="form-control ${(passwordError??)?string('is-invalid', '')}" id="password" type="password" name="password" placeholder="Password"/>
    		<#if passwordError??>
				<div class="invalid-feedback">
					${passwordError}
				</div>
			</#if>
    	</div>
    </div>
    <#if isRegisterForm>
     <div class="form-group row">
    	<label for="password" class="col-sm-2 col-form-label"> Password: </label>
    	<div  class="col-sm-6">
    		<input class="form-control ${(password2Error??)?string('is-invalid', '')}" id="password2" type="password" name="password2" placeholder="Retype password"/>
    		<#if password2Error??>
				<div class="invalid-feedback">
					${password2Error}
				</div>
			</#if>
    	</div>
    </div>
    <div class="form-group row">
    	<label for="email" class="col-sm-2 col-form-label"> Email: </label>
    	<div  class="col-sm-6">
    		<input class="form-control ${(emailError??)?string('is-invalid', '')}" value="<#if user??>${user.email}</#if>" id="email" type="email" name="email" placeholder="some@some.com"/>
    		<#if emailError??>
				<div class="invalid-feedback">
					${emailError}
				</div>
			</#if>
    	</div>
    </div>
    
    <div class="col-sm-6">
	      <div class="g-recaptcha" data-sitekey="6LcvSrwUAAAAAHDnxfrIHfXvg_IdPoRk4gWLvtpY"></div>
	      <br/>
	    <#if captchaError??>
			<div class="alert alert-danger" role="alert">
				${captchaError}
			</div>
		</#if>
    </div>
    </#if>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm><a href="/registration">Add new user</a></#if>
    <button type="submit" class="btn btn-primary" style="margin-top: 20px;"><#if isRegisterForm>Create<#else>Sign In</#if></button>
</form>

</#macro>

<#macro logout>
	<form action="/logout" method="post">
    	<input type="hidden" name="_csrf" value="${_csrf.token}" />
    	<button type="submit" class="btn btn-primary" ><#if user??> Sign Out<#else>Log in</#if></button>
	</form>
</#macro>