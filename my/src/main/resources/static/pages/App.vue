<template>
	<v-app>
		<v-app-bar app>
			<v-toolbar-title>Sarafan</v-toolbar-title>
			
			<v-spacer></v-spacer>
			{{profile.name}}
			<v-btn icon href="/logout">
        <v-icon>X</v-icon>
      </v-btn>
		</v-app-bar>
		<v-content>
			<div v-if="!profile">Необходимо авторизоваться через <a href="/login">Google</a></div>
			<div>
					<messages-list :messages="messages" />
		  	</div>
		</v-content>

	</v-app>
</template>

<script>
import MessagesList from '../components/messages/MessagesList.vue'
import {addHandler} from 'util/ws'
import {getIndex} from 'util/collections'
import { mdiExitToApp } from '@mdi/js'
export default {
	components: {
		MessagesList
	},
	data() {
		return {
    	messages: frontendData.messages,
			profile: frontendData.profile,
			logout: mdiExitToApp
		}
	},
	created() {
		addHandler(data => {
			let index = getIndex(this.messages, data.id)
			if (index > -1) {
				this.messages.splice(index, 1, data)
			} else {
				this.messages.push(data)
			}
		})
	}
}
</script>

<style>


</style>