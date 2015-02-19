package Snake;

import java.awt.Rectangle;

import javax.swing.JFrame;

import java.awt.event.*;

import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.util.Random;

public class Snake3PG extends JFrame implements ActionListener, KeyListener{
    
    public static int [] px1 = {280};
    public static int [] py1 = {50};
    
    public static int [] px2 = {20};
    public static int [] py2 = {150};
    
    public static int [] px3 = {50};
    public static int [] py3 = {280};
    
    public static int life1 = 1;
    public static int life2 = 1;
    public static int life3 = 1;
    
    public static int [] stoX;
    public static int [] stoY;
    
    public static int delay = 0;
    
    public static int vX1 = -1;
    public static int vY1 = 0;
    
    public static int vX2 = 1;
    public static int vY2 = 0;
    
    public static int vX3 = 0;
    public static int vY3 = -1;
    
    
    public static int moveLimiter1 = 0;
    public static int moveLimiter2 = 0;
    public static int moveLimiter3 = 0;
    
    public static int appleState = 0;
    public static int appleX;
    public static int appleY;
    public static Random rand;
    
    
    public static String gameover = "";
    public static String winner = "";
    public static Color winnersColor = Color.BLACK;
    
    public static int n;
    
    public static boolean pause = false;
    
    Image img = this.createImage(this.getWidth(),this.getHeight());
    
    Timer timer;
    
    public void paint(Graphics g){
        
    	img = this.createImage(this.getWidth(),this.getHeight());
    	
    	Graphics2D g2 = (Graphics2D) img.getGraphics();
    	
    	
        
        g2.setColor(Color.BLACK);
        g2.fill(new Rectangle(0,0,300,300));
        
        
        
        g2.setColor(Color.GREEN);
        n = 0;
        
        if(life1 == 1){
        	while(n != px1.length){
        		
        		g2.fill(new Rectangle( (px1[n])-5 ,(py1[n])-5,10,10));
        		
        		n++;
        	}
        }
        
        
        
        n = 0;
        
        if(life2 == 1){
        	while(n != px2.length){
           
        		g2.fill(new Rectangle( (px2[n])-5 ,(py2[n])-5,10,10));
           
        		n++;
        	}
        }
        
        
        
        n = 0;
        
        if(life3 == 1){
        	while(n != px3.length){
           
        		g2.fill(new Rectangle( (px3[n])-5 ,(py3[n])-5,10,10));
           		
           		n++;
        	}
        }
        
        
        
        
        g2.setColor(Color.RED);
        g2.fill(new Rectangle(appleX-5,appleY-5,10,10));
        
        
        
        if(life1 == 1){
        	g2.setColor(Color.YELLOW);
        	g2.fill(new Rectangle(px1[0]-5,py1[0]-5,10,10));
        }
        
        if(life2 == 1){
        	g2.setColor(Color.BLUE);
        	g2.fill(new Rectangle(px2[0]-5,py2[0]-5,10,10));
        }
        
        if(life3 == 1){
        	g2.setColor(Color.WHITE);
        	g2.fill(new Rectangle(px3[0]-5,py3[0]-5,10,10));
        }
        
        g2.setColor(Color.YELLOW);
        g2.drawString(gameover, 120, 50);
        g2.setColor(winnersColor);
        g2.drawString(winner, 120, 60);
        g2.setColor(Color.RED);
        if(pause){
        	g2.drawString("PAUSE", 120, 80);
        }
        
        g.drawImage(img, 0, 0, this);
    	
    	
    }
    
    public void actionPerformed(ActionEvent e){
        
        
        move();
        
        repaint();
        
    }
    
    public void keyReleased(KeyEvent e){}
    
    public void keyTyped(KeyEvent e){}
    
    public void keyPressed(KeyEvent e){
        
    	if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
    		
            pause = !pause;
            
         }
    	
        if (e.getKeyCode()==KeyEvent.VK_LEFT && vX1 != 1 && moveLimiter1 == 0){
           
           vX1 = -1;
           vY1 = 0;
           moveLimiter1 = 1;
        }
        
