package Single;

import Menu.Scene;

public class Single_Namebranch {
   //곡이 선택되었을 경우 곡의 타입을 보고 어떤 녹음 화면으로 변경시킬지 결정 1번은 바닐라모드 2~이후로는 디모곡리스트
   private String sing;

   public Single_Namebranch(Scene sc, String sing) {
      this.sing = sing;

      if (sing.equals("Nomusic")) {
         // 지금은 일단 아무 음악도 없이??
         sc.getContentPane().removeAll();
         sc.add(new Single(sc,null)).requestFocus();
         sc.revalidate();
      } else if (sing.equals("Selectmusic")) {
         //
         System.out.println("준비중");
      } else {
         // 음악 있이
         /*
          * System.out.println("준비중"); sc.getContentPane().removeAll(); sc.add(new
          * Single_Record(sc)); sc.revalidate();
          */

      }
   }

}