package com.neymeha.mypetgame.interact;

import com.neymeha.mypetgame.shapes.Ball;
import com.neymeha.mypetgame.shapes.Block;
import com.neymeha.mypetgame.shapes.EventBall;
import com.neymeha.mypetgame.shapes.Paddle;

public class Collision {
//    public static void checkCollision(Ball ball, Paddle paddle) {
//        if (ball.x-ball.size<paddle.x+paddle.width  &&  ball.x + ball.size>paddle.x  &&
//                ball.y-ball.size<paddle.y+paddle.height  &&  ball.y+ball.size>paddle.y)
//        {
//            if ((paddle.x<ball.x+ball.size  &&  paddle.y+paddle.height<ball.y-ball.size)  ||
//                (paddle.x+paddle.width<ball.x-ball.size  &&  paddle.y+paddle.height<ball.y-ball.size))
//            {
//                ball.xSpeed=-ball.xSpeed;
//            } else {
//                ball.ySpeed=-ball.ySpeed;
//            }
//        }
//    }
//public static void checkCollision(Ball ball, Paddle paddle) {
//if ( ball.x-ball.size<=paddle.x+paddle.width  &&  ball.x+ball.size>=paddle.x  &&  ball.y-ball.size<=paddle.y+paddle.height  &&  ball.y+ball.size>=paddle.y ) {
//    if ((ball.y - ball.size <= paddle.y + paddle.height && ball.y + ball.size >= paddle.y) &&
//            (ball.x - ball.size <= paddle.x + paddle.width && ball.x + ball.size >= paddle.x) &&
//            (ball.x - ball.size >= paddle.x && ball.x + ball.size <= paddle.x + paddle.width) &&
//            (ball.x >= paddle.x && ball.x <= paddle.x + paddle.width)) {
//        ball.ySpeed = -ball.ySpeed;
//    }
//    if ((ball.x - ball.size <= paddle.x + paddle.width && ball.x + ball.size >= paddle.x) &&
//            (ball.y - ball.size <= paddle.y + paddle.height && ball.y + ball.size >= paddle.y) &&
//            (ball.y - ball.size >= paddle.y && ball.y + ball.size <= paddle.y + paddle.height) &&
//            (ball.y >= paddle.y && ball.y <= paddle.y + paddle.height)) {
//        ball.xSpeed = -ball.xSpeed;
//    }
//}
//}
//
//    public static void checkCollision(Ball ball, Block block) {
//    if ( ball.x-ball.size<=block.x+block.width  &&  ball.x+ball.size>=block.x  &&  ball.y-ball.size<=block.y+block.height  &&  ball.y+ball.size>=block.y ) {
//
//        if ((ball.y - ball.size <= block.y + block.height && ball.y + ball.size >= block.y) &&
//                (ball.x - ball.size <= block.x + block.width && ball.x + ball.size >= block.x) &&
//                (ball.x - ball.size >= block.x && ball.x + ball.size <= block.x + block.width) &&
//                (ball.x >= block.x && ball.x <= block.x + block.width)) {
//            ball.ySpeed = -ball.ySpeed;
//            block.destroyed = true;
//        }
//        if ((ball.x - ball.size <= block.x + block.width && ball.x + ball.size >= block.x) &&
//                (ball.y - ball.size <= block.y + block.height && ball.y + ball.size >= block.y) &&
//                (ball.y - ball.size >= block.y && ball.y + ball.size <= block.y + block.height) &&
//                (ball.y >= block.y && ball.y <= block.y + block.height)) {
//            ball.xSpeed = -ball.xSpeed;
//            block.destroyed = true;
//        }
////        if ((ball.x+ball.size>block.x && ball.x-ball.size<block.x && ball.y+ball.size>block.y && ball.y-ball.size<block.y) ||
////            (ball.x+ball.size>block.x && ball.x-ball.size<block.x && ball.y+ball.size>block.y+block.height && ball.y-ball.size<block.y+block.height) ||
////            (ball.x+ball.size>block.x+block.height && ball.x-ball.size<block.x+block.height && ball.y+ball.size>block.y+block.height && ball.y-ball.size<block.y+block.height) ||
////            (ball.x+ball.size>block.x+block.height && ball.x-ball.size<block.x+block.height && ball.y+ball.size>block.y && ball.y-ball.size<block.y))
////        {
////            ball.xSpeed=-ball.xSpeed;
////            ball.ySpeed=-ball.ySpeed;
////            block.destroyed=true;
////        }
//    }
//    }

//    public static void checkCollision(Ball ball, Paddle paddle) {
//        if (ball.x-ball.size<=paddle.x+paddle.width && ball.x+ball.size>= paddle.x && ball.y-ball.size<=paddle.y+paddle.height && ball.y+ball.size>=paddle.y) {
//            if (ball.y>paddle.y+paddle.height || ball.y<paddle.y) {
//                ball.ySpeed=-ball.ySpeed;return;
//            }
//            if (ball.x>paddle.x+paddle.width || ball.x<paddle.x) {
//                ball.xSpeed=-ball.xSpeed;return;
//            }
//        }
//    }
//
//    public static void checkCollision(Ball ball, Block block) {
//        if (ball.x-ball.size<=block.x+block.width && ball.x+ball.size>=block.x && ball.y-ball.size<=block.y+block.height && ball.y+ball.size>=block.y) {
//            if (((ball.y>block.y+block.height && ball.y-ball.size<block.y+block.height)) || (ball.y<block.y && ball.y+ball.size>block.y) && (ball.x<block.x+block.width || ball.x>block.x)) {
//                ball.ySpeed=-ball.ySpeed;
//                block.destroyed=true;
//                return;
//            }
//            if ((ball.x>block.x+block.width || ball.x<block.x) && (ball.y<block.y+block.height || ball.y>block.y)) {
//                ball.xSpeed=-ball.xSpeed;
//                block.destroyed=true;
//                return;
//            }
//        }
//    }

//    static double wz=0; // переменная для вычисления колличества делений для изменения скорости шара на гранях
//    static int j=0; // переменная начала отсчета в петле для поиска места соприкосновения
//    static int i=0; // переменная принимающая в себя скорость для ее дальнейшего изменения с учетом места соприкосновения
//
//    public static void checkCollision(Ball ball, Paddle paddle) {
//        if((ball.x+ball.size>=ball.x-ball.nx && ball.x+ball.size<paddle.x+ball.nx
//                && ball.y+ball.size>=ball.y-ball.nx && ball.y+ball.size<paddle.y+ball.nx
//                && ball.xSpeed>0 && ball.ySpeed>0) ||
//                (ball.x+ball.size>=paddle.x-ball.nx && ball.x+ball.size<paddle.x+ball.nx
//                        && ball.y-ball.size>=paddle.y+paddle.height-ball.nx && ball.y-ball.size<paddle.y+paddle.height+ball.nx
//                        && ball.xSpeed>0 && ball.ySpeed<0) ||
//                (ball.x-ball.size>=paddle.x+paddle.width-ball.nx && ball.x-ball.size<paddle.x+paddle.width+ball.nx
//                        && ball.y-ball.size>=paddle.y+paddle.height-ball.nx && ball.y-ball.size<paddle.y+paddle.height+ball.nx
//                        && ball.xSpeed<0 && ball.ySpeed<0) ||
//                (ball.x-ball.size>=paddle.x+paddle.width-ball.nx && ball.x-ball.size<paddle.x+paddle.width+ball.nx
//                        && ball.y+ball.size>=ball.y-ball.nx && ball.y+ball.size<paddle.y+ball.nx
//                        && ball.xSpeed<0 && ball.ySpeed>0))
//        {
//            // если шар соприкоснулся он отталкивается в противоположном направлении блок разрушается метод заканчивает работу
//            ball.xSpeed=-ball.xSpeed;
//            ball.ySpeed=-ball.ySpeed;
//            return;
//        }
//
//
//        // условие соприкосновение шара с левой гранью с помощью nx
//        if (ball.x+ball.size<=paddle.x+ball.nx && ball.x+ball.size>paddle.x-ball.nx
//                && ball.y<paddle.height+paddle.y-ball.nx && ball.y>=paddle.y+ball.nx)
//        {
//            // условие соприкосновения шара с нижней частью левой грани блока
//            if (ball.y>=paddle.y+ball.nx && ball.y<(paddle.y+paddle.height)/2)
//            {
//                // вычисляем колличество делений на которое разобьем нижнюю левую грань
//                wz=((paddle.height+paddle.y)/2-(paddle.y+ball.nx))/ball.xSpeed;
//                // петля перебора и нахождения пространства столкновения шара и блока
//                for (j=(paddle.y+paddle.height)/2, i=ball.xSpeed; j>paddle.y+ball.nx+wz; j-=wz)
//                {
//                    // условие нахождения пространства соприкосновения с дальнейшим изменением вектора скорости
//                    // уничтожением блока и окончанием работой метода
//                    if (ball.y>=j-wz && ball.y<j) {ball.xSpeed=-i;return;}
//                    // если условие не сработало узменяем присваеваемую скорость изменения вектора скорости
//                    else if (ball.xSpeed>0) {i--;} else if (ball.xSpeed<0) {i++;}
//                }
//                // условие соприкосновения шара с верхней частью левой грани блока, далее повторяем
//                // те же действия для части левой верхней грани
//            } else if (ball.y>=(paddle.y+paddle.height)/2 && ball.y<paddle.y+paddle.height-ball.nx)
//            {
//                wz=((paddle.y+paddle.height-ball.nx)-(paddle.height+paddle.y)/2)/ball.xSpeed;
//                for (j=(paddle.y+paddle.height)/2, i=ball.xSpeed; j<paddle.y+paddle.height-ball.nx-wz; j+=wz)
//                {
//                    if (ball.y>=j && ball.y<j+wz) {ball.xSpeed=-i;return;}
//                    else if (ball.xSpeed>0) {i--;} else if (ball.xSpeed<0) {i++;}
//                }
//            }
//        }
//
//
//        // условия для соприкосновения с верхней гранью блока, повторяем алгоритм с учетом того что это верхняя грань
//        // сначала вычисляем правую потом левую
//        if (ball.x>=paddle.x+ball.nx && ball.x<paddle.x+paddle.width-ball.nx
//                && ball.y-ball.size>paddle.y+paddle.height-ball.nx && ball.y-ball.size<=paddle.y+paddle.height+ball.nx)
//        {
//            if (ball.x>=paddle.x+ball.nx && ball.x<(paddle.x+paddle.width)/2)
//            {
//                wz=((paddle.x+paddle.width)/2-(paddle.x+ball.nx))/ball.ySpeed;
//                for (j=(paddle.width+paddle.x)/2, i=ball.ySpeed; j>paddle.x+ball.nx; j-=wz)
//                {
//                    if (ball.x>=j-wz && ball.x<j) {ball.ySpeed=-i;return;}
//                    else if (ball.ySpeed>0) {i--;} else if (ball.ySpeed<0) {i++;}
//                }
//            } else if (ball.y>=(paddle.x+paddle.width)/2 && ball.x<paddle.x+paddle.width-ball.nx)
//            {
//                wz=((paddle.x+paddle.width-ball.nx)-(paddle.x+paddle.width)/2)/ball.ySpeed;
//                for (j=(paddle.width+paddle.x)/2, i=ball.ySpeed; j<paddle.x+paddle.width-ball.nx; j+=wz)
//                {
//                    if (ball.x>=j && ball.x<j+wz) {ball.ySpeed=-i;return;}
//                    else if (ball.ySpeed>0) {i--;} else if (ball.ySpeed<0) {i++;}
//                }
//            }
//        }
//
//        // условие соприкосновение шара с правой гранью с помощью nx
//        if (ball.x-ball.size<=paddle.x+paddle.width+ball.nx && ball.x-ball.size>paddle.x+paddle.width-ball.nx
//                && ball.y<paddle.height+paddle.y-ball.nx && ball.y>=paddle.y+ball.nx)
//        {
//            // условие соприкосновения шара с нижней частью правой грани блока
//            if (ball.y>=paddle.y+ball.nx && ball.y<(paddle.y+paddle.height)/2)
//            {
//                // вычисляем колличество делений на которое разобьем нижнюю правую грань
//                wz=((paddle.height+paddle.y)/2-(paddle.y+ball.nx))/ball.xSpeed;
//                // петля перебора и нахождения пространства столкновения шара и блока
//                for (j=(paddle.y+paddle.height)/2, i=ball.xSpeed; j>paddle.y+ball.nx+wz; j-=wz)
//                {
//                    // условие нахождения пространства соприкосновения с дальнейшим изменением вектора скорости
//                    // уничтожением блока и окончанием работой метода
//                    if (ball.y>=j-wz && ball.y<j) {ball.xSpeed=-i;return;}
//                    // если условие не сработало узменяем присваеваемую скорость изменения вектора скорости
//                    else if (ball.xSpeed>0) {i--;} else if (ball.xSpeed<0) {i++;}
//                }
//                // условие соприкосновения шара с верхней частью правой грани блока, далее повторяем
//                // те же действия для части правой верхней грани
//            } else if (ball.y>=(paddle.y+paddle.height)/2 && ball.y<paddle.y+paddle.height-ball.nx)
//            {
//                wz=((paddle.y+paddle.height-ball.nx)-(paddle.height+paddle.y)/2)/ball.xSpeed;
//                for (j=(paddle.y+paddle.height)/2, i=ball.xSpeed; j<paddle.y+paddle.height-ball.nx-wz; j+=wz)
//                {
//                    if (ball.y>=j && ball.y<j+wz) {ball.xSpeed=-i;return;}
//                    else if (ball.xSpeed>0) {i--;} else if (ball.xSpeed<0) {i++;}
//                }
//            }
//        }
//
//        // условия для соприкосновения с верхней гранью блока, повторяем алгоритм с учетом того что это верхняя грань
//        // сначала вычисляем правую потом левую
//        if (ball.x>=paddle.x+ball.nx && ball.x<paddle.x+paddle.width-ball.nx
//                && ball.y+ball.size>paddle.y-ball.nx && ball.y+ball.size<=paddle.y+ball.nx)
//        {
//            if (ball.x>=paddle.x+ball.nx && ball.x<(paddle.x+paddle.width)/2)
//            {
//                wz=((paddle.x+paddle.width)/2-(paddle.x+ball.nx))/ball.ySpeed;
//                for (j=(paddle.width+paddle.x)/2, i=ball.ySpeed; j>paddle.x+ball.nx; j-=wz)
//                {
//                    if (ball.x>=j-wz && ball.x<j) {ball.ySpeed=-i;return;}
//                    else if (ball.ySpeed>0) {i--;} else if (ball.ySpeed<0) {i++;}
//                }
//            } else if (ball.y>=(paddle.x+paddle.width)/2 && ball.x<paddle.x+paddle.width-ball.nx)
//            {
//                wz=((paddle.x+paddle.width-ball.nx)-(paddle.x+paddle.width)/2)/ball.ySpeed;
//                for (j=(paddle.width+paddle.x)/2, i=ball.ySpeed; j<paddle.x+paddle.width-ball.nx; j+=wz)
//                {
//                    if (ball.x>=j && ball.x<j+wz) {ball.ySpeed=-i;return;}
//                    else if (ball.ySpeed>0) {i--;} else if (ball.ySpeed<0) {i++;}
//                }
//            }
//        }
//    }
//
//
//    public static void checkCollision(Ball ball, Block block) {
//        // вычисляем пространство соприкосновение шара с блоком на углах (с помощью nx)
//        // условия идут по очереди по часовой стрелке от левого нижнего угла
//        if((ball.x+ball.size>=ball.x-ball.nx && ball.x+ball.size<block.x+ball.nx
//            && ball.y+ball.size>=ball.y-ball.nx && ball.y+ball.size<block.y+ball.nx
//            && ball.xSpeed>0 && ball.ySpeed>0) ||
//           (ball.x+ball.size>=block.x-ball.nx && ball.x+ball.size<block.x+ball.nx
//            && ball.y-ball.size>=block.y+block.height-ball.nx && ball.y-ball.size<block.y+block.height+ball.nx
//            && ball.xSpeed>0 && ball.ySpeed<0) ||
//           (ball.x-ball.size>=block.x+block.width-ball.nx && ball.x-ball.size<block.x+block.width+ball.nx
//            && ball.y-ball.size>=block.y+block.height-ball.nx && ball.y-ball.size<block.y+block.height+ball.nx
//            && ball.xSpeed<0 && ball.ySpeed<0) ||
//           (ball.x-ball.size>=block.x+block.width-ball.nx && ball.x-ball.size<block.x+block.width+ball.nx
//            && ball.y+ball.size>=ball.y-ball.nx && ball.y+ball.size<block.y+ball.nx
//            && ball.xSpeed<0 && ball.ySpeed>0))
//        {
//            // если шар соприкоснулся он отталкивается в противоположном направлении блок разрушается метод заканчивает работу
//            ball.xSpeed=-ball.xSpeed;
//            ball.ySpeed=-ball.ySpeed;
//            block.destroyed=true;
//            return;
//        }
//
//
//        // условие соприкосновение шара с левой гранью с помощью nx
//        if (ball.x+ball.size<=block.x+ball.nx && ball.x+ball.size>block.x-ball.nx
//            && ball.y<block.height+block.y-ball.nx && ball.y>=block.y+ball.nx)
//        {
//            // условие соприкосновения шара с нижней частью левой грани блока
//            if (ball.y>=block.y+ball.nx && ball.y<(block.y+block.height)/2)
//            {
//                // вычисляем колличество делений на которое разобьем нижнюю левую грань
//                wz=((block.height+block.y)/2-(block.y+ball.nx))/ball.xSpeed;
//                // петля перебора и нахождения пространства столкновения шара и блока
//                for (j=(block.y+block.height)/2, i=ball.xSpeed; j>block.y+ball.nx+wz; j-=wz)
//                {
//                    // условие нахождения пространства соприкосновения с дальнейшим изменением вектора скорости
//                    // уничтожением блока и окончанием работой метода
//                    if (ball.y>=j-wz && ball.y<j) {ball.xSpeed=-i;block.destroyed=true;return;}
//                    // если условие не сработало узменяем присваеваемую скорость изменения вектора скорости
//                    else if (ball.xSpeed>0) {i--;} else if (ball.xSpeed<0) {i++;}
//                }
//            // условие соприкосновения шара с верхней частью левой грани блока, далее повторяем
//            // те же действия для части левой верхней грани
//            } else if (ball.y>=(block.y+block.height)/2 && ball.y<block.y+block.height-ball.nx)
//            {
//                wz=((block.y+block.height-ball.nx)-(block.height+block.y)/2)/ball.xSpeed;
//                for (j=(block.y+block.height)/2, i=ball.xSpeed; j<block.y+block.height-ball.nx-wz; j+=wz)
//                {
//                    if (ball.y>=j && ball.y<j+wz) {ball.xSpeed=-i;block.destroyed=true;return;}
//                    else if (ball.xSpeed>0) {i--;} else if (ball.xSpeed<0) {i++;}
//                }
//            }
//        }
//
//
//        // условия для соприкосновения с верхней гранью блока, повторяем алгоритм с учетом того что это верхняя грань
//        // сначала вычисляем правую потом левую
//        if (ball.x>=block.x+ball.nx && ball.x<block.x+block.width-ball.nx
//            && ball.y-ball.size>block.y+block.height-ball.nx && ball.y-ball.size<=block.y+block.height+ball.nx)
//        {
//            if (ball.x>=block.x+ball.nx && ball.x<(block.x+block.width)/2)
//            {
//                wz=((block.x+block.width)/2-(block.x+ball.nx))/ball.ySpeed;
//                for (j=(block.width+block.x)/2, i=ball.ySpeed; j>block.x+ball.nx; j-=wz)
//                {
//                    if (ball.x>=j-wz && ball.x<j) {ball.ySpeed=-i;block.destroyed=true;return;}
//                    else if (ball.ySpeed>0) {i--;} else if (ball.ySpeed<0) {i++;}
//                }
//            } else if (ball.y>=(block.x+block.width)/2 && ball.x<block.x+block.width-ball.nx)
//            {
//                wz=((block.x+block.width-ball.nx)-(block.x+block.width)/2)/ball.ySpeed;
//                for (j=(block.width+block.x)/2, i=ball.ySpeed; j<block.x+block.width-ball.nx; j+=wz)
//                {
//                    if (ball.x>=j && ball.x<j+wz) {ball.ySpeed=-i;block.destroyed=true;return;}
//                    else if (ball.ySpeed>0) {i--;} else if (ball.ySpeed<0) {i++;}
//                }
//            }
//        }
//
//        // условие соприкосновение шара с правой гранью с помощью nx
//        if (ball.x-ball.size<=block.x+block.width+ball.nx && ball.x-ball.size>block.x+block.width-ball.nx
//                && ball.y<block.height+block.y-ball.nx && ball.y>=block.y+ball.nx)
//        {
//            // условие соприкосновения шара с нижней частью правой грани блока
//            if (ball.y>=block.y+ball.nx && ball.y<(block.y+block.height)/2)
//            {
//                // вычисляем колличество делений на которое разобьем нижнюю правую грань
//                wz=((block.height+block.y)/2-(block.y+ball.nx))/ball.xSpeed;
//                // петля перебора и нахождения пространства столкновения шара и блока
//                for (j=(block.y+block.height)/2, i=ball.xSpeed; j>block.y+ball.nx+wz; j-=wz)
//                {
//                    // условие нахождения пространства соприкосновения с дальнейшим изменением вектора скорости
//                    // уничтожением блока и окончанием работой метода
//                    if (ball.y>=j-wz && ball.y<j) {ball.xSpeed=-i;block.destroyed=true;return;}
//                    // если условие не сработало узменяем присваеваемую скорость изменения вектора скорости
//                    else if (ball.xSpeed>0) {i--;} else if (ball.xSpeed<0) {i++;}
//                }
//                // условие соприкосновения шара с верхней частью правой грани блока, далее повторяем
//                // те же действия для части правой верхней грани
//            } else if (ball.y>=(block.y+block.height)/2 && ball.y<block.y+block.height-ball.nx)
//            {
//                wz=((block.y+block.height-ball.nx)-(block.height+block.y)/2)/ball.xSpeed;
//                for (j=(block.y+block.height)/2, i=ball.xSpeed; j<block.y+block.height-ball.nx-wz; j+=wz)
//                {
//                    if (ball.y>=j && ball.y<j+wz) {ball.xSpeed=-i;block.destroyed=true;return;}
//                    else if (ball.xSpeed>0) {i--;} else if (ball.xSpeed<0) {i++;}
//                }
//            }
//        }
//
//        // условия для соприкосновения с верхней гранью блока, повторяем алгоритм с учетом того что это верхняя грань
//        // сначала вычисляем правую потом левую
//        if (ball.x>=block.x+ball.nx && ball.x<block.x+block.width-ball.nx
//                && ball.y+ball.size>block.y-ball.nx && ball.y+ball.size<=block.y+ball.nx)
//        {
//            if (ball.x>=block.x+ball.nx && ball.x<(block.x+block.width)/2)
//            {
//                wz=((block.x+block.width)/2-(block.x+ball.nx))/ball.ySpeed;
//                for (j=(block.width+block.x)/2, i=ball.ySpeed; j>block.x+ball.nx; j-=wz)
//                {
//                    if (ball.x>=j-wz && ball.x<j) {ball.ySpeed=-i;block.destroyed=true;return;}
//                    else if (ball.ySpeed>0) {i--;} else if (ball.ySpeed<0) {i++;}
//                }
//            } else if (ball.y>=(block.x+block.width)/2 && ball.x<block.x+block.width-ball.nx)
//            {
//                wz=((block.x+block.width-ball.nx)-(block.x+block.width)/2)/ball.ySpeed;
//                for (j=(block.width+block.x)/2, i=ball.ySpeed; j<block.x+block.width-ball.nx; j+=wz)
//                {
//                    if (ball.x>=j && ball.x<j+wz) {ball.ySpeed=-i;block.destroyed=true;return;}
//                    else if (ball.ySpeed>0) {i--;} else if (ball.ySpeed<0) {i++;}
//                }
//            }
//        }
//
//    }

//    public static int ballPosition;
//
//    public static void detectBallForPaddle(Ball ball, Paddle paddle) {
//        float ballBoundary=paddle.x;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=1;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=2;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=3;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=4;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=5;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=6;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=7;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=8;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=9;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=10;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=11;}
//        ballBoundary=ballBoundary+paddle.devision;
//        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.devision) {Collision.ballPosition=12;}
//    }
//
//    public static void checkCollision(Ball ball, Paddle paddle) {
//
//        if (ball.x-ball.size<paddle.x+paddle.width && ball.x+ball.size> paddle.x && ball.y-ball.size<paddle.y+paddle.height && ball.y+ball.size>paddle.y) {
//            if (ball.y>paddle.y+paddle.height+ball.ySpeed) {
//
//                detectBallForPaddle(ball,paddle);
//                double speed=ball.xSpeed/4;
//
//                if (ball.xSpeed>0) {
//                    switch (ballPosition) {
//                        case 1: ball.xSpeed=-ball.xSpeed;break;
//                        case 2: break;
//                        case 3: ball.xSpeed=ball.xSpeed-speed;break;
//                        case 4: ball.xSpeed=ball.xSpeed-speed*2;break;
//                        case 5: ball.xSpeed=ball.xSpeed-speed*3;break;
//                        case 6:
//                        case 7: ball.xSpeed=ball.xSpeed-speed*4;break;
//                        case 8: ball.xSpeed=ball.xSpeed+speed;break;
//                        case 9: ball.xSpeed=ball.xSpeed+speed*2;break;
//                        case 10: ball.xSpeed=ball.xSpeed+speed*3;break;
//                        case 11:
//                        case 12: ball.xSpeed=ball.xSpeed+speed*4;break;
//                    }
//                } else if (ball.xSpeed<0) {
//                    switch (ballPosition) {
//                        case 1:
//                        case 2: ball.xSpeed=ball.xSpeed+speed*4;break;
//                        case 3: ball.xSpeed=ball.xSpeed+speed*3;break;
//                        case 4: ball.xSpeed=ball.xSpeed+speed*2;break;
//                        case 5: ball.xSpeed=ball.xSpeed+speed;break;
//                        case 6:
//                        case 7: ball.xSpeed=ball.xSpeed-speed*4;break;
//                        case 8: ball.xSpeed=ball.xSpeed-speed*3;break;
//                        case 9: ball.xSpeed=ball.xSpeed-speed*2;break;
//                        case 10: ball.xSpeed=ball.xSpeed-speed;break;
//                        case 11: break;
//                        case 12: ball.xSpeed=-ball.xSpeed;break;
//                    }
//                } else if (ball.xSpeed==0){
//                    switch (ballPosition) {
//                        case 1: ball.xSpeed-=5;break;
//                        case 2: ball.xSpeed-=4;break;
//                        case 3: ball.xSpeed-=3;break;
//                        case 4: ball.xSpeed-=2;break;
//                        case 5: ball.xSpeed-=1;break;
//                        case 6:
//                        case 7: break;
//                        case 8: ball.xSpeed+=1;break;
//                        case 9: ball.xSpeed+=2;break;
//                        case 10: ball.xSpeed+=3;break;
//                        case 11: ball.xSpeed+=4;break;
//                        case 12:ball.xSpeed+=5;break;
//                    }
//                }
//                ball.ySpeed=-ball.ySpeed;
//            }
//            if (ball.x<paddle.x-ball.xSpeed || ball.x>paddle.x+paddle.width+ball.xSpeed) {
//                ball.xSpeed=-ball.xSpeed;
//            }
//        }
//
//    }
//
//    public static void checkCollision(Ball ball, Block block) {
//        if (ball.x-ball.size<block.x+block.width && ball.x+ball.size>block.x && ball.y-ball.size<block.y+block.height && ball.y+ball.size>block.y) {
//            if (ball.y>block.y-ball.ySpeed || ball.y<block.y+ball.ySpeed) {
//                block.destroyed=true;
//                ball.ySpeed=-ball.ySpeed;
//            }
//            if (ball.x<block.x-ball.xSpeed || ball.x>block.x+block.width+ball.xSpeed) {
//                block.destroyed=true;
//                ball.xSpeed=-ball.xSpeed;
//            }
//        }
//    }

