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
        <link
            rel="stylesheet"
            href="/Javbook/assets/fonts/fontawesome-5.15.4/css/all.min.css"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/variables.css"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/common/base.css"
        />
        <link
            rel="stylesheet"
            href="/Javbook/assets/css/login/login.css"
        />
    </head>
    <body>
        <header class="header">
            <div class="container">
                <div class="header-main">
                    <a href="#"
                        ><img
                            src="/Javbook/assets/img/logo/Javbook_white.png"
                            alt="Logo JavBook"
                            class="header__logo"
                    /></a>
                </div>
            </div>
        </header>
        <div class="main">
            <section class="sisu">
                <div class="container">
                    <div class="container-form">
                        <div id="sign-in" class="sisu-main">
                            <h1 class="sisu__title">Sign in to Javbook</h1>
                            <form
                                action="home.html"
                                method="POST"
                                class="sisu__form"
                            >
                                <!-- autocomplete: off -->
                                <div class="form__input">
                                    <label
                                        class="form__input-text"
                                        for="sign-in-username"
                                        >Username or email address</label
                                    >
                                    <div class="form__input-item">
                                        <input
                                            class="form__input-input"
                                            type="text"
                                            name="username"
                                            id="sign-in-username"
                                        />
                                    </div>
                                </div>
                                <div class="form__input">
                                    <label
                                        class="form__input-text"
                                        for="sign-in-password"
                                        >Password</label
                                    >
                                    <a href="#" class="form__input-text-more">
                                        Forgot password?</a
                                    >
                                    <div class="form__input-item">
                                        <input
                                            class="form__input-input"
                                            type="password"
                                            name="password"
                                            id="sign-in-password"
                                            autocomplete="off"
                                        />
                                        <span
                                            class="
                                                form__input-item-toggle-password
                                                js-sign-in-toggle-pass-btn
                                            "
                                        >
                                            <i class="far fa-eye"></i>
                                        </span>
                                    </div>
                                </div>
                                <label class="form__input-item-text">
                                    <input
                                        type="checkbox"
                                        name="remember-password"
                                        class="input-checkbox"
                                    />
                                    Remember password in 30 days.
                                </label>
                                <button
                                    type="submit"
                                    class="btn btn--primary mt-4"
                                >
                                    Sign in
                                </button>
                            </form>
                            <div class="sisu__sign-up">
                                New to JavBook?
                                <a
                                    href="#"
                                    class="sisu__sign-up-link"
                                    id="js-display-signup"
                                    >Create an account.</a
                                >
                            </div>
                        </div>
                        <div id="sign-up" class="sisu-main">
                            <h1 class="sisu__title">Sign up to JavBook</h1>
                            <form
                                action="home.html"
                                method="POST"
                                class="sisu__form"
                            >
                                <!-- autocomplete: off -->
                                <div class="form__input">
                                    <label
                                        class="form__input-text"
                                        for="sign-up-username"
                                        >Username or email address</label
                                    >
                                    <div class="form__input-item">
                                        <input
                                            class="form__input-input"
                                            type="text"
                                            name="username"
                                            id="sign-up-username"
                                            onkeyup="checkUsername()"
                                        />
                                    </div>
                                </div>
                                <div class="form__input">
                                    <label
                                        class="form__input-text"
                                        for="sign-up-password"
                                        >Password</label
                                    >
                                    <div class="form__input-item">
                                        <input
                                            class="form__input-input"
                                            type="password"
                                            name="password"
                                            id="sign-up-password"
                                            autocomplete="off"
                                            onkeyup="checkPassword()"
                                        />
                                        <span
                                            class="
                                                form__input-item-toggle-password
                                                js-sign-up-toggle-pass-btn
                                            "
                                        >
                                            <i class="far fa-eye"></i>
                                        </span>
                                    </div>
                                </div>
                                <div class="form__input">
                                    <label
                                        class="form__input-text"
                                        for="sign-up-repassword"
                                        >Repassword</label
                                    >
                                    <div class="form__input-item">
                                        <input
                                            class="form__input-input"
                                            type="password"
                                            name="password"
                                            id="sign-up-repassword"
                                            autocomplete="off"
                                            onkeyup="checkConfirmPassword()"
                                        />
                                        <span
                                            class="
                                                form__input-item-toggle-password
                                                js-sign-up-toggle-pass-btn
                                            "
                                        >
                                            <i class="far fa-eye"></i>
                                        </span>
                                    </div>
                                </div>
                                <label class="form__input-item-text">
                                    <input
                                        type="checkbox"
                                        name="agree-condition"
                                        class="input-checkbox"
                                    />
                                    I agree all terms & conditions.
                                </label>
                                <button
                                    type="submit"
                                    class="btn btn--primary mt-4"
                                >
                                    Sign up
                                </button>
                            </form>
                            <div class="sisu__sign-up">
                                Already have an account?
                                <a
                                    href="#"
                                    class="sisu__sign-up-link"
                                    id="js-display-signin"
                                    >Sign in</a
                                >
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <!-- <footer class="footer">
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
        </footer> -->
        <!-- Author: Le Huu Thang -->
        <footer>
            <div class="container">
                <div class="links">
                    <h1>Javbook</h1>
                    <ul>
                        <li class="footer-item"><a href="#">Privacy</a></li>
                        <li class="footer-item"><a href="#">Terms</a></li>
                        <li class="footer-item"><a href="#">About</a></li>
                        <li class="footer-item"><a href="#">Services</a></li>
                        <li class="footer-item"><a href="#">Contact Us</a></li>
                    </ul>
                </div>
                <!-- <div class="about">
                    <h2>Stay in touch</h2>
                    <ul class="social-icon">
                        <li>
                            <a href=""><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href=""><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href=""><i class="fa fa-instagram"></i></a>
                        </li>
                        <li>
                            <a href=""><i class="fa fa-youtube"></i></a>
                        </li>
                    </ul>
                </div> -->
            </div>
            <div class="copyright">
                <p class="mb-0">
                    <small>&copy; <b>JavaBook</b>. All Rights Reserved.</small>
                </p>
            </div>
        </footer>
        <script src="/Javbook/assets/js/login/toggleDisplayPassword.js"></script>
        <script src="/Javbook/assets/js/login/toggleDisplaySISU.js"></script>
        <script src="/Javbook/assets/js/login/checkValidationForm.js"></script>
    </body>
</html>
