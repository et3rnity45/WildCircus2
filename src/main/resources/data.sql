INSERT INTO `user` VALUES
(1, 'admin@gmail.com', '$2a$10$KMlIdTThJPcd5chekN60TuWOs2EQWUsAkHO/DDKUAi8Y.G0fkm7hm', 'ADMIN', 'admin');

INSERT INTO `presentation` VALUES
(1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tellus massa, laoreet feugiat mauris consequat, fringilla consectetur massa. Aenean eu dapibus sem, id volutpat nibh. Nam in mauris nec purus imperdiet laoreet. Curabitur sed molestie sem. Donec vel tellus eu metus consequat molestie ut in leo. Donec lorem augue, rutrum vel tellus nec, posuere ultrices turpis. Phasellus nulla nunc, ornare eget consectetur eget, euismod vitae orci. Interdum et malesuada fames ac ante ipsum primis in faucibus. Mauris malesuada mauris eget eleifend semper. Curabitur lobortis, risus in laoreet fringilla, odio ante placerat nunc, ut sagittis felis neque ut tellus. Aliquam tempus dui eu erat lacinia, dapibus ultrices ligula mattis. Nulla facilisi. Duis sed massa feugiat, tristique velit quis, lacinia enim. Donec dui orci, varius porta tincidunt a, ullamcorper vitae magna. Interdum et malesuada fames ac ante ipsum primis in faucibus.', '/img/presentationPicture/picture1.webp', 'Titre premier'),
(2, 'Maecenas id est quis tellus tristique rhoncus. Aenean nec aliquet sapien. Nunc in est imperdiet, venenatis quam non, bibendum libero. Vivamus sollicitudin mattis nulla in ullamcorper. Proin iaculis pulvinar molestie. In magna eros, bibendum at mattis et, sodales ac augue. Morbi facilisis justo et elit vehicula, ac congue erat laoreet. Curabitur lobortis lacinia odio, ac elementum elit rhoncus non. Phasellus quis lacinia elit, aliquam tincidunt neque. Duis nec hendrerit lorem, sed tristique sapien. In et est scelerisque, tempor quam in, egestas turpis. Quisque ornare, lacus vitae facilisis lobortis, purus ipsum mattis nulla, ut cursus tortor quam id ante. Proin rutrum, risus et placerat mattis, metus lacus faucibus purus, id placerat elit urna ac dui. Quisque et fermentum mi.', '/img/presentationPicture/picture2.jpg', 'Titre second'),
(3, 'Nunc ac leo sed nisi volutpat efficitur sit amet at arcu. Proin et justo velit. Morbi malesuada ipsum et nibh aliquet, sit amet tempor ipsum tristique. Morbi eu mi ac tortor venenatis euismod at ac nunc. Integer vitae elit suscipit, convallis justo id, venenatis arcu. Ut at nisl gravida, convallis est eu, scelerisque tellus. Pellentesque at viverra sapien. Sed nec metus suscipit, venenatis libero at, pretium est. Cras posuere felis ligula, vitae congue purus congue id. Nunc id sollicitudin libero. Proin ac blandit odio. Etiam efficitur ex commodo velit pretium, luctus fringilla felis ullamcorper.', '/img/presentationPicture/picture3.webp', 'Titre tertiaire');

INSERT INTO `galery` VALUES
(1, '/img/galery/galery1.jpg', 'Image 1'),
(2, '/img/galery/galery2.jpg', 'Image 2'),
(3, '/img/galery/galery3.jpg', 'Image 3'),
(4, '/img/galery/galery4.jpg', 'Image 4'),
(5, '/img/galery/galery5.jpg', 'Image 5'),
(6, '/img/galery/galery6.jpg', 'Image 6'),
(7, '/img/galery/galery7.jpg', 'Image 7'),
(8, '/img/galery/galery8.jpg', 'Image 8'),
(9, '/img/galery/galery9.jpg', 'Image 9'),
(10, '/img/galery/galery10.jpg', 'Image 10'),
(11, '/img/galery/galery11.jpg', 'Image 11');

INSERT INTO `message` VALUES
(1, 'Exemple de message', '2020-01-23 17:08:55', 'xyz@gmail.com', 'Quentin Liger'),
(2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tellus massa, laoreet feugiat mauris consequat.', '2020-01-06 07:54:24', 'exemple@gmail.com', 'Eleou Jeanne');

INSERT INTO `representation` VALUES
(1,'2020-02-24 21:00:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tellus massa, laoreet feugiat mauris consequat.','/img/shows/show_first.jpg',120,'Spectacle acrobates'),
(2,'2020-02-06 20:00:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tellus massa, laoreet feugiat mauris consequat.','/img/shows/show_second.jpg',1,'Show mensuel'),
(3,'2020-01-25 20:30:00','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tellus massa, laoreet feugiat mauris consequat.','/img/shows/show_third.jpg',60,'Spectacle de lions'),
(4,'2020-02-25 19:30:00','Suspendisse potenti. Nullam ac eros nec risus mollis tincidunt sollicitudin at est. Cras venenatis dapibus sem et varius. Etiam finibus aliquet magna, ut commodo turpis blandit convallis. Nam condimentum sit amet dolor in ultrices. Nam volutpat viverra justo eu varius. Curabitur quis bibendum tellus.','/img/shows/les_wilders.webp',25,'Les Wilders'),
(5,'2020-02-20 14:00:00','Suspendisse potenti. Nullam ac eros nec risus mollis tincidunt sollicitudin at est. Cras venenatis dapibus sem et varius. Etiam finibus aliquet magna, ut commodo turpis blandit convallis. Nam condimentum sit amet dolor in ultrices. Nam volutpat viverra justo eu varius. Curabitur quis bibendum tellus.','/img/shows/la_vie_du_cirque.jpg',120,'La vie du cirque'),
(6,'2020-02-22 23:00:00','Nam sollicitudin est nisi, eget dapibus enim aliquam at. Fusce placerat posuere finibus. Quisque maximus porttitor arcu non pulvinar. Donec at diam quis felis feugiat volutpat. Donec eu risus id ligula ullamcorper gravida.','/img/shows/spectacle_nocture.jpg',80,'Spectacle nocture');