package com.neymeha.mypetgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.neymeha.mypetgame.interact.Collision;
import com.neymeha.mypetgame.interact.Event;
import com.neymeha.mypetgame.interact.EventList;
import com.neymeha.mypetgame.shapes.Ball;
import com.neymeha.mypetgame.shapes.Block;
import com.neymeha.mypetgame.shapes.EventBall;
import com.neymeha.mypetgame.shapes.Paddle;

import java.util.ArrayList;
import java.util.Random;

public class MyPetGame extends ApplicationAdapter {

	ShapeRenderer eventBallShape;
	ShapeRenderer ballShape; // добавили зависимость от констр прост форм для шара
	ShapeRenderer paddleShape; // добавили зависимость от констр прост форм для отбивающей поверхности
	ShapeRenderer blockShape; // добавили зависимость от констр прост форм для блоков
	Paddle paddle; // зависимость от отбивающей поверхности
	ArrayList<Ball> balls=new ArrayList<>(); // создали список для всех мячей
	ArrayList<Block> blocks = new ArrayList<>(); // создали список для наших разрушимых блоков
	ArrayList<EventBall> eventBalls = new ArrayList<>(); // список для событийных шаров
	Random r = new Random(); // создали обьект рандома для элемента случайности

	private SpriteBatch batch; // обьект который будет накапливать и отрисовывать наш текст
	private BitmapFont font; // обьект который будет хранить характеристики нашего текста

