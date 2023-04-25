<#include '../master.ftl'/>
<#import '/spring.ftl' as spring/>

<#macro page_title>Регистрация</#macro>
<#macro page_body>
    <form action="/auth/register" method="POST">
        <h3 class="head-text">Регистрация</h3>
        <#if (springMacroRequestContext.getQueryString()?? && springMacroRequestContext.queryString?contains("error"))>
            Ошибка регистрации
        </#if>
        <div class="input-div">
            <label for="username">Логин</label>
            <input type="text" id="username" name="username"/>
        </div>
        <div class="input-div">
            <label for="email">Почта</label>
            <input type="email" id="email" name="email"/>
        </div>
        <div class="input-div">
            <label for="lastName">Фамилия</label>
            <input type="text" id="lastName" name="lastName"/>
        </div>
        <div class="input-div">
            <label for="firstName">Имя</label>
            <input type="text" id="firstName" name="firstName"/>
        </div>
        <div class="input-div">
            <label for="middleName">Отчество</label>
            <input type="text" id="middleName" name="middleName"/>
        </div>
        <div class="input-div">
            <label for="password">Пароль</label>
            <input type="password" id="password" name="password"/>
        </div>
        <button class="confirm" type="submit">
            Зарегистрироваться
        </button>
    </form>
</#macro>

<@show_page/>