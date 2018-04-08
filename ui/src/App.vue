<template>
    <div id="app">
        <div id="reister_container">
            <p @click="toggleRegister">Register</p>
            <div id="register_block" v-show="showRegister">
                <register></register>
            </div>
        </div>
        <login></login>
    </div>
</template>

<script>
    import Login from "./Login.vue";
    import Register from "./Register.vue";

    export default {
        name: 'app',
        components: {Register, Login},
        data() {
            return {
                showRegister: false
            }
        },
        methods: {
            toggleRegister: function () {
                this.showRegister = this.showRegister === false;
            }
        }
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }

    h1, h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }
</style>