	@Override
	public void create() {
		batch = new SpriteBatch(); // создали обьект который будет копить и отрисовывать текст
		font = new BitmapFont(); // создали обьект текста
		font.setColor(Color.RED); // присвоили обьекту текста цвет

		ballShape = new ShapeRenderer(); // присвоили обьект макета простой фигуры для шара
		paddleShape = new ShapeRenderer(); // присвоиди макет простой фигуры для отбивающей фигуры
		blockShape = new ShapeRenderer(); // присвоили обьект макета простой фигуры для блоков
		eventBallShape = new ShapeRenderer(); // присвоили обьект макета простой фигуры для событийных шаров

		balls.add(new Ball(100, 100, 5, 4, 5)); // добавили основной шар в список шаров
		paddle = new Paddle(); // создали отбивающую стандартную поверхность

		int blockWidth = 63; // задали ширину блоков
		int blockHeight = 20; // задали высоту блоков

		for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocks.add(new Block(x, y, blockWidth, blockHeight)); // в фор лупе добавляем блоки
			} // с заданным условием на смещение для заполнения блоками верхней части экрана
		}

		Event.makeSpecial(blocks); // достаем список блоков и наделяем некоторые особыми состояниями для событий
	}

	@Override
	public void render() { // метод для отрисовки по кадрам
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // отчищаем экран после движения шара

		batch.begin(); // запустили обьект для отрисовки текста

		ballShape.begin(ShapeRenderer.ShapeType.Filled); // до сих пор не понимаю что это делает но без этого никак
		paddleShape.begin(ShapeRenderer.ShapeType.Filled); // сейчас думаю что это конструктор для задания формы обьекта на экране
		blockShape.begin(ShapeRenderer.ShapeType.Filled); // все равно не ебу что это делает
		eventBallShape.begin(ShapeRenderer.ShapeType.Filled); // хз

		paddle.draw(paddleShape); // отрисовываем отбивающую поверхность
		paddle.move(); // задаем движение отбивающей поверхности

		for (Ball ball:balls){ // перебираем список шаров для дальнейшей манипуляции и проверок с ними
			ball.draw(ballShape); // отрисовываем шары
			ball.update(); // задаем движение шарам
			Collision.checkCollision(ball, paddle); // проверяем список мячей на столкновение с отбивающей поверхностью
		}

		for (Block block : blocks) { // в форичь лупе отрисовываем все блоки
			block.draw(blockShape); // отрисовываем все блоки
			for (Ball ball: balls) { // перебираем все шары для проверки на столкновение
				Collision.checkCollision(ball, block);	 // проверяем столкновение блока и шара и задаем логику отскока
			}
		}

		for (int i = 0; i < blocks.size(); i++) { // петля для постоянной проверки блоков на состояние уничтоженности
			Block b = blocks.get(i); // получаем поочереди блоки в новую переменную для удобства
			if (b.destroyed) { // проверяем условие, произошло ли столкновение с этим блоком
				if (b.special) { // проверяем является ли блок носитель особенного состояния
					eventBalls.add(b.eventBall); // если проверка + то добавляем зависимый событийный мяч от блока в список событийных мячей
				}
				blocks.remove(b); // если да то блок уничтожается
				// мы должны деукрементировать переменную когда блок уничтожен иначе мы можем пропустить блок
				i--; // блок (4) ушел, а значит его место занял блок (5) и стал блоком (4) по этому декремент в конце
			}
		}


		if (!eventBalls.isEmpty()) {  // Если список событийных шаров не пустой то мы отрисовываем каждый шар доставая его из списка и задаем движение
			for (int i=0; i<eventBalls.size(); i++) { // в лупе перебираем список полученных событийных шаров
				EventBall e_ball=eventBalls.get(i); // присваиваем новой переменной по очереди событтйные шары для удобства
				e_ball.draw(eventBallShape); // отрисовываем событийные шары
				e_ball.update(); // задаем движение событийным шарам
				if (Collision.checkCollision(e_ball,paddle)) { // проверяем на столкновение с отбивающей поверхностью событийный шар
					if (e_ball.event==EventList.DRAGONBALL) { // проверяем какое состояние хранит наш событийный шар и запускаем состояние определенного события
						Event.dragonball_event_running=true; // присваиваем состояние ивенту на активное
					} else if (e_ball.event==EventList.MULTIPLY) { // проверка на второе событие
						Event.multiply_event_running=true; // присваиваем состояние ивенту на активное
						int size=balls.size(); // присваиваем переменной размер нашего списка для использования в лупе ибо он будет меняться
						for (int j=0; j<size; j++) { // используем луп для увеличения колличество шаров согласно события
							balls.addAll(Ball.ballFactory(balls.get(j)));// используем фабрику шаров для события и присваием весь список основному списку мячей
						}
					}
					eventBalls.remove(i); 	// убираем событийный шар из списка если тот столкнулся с отпибающей поверхностью
				} else if (e_ball.y-e_ball.size<0) {
					eventBalls.remove(i);  // убираем событийный шар ушедший за низ экрана
				}
			}
		}

		for (int i=0; i<balls.size(); i++) { // в лупе перебераем и убираем уничтоженные мячи (ушедшие за низ экрана)
			if (balls.get(i).destroyed) { // проверяем уничтожен ли наш мяч
				balls.remove(i); // убираем мяч из списка что бы он больше не отрисовывался
			}
		}

		if (balls.isEmpty()) { // если условие + выводим ниже текст на экран
			font.draw(batch, "-1 Live!!!", Gdx.graphics.getWidth()/2 , Gdx.graphics.getHeight()/2);
		}

		batch.end(); // закончили работу обьекта для отрисовки текста
		ballShape.end(); // заканчиваем работу форм
		paddleShape.end(); // и я все равно хз что это
		blockShape.end();
		eventBallShape.end();
	}

	@Override
	public void resize(int width, int height) { // хз что это надо разобраться
	}

	@Override
	public void pause() { // хз что это надо разобраться
	}

	@Override
	public void resume() { // хз что это надо разобраться
	}

	@Override
	public void dispose() { // хз что это надо разобраться
	}
}

