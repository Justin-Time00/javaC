package typeracer;


import java.awt.AWTException;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Robot;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.Process;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
public class typeracerGod extends JFrame implements ComponentListener,KeyEventDispatcher{
	public DefaultListModel<String> ourModel = new DefaultListModel<String>();
	private JList<String> ourLog = new JList<String>(ourModel);
	public static  boolean keypr = true;
	public  static void startRace(){
		try{
			FileReader fr = new FileReader("C:/Users/t00053018/Desktop/1.html");
		      BufferedReader br = new BufferedReader(fr);
		      String line;

	    	  long timeStart = System.currentTimeMillis();
	          long timeEnd = System.currentTimeMillis();
	  		while(timeEnd - timeStart < 1000){
	  			timeEnd = System.currentTimeMillis();
	  		}
		      while((line = br.readLine()) !=null){
		    	  Pattern current = Pattern.compile("<span id=\"nhwMiddlegwt-uid-[0-9]{1,}\" style=\"text-decoration: underline; color: rgb.153, 204, 0.;\">(.*?)</span>");
		    	  Matcher mcur = current.matcher(line);
		    	  if(mcur.find()){
		    		  Pattern cur1 = Pattern.compile("<span id=\"nhwMiddleCommagwt-uid-[0-9]{1,}\" style=\"color: rgb.153, 204, 0.;\">(.*?)</span>");
		    		  Matcher mcur2 = cur1.matcher(line);
		    		  mcur2.find();
		    		  String temp = mcur.group(1);
		    		  for(int i=0;i<temp.length();i++){
			        	  presskey(temp.charAt(i));
		    		  }
		    		  if(mcur2.group(1).length()>0)
		    		   presskey(mcur2.group(1).charAt(0));
		    		  try{
				          Robot r = new Robot();
		    		  r.keyPress(KeyEvent.VK_SPACE);
	        		  r.keyRelease(KeyEvent.VK_SPACE);
		    		  }
			          catch(AWTException o){}
		    	  }
		    	  Pattern pTitle = Pattern.compile("<span id=\"nhwRightgwt-uid-[0-9]{1,}\">(.*?)</span>");
		          Matcher mTitle = pTitle.matcher(line);
		          if(mTitle.find()){
		          line = mTitle.group(1);
		          try{
			          Robot r = new Robot();
			          line = line.trim();
			          for(int i=0;i<line.length();i++){
			        	  presskey(line.charAt(i));
			          }
			          /*r.keyPress(KeyEvent.VK_SHIFT);
	        		  r.keyPress((int)'5');
	        		  r.keyRelease((int)'5');
	        		  r.keyRelease(KeyEvent.VK_SHIFT);*/
		          }
		          catch(AWTException o){}
		          }
		      }

	          fr.close();
		    }
		    catch(IOException e){
		    }
	}
	public static void presskey(char a){
		try{
	          Robot r = new Robot();
		char temp = a;
		long timeStart = System.currentTimeMillis();
        long timeEnd = System.currentTimeMillis();
		while(timeEnd - timeStart < 50){// typing speed (110 == 100 wpm)
			timeEnd = System.currentTimeMillis();
		}
		if(temp=='a'){
  	  r.keyPress(KeyEvent.VK_A);
		  r.keyRelease(KeyEvent.VK_A);
		  r.keyPress(KeyEvent.VK_BACK_SPACE);
		  r.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
  	  if(Character.isUpperCase(temp)){
  		  r.keyPress(KeyEvent.VK_SHIFT);
  		  r.keyPress((int)temp);
  		  r.keyRelease((int)temp);
  		  r.keyRelease(KeyEvent.VK_SHIFT);
  	  }
  	  else{
  		  switch(temp){
  		  	case '!':
	  		  	r.keyPress(KeyEvent.VK_SHIFT);
	  		  r.keyPress((int)'1');
	  		  r.keyRelease((int)'1');
	  		  r.keyRelease(KeyEvent.VK_SHIFT);
	        		  break;
  		  	case '%':
  		  		r.keyPress(KeyEvent.VK_SHIFT);
	        		  r.keyPress((int)'5');
	        		  r.keyRelease((int)'5');
	        		  r.keyRelease(KeyEvent.VK_SHIFT);
	        		break;
  		  	case '*':
  		  		r.keyPress(KeyEvent.VK_SHIFT);
	        		  r.keyPress((int)'8');
	        		  r.keyRelease((int)'8');
	        		  r.keyRelease(KeyEvent.VK_SHIFT);
	        		break;
  		  	case '(':
  		  		r.keyPress(KeyEvent.VK_SHIFT);
	        		  r.keyPress((int)'9');
	        		  r.keyRelease((int)'9');
	        		  r.keyRelease(KeyEvent.VK_SHIFT);
	        		break;
  		  	case ')':
  		  		r.keyPress(KeyEvent.VK_SHIFT);
	        		  r.keyPress((int)'0');
	        		  r.keyRelease((int)'0');
	        		  r.keyRelease(KeyEvent.VK_SHIFT);
	        		break;
  		  	case '-':
  		  		r.keyPress(KeyEvent.VK_MINUS);
	        		  r.keyRelease(KeyEvent.VK_MINUS);
	        		break;
  		  	case '_':
  		  		r.keyPress(KeyEvent.VK_SHIFT);
  		  		r.keyPress(KeyEvent.VK_MINUS);
	        		  r.keyRelease(KeyEvent.VK_MINUS);
	        		  r.keyRelease(KeyEvent.VK_SHIFT);
	        		break;
  		  	case '+':
  		  		r.keyPress(KeyEvent.VK_PLUS);
	        		  r.keyRelease(KeyEvent.VK_PLUS);
	        		break;
  		  	case '\'':
  		  		r.keyPress(KeyEvent.VK_QUOTE);
	        		  r.keyRelease(KeyEvent.VK_QUOTE);
	        		break;
  		  	case '"':
  		  		r.keyPress(KeyEvent.VK_SHIFT);
  		  		r.keyPress(KeyEvent.VK_QUOTE);
	        		  r.keyRelease(KeyEvent.VK_QUOTE);
	        		  r.keyRelease(KeyEvent.VK_SHIFT);
	        		break;
  		  	case ';':
  		  		r.keyPress(KeyEvent.VK_SEMICOLON);
	        		  r.keyRelease(KeyEvent.VK_SEMICOLON);
	        		break;
  		  	case ':':
  		  		r.keyPress(KeyEvent.VK_SHIFT);
  		  		r.keyPress(KeyEvent.VK_SEMICOLON);
	        		  r.keyRelease(KeyEvent.VK_SEMICOLON);
	        		  r.keyRelease(KeyEvent.VK_SHIFT);
	        		break;
  		  	case '?':
  		  		r.keyPress(KeyEvent.VK_SHIFT);
  		  		r.keyPress(KeyEvent.VK_SLASH);
	        		  r.keyRelease(KeyEvent.VK_SLASH);
	        		  r.keyRelease(KeyEvent.VK_SHIFT);
	        		break;
  		  	case ',':
  		  		r.keyPress(KeyEvent.VK_COMMA);
	        		  r.keyRelease(KeyEvent.VK_COMMA);
	        		break;
  		  	case '.':
  		  		r.keyPress(KeyEvent.VK_PERIOD);
	        		  r.keyRelease(KeyEvent.VK_PERIOD);
	        		break;
	        	default:
      		  temp = Character.toUpperCase(temp);
      		  r.keyPress((int)temp);
      		  r.keyRelease((int)temp);
      		  break;
  		  }
  	  }	
		}
        catch(AWTException o){}
	}
	private static boolean wPressed = false;
    /*public static boolean isWPressed() {
        synchronized (typeracerGod.class) {
            return wPressed;
        }
    }*/
	//nhwRightgwt-uid-10  nhwMiddlegwt-uid-8
	@Override
    public boolean dispatchKeyEvent(KeyEvent ke) {
		switch(ke.getKeyCode()){
			case KeyEvent.VK_SPACE:
	            	startRace();
					System.exit(0);
	                break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
            
		}
            return false;
    }
	typeracerGod(){
		KeyboardFocusManager mngt = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		mngt.addKeyEventDispatcher(this);
		this.addComponentListener(this);
		//this.add(this.ourLog);
		this.setSize(550,300);
		this.setVisible(true);
		//this.repaint();
	}
	private boolean listCheck(){
		if(this.ourModel.getSize()>10){
			this.ourModel.clear();
			return true;
		}
		else return false;
	}
	public void componentHidden(ComponentEvent ce){
		this.listCheck();
	}
	public void componentMoved(ComponentEvent ce){
		this.listCheck();
	}
	public void componentResized(ComponentEvent ce){
		this.listCheck();
	}
	public void componentShown(ComponentEvent ce){
		this.listCheck();
	}
	public static void main(String[] args) {
		new typeracerGod();
		/*try{
		FileReader fr = new FileReader("C:/Users/t00053018/Desktop/1.txt");
		fr.close();
		}
		catch(IOException e){}*/
	}

}
