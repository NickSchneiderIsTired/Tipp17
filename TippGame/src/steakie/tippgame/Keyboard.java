package steakie.tippgame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    public boolean[] keys = new boolean[65536];
    public boolean a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z, enter, esc, back;
   // public boolean[] letts;

    public void update() {
        a = keys[KeyEvent.VK_A];
        b = keys[KeyEvent.VK_B];
        c = keys[KeyEvent.VK_C];
        d = keys[KeyEvent.VK_D];
        e = keys[KeyEvent.VK_E];
        f = keys[KeyEvent.VK_F];
        g = keys[KeyEvent.VK_G];
        h = keys[KeyEvent.VK_H];
        i = keys[KeyEvent.VK_I];
        j = keys[KeyEvent.VK_J];
        k = keys[KeyEvent.VK_K];
        l = keys[KeyEvent.VK_L];
        m = keys[KeyEvent.VK_M];
        n = keys[KeyEvent.VK_N];
        o = keys[KeyEvent.VK_O];
        p = keys[KeyEvent.VK_P];
        q = keys[KeyEvent.VK_Q];
        r = keys[KeyEvent.VK_R];
        s = keys[KeyEvent.VK_S];
        t = keys[KeyEvent.VK_T];
        u = keys[KeyEvent.VK_U];
        v = keys[KeyEvent.VK_V];
        w = keys[KeyEvent.VK_W];
        x = keys[KeyEvent.VK_X];
        y = keys[KeyEvent.VK_Y];
        z = keys[KeyEvent.VK_Z];
        enter = keys[KeyEvent.VK_ENTER];
        esc = keys[KeyEvent.VK_ESCAPE];
        back = keys[KeyEvent.VK_BACK_SPACE];
        /*letts = new boolean[26];
        letts[0] = a;
        letts[1] = b;
        letts[2] = c;
        letts[3] = d;
        letts[4] = e;
        letts[5] = f;
        letts[6] = g;
        letts[7] = h;
        letts[8] = i;
        letts[9] = j;
        letts[10] = k;
        letts[11] = l;
        letts[12] = m;
        letts[13] = n;
        letts[14] = o;
        letts[15] = p;
        letts[16] = q;
        letts[17] = r;
        letts[18] = s;
        letts[19] = t;
        letts[20] = u;
        letts[21] = v;
        letts[22] = w;
        letts[23] = x;
        letts[24] = y;
        letts[25] = z;*/
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e) {

    }
}