    public static int ballPosition;

    public static void detectBallForPaddle(Ball ball, Paddle paddle) {
        float ballBoundary=paddle.x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=1;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=2;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=3;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=4;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=5;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=6;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=7;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=8;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=9;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=10;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=11;}
        ballBoundary=ballBoundary+paddle.division_x;
        if (ball.x>ballBoundary && ball.x<ballBoundary+paddle.division_x) {Collision.ballPosition=12;}
    }

    public static void checkCollision(Ball ball, Paddle paddle) {

        if (ball.x-ball.size<paddle.x+paddle.width && ball.x+ball.size> paddle.x && ball.y-ball.size<paddle.y+paddle.height && ball.y+ball.size>paddle.y) {
            if (ball.y>paddle.y+paddle.height+ball.ySpeed) {

                detectBallForPaddle(ball,paddle);
                int speed=ball.xSpeed/4;
                if (ball.xSpeed>0) {
                    switch (ballPosition) {
                        case 1: ball.xSpeed=-ball.xSpeed;break;
                        case 2:
                        case 3: ball.xSpeed-=1*speed;break;
                        case 4:
                        case 5: ball.xSpeed-=2*speed;break;
                        case 6:
                        case 7: ball.xSpeed=0;break;
                        case 8:
                        case 9: ball.xSpeed+=1*speed;break;
                        case 10:
                        case 11:
                        case 12: ball.xSpeed+=2*speed;break;
                    }
                } else if (ball.xSpeed<0) {
                    switch (ballPosition) {
                        case 1:
                        case 2:
                        case 3: ball.xSpeed=ball.xSpeed-2*speed;break;
                        case 4:
                        case 5: ball.xSpeed=ball.xSpeed-1*speed;break;
                        case 6:
                        case 7: ball.xSpeed=0;break;
                        case 8:
                        case 9: ball.xSpeed=ball.xSpeed+2*speed;break;
                        case 10:
                        case 11: ball.xSpeed=ball.xSpeed+1*speed;break;
                        case 12: ball.xSpeed=-ball.xSpeed;break;
                    }
                } else if (ball.xSpeed==0){
                    switch (ballPosition) {
                        case 1:
                        case 2:
                        case 3: ball.xSpeed-=2;break;
                        case 4:
                        case 5: ball.xSpeed-=1;break;
                        case 6:
                        case 7: break;
                        case 8:
                        case 9: ball.xSpeed+=1;break;
                        case 10:
                        case 11:
                        case 12:ball.xSpeed+=2;break;
                    }
                }
                ball.ySpeed=-ball.ySpeed;
            }
            if (ball.x<paddle.x-ball.xSpeed || ball.x>paddle.x+paddle.width+ball.xSpeed) {
                ball.xSpeed=-ball.xSpeed;
            }
        }

    }

    public static void checkCollision(Ball ball, Block block) {

        if (ball.x-ball.size<block.x+block.width && ball.x+ball.size>block.x && ball.y-ball.size<block.y+block.height && ball.y+ball.size>block.y) {
            if((ball.x+ball.size>=ball.x-ball.nx && ball.x+ball.size<block.x+ball.nx
                && ball.y+ball.size>=ball.y-ball.nx && ball.y+ball.size<block.y+ball.nx
                && ball.xSpeed>0 && ball.ySpeed>0) ||
               (ball.x+ball.size>=block.x-ball.nx && ball.x+ball.size<block.x+ball.nx
                && ball.y-ball.size>=block.y+block.height-ball.nx && ball.y-ball.size<block.y+block.height+ball.nx
                && ball.xSpeed>0 && ball.ySpeed<0) ||
               (ball.x-ball.size>=block.x+block.width-ball.nx && ball.x-ball.size<block.x+block.width+ball.nx
                && ball.y-ball.size>=block.y+block.height-ball.nx && ball.y-ball.size<block.y+block.height+ball.nx
                && ball.xSpeed<0 && ball.ySpeed<0) ||
               (ball.x-ball.size>=block.x+block.width-ball.nx && ball.x-ball.size<block.x+block.width+ball.nx
                && ball.y+ball.size>=ball.y-ball.nx && ball.y+ball.size<block.y+ball.nx
                && ball.xSpeed<0 && ball.ySpeed>0)) {
            // если шар соприкоснулся он отталкивается в противоположном направлении блок разрушается метод заканчивает работу
            ball.xSpeed=-ball.xSpeed;
            ball.ySpeed=-ball.ySpeed;
            if (block.special_grade==0) {
                block.destroyed=true;
            } else {block.special_grade-=1;}

        } else if (ball.y>block.y-ball.ySpeed || ball.y<block.y+ball.ySpeed) {
                if (block.special_grade==0) {
                    block.destroyed=true;
                } else {block.special_grade-=1;}
                ball.ySpeed=-ball.ySpeed;
            } else if (ball.x<block.x-ball.xSpeed || ball.x>block.x+block.width+ball.xSpeed) {
                if (block.special_grade==0) {
                    block.destroyed=true;
                } else {block.special_grade-=1;}
                ball.xSpeed=-ball.xSpeed;
            }
        }
    }

    public static boolean checkCollision(EventBall eventBall, Paddle paddle) {
        if (paddle.y+paddle.height-eventBall.ySpeed>eventBall.y-eventBall.size
                && eventBall.x+eventBall.size>paddle.x && eventBall.x-eventBall.size<paddle.x+paddle.width) {
            return true;
        }
        return false;
    }

}
