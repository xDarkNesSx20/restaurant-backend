CREATE TYPE Role AS ENUM (
    'ADMIN',
    'COOKER',
    'WAITER',
    'DELIVER',
    'CASHIER',
    'CUSTOMER'
    );

CREATE TYPE WeekDays AS ENUM (
    'MONDAY',
    'TUESDAY',
    'WEDNESDAY',
    'THURSDAY',
    'FRIDAY',
    'SATURDAY',
    'SUNDAY'
    );

CREATE TYPE TableType AS ENUM (
    'INSIDE',
    'OUTSIDE',
    'SALOON'
    );

CREATE TYPE ProductCategory AS ENUM (
    'ENTRANCE',
    'MAIN_DISH',
    'DESSERT',
    'DRINK'
    );

CREATE TYPE PaymentMethod AS ENUM (
    'CASH',
    'CARD',
    'TRANSFER',
    'QR'
    );

CREATE TYPE OrderType AS ENUM (
    'TO_EAT_HERE',
    'TO_TAKEOUT',
    'BOOKED'
    );

CREATE TYPE OrderStatus AS ENUM (
    'CONFIRMED',
    'COOKING',
    'READY',
    'GIVEN',
    'CANCELLED'
    );

CREATE TYPE BookingStatus AS ENUM (
    'PENDING',
    'CONFIRMED',
    'ON_GOING',
    'COMPLETED',
    'CANCELLED',
    'NO_SHOWED'
    );

CREATE TYPE PromotionType AS ENUM (
    'ONE_PRODUCT',
    'TWO_PRODUCT',
    'TOTAL'
    );

CREATE TYPE ReviewType AS ENUM (
    'ORDER',
    'PRODUCT',
    'EMPLOYEE_SERVICE',
    'RESTAURANT',
    'SOFTWARE'
    );

CREATE TABLE users
(
    id            BIGSERIAL PRIMARY KEY,
    public_id     VARCHAR(16) UNIQUE NOT NULL,
    name          VARCHAR            NOT NULL,
    last_name     VARCHAR            NOT NULL,
    email         VARCHAR     UNIQUE NOT NULL,
    password_hash VARCHAR(16)        NOT NULL,
    phone         VARCHAR(15) UNIQUE,
    dni_number    VARCHAR(10) UNIQUE NOT NULL,
    created_at    TIMESTAMP          NOT NULL,
    active        BOOLEAN            NOT NULL DEFAULT TRUE,
    role          Role               NOT NULL,
    profile_photo_url TEXT
);

CREATE TABLE bookings
(
    id         BIGSERIAL PRIMARY KEY,
    public_id  VARCHAR(16) UNIQUE NOT NULL,
    user_id    BIGINT             NOT NULL,
    order_id   BIGINT             NOT NULL,
    date       DATE               NOT NULL,
    start_hour TIME               NOT NULL,
    end_hour   TIME,
    num_people INTEGER            NOT NULL,
    status     BookingStatus      NOT NULL,
    note       TEXT,
    created_at TIMESTAMP          NOT NULL,
    CONSTRAINT fk_user_bookings FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_order_bookings FOREIGN KEY (order_id) REFERENCES orders (id)
);

