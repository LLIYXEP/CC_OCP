<#import "parts/common.ftl" as c> <@c.page>

<div class="form-row">
	<div class="form-group col-md-6">
		<form method="get" action="/main" class="form-inline">
			<input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag">
			<button class="btn btn-primary ml-2" type="submit">Search</button>
		</form>
	</div>
</div>

<a class="btn btn-primary mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new message
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
				<input class="form-control" type="hidden" name="_csrf"
					value="${_csrf.token}" />
			</div>
			<div class="form-group">
				<button class="btn btn-primary" type="submit">Добавить</button>
			</div>
		</form>
</div>
</div>

<!-- <#include "parts/messageEdit.ftl"/> -->

<#include "parts/messageList.ftl"/>

</@c.page>