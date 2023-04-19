<#include '../master.ftl'>

<#macro page_title>Вход</#macro>
<#macro page_body>
    <form action="/auth/login" method="POST">
        <h3 class="head-text">Вход</h3>
        <#if (springMacroRequestContext.getQueryString()?? && springMacroRequestContext.queryString?contains("error"))>
            Ошибка входа
        </#if>
        <div class="input-div">
            <label for="username">Логин</label>
            <input type="text" id="username" name="username"/>
        </div>
        <div class="input-div">
            <label for="password">Пароль</label>
            <input type="password" id="password" name="password"/>
        </div>
        <button class="confirm" type="submit">
            Войти
        </button>
    </form>
</#macro>

<@show_page/>