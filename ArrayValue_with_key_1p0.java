/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array_Value_with_key;

/**
 *
 * @author gosiple
 */
public class ArrayValue_with_key_1p0 {

    int[][] value;
    int[][] key;
    final static int all = -2;//输出对象方式
    final static int last = -1;

    private void init() {
        this.value = new int[1][1];
        this.key = new int[1][2];
    }

    public void add(int key, int value) {
        if (this.value == null) {
            this.init();
            this.key[0][0] = key;
            this.key[0][1] = 0;
            this.value[0][0] = value;
        } else {
            int t1 = selectfloor01(key);
            if (t1 == -1) {
                insert(this.value.length, 1, key, value);
            } else {
                int t2 = selectfloor02(t1, value);
                if (t2 == -1) {
                    insert(t1, this.value[t1].length, value);
                } else {
                    insert(t1, this.value[t1].length, value);
                }
            }
        }
    }

    private int selectfloor01(int key) {
        int loop;
        for (loop = 0; loop < this.key.length; loop++) {
            if (key == this.key[loop][0]) {
                return this.key[loop][1];
            }
        }
        return -1;
    }

    private int selectfloor02(int key, int value) {
        int loop;
        for (loop = 0; loop < this.value[key].length; loop++) {
            if (value == this.value[key][loop]) {
                return loop;
            }
        }
        return -1;
    }

    private void insert(int aimline, int aimlist, int key, int value) {
        int loop;
        int[][] tempkey = this.key;
        int[][] tempvalue = this.value;
        this.key = new int[aimline + 1][2];
        this.value = new int[aimline + 1][];
        for (loop = 0; loop < tempkey.length; loop++) {
            this.key[loop] = tempkey[loop].clone();
            this.value[loop] = tempvalue[loop].clone();
        }
        this.key[aimline] = new int[2];
        this.value[aimline] = new int[1];
        this.key[aimline][0] = key;
        this.key[aimline][1] = aimline;
        this.value[aimline][0] = value;
    }

    private void insert(int aimline, int aimlist, int value) {
        int loop;
        int[] tempvalue = this.value[aimline];
        this.value[aimline] = new int[aimlist + 1];
        for (loop = 0; loop < aimlist; loop++) {
            this.value[aimline][loop] = tempvalue[loop];
        }
        this.value[aimline][aimlist] = value;
    }

    public void order(boolean orderkey, boolean ordervalue) {
        int loop;
        if (ordervalue) {
            for (loop = 0; loop < this.value.length; loop++) {
                ordervalueint(loop);
            }
        }
        if (orderkey) {
            orderkeyguideint();
        }
    }

    private void orderkeyguideint() {
        int loop, min, ln;

        for (loop = 0; loop < this.key.length - 1; loop++) {
            int x;
            x = this.key[loop][0];
            min = loop;
            for (ln = loop + 1; ln < this.key.length; ln++) {
                if (x > this.key[ln][0]) {
                    x = this.key[ln][0];
                    min = ln;
                } else {
                    continue;
                }
            }
            int[] temp = this.key[min];
            this.key[min] = this.key[loop];
            this.key[loop] = temp;
        }
    }

    private void ordervalueint(int key) {
        int loop, min, ln;

        for (loop = 0; loop < this.value[key].length - 1; loop++) {
            int x;
            x = this.value[key][loop];
            min = loop;
            for (ln = loop + 1; ln < this.value[key].length; ln++) {
                if (x > this.value[key][ln]) {
                    x = this.value[key][ln];
                    min = ln;
                } else {
                    continue;
                }
            }
            this.value[key][min] = this.value[key][loop];
            this.value[key][loop] = x;
        }
    }
}
