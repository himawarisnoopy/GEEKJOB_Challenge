/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.*;

/**
 *
 * @author kawas
 */
public abstract class Human {
    ArrayList<Integer> myCards;
    
    public abstract int open();
    public abstract void setCard(ArrayList<Integer> al);
    public abstract boolean checkSum();
    
}

class Dealer extends Human {
    ArrayList<Integer> cards = new ArrayList<Integer>();
    
    // コンストラクタ
    Dealer() {
        //　全カードを設定
        for(int mark=0;mark<4;mark++) {
            for(int num=1;num<14;num++) {
                if (num > 10) {
                    cards.add(10);
                } else {
                    cards.add(num);
                }
            }
        }
        
        // 自分の手札を初期化
        this.myCards = new ArrayList<Integer>();
    }
    
    // ---- 抽象クラス関連メソッド ----
    public int open() {
        return getTotal();
    }
    
    // 受け取ったカードを自分のカードに
    public void setCard(ArrayList<Integer> al) {
        if (al != null) {
            for(Integer card : al) {
                this.myCards.add(card);
            }
        }
    }
    
    public boolean checkSum() {
        // Dealerは、17で止める
        Integer sum = getTotal();
        
        if (sum < 17) {
            return true;
        }
        
        return false;
    }
    // ---- 抽象クラス関連メソッド ----
    
    public ArrayList<Integer> deal() {
        ArrayList<Integer> resultCard = new ArrayList<Integer>();
        
        Random rand = new Random();
        
        for(int i=0;i<2;i++) {
            Integer target = rand.nextInt(this.cards.size());
            resultCard.add(this.cards.get(target));
            // 使用したカードは、破棄
                this.cards.remove(target);  
            } 

            // 返却
            return resultCard;
    }
    
    public ArrayList<Integer> hit() {
        ArrayList<Integer> resultCard = new ArrayList<Integer>();
        
        Random rand = new Random();
        
        Integer target = rand.nextInt(this.cards.size());
        resultCard.add(this.cards.get(target));
        
        // 使用したカードは、破棄
        this.cards.remove(target);
        
        // 返却
        return resultCard;
    }
    
    private Integer getTotal() {
        Integer total = 0;
        
        if (this.myCards != null) {
            int aceCnt = 0;
            for(Integer card : this.myCards) {
                if (card != 1) {
                    // 先に１以外を加算
                    total += card;
                } else {
                    aceCnt++;
                }
            }

            // 1を計算
            if (aceCnt > 0) {
                if (aceCnt > 1) {
                    // 1枚以上1の場合は、1枚残して全て1。
                    total += (aceCnt - 1);
                }
                
                // 残った1枚のチェック
                if ((total + 11) <= 21) {
                    total += 11;
                } else {
                    total += 1;
                }
            }
        }
        
        return total;
    }
}

class User extends Human {
    
    User() {
        // 自分の手札を初期化
        this.myCards = new ArrayList<Integer>();
    }
    
    // ---- 抽象クラス関連メソッド ----
    public int open() {
        return getTotal();
    }
    
    public void setCard(ArrayList<Integer> al) {
        if (al != null) {
            for(Integer card : al) {
                this.myCards.add(card); 
            }
        }
    }
    
    public boolean checkSum() {
        // Userは、15で止める（仮）
        Integer sum = getTotal();
        
        if (sum < 15) {
            return true;
        }
        
        return false;
    }
    // ---- 抽象クラス関連メソッド ----
    
    private Integer getTotal() {
        Integer total = 0;
        
        if (this.myCards != null) {
            int aceCnt = 0;
            for(Integer card : this.myCards) {
                if (card != 1) {
                    // 先に１以外を加算
                    total += card;
                } else {
                    aceCnt++;
                }
            }

            // 1を計算
            if (aceCnt > 0) {
                if (aceCnt > 1) {
                    // 1枚以上1の場合は、1枚残して全て1。
                    total += (aceCnt - 1);
                }
                
                // 残った1枚のチェック
                if ((total + 11) <= 21) {
                    total += 11;
                } else {
                    total += 1;
                }
            }
        }
        
        return total;
    }
}
