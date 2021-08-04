INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$12$R1DM3GHNhtUL1S2yNNifV.oK/J8Vq1lFtMNrIljxNSzkX7xQ.um5u');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'lred@gmail.com', '$2a$12$JMDlrXizES.3D/AkMIP8B.P0FlN.KavpImBSfCB5N4bpOQP2qj4gG');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,2);
