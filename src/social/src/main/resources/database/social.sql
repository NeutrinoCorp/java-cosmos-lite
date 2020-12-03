/*
*   Application: Cosmos Lite - Social Context
*   Author: A. Ruiz
*   Date: 12-2-2020
*/

-- * Users module * --
CREATE TABLE IF NOT EXISTS users (
    id varchar(128) NOT NULL,
    username varchar(128) NOT NULL UNIQUE, -- Immutable username
    display_name varchar(256) NOT NULL, -- Mutable username
    name varchar(128) DEFAULT NULL,
    surname varchar(128) DEFAULT NULL,
    bio varchar(256) DEFAULT NULL,
    picture varchar(2048) DEFAULT NULL,
    create_time timestamp without time zone DEFAULT (now() at time zone 'utc'),
    update_time timestamp without time zone DEFAULT (now() at time zone 'utc'),
    active boolean DEFAULT true,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_friend_requests (
    user_id varchar(128) NOT NULL,
    requester_id varchar(128) NOT NULL,
    approved boolean DEFAULT false,
    request_time timestamp without time zone DEFAULT (now() at time zone 'utc'),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_requester FOREIGN KEY (requester_id) REFERENCES users(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, requester_id)
);

CREATE TABLE IF NOT EXISTS user_friends (
    user_id varchar(128) NOT NULL,
    friend_id varchar(128) NOT NULL,
    add_time timestamp without time zone DEFAULT (now() at time zone 'utc'),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_friend FOREIGN KEY (friend_id) REFERENCES users(id) ON DELETE CASCADE,
    PRIMARY KEY(user_id, friend_id)
);

CREATE TABLE IF NOT EXISTS user_total_friends (
    user_id varchar(128) NOT NULL,
    total_friends bigint DEFAULT 0,
    last_friend_time timestamp without time zone DEFAULT (now() at time zone 'utc'),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS user_removal_request_queue (
    user_id varchar(128) NOT NULL,
    remove_time timestamp without time zone DEFAULT ((now() + INTERVAL '30 day') at time zone 'utc'),
    active boolean DEFAULT true,
	CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
	PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS friends_group (
    id varchar(128) NOT NULL,
    host_id varchar(128) NOT NULL,
    display_name varchar(128) NOT NULL,
    description varchar(256) DEFAULT NULL,
    picture varchar(2048) DEFAULT NULL,
    create_time timestamp without time zone DEFAULT (now() at time zone 'utc'),
    update_time timestamp without time zone DEFAULT (now() at time zone 'utc')
    CONSTRAINT fk_host FOREIGN KEY (host_id) REFERENCES users(id) ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS friends_group_members (
    group_id varchar(128) NOT NULL,
    member_id varchar(128) NOT NULL,
    add_time timestamp without time zone DEFAULT (now() at time zone 'utc'),
    CONSTRAINT fk_group FOREIGN KEY (group_id) REFERENCES friends_group(id) ON DELETE CASCADE,
    CONSTRAINT fk_member FOREIGN KEY (member_id) REFERENCES users(id) ON DELETE CASCADE,
    PRIMARY KEY (group_id, member_id)
);
