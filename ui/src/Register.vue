<template>
    <div id="register">
        <form @submit="register">
            <label for="r_username">Имя пользователя</label>
            <input id="r_username" type="text" v-model="user.username"/>
            <label for="r_password">Пароль</label>
            <input id="r_password" type="password" v-model="user.password"/>
            <label for="r_password_confirmation">Повторите пароль</label>
            <input id="r_password_confirmation" type="password" v-model="user.passwordConfirmation"/>
            <input type="submit" value="Войти"/>
        </form>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: 'register',
        data() {
             return {
                 user: {
                     username: '',
                     password: '',
                     passwordConfirmation: ''
                 }
             }
        },
        methods: {
            register: function () {
                axios.post('/user', {
                    user: this.user
                })
            }
        }
    }
</script>

<style>
    #register label {
        float: left;
    }
    #register input {
        display: block;
    }
</style>