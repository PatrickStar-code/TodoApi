CREATE TABLE tb_todo (
    id SERIAL PRIMARY KEY ,
    title VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    date TIMESTAMP NOT NULL,
    description TEXT NOT NULL,
    priority INT NOT NULL,
    category VARCHAR(255) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    user_id BIGINT,
    CONSTRAINT fk_todo_user FOREIGN KEY (user_id) REFERENCES tb_user(id)
);
