INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_ADMIN', 1);

INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_USER', 2);

INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (1, 1);

INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 2);

INSERT INTO `user` (`id`, `username`, `password`, `dateCreated`) VALUES (1,'ironman','iron','2015-11-15');

INSERT INTO `user` (`id`, `username`, `password`, `dateCreated`) VALUES (2,'rabi','rabi','2019-11-25');