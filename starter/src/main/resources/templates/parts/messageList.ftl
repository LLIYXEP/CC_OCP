<#include "security.ftl">
<#import "pager.ftl" as p>

<@p.pager url page />
<div class="card-columns">


<#list page.content as message>
<div class="card my-3" style="width: 18rem;">

	<#if message.fileName??> 
		<img class="img card-img-top" src="/img/${message.fileName}"> 
	</#if>

	<div class="m2">
		<span>${message.text}</span> <br>
		<i>#${message.tag}</i>
	</div>
	
	<div class="card-footer text-muted container">
		<div class="row">
		<a class="col align-self-center" href="/user-messages/${message.author.id}">${message.authorName}</a>
		<a class="col align-self-center" href="#">
			<#if true>
				<i class="far fa-heart">+</i>
			<#else>
				<i class="fas fa-heart">-</i>
			</#if>
		</a>
		<#if message.author.id == currentUserId>
		<a href="/user-messages/${message.author.id}?message=${message.id}" class="col btn btn-primary">Edit</a>
		</#if>
		</div>
	</div>
</div>

<#else> No message 
</#list>
</div>

<@p.pager url page />