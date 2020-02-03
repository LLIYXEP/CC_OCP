<a class="btn btn-primary mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Edit message
  </a>

<div class="collapse <#if message??>show</#if>" id="collapseExample">
	<div class="form-group">
	<form method="post" enctype="multipart/form-data">
			<div class="form-group">
				<input class="form-control ${(textError??)?string('is-invalid', '')}" type="text" name="text" value="<#if message??>${message.text}</#if>"
					placeholder="Введите сообщение" />
					<#if textError??>
					<div class="invalid-feedback">
						${textError}
					</div>
					</#if>
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="tag" placeholder="Тэг" value="<#if message??>${message.tag}</#if>">
				<#if tagError??>
					<div class="invalid-feedback">
						${tagError}
					</div>
					</#if>
			</div>
			<div class="form-group">
				<div class="custom-file">
					<input class="form-control" type="file" id="customFile" name="file">
					<label class="custom-file-label" for="customFile">Choose
						file</label>
				</div>
			</div>
			<div class="form-group">
				<input class="form-control" type="hidden" name="_csrf" value="${_csrf.token}" />
				<input class="form-control" type="hidden" name="id" value="<#if message??>${message.id}</#if>" />
			</div>
			<div class="form-group">
				<button class="btn btn-primary" type="submit">Save Message</button>
			</div>
		</form>
</div>
</div>