        if (e.getKeyCode()==KeyEvent.VK_RIGHT && vX1 != -1 && moveLimiter1 == 0){
           
           vX1 = 1;
           vY1 = 0;
           moveLimiter1 = 1;
        }
        
        if (e.getKeyCode()==KeyEvent.VK_UP && vY1 != 1 && moveLimiter1 == 0){
           
           vX1 = 0;
           vY1 = -1;
           moveLimiter1 = 1;
        }
        
        if (e.getKeyCode()==KeyEvent.VK_DOWN && vY1 != -1 && moveLimiter1 == 0){
           
           vX1 = 0;
           vY1 = 1;
           moveLimiter1 = 1;
        }
        
        //
        
        
        
        if (e.getKeyCode()==KeyEvent.VK_A && vX2 != 1 && moveLimiter2 == 0){
           
           vX2 = -1;
           vY2 = 0;
           moveLimiter2 = 1;
        }
        
        if (e.getKeyCode()==KeyEvent.VK_D && vX2 != -1 && moveLimiter2 == 0){
           
           vX2 = 1;
           vY2 = 0;
           moveLimiter2 = 1;
        }
        
        if (e.getKeyCode()==KeyEvent.VK_W && vY2 != 1 && moveLimiter2 == 0){
           
           vX2 = 0;
           vY2 = -1;
           moveLimiter2 = 1;
        }
        
        if (e.getKeyCode()==KeyEvent.VK_S && vY2 != -1 && moveLimiter2 == 0){
           
           vX2 = 0;
           vY2 = 1;
           moveLimiter2 = 1;
        }
        
        
        //
        
        
        
        if (e.getKeyCode()==KeyEvent.VK_J && vX3 != 1 && moveLimiter3 == 0){
           
           vX3 = -1;
           vY3 = 0;
           moveLimiter3 = 1;
        }
        
        if (e.getKeyCode()==KeyEvent.VK_L && vX3 != -1 && moveLimiter3 == 0){
           
           vX3 = 1;
           vY3 = 0;
           moveLimiter3 = 1;
        }
        
        if (e.getKeyCode()==KeyEvent.VK_I && vY3 != 1 && moveLimiter3 == 0){
           
           vX3 = 0;
           vY3 = -1;
           moveLimiter3 = 1;
        }
        
