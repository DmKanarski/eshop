<template>
    <div id="login">
        <form @submit="login">
            <div>
                <label for="l_username">Имя пользователя</label>
                <input id="l_username" type="text" v-model="user.username"/>
            </div>
            <div>
                <label for="l_password">Пароль</label>
                <input id="l_password" type="password" v-model="user.password"/>
            </div>
            <div>
                <input type="submit" value="Войти"/>
            </div>
        </form>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: 'login',
        data() {
             return {
                 user: {
                     username: '',
                     password: ''
                 }
             }
        },
        methods: {
            login: function () {
                axios.post('/auth', {
                    user: this.user
                })
            }
        }
    }
</script>

<style>
    #login {
        position: relative;
        height: 25%;
        width: 50%;
    }
</style>