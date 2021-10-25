<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>About</title>
        <link
            rel="stylesheet"
            href="/Javbook/assets/fonts/fontawesome-5.15.4/css/all.min.css"
        />
        <script
            src="https://kit.fontawesome.com/466439df6f.js"
            crossorigin="anonymous"
        ></script>
        <link rel="stylesheet" href="./assets/css/Common/variables.css" />
        <link rel="stylesheet" href="./assets/css/Common/base.css" />
        <link rel="stylesheet" href="./assets/css/profile/style.css" />
        <link rel="stylesheet" href="common.css" />
        <script src="./assets/js/main.js" async></script>
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="main-container">
            <div class="profile">
                <div class="profile-name-background"></div>
                <div class="profile-avatar">
                    <img
                        src="./assets/image/avatar.jpg"
                        alt=""
                        class="profile-img"
                    />

                    <div class="profile-name">Nguyễn Hoàng Khang</div>
                </div>
                <div class="edit-header-avatar">
                    <label for="header-avatar-file">
                        <i class="fas fa-camera"></i>
                    </label>
                    <input
                        type="file"
                        name="photo-file"
                        id="header-avatar-file"
                        accept="image/* "
                    />
                </div>
                <div class="photo-profile-cover">
                    <div class="edit-cover-img">
                        <label for="header-photo-file">
                            <i class="far fa-edit fa-lg"></i>
                        </label>
                        <input
                            type="file"
                            name="photo-file"
                            id="header-photo-file"
                            accept="image/* "
                        />
                    </div>
                    <img
                        src="https://scontent.fvca1-2.fna.fbcdn.net/v/t1.6435-9/153880781_1269206826834221_640873498255439976_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=e3f864&_nc_ohc=TSfn9YA190wAX-S5rLI&_nc_ht=scontent.fvca1-2.fna&oh=f93eb6f75dc683485e9368c55058ae26&oe=61721FE1"
                        alt=""
                        class="profile-cover"
                    />
                </div>

                <div class="profile-menu">
                    <a class="profile-menu-link active">Post</a>
                    <a class="profile-menu-link">About</a>
                    <a class="profile-menu-link">Friends</a>
                    <a class="profile-menu-link">Photos</a>
                </div>
            </div>
            <div class="timeline">
                <div class="about">
                    <div class="about-main">
                        <nav class="about-nav">
                            <ul class="list">
                                <li
                                    class="list-item active"
                                    data-content-type="Profile"
                                >
                                    <div class="list-item-container">
                                        <span class="icon"
                                            ><i class="far fa-user"></i
                                        ></span>
                                        <span class="title">Profile</span>
                                    </div>
                                </li>
                                <li
                                    class="list-item"
                                    data-content-type="Password"
                                >
                                    <div class="list-item-container">
                                        <span class="icon"
                                            ><i class="fas fa-lock"></i
                                        ></span>
                                        <span class="title">Password</span>
                                    </div>
                                </li>
                                <li
                                    class="list-item"
                                    data-content-type="Setting"
                                >
                                    <div class="list-item-container">
                                        <span class="icon"
                                            ><i class="fas fa-cog"></i
                                        ></span>
                                        <span class="title">Setting</span>
                                    </div>
                                </li>
                            </ul>
                        </nav>
                        <div class="about-content">
                            <div class="profile-main">
                                <ul class="list">
                                    <li class="list-item">
                                        <div class="icon">
                                            <i class="fas fa-briefcase"></i>
                                        </div>
                                        <div class="list-item-content">
                                            Studies at
                                            <input
                                                disabled
                                                class="edit-text"
                                                type="text"
                                                value="Đại Học FPT Cần Thơ"
                                            />
                                        </div>
                                        <div
                                            class="
                                                edit-icon
                                                js-edit-select-audience
                                            "
                                            data-select-audience-type="Global"
                                        >
                                            <i class="fas fa-globe-asia"></i>
                                        </div>
                                        <div class="edit-icon js-edit-text-btn">
                                            <i class="fas fa-pen"></i>
                                            <i class="fas fa-check"></i>
                                        </div>
                                    </li>
                                    <li class="list-item">
                                        <div class="icon">
                                            <i
                                                class="fas fa-map-marker-alt"
                                            ></i>
                                        </div>
                                        <div class="list-item-content">
                                            Live in
                                            <input
                                                disabled
                                                class="edit-text"
                                                type="text"
                                                value="Bạc Liêu"
                                            />
                                        </div>
                                        <div
                                            class="
                                                edit-icon
                                                js-edit-select-audience
                                            "
                                            data-select-audience-type="Global"
                                        >
                                            <i class="fas fa-globe-asia"></i>
                                        </div>
                                        <div class="edit-icon js-edit-text-btn">
                                            <i class="fas fa-pen"></i>
                                            <i class="fas fa-check"></i>
                                        </div>
                                    </li>
                                    <li class="list-item">
                                        <div class="icon">
                                            <i class="fas fa-birthday-cake"></i>
                                        </div>
                                        <div class="list-item-content">
                                            Birthday on
                                            <input
                                                disabled
                                                class="edit-text"
                                                type="date"
                                                value="2001-09-08"
                                            />
                                        </div>
                                        <div
                                            class="
                                                edit-icon
                                                js-edit-select-audience
                                            "
                                            data-select-audience-type="Global"
                                        >
                                            <i class="fas fa-globe-asia"></i>
                                        </div>
                                        <div class="edit-icon js-edit-text-btn">
                                            <i class="fas fa-pen"></i>
                                            <i class="fas fa-check"></i>
                                        </div>
                                    </li>
                                    <li class="list-item">
                                        <div class="icon">
                                            <i class="fas fa-user"></i>
                                        </div>
                                        <div class="list-item-content">
                                            <input
                                                disabled
                                                class="
                                                    edit-text
                                                    js-gender-value
                                                "
                                                type="text"
                                                value="Male"
                                            />
                                        </div>
                                        <div
                                            class="
                                                edit-icon
                                                js-edit-select-audience
                                            "
                                        >
                                            <i class="fas fa-globe-asia"></i>
                                        </div>
                                        <div
                                            class="edit-icon js-edit-gender-btn"
                                        >
                                            <i class="fas fa-pen"></i>
                                        </div>
                                        <div class="modal modal-gender">
                                            <div class="modal__overlay"></div>
                                            <div class="modal__body">
                                                <div
                                                    class="
                                                        modal__body-container
                                                    "
                                                >
                                                    <div class="modal__header">
                                                        <h3
                                                            class="modal__title"
                                                        >
                                                            Select gender
                                                        </h3>
                                                        <div
                                                            class="modal__close"
                                                        >
                                                            <i
                                                                class="
                                                                    modal__close-icon
                                                                    fas
                                                                    fa-times
                                                                "
                                                            ></i>
                                                        </div>
                                                    </div>
                                                    <div class="choices">
                                                        <label
                                                            class="choice-item"
                                                        >
                                                            <div
                                                                class="
                                                                    choice-item-icon
                                                                "
                                                            >
                                                                <i
                                                                    class="
                                                                        fas
                                                                        fa-mars
                                                                    "
                                                                ></i>
                                                            </div>
                                                            <div
                                                                class="
                                                                    choice-item-text
                                                                "
                                                            >
                                                                <h3
                                                                    class="
                                                                        title
                                                                    "
                                                                >
                                                                    Male
                                                                </h3>
                                                                <p
                                                                    class="
                                                                        content
                                                                    "
                                                                >
                                                                    Are you
                                                                    interested
                                                                    in girls?
                                                                </p>
                                                            </div>
                                                            <div
                                                                class="
                                                                    radio-btn
                                                                "
                                                            >
                                                                <input
                                                                    data-select-gender-order="1"
                                                                    type="radio"
                                                                    name="select-gender"
                                                                    id=""
                                                                    class="
                                                                        js-select-gender-input
                                                                    "
                                                                />
                                                            </div>
                                                        </label>
                                                        <label
                                                            class="choice-item"
                                                        >
                                                            <div
                                                                class="
                                                                    choice-item-icon
                                                                "
                                                            >
                                                                <i
                                                                    class="
                                                                        fas
                                                                        fa-venus
                                                                    "
                                                                ></i>
                                                            </div>
                                                            <div
                                                                class="
                                                                    choice-item-text
                                                                "
                                                            >
                                                                <h3
                                                                    class="
                                                                        title
                                                                    "
                                                                >
                                                                    Female
                                                                </h3>
                                                                <p
                                                                    class="
                                                                        content
                                                                    "
                                                                >
                                                                    Are you
                                                                    interested
                                                                    in boys?
                                                                </p>
                                                            </div>
                                                            <div
                                                                class="
                                                                    radio-btn
                                                                "
                                                            >
                                                                <input
                                                                    data-select-gender-order="2"
                                                                    type="radio"
                                                                    name="select-gender"
                                                                    id=""
                                                                    class="
                                                                        js-select-gender-input
                                                                    "
                                                                />
                                                            </div>
                                                        </label>
                                                        <label
                                                            class="choice-item"
                                                        >
                                                            <div
                                                                class="
                                                                    choice-item-icon
                                                                "
                                                            >
                                                                <i
                                                                    class="
                                                                        fas
                                                                        fa-user-secret
                                                                    "
                                                                ></i>
                                                            </div>
                                                            <div
                                                                class="
                                                                    choice-item-text
                                                                "
                                                            >
                                                                <h3
                                                                    class="
                                                                        title
                                                                    "
                                                                >
                                                                    Others
                                                                </h3>
                                                                <p
                                                                    class="
                                                                        content
                                                                    "
                                                                >
                                                                    Secret!
                                                                </p>
                                                            </div>
                                                            <div
                                                                class="
                                                                    radio-btn
                                                                "
                                                            >
                                                                <input
                                                                    data-select-gender-order="3"
                                                                    type="radio"
                                                                    name="select-gender"
                                                                    id=""
                                                                    class="
                                                                        js-select-gender-input
                                                                    "
                                                                />
                                                            </div>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="list-item">
                                        <div class="icon">
                                            <i class="fas fa-mobile-alt"></i>
                                        </div>
                                        <div class="list-item-content">
                                            <input
                                                disabled
                                                class="edit-text"
                                                type="text"
                                                value="0857817812"
                                            />
                                        </div>
                                        <div
                                            class="
                                                edit-icon
                                                js-edit-select-audience
                                            "
                                            data-select-audience-type="Global"
                                        >
                                            <i class="fas fa-globe-asia"></i>
                                        </div>
                                        <div class="edit-icon js-edit-text-btn">
                                            <i class="fas fa-pen"></i>
                                            <i class="fas fa-check"></i>
                                        </div>
                                    </li>
                                    <li class="list-item">
                                        <div class="icon">
                                            <i class="fas fa-heart"></i>
                                        </div>
                                        <div class="list-item-content">
                                            <input
                                                disabled
                                                class="
                                                    edit-text
                                                    js-status-value
                                                "
                                                type="text"
                                                value="Married"
                                            />
                                        </div>
                                        <div
                                            class="
                                                edit-icon
                                                js-edit-select-audience
                                            "
                                        >
                                            <i class="fas fa-globe-asia"></i>
                                        </div>
                                        <div
                                            class="edit-icon js-edit-status-btn"
                                        >
                                            <i class="fas fa-pen"></i>
                                        </div>
                                        <div class="modal modal-status">
                                            <div class="modal__overlay"></div>
                                            <div class="modal__body">
                                                <div
                                                    class="
                                                        modal__body-container
                                                    "
                                                >
                                                    <div class="modal__header">
                                                        <h3
                                                            class="modal__title"
                                                        >
                                                            Select status
                                                        </h3>
                                                        <div
                                                            class="modal__close"
                                                        >
                                                            <i
                                                                class="
                                                                    modal__close-icon
                                                                    fas
                                                                    fa-times
                                                                "
                                                            ></i>
                                                        </div>
                                                    </div>
                                                    <div class="choices">
                                                        <label
                                                            class="choice-item"
                                                        >
                                                            <div
                                                                class="
                                                                    choice-item-icon
                                                                "
                                                            >
                                                                <i
                                                                    class="
                                                                        fas
                                                                        fa-heart
                                                                    "
                                                                ></i>
                                                            </div>
                                                            <div
                                                                class="
                                                                    choice-item-text
                                                                "
                                                            >
                                                                <h3
                                                                    class="
                                                                        title
                                                                    "
                                                                >
                                                                    Married
                                                                </h3>
                                                                <p
                                                                    class="
                                                                        content
                                                                    "
                                                                >
                                                                    Don't flirt
                                                                    with me!
                                                                </p>
                                                            </div>
                                                            <div
                                                                class="
                                                                    radio-btn
                                                                "
                                                            >
                                                                <input
                                                                    data-select-status-order="1"
                                                                    type="radio"
                                                                    name="select-status"
                                                                    id=""
                                                                    class="
                                                                        js-select-status-input
                                                                    "
                                                                />
                                                            </div>
                                                        </label>
                                                        <label
                                                            class="choice-item"
                                                        >
                                                            <div
                                                                class="
                                                                    choice-item-icon
                                                                "
                                                            >
                                                                <i
                                                                    class="
                                                                        fas
                                                                        fa-heart-broken
                                                                    "
                                                                ></i>
                                                            </div>
                                                            <div
                                                                class="
                                                                    choice-item-text
                                                                "
                                                            >
                                                                <h3
                                                                    class="
                                                                        title
                                                                    "
                                                                >
                                                                    Single
                                                                </h3>
                                                                <p
                                                                    class="
                                                                        content
                                                                    "
                                                                >
                                                                    Need a true
                                                                    love!
                                                                </p>
                                                            </div>
                                                            <div
                                                                class="
                                                                    radio-btn
                                                                "
                                                            >
                                                                <input
                                                                    data-select-status-order="2"
                                                                    type="radio"
                                                                    name="select-status"
                                                                    id=""
                                                                    class="
                                                                        js-select-status-input
                                                                    "
                                                                />
                                                            </div>
                                                        </label>
                                                        <label
                                                            class="choice-item"
                                                        >
                                                            <div
                                                                class="
                                                                    choice-item-icon
                                                                "
                                                            >
                                                                <i
                                                                    class="
                                                                        fas
                                                                        fa-question
                                                                    "
                                                                ></i>
                                                            </div>
                                                            <div
                                                                class="
                                                                    choice-item-text
                                                                "
                                                            >
                                                                <h3
                                                                    class="
                                                                        title
                                                                    "
                                                                >
                                                                    Others
                                                                </h3>
                                                                <p
                                                                    class="
                                                                        content
                                                                    "
                                                                >
                                                                    Secret!
                                                                </p>
                                                            </div>
                                                            <div
                                                                class="
                                                                    radio-btn
                                                                "
                                                            >
                                                                <input
                                                                    data-select-status-order="3"
                                                                    type="radio"
                                                                    name="select-status"
                                                                    id=""
                                                                    class="
                                                                        js-select-status-input
                                                                    "
                                                                />
                                                            </div>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <!-- Modal layout -->
                                <div class="modal modal-select-audience">
                                    <div class="modal__overlay"></div>
                                    <div class="modal__body">
                                        <div class="modal__body-container">
                                            <div class="modal__header">
                                                <h3 class="modal__title">
                                                    Select audience
                                                </h3>
                                                <div class="modal__close">
                                                    <i
                                                        class="
                                                            modal__close-icon
                                                            fas
                                                            fa-times
                                                        "
                                                    ></i>
                                                </div>
                                            </div>
                                            <div class="choices">
                                                <label class="choice-item">
                                                    <div
                                                        class="choice-item-icon"
                                                    >
                                                        <i
                                                            class="
                                                                fas
                                                                fa-globe-asia
                                                            "
                                                        ></i>
                                                    </div>
                                                    <div
                                                        class="choice-item-text"
                                                    >
                                                        <h3 class="title">
                                                            Public
                                                        </h3>
                                                        <p class="content">
                                                            Anyone on or off
                                                            Javbook
                                                        </p>
                                                    </div>
                                                    <div class="radio-btn">
                                                        <input
                                                            checked
                                                            data-select-audience-order="1"
                                                            type="radio"
                                                            name="select-audience"
                                                            id=""
                                                            class="
                                                                js-select-audience-input
                                                            "
                                                        />
                                                    </div>
                                                </label>
                                                <label class="choice-item">
                                                    <div
                                                        class="choice-item-icon"
                                                    >
                                                        <i
                                                            class="
                                                                fas
                                                                fa-user-friends
                                                            "
                                                        ></i>
                                                    </div>
                                                    <div
                                                        class="choice-item-text"
                                                    >
                                                        <h3 class="title">
                                                            Friends
                                                        </h3>
                                                        <p class="content">
                                                            Your friends on
                                                            Javbook
                                                        </p>
                                                    </div>
                                                    <div class="radio-btn">
                                                        <input
                                                            data-select-audience-order="2"
                                                            type="radio"
                                                            name="select-audience"
                                                            id=""
                                                            class="
                                                                js-select-audience-input
                                                            "
                                                        />
                                                    </div>
                                                </label>
                                                <label class="choice-item">
                                                    <div
                                                        class="choice-item-icon"
                                                    >
                                                        <i
                                                            class="fas fa-lock"
                                                        ></i>
                                                    </div>
                                                    <div
                                                        class="choice-item-text"
                                                    >
                                                        <h3 class="title">
                                                            Only me
                                                        </h3>
                                                        <p class="content">
                                                            Don't show to anyone
                                                        </p>
                                                    </div>
                                                    <div class="radio-btn">
                                                        <input
                                                            data-select-audience-order="3"
                                                            type="radio"
                                                            name="select-audience"
                                                            id=""
                                                            class="
                                                                js-select-audience-input
                                                            "
                                                        />
                                                    </div>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="password-main">
                                <ul class="list">
                                    <li class="list-item">
                                        <div class="icon">
                                            <i class="fas fa-key"></i>
                                        </div>
                                        <div class="list-item-content password">
                                            Password
                                            <input
                                                disabled
                                                class="edit-text"
                                                type="password"
                                                value="********************"
                                            />
                                        </div>
                                        <div
                                            class="
                                                list-item-content
                                                edit-password
                                            "
                                        >
                                            <div class="edit-password-item">
                                                Current Password
                                                <input
                                                    class="edit-text active"
                                                    type="password"
                                                    value=""
                                                />
                                            </div>
                                            <div class="edit-password-item">
                                                New Password
                                                <input
                                                    class="edit-text active"
                                                    type="password"
                                                    value=""
                                                />
                                            </div>
                                            <div class="edit-password-item">
                                                New Password
                                                <input
                                                    class="edit-text active"
                                                    type="password"
                                                    value=""
                                                />
                                            </div>
                                        </div>
                                        <div
                                            class="
                                                edit-icon
                                                js-edit-password-btn
                                            "
                                        >
                                            <i class="fas fa-pen"></i>
                                            <i class="fas fa-check"></i>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="setting-main">
                                <ul class="list">
                                    <li class="list-item">
                                        <div class="icon">
                                            <i class="fas fa-adjust"></i>
                                        </div>
                                        <div class="list-item-content">
                                            Dark Mode
                                        </div>
                                        <div class="dark-mode">
                                            <input
                                                class="dark-mode-btn"
                                                type="checkbox"
                                                name=""
                                                id=""
                                            />
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="main.js"></script>
    </body>
</html>