//public class MyPetGame extends ApplicationAdapter {
//
//	ShapeRenderer eventBallShape;
//	ShapeRenderer ballShape; // добавили зависимость от констр прост форм для шара
//	ShapeRenderer paddleShape; // добавили зависимость от констр прост форм для отбивающей поверхности
//	ShapeRenderer blockShape; // добавили зависимость от констр прост форм для блоков
//	EventBall eventBall;
//	Ball ball; // зависимость от шара
//	Paddle paddle; // зависимость от отбивающей поверхности
//	ArrayList<Block> blocks = new ArrayList<>(); // создали список для наших разрушимых блоков
//	ArrayList<EventBall> eventBalls = new ArrayList<>(); // список для событийных шаров
//	Random r = new Random(); // создали обьект рандома для элемента случайности
//
//	@Override
//	public void create() {
//
//		ballShape = new ShapeRenderer(); // присвоили обьект макета простой фигуры для шара
//		paddleShape = new ShapeRenderer(); // присвоиди макет простой фигуры для отбивающей фигуры
//		blockShape = new ShapeRenderer(); // присвоили обьект макета простой фигуры для блоков
//		eventBallShape = new ShapeRenderer(); // присвоили обьект макета простой фигуры для событийных шаров
//
//		ball = new Ball(100, 100, 5, 4, 5); // создали шар
//		paddle = new Paddle(); // создали отбивающую стандартную поверхность
//
//		int blockWidth = 63; // задали ширину блоков
//		int blockHeight = 20; // задали высоту блоков
//
//		for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
//			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
//				blocks.add(new Block(x, y, blockWidth, blockHeight)); // в фор лупе добавляем блоки
//			} // с заданным условием на смещение для заполнения блоками верхней части экрана
//		}
//
//		Event.makeSpecial(blocks); // достаем список блоков и наделяем некоторые особыми состояниями для событий
//
//	}
//
//	@Override
//	public void render() { // метод для отрисовки по кадрам
//
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // отчищаем экран после движения шара
//
//		ballShape.begin(ShapeRenderer.ShapeType.Filled); // до сих пор не понимаю что это делает но без этого никак
//		paddleShape.begin(ShapeRenderer.ShapeType.Filled); // сейчас думаю что это конструктор для задания формы обьекта на экране
//		blockShape.begin(ShapeRenderer.ShapeType.Filled); // все равно не ебу что это делает
//		eventBallShape.begin(ShapeRenderer.ShapeType.Filled);
//
//		ball.draw(ballShape); // отрисовываем шар
//		paddle.draw(paddleShape); // отрисовываем отбивающую поверхность
//
//		for (Block block : blocks) { // в форичь лупе отрисовываем все блоки
//			block.draw(blockShape);
//			Collision.checkCollision(ball, block); // отталкиваемся от блока если произошло столкновение
//		}
//
//		for (int i = 0; i < blocks.size(); i++) { // петля для постоянной проверки блоков на состояние уничтоженности
//			Block b = blocks.get(i); // получаем поочереди блоки
//			if (b.destroyed) { // проверяем условие, произошло ли столкновение с этим блоком
//				if (b.special) {
//					eventBalls.add(b.eventBall);
//				}
//				blocks.remove(b); // если да то блок уничтожается
//				// we need to decrement i when a ball gets removed, otherwise we skip a ball!
//				i--; // блок (4) ушел, а значит его место занял блок (5) и стал блоком (4) по этому декремент в конце
//			}
//		}
//
//		// Если список событийных шаров не пустой то мы отрисовываем каждый шар доставая его из списка
//		// и задаем движение
//		if (!eventBalls.isEmpty()) {
//			for (int i=0; i<eventBalls.size(); i++) {
//				EventBall e_ball=eventBalls.get(i);
//				e_ball.draw(eventBallShape);
//				e_ball.update();
//				// проверяем на столкновение с отбивающей поверхностью событийный шар
//				if (Collision.checkCollision(e_ball,paddle)) {
//					// проверяем какое состояние хранит наш событийный шар и запускаем состояние
//					// определенного события
//					if (e_ball.event==EventList.DRAGONBALL) {
//						Event.dragonball_event_running=true;
//					} else if (e_ball.event==EventList.MULTIPLY) {
//						Event.multiply_event_running=true;
//						// используем фабрику шаров для события
//						Event.balls=ball.ballFactory(ball);
//					}
//					// убираем шар из списка что бы не отрисовывать те что столкнулись с отбивающей
//					eventBalls.remove(i);
//				} else if (e_ball.y-e_ball.size<0) {
//					// убираем шар ушедший за низ экрана
//					eventBalls.remove(i);
//				}
//			}
//		}
//
//		if (Event.balls!=null) {
//			for (int i=0; i<Event.balls.size(); i++) {
//				Event.balls.get(i).draw(ballShape);
//				Event.balls.get(i).update();
//				Collision.checkCollision(Event.balls.get(i),paddle);
//				if (ball.destroyed) {
//					ball=Event.balls.get(r.nextInt(0,Event.balls.size()));
//				}
//				for (Block block : blocks) { // в форичь лупе отрисовываем все блоки
//					Collision.checkCollision(Event.balls.get(i),block);
//				}
//				if (Event.balls.get(i).destroyed) {
//					Event.balls.remove(i);
//				}
//
//			}
//
//		}
//
//		ball.update(); // задаем изменения движения шара имеющимся методом
//		paddle.move(); // задаем движение отбивающей поверхности
//		Collision.checkCollision(ball, paddle); // проверяем шар на столкновение с отбивающей поверхностью
//
//		ballShape.end();
//		paddleShape.end();
//		blockShape.end();
//		eventBallShape.end();
//	}
//}