        if (e.getKeyCode()==KeyEvent.VK_K && vY3 != -1 && moveLimiter3 == 0){
           
           vX3 = 0;
           vY3 = 1;
           moveLimiter3 = 1;
        }
        
    }
    
    
    public static void main (String[] args){
        
        
        
        JFrame window = new Snake3PG();
        window.setSize(300,300);
        window.setResizable(false);
        window.setTitle("Snake 3PG v:1.2");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setLocationRelativeTo(null);
        
        window.setVisible(true);
        
        
        
        
    }
    
    
    
    public void move(){
        
    	if(!pause){
	    	
	    	int [] resetList = {0};
	    	
	        if(life1 == 0){
	        	px1 = resetList;
	        	py1 = resetList;
	        }
	        
	        if(life2 == 0){
	        	px2 = resetList;
	        	py2 = resetList;
	        }
	        
	        if(life3 == 0){
	        	px3 = resetList;
	        	py3 = resetList;
	        }
	    	
	    	if(life1 + life2 + life3 <= 1){
	    		
	    		if(life1 == 1){
	    			winnersColor = Color.YELLOW;
	    			winner = "Snake1 win";
	    		}
	    		
	    		if(life2 == 1){
	    			winnersColor = Color.BLUE;
	    			winner = "Snake2 win";
	    		}
	    		
	    		if(life3 == 1){
	    			winnersColor = Color.WHITE;
	    			winner = "Snake3 win";
	    		}
	    		
	    		
	    	}
	    	
	        n = px1.length-1;
	            
	        while (0 != n){
	            
	            if(px1[0] == px1[n] && py1[0] == py1[n]){
	                
	                //delay = 100;
	                
	                life1 = 0;
	                //gameover = "Game Over";
	                
	            }
	            
	            n--;
	        }
	        
	        
	        
	        n = px2.length-1;
	            
	        while (0 != n){
	            
	            if(px2[0] == px2[n] && py2[0] == py2[n]){
	                
	                //delay = 100;
	                
	                life2 = 0;
	                //gameover = "Game Over";
	                
	            }
	            
	            n--;
	        }
	        
	        
	        
	        n = px3.length-1;
	            
	        while (0 != n){
	            
	            if(px3[0] == px3[n] && py3[0] == py3[n]){
	                
	                //delay = 100;
	                
	                life3 = 0;
	                //gameover = "Game Over";
	                
	            }
	            
	            n--;
		        
	        	
	        
	        }
	        
	        
	        
	        
	        
	        
	        
	        //Collision between two snake
	        
	        //snake 1
	        n = px1.length-1;
	            
	        while (0 != n){
	            
	            if( (px2[0] == px1[n] && py2[0] == py1[n]) ||
	                (px3[0] == px1[n] && py3[0] == py1[n]) ){
	                
	            	if(px2[0] == px1[n] && py2[0] == py1[n]){
	            		life2 = 0;
	            	}
	            	if(px3[0] == px1[n] && py3[0] == py1[n]){
	            		life3 = 0;
	            	}
	            	
	                //delay = 100;
	                
	                //gameover = "Game Over";
	                
	            }
	            
	            n--;
	        }
	        
	        
	        //snake 2
	        n = px2.length-1;
	            
	        while (0 != n){
	            
	            if( (px1[0] == px2[n] && py1[0] == py2[n]) ||
	                (px3[0] == px2[n] && py3[0] == py2[n]) ){
	                
	            	if(px1[0] == px2[n] && py1[0] == py2[n]){
	            		life1 = 0;
	            	}
	            	if(px3[0] == px2[n] && py3[0] == py2[n]){
	            		life3 = 0;
	            	}
	            	
	                //delay = 100;
	                
	                //gameover = "Game Over";
	                
	            }
	            
	            n--;
	        }
	        
	        //snake 3
	        n = px3.length-1;
	            
	        while (0 != n){
	            
	            if( (px1[0] == px3[n] && py1[0] == py3[n]) ||
	                (px2[0] == px3[n] && py2[0] == py3[n])  ){
	                
	            	if((px1[0] == px3[n] && py1[0] == py3[n])){
	            		life1 = 0;
	            	}
	            	if(px2[0] == px3[n] && py2[0] == py3[n]){
	            		life2 = 0;
	            	}
	            	
	                //delay = 100;
	                
	                //gameover = "Game Over";
	                
	            }
	            
	            n--;
	        }
	        
	        
	        
	        
	        
	        
	        
	        if (appleState == 1){
	            if(life1 == 1){
		            if(appleX == px1[0] && appleY == py1[0]){
		                stoX = new int[(px1.length)+1];
		                stoY = new int[(py1.length)+1];
		                
		                n = 0;
		                while(n != px1.length){
		                    stoX[n] = px1[n];
		                    stoY[n] = py1[n];
		                    n++;
		                }
		                
		                stoX[(stoX.length)-1] = stoX[(stoX.length)-2];
		                stoY[(stoY.length)-1] = stoY[(stoY.length)-2];
		                
		                px1 = new int [stoX.length];
		                py1 = new int [stoY.length];
		                
		                n = 0;
		                while(n != stoX.length){
		                    px1[n] = stoX[n];
		                    py1[n] = stoY[n];
		                    n++;
		                }
		                
		                appleState = 0;
		            }
	            }
	            
	            
	            if(life2 == 1){
		            if(appleX == px2[0] && appleY == py2[0]){
		                stoX = new int[(px2.length)+1];
		                stoY = new int[(py2.length)+1];
		                
		                n = 0;
		                while(n != px2.length){
		                    stoX[n] = px2[n];
		                    stoY[n] = py2[n];
		                    n++;
		                }
		                
		                stoX[(stoX.length)-1] = stoX[(stoX.length)-2];
		                stoY[(stoY.length)-1] = stoY[(stoY.length)-2];
		                
		                px2 = new int [stoX.length];
		                py2 = new int [stoY.length];
		                
		                n = 0;
		                while(n != stoX.length){
		                    px2[n] = stoX[n];
		                    py2[n] = stoY[n];
		                    n++;
		                }
		                
		                appleState = 0;
		            }
	            }
	            
	            
	            if(life3 == 1){
		            if(appleX == px3[0] && appleY == py3[0]){
		                stoX = new int[(px3.length)+1];
		                stoY = new int[(py3.length)+1];
		                
		                n = 0;
		                while(n != px3.length){
		                    stoX[n] = px3[n];
		                    stoY[n] = py3[n];
		                    n++;
		                }
		                
		                stoX[(stoX.length)-1] = stoX[(stoX.length)-2];
		                stoY[(stoY.length)-1] = stoY[(stoY.length)-2];
		                
		                px3 = new int [stoX.length];
		                py3 = new int [stoY.length];
		                
		                n = 0;
		                while(n != stoX.length){
		                    px3[n] = stoX[n];
		                    py3[n] = stoY[n];
		                    n++;
		                }
		                
		                appleState = 0;
		            }
	            }
	            
	            
	            
	            
	            
	        }
	        
	        
	        
	        
	        if (appleState == 0){
	            
	            rand = new Random();
	            appleX = (rand.nextInt(25)+3)*10;
	            
	            rand = new Random();
	            appleY = (rand.nextInt(25)+3)*10;
	            
	            appleState = 1;
	            
	        }
	        
	        
	        
	        
	        if (delay == 0){
	            
	            //snake 1
	        	if(life1 == 1){
		            n = px1.length-1;
		            
		            while (0 != n){
		                
		                px1[n] = px1[n-1];
		                py1[n] = py1[n-1];
		                
		                n--;
		            }
		            
		            px1[0] = px1[0] + (vX1 * 10);
		            py1[0] = py1[0] + (vY1 * 10);
	        	}
	            
	            //snake 2
	        	if(life2 == 1){
		            n = px2.length-1;
		            
		            while (0 != n){
		                
		                px2[n] = px2[n-1];
		                py2[n] = py2[n-1];
		                
		                n--;
		            }
		            
		            px2[0] = px2[0] + (vX2 * 10);
		            py2[0] = py2[0] + (vY2 * 10);
		        	}
	            
	            //snake 3
	        	if(life3 == 1){
		            n = px3.length-1;
		            
		            while (0 != n){
		                
		                px3[n] = px3[n-1];
		                py3[n] = py3[n-1];
		                
		                n--;
		            }
		            
		            px3[0] = px3[0] + (vX3 * 10);
		            py3[0] = py3[0] + (vY3 * 10);
		        }
	            
	            
	            
	            
	            
	            //snake1
	        	if(life1 == 1){
		            if(px1[0] < 0){
		                px1[0] = 300;
		            }
		            
		            if(py1[0] < 20){
		                py1[0] = 300;
		            }
		            
		            if(px1[0] > 300){
		                px1[0] = 0;
		            }
		            
		            if(py1[0] > 300){
		                py1[0] = 20;
		            }
	        	}
	            
	            //snake2
	            if(life2 == 1){
		        	if(px2[0] < 0){
		                px2[0] = 300;
		            }
		            
		            if(py2[0] < 20){
		                py2[0] = 300;
		            }
		            
		            if(px2[0] > 300){
		                px2[0] = 0;
		            }
		            
		            if(py2[0] > 300){
		                py2[0] = 20;
		            }
	            }
	            
	            
	            //snake3
		            if(life3 == 1){
		            if(px3[0] < 0){
		                px3[0] = 300;
		            }
		            
		            if(py3[0] < 20){
		                py3[0] = 300;
		            }
		            
		            if(px3[0] > 300){
		                px3[0] = 0;
		            }
		            
		            if(py3[0] > 300){
		                py3[0] = 20;
		            }
	            }
	            
	            
	            
	            moveLimiter1 = 0;
	            moveLimiter2 = 0;
	            moveLimiter3 = 0;
	            
        	}
        }
        
        
        if (delay != 0){
            
            delay--;
            
        }
        
        
        
        
    }
    
    
    
    
    public Snake3PG() {
        timer = new Timer(150,this);
        
        timer.setInitialDelay(500);
        timer.start();
        
        
        addKeyListener(this);
    }
    
    
    
    
}






