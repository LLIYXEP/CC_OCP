<#import "parts/common.ftl" as c> 
<@c.page>

<h3>${userChanel.username}</h3>

<#if !isCurrentUser>
	<#if isSubscriber>
		<a class="btn btn-info" href="/user/unsubscribe/${userChanel.id}">Unsubscribe</a>
		<#else>
		<a class="btn btn-info" href="/user/subscribe/${userChanel.id}">Subscribe</a>
	</#if>
</#if>

</br>
</br>

<div class="container">
	<div class="row">
		<div class="col">
			<div class="card">
				<div class="card-body">
				    <div class="card-title">Subscriptions</div>
				    <div class="card-text">
				    	<a href="/user/subscriptions/${userChanel.id}/list">${subscriptionsCount}</a>
				    </div>
				 </div>
			</div>
		</div>
		<div class="col">
			<div class="card">
				<div class="card-body">
				    <div class="card-title">Subscribers</div>
				    <div class="card-text">
				    	<a href="/user/subscribers/${userChanel.id}/list">${subscribersCount}</a>
				    </div>
				 </div>
			</div>
		</div>
	</div>
</div>

</br>

<#if isCurrentUser>
<#include "parts/messageEdit.ftl"/>
</#if>

<#include "parts/messageList.ftl"/>


</@c.page>