CREATE TABLE orders
(
    id             BIGSERIAL PRIMARY KEY,
    public_id      VARCHAR(16) UNIQUE NOT NULL,
    user_id        BIGINT             NOT NULL,
    created_at     TIMESTAMP          NOT NULL,
    status         OrderStatus        NOT NULL,
    type           OrderType          NOT NULL,
    total          DECIMAL(10, 2)     NOT NULL,
    payment_method PaymentMethod      NOT NULL,
    paid           BOOLEAN            NOT NULL DEFAULT FALSE,
    note           TEXT,
    CONSTRAINT fk_user_orders FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE order_items
(
    id         BIGSERIAL PRIMARY KEY,
    order_id   BIGINT          NOT NULL,
    product_id BIGINT          NOT NULL,
    amount     INTEGER         NOT NULL,
    unit_price DECIMAL(8, 2)   NOT NULL,
    subtotal   DECIMAL(10, 2)  NOT NULL,
    note       TEXT,
    CONSTRAINT fk_order_order_items FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk_order_items_product FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE products
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR UNIQUE  NOT NULL,
    slug        VARCHAR UNIQUE  NOT NULL,
    description TEXT,
    price       DECIMAL(8, 2)   NOT NULL,
    available   BOOLEAN         NOT NULL DEFAULT TRUE,
    category    ProductCategory NOT NULL,
    photo_url   TEXT NOT NULL
);

CREATE TABLE booking_tables
(
    booking_id BIGINT NOT NULL,
    table_id   BIGINT NOT NULL,
    PRIMARY KEY (booking_id, table_id),
    CONSTRAINT fk_booking_booking_tables FOREIGN KEY (booking_id) REFERENCES bookings (id),
    CONSTRAINT fk_table_booking_tables FOREIGN KEY (table_id) REFERENCES tables (id)
);

CREATE TABLE tables
(
    id       BIGSERIAL PRIMARY KEY,
    type     TableType NOT NULL,
    number   INTEGER   NOT NULL,
    capacity INTEGER   NOT NULL,
    active   BOOLEAN   NOT NULL DEFAULT TRUE
);

CREATE TABLE promotions
(
    id               bigserial PRIMARY KEY,
    public_id        VARCHAR(16) UNIQUE NOT NULL,
    code             VARCHAR     UNIQUE NOT NULL,
    name             VARCHAR            NOT NULL,
    description      TEXT,
    discount_percent INTEGER            NOT NULL,
    start_at         TIMESTAMP          NOT NULL,
    end_at           TIMESTAMP          NOT NULL,
    active           BOOLEAN            NOT NULL DEFAULT TRUE,
    type             PromotionType      NOT NULL
);

CREATE TABLE reviews
(
    id                 BIGSERIAL PRIMARY KEY,
    public_id          VARCHAR(16) UNIQUE NOT NULL,
    user_id            BIGINT             NOT NULL,
    rating             SMALLINT           NOT NULL,
    comment            TEXT,
    created_at         TIMESTAMP          NOT NULL,
    admin_answer       TEXT,
    answered_at        TIMESTAMP,
    type               ReviewType         NOT NULL,
    entity_reviewed_id VARCHAR,
    CONSTRAINT fk_user_reviews FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE review_photos
(
    review_id BIGINT NOT NULL,
    photo_url TEXT   NOT NULL,
    PRIMARY KEY (review_id, photo_url),
    CONSTRAINT fk_review_review_photos FOREIGN KEY (review_id) REFERENCES reviews (id)
);

CREATE TABLE configs
(
    key   VARCHAR PRIMARY KEY,
    value VARCHAR NOT NULL
);

CREATE TABLE employees
(
    id       BIGSERIAL PRIMARY KEY,
    user_id  BIGINT          NOT NULL,
    hired_at DATE            NOT NULL,
    salary   DECIMAL(9, 2)   NOT NULL,
    active   BOOLEAN         NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_user_employee FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE turns
(
    id          BIGSERIAL PRIMARY KEY,
    employee_id BIGINT   NOT NULL,
    start_hour  TIME     NOT NULL,
    end_hour    TIME     NOT NULL,
    day         WeekDays NOT NULL,
    CONSTRAINT fk_employee_turns FOREIGN KEY (employee_id) REFERENCES employees (id)
);

CREATE TABLE order_tables
(
    order_id BIGINT NOT NULL,
    table_id BIGINT NOT NULL,
    PRIMARY KEY (order_id, table_id),
    CONSTRAINT fk_order_order_table FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT fk_table_order_tables FOREIGN KEY (table_id) REFERENCES tables (id)
);