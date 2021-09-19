<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Login JavBook</title>
        <link
            rel="icon"
            href="/Javbook/assets/img/icon/Javbook.ico"
            type="image/x-icon"
        />
        <link rel="stylesheet" href="./assets/css/variables.css" />
        <link rel="stylesheet" href="./assets/css/base.css" />
        <link rel="stylesheet" href="./assets/css/style.css" />
    </head>
    <body>
        <header class="header">
            <div class="container">
                <div class="header-main">
                    <a href="#"
                        ><img
                            src="/Javbook/assets/img/logo/Javbook.png"
                            alt="Logo JavBook"
                            class="header__logo"
                    /></a>
                </div>
            </div>
        </header>
        <div class="main">
            <section class="sign-in">
                <div class="container">
                    <div class="sign-in-main">
                        <h1 class="sign-in__title">Sign in to JavBook</h1>
                        <form
                            action="home.html"
                            method="POST"
                            class="sign-in__form"
                        >
                            <!-- autocomplete: off -->
                            <div class="form__input">
                                <label class="form__input-text" for="username"
                                    >Username or email address</label
                                >
                                <input
                                    class="form__input-item"
                                    type="text"
                                    name="username"
                                    id="username"
                                />
                            </div>
                            <div class="form__input">
                                <label class="form__input-text" for="password"
                                    >Password</label
                                >
                                <a href="#" class="form__input-text-more">
                                    Forgot password?</a
                                >
                                <input
                                    class="form__input-item"
                                    type="password"
                                    name="password"
                                    id="password"
                                />
                            </div>
                            <button type="submit" class="btn btn--primary mt-4">
                                Sign in
                            </button>
                        </form>
                        <div class="sign-in__sign-up">
                            New to JavBook?
                            <a href="#" class="sign-in__sign-up-link"
                                >Create an account.</a
                            >
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <footer class="footer">
            <div class="container">
                <div class="footer-main">
                    <ul class="footer-info">
                        <li class="footer-item"><a href="#">Terms</a></li>
                        <li class="footer-item"><a href="#">Privacy</a></li>
                        <li class="footer-item"><a href="#">Security</a></li>
                        <li class="footer-item">
                            <a href="#">Contact JavBook</a>
                        </li>
                    </ul>
                </div>
            </div>
        </footer>
    </body>
</html>
